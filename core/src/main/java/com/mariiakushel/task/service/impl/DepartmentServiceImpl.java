package com.mariiakushel.task.service.impl;

import com.mariiakushel.task.enumeration.SubdepartmentType;
import com.mariiakushel.task.exception.CustomException;
import com.mariiakushel.task.repository.DepartmentRepository;
import com.mariiakushel.task.repository.DirectorateRepository;
import com.mariiakushel.task.repository.EmployeeRepository;
import com.mariiakushel.task.repository.entity.Department;
import com.mariiakushel.task.repository.entity.Directorate;
import com.mariiakushel.task.repository.entity.Subdepartment;
import com.mariiakushel.task.service.DepartmentService;
import com.mariiakushel.task.service.dto.DepartmentDtoInput;
import com.mariiakushel.task.service.dto.DepartmentDtoOutput;
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

@Service
@Validated
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository repository;
    private EmployeeRepository empRepository;
    private DirectorateRepository dirRepository;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository repository,
                                 EmployeeRepository empRepository,
                                 DirectorateRepository dirRepository) {
        this.repository = repository;
        this.empRepository = empRepository;
        this.dirRepository = dirRepository;
    }

    @Override
    @Transactional
    public DepartmentDtoOutput create(Long idDir, DepartmentDtoInput dto) throws CustomException {
        Directorate dir = dirRepository.findByIdAndActive(idDir, true)
                .orElseThrow(() -> new CustomException("resource not found id=" + idDir, HttpStatus.NOT_FOUND));
        Optional<Department> nameCheck =
                repository.findByNameAndDirectorateAndActive(dto.getName(), dir, true);
        if (nameCheck.isPresent()) {
            throw new CustomException(
                    new StringBuilder()
                            .append("Department named '")
                            .append(dto.getName())
                            .append("' already exist in the current directorate.")
                            .toString(),
                    HttpStatus.CONFLICT);
        }
        Department dep = DtoEntityConvertor.convert(dto);
        dep.setDirectorate(dir);
        createSubdepartments(dep);
        Department newDep = repository.save(dep);
        return DtoEntityConvertor.convert(newDep);
    }

    @Override
    @Transactional
    public DepartmentDtoOutput update(Long idDir, Long id, DepartmentDtoInput dto) throws CustomException {
        Optional<Department> optDep = repository.findByIdAndDirectorateAndActive(id, new Directorate(idDir), true);
        Department dep = optDep
                .orElseThrow(() -> new CustomException("resource not found id=" + id, HttpStatus.NOT_FOUND));
        Optional<Department> nameCheck =
                repository.findByNameAndDirectorateAndActive(dto.getName(), new Directorate(idDir), true);
        if (nameCheck.isPresent()) {
            throw new CustomException(
                    new StringBuilder()
                            .append("Department named '")
                            .append(dto.getName())
                            .append("' already exist in the current directorate.")
                            .toString(),
                    HttpStatus.CONFLICT);
        }
        dep.setName(dto.getName());
        dep.setDescription(dto.getDescription());
        Department updetedDep = repository.save(dep);
        return DtoEntityConvertor.convert(updetedDep);
    }

    @Override
    @Transactional
    public void deactivate(Long idDir, Long id) throws CustomException {
        Optional<Department> optDep = repository.findByIdAndDirectorateAndActive(id, new Directorate(idDir), true);
        Department dep = optDep
                .orElseThrow(() -> new CustomException("resource not found id=" + id, HttpStatus.NOT_FOUND));
        long numberOfEmployees = empRepository.countByActiveAndDepartment(true, dep.getId());
        if (numberOfEmployees != 0) {
            throw new CustomException(
                    new StringBuilder()
                            .append("It is not possible deactivate department id=")
                            .append(dep.getId())
                            .append(", name=")
                            .append(dep.getName())
                            .append(" while there are ")
                            .append(numberOfEmployees)
                            .append(" employees.")
                            .toString(),
                    HttpStatus.CONFLICT);
        }
        dep.setActive(false);
        dep.getSubdepartments().forEach(e -> e.setActive(false));
        repository.save(dep);
    }

    @Override
    public DepartmentDtoOutput findByIdByDirectorate(Long idDir, Long id) throws CustomException {
        Optional<Department> optDep = repository.findByIdAndDirectorateAndActive(id, new Directorate(idDir), true);
        Department dep = optDep
                .orElseThrow(() -> new CustomException("resource not found id=" + id, HttpStatus.NOT_FOUND));
        return DtoEntityConvertor.convert(dep);
    }

    @Override
    public List<DepartmentDtoOutput> findAllByDirectorate(Long idDir, int page, int size) {
        Pageable paging = PageRequest.of(page - 1, size);
        List<Department> deps = repository.findAllByDirectorateAndActive(new Directorate(idDir), true, paging).toList();
        return DtoEntityConvertor.convertDepartments(deps);
    }

    private void createSubdepartments(Department dep) {
        Subdepartment heads = new Subdepartment();
        heads.setDepartment(dep);
        heads.setType(SubdepartmentType.HEADS);
        Subdepartment employees = new Subdepartment();
        employees.setDepartment(dep);
        employees.setType(SubdepartmentType.EMPLOYEES);
        dep.setSubdepartments(Set.of(heads, employees));
    }
}
