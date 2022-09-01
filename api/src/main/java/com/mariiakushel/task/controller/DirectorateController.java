package com.mariiakushel.task.controller;

import com.mariiakushel.task.exception.CustomException;
import com.mariiakushel.task.service.DirectorateService;
import com.mariiakushel.task.service.dto.DirectorateDtoInput;
import com.mariiakushel.task.service.dto.DirectorateDtoOutput;
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
 * Rest controller represent CRUD operation on Directorate
 */
@RestController
@Validated
@RequestMapping(value = "/directorates")
public class DirectorateController {

    private DirectorateService service;

    @Autowired
    public DirectorateController(DirectorateService service) {
        this.service = service;
    }

    /**
     * Method creates new Directorate
     *
     * @param dto DTO representation of Directorate
     * @return DTO representation of created Directorate
     * @throws CustomException if Directorate with such name already exist.
     */
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public DirectorateDtoOutput createDirectorate(@RequestBody DirectorateDtoInput dto) throws CustomException {
        return service.create(dto);
    }

    /**
     * Method updates active Directorate.
     *
     * @param id  Directorate id
     * @param dto DTO representation of data for update
     * @return DTO representation of updated Directorate
     * @throws CustomException if Directorate was not found by id or
     *                         if Directorate with such name already exist .
     */
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_DIRECTOR')")
    @PatchMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public DirectorateDtoOutput updateDirectorate(@PathVariable("id") @Positive Long id,
                                                  @RequestBody DirectorateDtoInput dto) throws CustomException {
        return service.update(id, dto);
    }

    /**
     * Method deactivates active Directorate.
     *
     * @param id Directorate id
     * @throws CustomException if Directorate was not found by id  or
     *                         if there are present active Employees at Directorate.
     */
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping(value = "/{id}")
    public void deactivateDirectorate(@PathVariable("id") @Positive Long id) throws CustomException {
        service.deactivate(id);
    }

    /**
     * Method finds active Directorate by id
     *
     * @param id id Directorate id
     * @return DTO representation of Directorate
     * @throws CustomException if Directorate was not found by id
     */
    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/{id}")
    public DirectorateDtoOutput findDirectorate(@PathVariable("id") @Positive Long id) throws CustomException {
        return service.findById(id);
    }

    /**
     * Method finds all active Directorates with pagination.
     *
     * @param page number of page
     * @param size page size
     * @return List of DTO representation of Directorates or empty List, if no one Directorates was found.
     */
    @PreAuthorize("isAuthenticated()")
    @GetMapping
    public List<DirectorateDtoOutput> findAllDirectorates(
            @RequestParam(name = "page", defaultValue = "1", required = false) @Min(1) int page,
            @RequestParam(name = "size", defaultValue = "10", required = false) @Min(1) int size) {
        return service.findAll(page, size);
    }
}
