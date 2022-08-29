package com.mariiakushel.task.controller;

import com.mariiakushel.task.exception.CustomException;
import com.mariiakushel.task.service.EmployeeService;
import com.mariiakushel.task.service.dto.EmployeeDtoInputCreate;
import com.mariiakushel.task.service.dto.EmployeeDtoInputUpdate;
import com.mariiakushel.task.service.dto.EmployeeDtoOutput;
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
public class EmployeeController {

    private EmployeeService service;

    @Autowired
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    //@PreAuthorize("hasAuthority('ADMIN', 'HEAD')")
    @PostMapping(value = "/departments/{idDep}/employees", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeDtoOutput createEmployee(@PathVariable("idDep") @Positive Long idDep,
                                            @RequestBody EmployeeDtoInputCreate dto) throws CustomException {
        return service.create(idDep, dto);
    }

    //@PreAuthorize("hasAuthority('ADMIN', 'HEAD')")
    @PatchMapping(value = "/employees/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public EmployeeDtoOutput updateEmployee(@PathVariable("id") @Positive Long id,
                                            @RequestBody EmployeeDtoInputUpdate dto) throws CustomException {
        return service.update(id, dto);
    }


    //    @PreAuthorize("hasAuthority('ADMIN', 'DIRECTOR?')")
    @DeleteMapping(value = "/employees/{id}")
    public void deactivateEmployee(@PathVariable("id") @Positive Long id) throws CustomException {
        service.deactivate(id);
    }

    //  @PreAuthorize("hasAuthority('ADMIN', 'DIRECTOR', 'HEAD')")
    @GetMapping(value = "/employees/{id}")
    public EmployeeDtoOutput findEmployee(//@AuthenticationPrincipal Jwt jwt,
                                          @PathVariable("id") @Positive Long id) throws CustomException {
        return service.findById(id);
    }

    //    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/employees/mine")
    public EmployeeDtoOutput findMyEmployee(//@AuthenticationPrincipal Jwt jwt
    ) throws CustomException {
//        return service.findByIdByDirectorate(idDir, id);
        return null;
    }

    //
//  @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping(value = "/employees")
    public List<EmployeeDtoOutput> findAllEmployees(//@AuthenticationPrincipal Jwt jwt,
                                                    @RequestParam(name = "page", defaultValue = "1", required = false) @Min(1) int page,
                                                    @RequestParam(name = "size", defaultValue = "10", required = false) @Min(1) int size)
            throws CustomException {
        return service.findAll(page, size);
    }

    //  @PreAuthorize("hasAuthority('ADMIN', 'HEAD')")
    @GetMapping(value = "/departments/{idDep}/employees")
    public List<EmployeeDtoOutput> findAllEmployeesByDepartment(//@AuthenticationPrincipal Jwt jwt,
                                                                @PathVariable("idDep") @Positive Long idDep,
                                                                @RequestParam(name = "page", defaultValue = "1", required = false) @Min(1) int page,
                                                                @RequestParam(name = "size", defaultValue = "10", required = false) @Min(1) int size)
            throws CustomException {
        return service.findAllByDepartment(idDep, page, size);
    }

    //  @PreAuthorize("hasAuthority('ADMIN', 'DIRECTOR')")
    @GetMapping(value = "/directorates/{idDir}/employees")
    public List<EmployeeDtoOutput> findAllEmployeesByDirectorate(//@AuthenticationPrincipal Jwt jwt,
                                                                 @PathVariable("idDir") @Positive Long idDir,
                                                                 @RequestParam(name = "page", defaultValue = "1", required = false) @Min(1) int page,
                                                                 @RequestParam(name = "size", defaultValue = "10", required = false) @Min(1) int size)
            throws CustomException {
        return service.findAllByDirectorate(idDir, page, size);
    }
}

