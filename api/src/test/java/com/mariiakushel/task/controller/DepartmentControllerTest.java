package com.mariiakushel.task.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mariiakushel.task.ApiRunner;
import com.mariiakushel.task.exception.CustomException;
import com.mariiakushel.task.service.DepartmentService;
import com.mariiakushel.task.service.dto.DepartmentDtoInput;
import com.mariiakushel.task.service.dto.DepartmentDtoOutput;
import com.mariiakushel.task.service.dto.DirectorateDtoInput;
import com.mariiakushel.task.service.dto.DirectorateDtoOutput;
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

import static com.mariiakushel.task.controller.Jwts.DIRECTOR_JWT;
import static com.mariiakushel.task.controller.Jwts.EMPLOYEE_JWT;
import static com.mariiakushel.task.controller.Jwts.HEAD_JWT;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
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

@WebMvcTest(DepartmentController.class)
@ContextConfiguration(classes = {ApiRunner.class, TestConfig.class})
class DepartmentControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService serviceMock;
    @Autowired
    private ObjectMapper mapper;
    @Autowired
    private JwtGrantedAuthoritiesConverter customConverter;

    @Test
    void createDepartment_directorAndCorrectData_created() throws Exception {
        DirectorateDtoOutput dirDto = new DirectorateDtoOutput(1L, "dir", "dir_description");
        DepartmentDtoOutput depDto = new DepartmentDtoOutput(1L, "dep", "dep_description", dirDto);
        when(serviceMock.create(anyLong(), any(DepartmentDtoInput.class))).thenReturn(depDto);
        String jsonContent =
                mapper.writeValueAsString(new DirectorateDtoInput("dir", "dir_description"));

        mockMvc.perform(post("/directorates/1/departments")
                        .content(jsonContent)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .with(jwt().jwt(DIRECTOR_JWT).authorities(customConverter)))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1L));

        verify(serviceMock, times(1)).create(anyLong(), any(DepartmentDtoInput.class));
    }

    @Test
    void createDepartment_directorAndNotCorrectData_notFound() throws Exception {
        CustomException ex = new CustomException("error message", HttpStatus.NOT_FOUND);
        when(serviceMock.create(anyLong(), any(DepartmentDtoInput.class))).thenThrow(ex);
        String jsonContent =
                mapper.writeValueAsString(new DirectorateDtoInput("dir", "dir_description"));

        mockMvc.perform(post("/directorates/1/departments")
                        .content(jsonContent)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .with(jwt().jwt(DIRECTOR_JWT).authorities(customConverter)))
                .andDo(print())
                .andExpect(status().isNotFound());

        verify(serviceMock, times(1)).create(anyLong(), any(DepartmentDtoInput.class));
    }

    @Test
    void createDepartment_directorAndNotCorrectName_conflict() throws Exception {
        CustomException ex = new CustomException("error message", HttpStatus.CONFLICT);
        when(serviceMock.create(anyLong(), any(DepartmentDtoInput.class))).thenThrow(ex);
        String jsonContent =
                mapper.writeValueAsString(new DirectorateDtoInput("dir", "dir_description"));

        mockMvc.perform(post("/directorates/1/departments")
                        .content(jsonContent)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .with(jwt().jwt(DIRECTOR_JWT).authorities(customConverter)))
                .andDo(print())
                .andExpect(status().isConflict());

        verify(serviceMock, times(1)).create(anyLong(), any(DepartmentDtoInput.class));
    }

    @Test
    void createDepartment_notDirector_forbidden() throws Exception {
        String jsonContent =
                mapper.writeValueAsString(new DirectorateDtoInput("dir", "dir_description"));

        mockMvc.perform(post("/directorates/1/departments")
                        .content(jsonContent)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .with(jwt().jwt(EMPLOYEE_JWT).authorities(customConverter)))
                .andDo(print())
                .andExpect(status().isForbidden());
    }

    @Test
    void createDepartment_guest_unauthorized() throws Exception {
        String jsonContent =
                mapper.writeValueAsString(new DirectorateDtoInput("dir", "dir_description"));

        mockMvc.perform(post("/directorates/1/departments")
                        .content(jsonContent)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .with(csrf()))
                .andDo(print())
                .andExpect(status().isUnauthorized());
    }

    @Test
    void updateDepartment_directorOrHeadAndCorrectData_ok() throws Exception {
        DirectorateDtoOutput dirDto = new DirectorateDtoOutput(1L, "dir", "dir_description");
        DepartmentDtoOutput depDto = new DepartmentDtoOutput(1L, "dep", "dep_description", dirDto);
        when(serviceMock.update(anyLong(), any(DepartmentDtoInput.class))).thenReturn(depDto);
        String jsonContent =
                mapper.writeValueAsString(new DirectorateDtoInput("dir", "dir_description"));

        mockMvc.perform(patch("/departments/1")
                        .content(jsonContent)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .with(jwt().jwt(HEAD_JWT).authorities(customConverter)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L));

        verify(serviceMock, times(1)).update(anyLong(), any(DepartmentDtoInput.class));
    }

    @Test
    void updateDepartment_directorOrHeadAndNotCorrectData_notFound() throws Exception {
        CustomException ex = new CustomException("error message", HttpStatus.NOT_FOUND);
        when(serviceMock.update(anyLong(), any(DepartmentDtoInput.class))).thenThrow(ex);
        String jsonContent =
                mapper.writeValueAsString(new DirectorateDtoInput("dir", "dir_description"));

        mockMvc.perform(patch("/departments/1")
                        .content(jsonContent)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .with(jwt().jwt(DIRECTOR_JWT).authorities(customConverter)))
                .andDo(print())
                .andExpect(status().isNotFound());

        verify(serviceMock, times(1)).update(anyLong(), any(DepartmentDtoInput.class));
    }

    @Test
    void updateDepartment_directorOrHeadAndNotCorrectName_conflict() throws Exception {
        CustomException ex = new CustomException("error message", HttpStatus.CONFLICT);
        when(serviceMock.update(anyLong(), any(DepartmentDtoInput.class))).thenThrow(ex);
        String jsonContent =
                mapper.writeValueAsString(new DirectorateDtoInput("dir", "dir_description"));

        mockMvc.perform(patch("/departments/1")
                        .content(jsonContent)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .with(jwt().jwt(DIRECTOR_JWT).authorities(customConverter)))
                .andDo(print())
                .andExpect(status().isConflict());

        verify(serviceMock, times(1)).update(anyLong(), any(DepartmentDtoInput.class));
    }

    @Test
    void updateDepartment_notDirectorOrHead_forbidden() throws Exception {
        String jsonContent =
                mapper.writeValueAsString(new DirectorateDtoInput("dir", "dir_description"));

        mockMvc.perform(patch("/departments/1")
                        .content(jsonContent)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .with(jwt().jwt(EMPLOYEE_JWT).authorities(customConverter)))
                .andDo(print())
                .andExpect(status().isForbidden());
    }

    @Test
    void updateDepartment_guest_unauthorized() throws Exception {
        String jsonContent =
                mapper.writeValueAsString(new DirectorateDtoInput("dir", "dir_description"));

        mockMvc.perform(patch("/departments/1")
                        .content(jsonContent)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .with(csrf()))
                .andDo(print())
                .andExpect(status().isUnauthorized());
    }

    @Test
    void deactivateDepartment_directorAndCorrectData_ok() throws Exception {
        doNothing().when(serviceMock).deactivate(anyLong());

        mockMvc.perform(delete("/departments/1")
                        .with(jwt().jwt(DIRECTOR_JWT).authorities(customConverter)))
                .andDo(print())
                .andExpect(status().isOk());

        verify(serviceMock, times(1)).deactivate(anyLong());
    }

    @Test
    void deactivateDepartment_directorAndNotCorrectData_notFound() throws Exception {
        CustomException ex = new CustomException("error message", HttpStatus.NOT_FOUND);
        doThrow(ex).when(serviceMock).deactivate(anyLong());

        mockMvc.perform(delete("/departments/1")
                        .with(jwt().jwt(DIRECTOR_JWT).authorities(customConverter)))
                .andDo(print())
                .andExpect(status().isNotFound());

        verify(serviceMock, times(1)).deactivate(anyLong());
    }

    @Test
    void deactivateDepartment_directorAndNotCorrectName_conflict() throws Exception {
        CustomException ex = new CustomException("error message", HttpStatus.CONFLICT);
        doThrow(ex).when(serviceMock).deactivate(anyLong());

        mockMvc.perform(delete("/departments/1")
                        .with(jwt().jwt(DIRECTOR_JWT).authorities(customConverter)))
                .andDo(print())
                .andExpect(status().isConflict());

        verify(serviceMock, times(1)).deactivate(anyLong());
    }

    @Test
    void deactivateDepartment_notDirectorOrHead_forbidden() throws Exception {
        mockMvc.perform(delete("/departments/1")
                        .with(jwt().jwt(EMPLOYEE_JWT).authorities(customConverter)))
                .andDo(print())
                .andExpect(status().isForbidden());
    }

    @Test
    void deactivateDepartment_guest_unauthorized() throws Exception {
        mockMvc.perform(delete("/departments/1")
                        .with(csrf()))
                .andDo(print())
                .andExpect(status().isUnauthorized());
    }

    @Test
    void findDepartment_anuUser_ok() throws Exception {
        DirectorateDtoOutput dirDto = new DirectorateDtoOutput(1L, "dir", "dir_description");
        DepartmentDtoOutput depDto = new DepartmentDtoOutput(1L, "dep", "dep_description", dirDto);
        when(serviceMock.findAll(anyInt(), anyInt())).thenReturn(List.of(depDto));

        mockMvc.perform(get("/departments")
                        .with(jwt().jwt(HEAD_JWT).authorities(customConverter)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.*", hasSize(1)));

        verify(serviceMock, times(1)).findAll(anyInt(), anyInt());
    }

    @Test
    void findDepartment_guest_unauthorized() throws Exception {
        mockMvc.perform(get("/departments")
                        .with(csrf()))
                .andDo(print())
                .andExpect(status().isUnauthorized());
    }

    @Test
    void findAllDepartmentByDirectorate_anuUserAndCorrectData_ok() throws Exception {
        DirectorateDtoOutput dirDto = new DirectorateDtoOutput(1L, "dir", "dir_description");
        DepartmentDtoOutput depDto = new DepartmentDtoOutput(1L, "dep", "dep_description", dirDto);
        when(serviceMock.findAllByDirectorate(anyLong(), anyInt(), anyInt())).thenReturn(List.of(depDto));

        mockMvc.perform(get("/directorates/1/departments")
                        .with(jwt().jwt(EMPLOYEE_JWT).authorities(customConverter)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.*", hasSize(1)));

        verify(serviceMock, times(1)).findAllByDirectorate(anyLong(), anyInt(), anyInt());
    }

    @Test
    void findAllDepartmentByDirectorate_guest_unauthorized() throws Exception {
        mockMvc.perform(get("/directorates/1/departments")
                        .with(csrf()))
                .andDo(print())
                .andExpect(status().isUnauthorized());
    }
}