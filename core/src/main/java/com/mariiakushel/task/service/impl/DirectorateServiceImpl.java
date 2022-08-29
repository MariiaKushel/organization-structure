package com.mariiakushel.task.service.impl;

import com.mariiakushel.task.enumeration.SubdepartmentType;
import com.mariiakushel.task.exception.CustomException;
import com.mariiakushel.task.repository.DirectorateRepository;
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

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Validated
public class DirectorateServiceImpl implements DirectorateService {

    private static final String DEFAULT_DEPARTMENT_NAME = "Default department";
    private static final String DEFAULT_DEPARTMENT_DESCRIPTION = "Special department for Director of Direction";

    private DirectorateRepository repository;

    @Autowired
    public DirectorateServiceImpl(DirectorateRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public DirectorateDtoOutput create(/*@Valid*/ DirectorateDtoInput dto) throws CustomException {
        Optional<Directorate> dirCheck = repository.findByNameAndActive(dto.getName(), true);
        if (dirCheck.isPresent()) {
            throw new CustomException("Direction named '" + dto.getName() + "' already exist",
                    HttpStatus.CONFLICT);
        }
        Department defaultDep = createDefaultDepartmentForDirector();
        Directorate dir = DtoEntityConvertor.convert(dto);
        dir.setDepartments(Set.of(defaultDep));
        defaultDep.setDirectorate(dir);
        Directorate newDir = repository.save(dir);
        return DtoEntityConvertor.convert(newDir);
    }

    @Override
    @Transactional
    public DirectorateDtoOutput update(Long id, /*@Valid*/ DirectorateDtoInput dto) throws CustomException {
        Optional<Directorate> optDir = repository.findByIdAndActive(id, true);
        Directorate dir = optDir
                .orElseThrow(() -> new CustomException("resource not found id=" + id, HttpStatus.NOT_FOUND));
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
        dir.setActive(false);
        Directorate deactivatedDir = repository.save(dir);
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

    private Department createDefaultDepartmentForDirector() {
        Department defaultDep = new Department();
        defaultDep.setName(DEFAULT_DEPARTMENT_NAME);
        defaultDep.setDescription(DEFAULT_DEPARTMENT_DESCRIPTION);
        Subdepartment defaultSubdep = new Subdepartment();
        defaultSubdep.setType(SubdepartmentType.DIRECTORS);
        defaultSubdep.setDepartment(defaultDep);
        defaultDep.setSubdepartments(Set.of(defaultSubdep));
        return defaultDep;
    }
}
