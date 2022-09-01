package com.mariiakushel.task.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mariiakushel.task.ApiRunner;
import com.mariiakushel.task.enumeration.Position;
import com.mariiakushel.task.exception.CustomException;
import com.mariiakushel.task.repository.EmployeeRepository;
import com.mariiakushel.task.service.DepartmentService;
import com.mariiakushel.task.service.EmployeeService;
import com.mariiakushel.task.service.dto.DepartmentDtoInput;
import com.mariiakushel.task.service.dto.DepartmentDtoOutput;
import com.mariiakushel.task.service.dto.DirectorateDtoInput;
import com.mariiakushel.task.service.dto.DirectorateDtoOutput;
import com.mariiakushel.task.service.dto.EmployeeDtoInputCreate;
import com.mariiakushel.task.service.dto.EmployeeDtoInputUpdate;
import com.mariiakushel.task.service.dto.EmployeeDtoOutput;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static com.mariiakushel.task.controller.Jwts.ADMIN_JWT;
import static com.mariiakushel.task.controller.Jwts.DIRECTOR_JWT;
import static com.mariiakushel.task.controller.Jwts.EMPLOYEE_JWT;
import static com.mariiakushel.task.controller.Jwts.HEAD_JWT;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.jwt;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EmployeeController.class)
@ContextConfiguration(classes = {ApiRunner.class, TestConfig.class})
class EmployeeControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService serviceMock;
    @Autowired
    private ObjectMapper mapper;
    @Autowired
    private JwtGrantedAuthoritiesConverter customConverter;

    @Test
    void createEmployee_headOrDirectorAndCorrectData_created() throws Exception {
        DirectorateDtoOutput dirDto = new DirectorateDtoOutput(1L, "dir", "dir_description");
        DepartmentDtoOutput depDto = new DepartmentDtoOutput(1L, "dep", "dep_description", dirDto);
        EmployeeDtoOutput empDto = new EmployeeDtoOutput(1L, "name", "surname", "111111111", 30, Position.EMPLOYEE, depDto);
        when(serviceMock.create(anyLong(), any(EmployeeDtoInputCreate.class))).thenReturn(empDto);
        String jsonContent =
                mapper.writeValueAsString(new EmployeeDtoInputCreate("name", "surname", "111111111", 30, Position.EMPLOYEE));

        mockMvc.perform(post("/departments/1/employees")
                        .content(jsonContent)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .with(jwt().jwt(HEAD_JWT).authorities(customConverter)))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1L));

        verify(serviceMock, times(1)).create(anyLong(), any(EmployeeDtoInputCreate.class));
    }

    @Test
    void createEmployee_headOrDirectorAndNotCorrectData_notFound() throws Exception {
        CustomException ex = new CustomException("error message", HttpStatus.NOT_FOUND);
        when(serviceMock.create(anyLong(), any(EmployeeDtoInputCreate.class))).thenThrow(ex);
        String jsonContent =
                mapper.writeValueAsString(new DirectorateDtoInput("dir", "dir_description"));

        mockMvc.perform(post("/departments/1/employees")
                        .content(jsonContent)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .with(jwt().jwt(HEAD_JWT).authorities(customConverter)))
                .andDo(print())
                .andExpect(status().isNotFound());

        verify(serviceMock, times(1)).create(anyLong(), any(EmployeeDtoInputCreate.class));
    }

    @Test
    void createEmployee_headOrDirectorAndNotCorrectData_conflict() throws Exception {
        CustomException ex = new CustomException("error message", HttpStatus.CONFLICT);
        when(serviceMock.create(anyLong(), any(EmployeeDtoInputCreate.class))).thenThrow(ex);
        String jsonContent =
                mapper.writeValueAsString(new DirectorateDtoInput("dir", "dir_description"));

        mockMvc.perform(post("/departments/1/employees")
                        .content(jsonContent)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .with(jwt().jwt(DIRECTOR_JWT).authorities(customConverter)))
                .andDo(print())
                .andExpect(status().isConflict());

        verify(serviceMock, times(1)).create(anyLong(), any(EmployeeDtoInputCreate.class));
    }

    @Test
    void createEmployee_notHeadOrDirector_forbidden() throws Exception {
        String jsonContent =
                mapper.writeValueAsString(new DirectorateDtoInput("dir", "dir_description"));

        mockMvc.perform(post("/departments/1/employees")
                        .content(jsonContent)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .with(jwt().jwt(EMPLOYEE_JWT).authorities(customConverter)))
                .andDo(print())
                .andExpect(status().isForbidden());
    }

    @Test
    void createEmployee_guest_unauthorized() throws Exception {
        String jsonContent =
                mapper.writeValueAsString(new DirectorateDtoInput("dir", "dir_description"));

        mockMvc.perform(post("/departments/1/employees")
                        .content(jsonContent)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .with(csrf()))
                .andDo(print())
                .andExpect(status().isUnauthorized());
    }

    @Test
    void updateEmployee_headOrDirectorAndCorrectData_ok() throws Exception {
        DirectorateDtoOutput dirDto = new DirectorateDtoOutput(1L, "dir", "dir_description");
        DepartmentDtoOutput depDto = new DepartmentDtoOutput(1L, "dep", "dep_description", dirDto);
        EmployeeDtoOutput empDto = new EmployeeDtoOutput(1L, "name", "surname", "111111111", 30, Position.EMPLOYEE, depDto);
        when(serviceMock.update(anyLong(), any(EmployeeDtoInputUpdate.class))).thenReturn(empDto);
        String jsonContent =
                mapper.writeValueAsString(new EmployeeDtoInputUpdate("name", "surname", 30, Position.EMPLOYEE, 1L));

        mockMvc.perform(patch("/departments/1/employees")
                        .content(jsonContent)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .with(jwt().jwt(HEAD_JWT).authorities(customConverter)))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1L));

        verify(serviceMock, times(1)).update(anyLong(), any(EmployeeDtoInputUpdate.class));
    }

    @Test
    void updateEmployee_directorOrHeadAndNotCorrectData_notFound() throws Exception {
        CustomException ex = new CustomException("error message", HttpStatus.NOT_FOUND);
        when(serviceMock.update(anyLong(), any(EmployeeDtoInputUpdate.class))).thenThrow(ex);
        String jsonContent =
                mapper.writeValueAsString(new EmployeeDtoInputUpdate("name", "surname", 30, Position.EMPLOYEE, 1L));

        mockMvc.perform(patch("/departments/1/employees")
                        .content(jsonContent)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .with(jwt().jwt(HEAD_JWT).authorities(customConverter)))
                .andDo(print())
                .andExpect(status().isNotFound());

        verify(serviceMock, times(1)).update(anyLong(), any(EmployeeDtoInputUpdate.class));
    }

    @Test
    void updateEmployee_directorOrHeadAndNotCorrectData_conflict() throws Exception {
        CustomException ex = new CustomException("error message", HttpStatus.CONFLICT);
        when(serviceMock.update(anyLong(), any(EmployeeDtoInputUpdate.class))).thenThrow(ex);
        String jsonContent =
                mapper.writeValueAsString(new EmployeeDtoInputUpdate("name", "surname", 30, Position.EMPLOYEE, 1L));

        mockMvc.perform(patch("/departments/1/employees")
                        .content(jsonContent)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .with(jwt().jwt(DIRECTOR_JWT).authorities(customConverter)))
                .andDo(print())
                .andExpect(status().isConflict());

        verify(serviceMock, times(1)).update(anyLong(), any(EmployeeDtoInputUpdate.class));
    }

    @Test
    void updateEmployee_notHeadOrDirector_forbidden() throws Exception {
        String jsonContent =
                mapper.writeValueAsString(new EmployeeDtoInputUpdate("name", "surname", 30, Position.EMPLOYEE, 1L));

        mockMvc.perform(patch("/departments/1/employees")
                        .content(jsonContent)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .with(jwt().jwt(EMPLOYEE_JWT).authorities(customConverter)))
                .andDo(print())
                .andExpect(status().isForbidden());
    }

    @Test
    void updateEmployee_guest_unauthorized() throws Exception {
        String jsonContent =
                mapper.writeValueAsString(new EmployeeDtoInputUpdate("name", "surname", 30, Position.EMPLOYEE, 1L));

        mockMvc.perform(patch("/departments/1/employees")
                        .content(jsonContent)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .with(csrf()))
                .andDo(print())
                .andExpect(status().isUnauthorized());
    }

    @Test
    void deactivateEmployee_directorOrHeadAndCorrectData_ok() throws Exception {
        doNothing().when(serviceMock).deactivate(anyLong());

        mockMvc.perform(delete("/employees/1")
                        .with(jwt().jwt(DIRECTOR_JWT).authorities(customConverter)))
                .andDo(print())
                .andExpect(status().isOk());

        verify(serviceMock, times(1)).deactivate(anyLong());
    }

    @Test
    void deactivateEmployee_directorOrHeadAndNotCorrectData_notFound() throws Exception {
        CustomException ex = new CustomException("error message", HttpStatus.NOT_FOUND);
        doThrow(ex).when(serviceMock).deactivate(anyLong());

        mockMvc.perform(delete("/employees/1")
                        .with(jwt().jwt(DIRECTOR_JWT).authorities(customConverter)))
                .andDo(print())
                .andExpect(status().isNotFound());

        verify(serviceMock, times(1)).deactivate(anyLong());
    }

    @Test
    void deactivateEmployee_directorOrHeadAndNotCorrectName_conflict() throws Exception {
        CustomException ex = new CustomException("error message", HttpStatus.CONFLICT);
        doThrow(ex).when(serviceMock).deactivate(anyLong());

        mockMvc.perform(delete("/employees/1")
                        .with(jwt().jwt(DIRECTOR_JWT).authorities(customConverter)))
                .andDo(print())
                .andExpect(status().isConflict());

        verify(serviceMock, times(1)).deactivate(anyLong());
    }

    @Test
    void deactivateEmployee_notDirectorOrHead_forbidden() throws Exception {
        mockMvc.perform(delete("/employees/1")
                        .with(jwt().jwt(EMPLOYEE_JWT).authorities(customConverter)))
                .andDo(print())
                .andExpect(status().isForbidden());
    }

    @Test
    void deactivateEmployee_guest_unauthorized() throws Exception {
        mockMvc.perform(delete("/employees/1")
                        .with(csrf()))
                .andDo(print())
                .andExpect(status().isUnauthorized());
    }

    @Test
    void findAllEmployees_admin_ok() throws Exception {
        DirectorateDtoOutput dirDto = new DirectorateDtoOutput(1L, "dir", "dir_description");
        DepartmentDtoOutput depDto = new DepartmentDtoOutput(1L, "dep", "dep_description", dirDto);
        EmployeeDtoOutput empDto = new EmployeeDtoOutput(1L, "name", "surname", "111111111", 30, Position.EMPLOYEE, depDto);
        when(serviceMock.findAll(anyInt(), anyInt())).thenReturn(List.of(empDto));

        mockMvc.perform(get("/employees")
                        .with(jwt().jwt(ADMIN_JWT).authorities(customConverter)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.*", hasSize(1)));

        verify(serviceMock, times(1)).findAll(anyInt(), anyInt());
    }
}