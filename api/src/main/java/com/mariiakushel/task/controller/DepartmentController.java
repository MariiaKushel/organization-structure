package com.mariiakushel.task.controller;

import com.mariiakushel.task.exception.CustomException;
import com.mariiakushel.task.service.DepartmentService;
import com.mariiakushel.task.service.dto.DepartmentDtoInput;
import com.mariiakushel.task.service.dto.DepartmentDtoOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import java.util.List;

/**
 * Rest controller represent CRUD operation on Department
 */
@RestController
@Validated
@RequestMapping
public class DepartmentController {
    private DepartmentService service;

    @Autowired
    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    /**
     * Method creates new Department.
     *
     * @param idDir Directorate id which  is new Department owner
     * @param dto   DTO representation of new Department
     * @return DTO representation of created Department
     * @throws CustomException if Directorate by id was not found or
     *                         if Department with such name already exist in that Directorate.
     */
    @PreAuthorize("hasAuthority('ROLE_DIRECTOR')")
    @PostMapping(value = "/directorates/{idDir}/departments", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public DepartmentDtoOutput createDepartment(@PathVariable("idDir") @Positive Long idDir,
                                                @RequestBody DepartmentDtoInput dto) throws CustomException {
        return service.create(idDir, dto);
    }

    /**
     * Method updates active Department.
     *
     * @param id  Department id
     * @param dto DTO representation of data for update
     * @return DTO representation of updated Department
     * @throws CustomException if Department was not found by id or
     *                         if Department with such name already exist in that Directorate.
     */
    @PreAuthorize("hasAnyAuthority('ROLE_HEAD','ROLE_DIRECTOR')")
    @PatchMapping(value = "/departments/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public DepartmentDtoOutput updateDepartment(@PathVariable("id") @Positive Long id,
                                                @RequestBody DepartmentDtoInput dto) throws CustomException {
        return service.update(id, dto);
    }

    /**
     * Method deactivates active Department. As well, it deactivates included Subdeparments.
     *
     * @param id Department id
     * @throws CustomException if Department was not found by id  or
     *                         if there are present active Employees at Department.
     */
    @PreAuthorize("hasAuthority('ROLE_DIRECTOR')")
    @DeleteMapping(value = "/departments/{id}")
    public void deactivateDepartment(@PathVariable("id") @Positive Long id) throws CustomException {
        service.deactivate(id);
    }

    /**
     * Method finds active Department by id
     *
     * @param id Department id
     * @return DTO representation of Department
     * @throws CustomException if Department was not found by id
     */
    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/departments/{id}")
    public DepartmentDtoOutput findDepartment(@PathVariable("id") @Positive Long id) throws CustomException {
        return service.findById(id);
    }

    /**
     * Method finds all active Departments with pagination.
     *
     * @param page number of page
     * @param size page size
     * @return List of DTO representation of Departments or empty List, if no one Department was found.
     */
    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/departments")
    public List<DepartmentDtoOutput> findAllDepartment(
            @RequestParam(name = "page", defaultValue = "1", required = false) @Min(1) int page,
            @RequestParam(name = "size", defaultValue = "10", required = false) @Min(1) int size) {
        return service.findAll(page, size);
    }

    /**
     * Method finds all active Departments by Directorate with pagination.
     *
     * @param idDir Directorate id which  is new Department owner
     * @param page  number of page
     * @param size  page size
     * @return List of DTO representation of Departments or empty List, if no one Department was found.
     */
    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/directorates/{idDir}/departments")
    public List<DepartmentDtoOutput> findAllDepartmentByDirectorate(
            @PathVariable("idDir") @Positive Long idDir,
            @RequestParam(name = "page", defaultValue = "1", required = false) @Min(1) int page,
            @RequestParam(name = "size", defaultValue = "10", required = false) @Min(1) int size) {
        return service.findAllByDirectorate(idDir, page, size);
    }
}

