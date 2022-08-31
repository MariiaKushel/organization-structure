package com.mariiakushel.task.service.impl;

import com.mariiakushel.task.enumeration.SubdepartmentType;
import com.mariiakushel.task.exception.CustomException;
import com.mariiakushel.task.repository.DirectorateRepository;
import com.mariiakushel.task.repository.EmployeeRepository;
import com.mariiakushel.task.repository.entity.Department;
import com.mariiakushel.task.repository.entity.Directorate;
import com.mariiakushel.task.repository.entity.Subdepartment;
import com.mariiakushel.task.service.DirectorateService;
import com.mariiakushel.task.service.dto.DirectorateDtoInput;
import com.mariiakushel.task.service.dto.DirectorateDtoOutput;
import com.mariiakushel.task.service.util.DtoEntityConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * Class represent implementation of DirectorateService
 */
@Service
@Validated
public class DirectorateServiceImpl implements DirectorateService {

    private static final String DEFAULT_DEPARTMENT_NAME = "Default department";
    private static final String DEFAULT_DEPARTMENT_DESCRIPTION = "Special department for Director of Direction";

    private DirectorateRepository repository;
    private EmployeeRepository empRepository;

    @Autowired
    public DirectorateServiceImpl(DirectorateRepository repository, EmployeeRepository empRepository) {
        this.repository = repository;
        this.empRepository = empRepository;
    }

    @Override
    @Transactional
    public DirectorateDtoOutput create(DirectorateDtoInput dto) throws CustomException {
        Optional<Directorate> nameCheck = repository.findByNameAndActive(dto.getName(), true);
        if (nameCheck.isPresent()) {
            throw new CustomException(
                    new StringBuilder()
                            .append("Directorate named '")
                            .append(dto.getName())
                            .append("' already exist.")
                            .toString(),
                    HttpStatus.CONFLICT);
        }

        Directorate dir = DtoEntityConvertor.convert(dto);
        createDefaultDepartmentForDirector(dir);
        Directorate newDir = repository.save(dir);
        return DtoEntityConvertor.convert(newDir);
    }

    @Override
    @Transactional
    public DirectorateDtoOutput update(Long id, DirectorateDtoInput dto) throws CustomException {
        Optional<Directorate> optDir = repository.findByIdAndActive(id, true);
        Directorate dir = optDir
                .orElseThrow(() -> new CustomException("resource not found id=" + id, HttpStatus.NOT_FOUND));
        Optional<Directorate> nameCheck = repository.findByNameAndActive(dto.getName(), true);
        if (nameCheck.isPresent() && !nameCheck.get().equals(dir)) {
            throw new CustomException(
                    new StringBuilder()
                            .append("Directorate named '")
                            .append(dto.getName())
                            .append("' already exist.")
                            .toString(),
                    HttpStatus.CONFLICT);
        }
        dir.setName(dto.getName());
        dir.setDescription(dto.getDescription());
        Directorate updatedDir = repository.save(dir);
        return DtoEntityConvertor.convert(updatedDir);
    }

    @Override
    @Transactional
    public void deactivate(Long id) throws CustomException {
        Optional<Directorate> optDir = repository.findByIdAndActive(id, true);
        Directorate dir = optDir
                .orElseThrow(() -> new CustomException("resource not found id=" + id, HttpStatus.NOT_FOUND));
        long numberOfEmployees = empRepository.countByActiveAndSubdepartmentDepartmentDirectorate(true, dir);
        if (numberOfEmployees != 0) {
            throw new CustomException(
                    new StringBuilder()
                            .append("It is not possible deactivate directorate id=")
                            .append(dir.getId())
                            .append(", name=")
                            .append(dir.getName())
                            .append(" while there are ")
                            .append(numberOfEmployees)
                            .append(" employees.")
                            .toString(),
                    HttpStatus.CONFLICT);
        }
        dir.setActive(false);
        Set<Department> deps = dir.getDepartments();
        for (Department dep : deps) {
            dep.setActive(false);
            Set<Subdepartment> subdeps = dep.getSubdepartments();
            subdeps.forEach(sd -> sd.setActive(false));
        }
        repository.save(dir);
    }

    @Override
    public DirectorateDtoOutput findById(Long id) throws CustomException {
        Optional<Directorate> optDir = repository.findByIdAndActive(id, true);
        Directorate dir = optDir
                .orElseThrow(() -> new CustomException("resource not found id=" + id, HttpStatus.NOT_FOUND));
        return DtoEntityConvertor.convert(dir);
    }

    @Override
    public List<DirectorateDtoOutput> findAll(int page, int size) {
        Pageable paging = PageRequest.of(page - 1, size);
        List<Directorate> dirs = repository.findAllByActive(true, paging).toList();
        return DtoEntityConvertor.convertDirectorates(dirs);
    }

    private void createDefaultDepartmentForDirector(Directorate dir) {
        Department defaultDep = new Department();
        defaultDep.setDirectorate(dir);
        defaultDep.setName(DEFAULT_DEPARTMENT_NAME);
        defaultDep.setDescription(DEFAULT_DEPARTMENT_DESCRIPTION);
        Subdepartment defaultSubdep = new Subdepartment();
        defaultSubdep.setType(SubdepartmentType.DIRECTORS);
        defaultSubdep.setDepartment(defaultDep);
        defaultDep.setSubdepartments(Set.of(defaultSubdep));
        dir.setDepartments(Set.of(defaultDep));
    }
}
