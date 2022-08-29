package com.mariiakushel.task.controller;

import com.mariiakushel.task.exception.CustomException;
import com.mariiakushel.task.service.DepartmentService;
import com.mariiakushel.task.service.dto.DepartmentDtoInput;
import com.mariiakushel.task.service.dto.DepartmentDtoOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

@RestController
@Validated
@RequestMapping
public class DepartmentController {
    private DepartmentService service;

    @Autowired
    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    //@PreAuthorize("hasAuthority('ADMIN', 'DIRECTOR')")
    @PostMapping(value = "/directorates/{idDir}/departments", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public DepartmentDtoOutput createDepartment(@PathVariable("idDir") @Positive Long idDir,
                                                @RequestBody DepartmentDtoInput dto) throws CustomException {
        return service.create(idDir, dto);
    }

    //@PreAuthorize("hasAuthority('ADMIN', 'DIRECTOR?')")
    @PatchMapping(value = "/departments/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public DepartmentDtoOutput updateDepartment(@PathVariable("id") @Positive Long id,
                                                @RequestBody DepartmentDtoInput dto) throws CustomException {
        return service.update(id, dto);
    }

    //@PreAuthorize("hasAuthority('ADMIN', 'DIRECTOR?')")
    @DeleteMapping(value = "/departments/{id}")
    public void deactivateDepartment(@PathVariable("id") @Positive Long id) throws CustomException {
        service.deactivate(id);
    }

    //@PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/departments/{id}")
    public DepartmentDtoOutput findDepartment(//@AuthenticationPrincipal Jwt jwt,
                                              @PathVariable("id") @Positive Long id) throws CustomException {
        return service.findById(id);
    }

    //@PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/departments")
    public List<DepartmentDtoOutput> findAllDepartment(//@AuthenticationPrincipal Jwt jwt,
                                                       @RequestParam(name = "page", defaultValue = "1", required = false) @Min(1) int page,
                                                       @RequestParam(name = "size", defaultValue = "10", required = false) @Min(1) int size)
            throws CustomException {
        return service.findAll(page, size);
    }

    @GetMapping(value = "/directorates/{idDir}/departments")
    public List<DepartmentDtoOutput> findAllDepartmentByDirectorate(//@AuthenticationPrincipal Jwt jwt,
                                                                    @PathVariable("idDir") @Positive Long idDir,
                                                                    @RequestParam(name = "page", defaultValue = "1", required = false) @Min(1) int page,
                                                                    @RequestParam(name = "size", defaultValue = "10", required = false) @Min(1) int size)
            throws CustomException {
        return service.findAllByDirectorate(idDir, page, size);
    }
}

