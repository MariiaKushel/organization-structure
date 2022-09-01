package com.mariiakushel.task.controller;

import com.mariiakushel.task.exception.CustomException;
import com.mariiakushel.task.service.EmployeeService;
import com.mariiakushel.task.service.dto.EmployeeDtoInputCreate;
import com.mariiakushel.task.service.dto.EmployeeDtoInputUpdate;
import com.mariiakushel.task.service.dto.EmployeeDtoOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
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
 * Rest controller represent CRUD operation on Employee
 */
@RestController
@Validated
@RequestMapping
public class EmployeeController {

    private static final String EMPLOYEE_ID_CLAIM_KEY = "employee_id";
    private EmployeeService service;

    @Autowired
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    /**
     * Method creates new Employee. As well, it creates new User corresponding that Employee.
     *
     * @param idDep Department id which is new Employee owner
     * @param dto   DTO representation of new Employee
     * @return DTO representation of created Employee
     * @throws CustomException if Department by id was not found or
     *                         if Employee with such personal id already exist or
     *                         if Employee`s position is not present in such Department or
     *                         if position capacity is overflow.
     */
    @PreAuthorize("hasAnyAuthority('ROLE_DIRECTOR', 'ROLE_HEAD')")
    @PostMapping(value = "/departments/{idDep}/employees", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeDtoOutput createEmployee(@PathVariable("idDep") @Positive Long idDep,
                                            @RequestBody EmployeeDtoInputCreate dto) throws CustomException {
        return service.create(idDep, dto);
    }

    /**
     * Method updates active Employee. Employee`s personal id must not change.
     *
     * @param id  Employee id
     * @param dto DTO representation of data for update
     * @return DTO representation of updated Employee
     * @throws CustomException if Employee by id was not found or
     *                         if new Department by id was not found or
     *                         if Employee`s position is not present in such Department or
     *                         if position capacity is overflow.
     */
    @PreAuthorize("hasAnyAuthority('ROLE_DIRECTOR', 'ROLE_HEAD')")
    @PatchMapping(value = "/employees/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public EmployeeDtoOutput updateEmployee(@PathVariable("id") @Positive Long id,
                                            @RequestBody EmployeeDtoInputUpdate dto) throws CustomException {
        return service.update(id, dto);
    }

    /**
     * Method deactivates active Employee. As well, it deactivates corresponding User.
     *
     * @param id Employee id
     * @throws CustomException if Employee by id was not found
     */
    @PreAuthorize("hasAnyAuthority('ROLE_DIRECTOR', 'ROLE_HEAD')")
    @DeleteMapping(value = "/employees/{id}")
    public void deactivateEmployee(@PathVariable("id") @Positive Long id) throws CustomException {
        service.deactivate(id);
    }

    /**
     * Method finds active Employee by id
     *
     * @param id Employee id
     * @return DTO representation of Employee
     * @throws CustomException if Employee by id was not found
     */
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/employees/{id}")
    public EmployeeDtoOutput findEmployee(@PathVariable("id") @Positive Long id) throws CustomException {
        return service.findById(id);
    }

    /**
     * Method finds active Employee by id
     *
     * @param jwt AuthenticationPrincipal
     * @return DTO representation of Employee
     * @throws CustomException if Employee by id was not found
     */
    @PreAuthorize("hasAnyAuthority('ROLE_DIRECTOR', 'ROLE_HEAD', 'EMPLOYEE')")
    @GetMapping(value = "/employees/my")
    public EmployeeDtoOutput findMyEmployee(@AuthenticationPrincipal Jwt jwt) throws CustomException {
        Long id = jwt.getClaim(EMPLOYEE_ID_CLAIM_KEY);
        return service.findById(id);
    }

    /**
     * Method finds all active Employees with pagination.
     *
     * @param page number of page
     * @param size page size
     * @return List of DTO representation of Employees or empty List, if no one Employees was found.
     */
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/employees")
    public List<EmployeeDtoOutput> findAllEmployees(
            @RequestParam(name = "page", defaultValue = "1", required = false) @Min(1) int page,
            @RequestParam(name = "size", defaultValue = "10", required = false) @Min(1) int size) {
        return service.findAll(page, size);
    }

    /**
     * Method finds all active Employees by Department with pagination.
     *
     * @param jwt  AuthenticationPrincipal
     * @param page number of page
     * @param size page size
     * @return List of DTO representation of Employees or empty List, if no one Employees was found.
     * @throws CustomException if Head of Department by id was not found
     */
    @PreAuthorize("hasAuthority('ROLE_HEAD')")
    @GetMapping(value = "/departments/my/employees")
    public List<EmployeeDtoOutput> findAllEmployeesByDepartment(
            @AuthenticationPrincipal Jwt jwt,
            @RequestParam(name = "page", defaultValue = "1", required = false) @Min(1) int page,
            @RequestParam(name = "size", defaultValue = "10", required = false) @Min(1) int size)
            throws CustomException {
        Long idHead = jwt.getClaim(EMPLOYEE_ID_CLAIM_KEY);
        return service.findAllByDepartment(idHead, page, size);
    }

    /**
     * Method finds all active Employees by Directorate with pagination.
     *
     * @param jwt  AuthenticationPrincipal
     * @param page       number of page
     * @param size       page size
     * @return List of DTO representation of Employees or empty List, if no one Employees was found.
     * @throws CustomException if Director of Directorate by id was not found
     */
    @PreAuthorize("hasAuthority('ROLE_DIRECTOR')")
    @GetMapping(value = "/directorates/my/employees")
    public List<EmployeeDtoOutput> findAllEmployeesByDirectorate(
            @AuthenticationPrincipal Jwt jwt,
            @RequestParam(name = "page", defaultValue = "1", required = false) @Min(1) int page,
            @RequestParam(name = "size", defaultValue = "10", required = false) @Min(1) int size)
            throws CustomException {
        Long idDirector = jwt.getClaim(EMPLOYEE_ID_CLAIM_KEY);
        return service.findAllByDirectorate(idDirector, page, size);
    }
}

