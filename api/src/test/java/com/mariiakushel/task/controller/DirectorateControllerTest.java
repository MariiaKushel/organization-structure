package com.mariiakushel.task.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mariiakushel.task.ApiRunner;
import com.mariiakushel.task.exception.CustomException;
import com.mariiakushel.task.service.DirectorateService;
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

import static com.mariiakushel.task.controller.Jwts.ADMIN_JWT;
import static com.mariiakushel.task.controller.Jwts.DIRECTOR_JWT;
import static com.mariiakushel.task.controller.Jwts.EMPLOYEE_JWT;
import static com.mariiakushel.task.controller.Jwts.HEAD_JWT;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.any;
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

@WebMvcTest(DirectorateController.class)
@ContextConfiguration(classes = {ApiRunner.class, TestConfig.class})
class DirectorateControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DirectorateService serviceMock;
    @Autowired
    private ObjectMapper mapper;
    @Autowired
    private JwtGrantedAuthoritiesConverter customConverter;

    @Test
    void createDirectorate_adminAndCorrectData_created() throws Exception {
        DirectorateDtoOutput dto = new DirectorateDtoOutput(1L, "dir", "dir_description");
        when(serviceMock.create(any(DirectorateDtoInput.class))).thenReturn(dto);
        String jsonContent =
                mapper.writeValueAsString(new DirectorateDtoInput("dir", "dir_description"));

        mockMvc.perform(post("/directorates")
                        .content(jsonContent)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .with(jwt().jwt(ADMIN_JWT).authorities(customConverter)))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1L));

        verify(serviceMock, times(1)).create(any(DirectorateDtoInput.class));
    }

    @Test
    void createDirectorate_adminAndNotCorrectData_conflict() throws Exception {
        CustomException ex = new CustomException("error message", HttpStatus.CONFLICT);
        when(serviceMock.create(any(DirectorateDtoInput.class))).thenThrow(ex);
        String jsonContent =
                mapper.writeValueAsString(new DirectorateDtoInput("dir", "dir_description"));

        mockMvc.perform(post("/directorates")
                        .content(jsonContent)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .with(jwt().jwt(ADMIN_JWT).authorities(customConverter)))
                .andDo(print())
                .andExpect(status().isConflict());

        verify(serviceMock, times(1)).create(any(DirectorateDtoInput.class));
    }

    @Test
    void createDirectorate_notAdmin_forbidden() throws Exception {
        String jsonContent =
                mapper.writeValueAsString(new DirectorateDtoInput("dir", "dir_description"));

        mockMvc.perform(post("/directorates")
                        .content(jsonContent)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .with(jwt().jwt(EMPLOYEE_JWT).authorities(customConverter)))
                .andDo(print())
                .andExpect(status().isForbidden());
    }

    @Test
    void createDirectorate_guest_unauthorized() throws Exception {
        String jsonContent =
                mapper.writeValueAsString(new DirectorateDtoInput("dir", "dir_description"));

        mockMvc.perform(post("/directorates")
                        .content(jsonContent)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .with(csrf()))
                .andDo(print())
                .andExpect(status().isUnauthorized());
    }

    @Test
    void updateDirectorate_adminOrDirectorAndCorrectData_ok() throws Exception {
        DirectorateDtoOutput dto = new DirectorateDtoOutput(1L, "dir", "dir_description");
        when(serviceMock.update(anyLong(), any(DirectorateDtoInput.class))).thenReturn(dto);
        String jsonContent =
                mapper.writeValueAsString(new DirectorateDtoInput("dir", "dir_description"));

        mockMvc.perform(patch("/directorates/1")
                        .content(jsonContent)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .with(jwt().jwt(DIRECTOR_JWT).authorities(customConverter)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L));

        verify(serviceMock, times(1)).update(anyLong(), any(DirectorateDtoInput.class));
    }

    @Test
    void updateDirectorate_adminOrDirectorAndNotCorrectData_notFound() throws Exception {
        CustomException ex = new CustomException("error message", HttpStatus.NOT_FOUND);
        when(serviceMock.update(anyLong(), any(DirectorateDtoInput.class))).thenThrow(ex);
        String jsonContent =
                mapper.writeValueAsString(new DirectorateDtoInput("dir", "dir_description"));

        mockMvc.perform(patch("/directorates/1")
                        .content(jsonContent)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .with(jwt().jwt(DIRECTOR_JWT).authorities(customConverter)))
                .andDo(print())
                .andExpect(status().isNotFound());

        verify(serviceMock, times(1)).update(anyLong(), any(DirectorateDtoInput.class));
    }

    @Test
    void updateDirectorate_adminOrDirectorAndNotCorrectName_conflict() throws Exception {
        CustomException ex = new CustomException("error message", HttpStatus.CONFLICT);
        when(serviceMock.update(anyLong(), any(DirectorateDtoInput.class))).thenThrow(ex);
        String jsonContent =
                mapper.writeValueAsString(new DirectorateDtoInput("dir", "dir_description"));

        mockMvc.perform(patch("/directorates/1")
                        .content(jsonContent)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .with(jwt().jwt(DIRECTOR_JWT).authorities(customConverter)))
                .andDo(print())
                .andExpect(status().isConflict());

        verify(serviceMock, times(1)).update(anyLong(), any(DirectorateDtoInput.class));
    }

    @Test
    void updateDirectorate_notAdminOrDirector_forbidden() throws Exception {
        String jsonContent =
                mapper.writeValueAsString(new DirectorateDtoInput("dir", "dir_description"));

        mockMvc.perform(patch("/directorates/1")
                        .content(jsonContent)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .with(jwt().jwt(HEAD_JWT).authorities(customConverter)))
                .andDo(print())
                .andExpect(status().isForbidden());
    }

    @Test
    void updateDirectorate_guest_unauthorized() throws Exception {
        String jsonContent =
                mapper.writeValueAsString(new DirectorateDtoInput("dir", "dir_description"));

        mockMvc.perform(patch("/directorates/1")
                        .content(jsonContent)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .with(csrf()))
                .andDo(print())
                .andExpect(status().isUnauthorized());
    }

    @Test
    void deactivateDirectorate_admin_ok() throws Exception {
        doNothing().when(serviceMock).deactivate(anyLong());

        mockMvc.perform(delete("/directorates/1")
                        .with(jwt().jwt(ADMIN_JWT).authorities(customConverter)))
                .andDo(print())
                .andExpect(status().isOk());

        verify(serviceMock, times(1)).deactivate(anyLong());
    }

    @Test
    void deactivateDirectorate_adminAndNotCorrectId_notFound() throws Exception {
        CustomException ex = new CustomException("error message", HttpStatus.NOT_FOUND);
        doThrow(ex).when(serviceMock).deactivate(anyLong());

        mockMvc.perform(delete("/directorates/1")
                        .with(jwt().jwt(ADMIN_JWT).authorities(customConverter)))
                .andDo(print())
                .andExpect(status().isNotFound());

        verify(serviceMock, times(1)).deactivate(anyLong());
    }

    @Test
    void deactivateDirectorate_notAdmin_forbidden() throws Exception {
        mockMvc.perform(delete("/directorates/1")
                        .with(jwt().jwt(HEAD_JWT).authorities(customConverter)))
                .andDo(print())
                .andExpect(status().isForbidden());
    }

    @Test
    void deactivateDirectorate_guest_unauthorized() throws Exception {
        mockMvc.perform(delete("/directorates/1")
                        .with(csrf()))
                .andDo(print())
                .andExpect(status().isUnauthorized());
    }

    @Test
    void findDirectorate_anyUserAndCorrectId_ok() throws Exception {
        DirectorateDtoOutput dto = new DirectorateDtoOutput(1L, "dir", "dir_description");
        when(serviceMock.findById(anyLong())).thenReturn(dto);
        String jsonContent =
                mapper.writeValueAsString(new DirectorateDtoInput("dir", "dir_description"));

        mockMvc.perform(get("/directorates/1")
                        .content(jsonContent)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .with(jwt().jwt(EMPLOYEE_JWT).authorities(customConverter)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L));

        verify(serviceMock, times(1)).findById(anyLong());
    }

    @Test
    void findDirectorate_anyUserAndNotCorrectId_notFound() throws Exception {
        CustomException ex = new CustomException("error message", HttpStatus.NOT_FOUND);
        when(serviceMock.findById(anyLong())).thenThrow(ex);
        String jsonContent =
                mapper.writeValueAsString(new DirectorateDtoInput("dir", "dir_description"));

        mockMvc.perform(get("/directorates/1")
                        .content(jsonContent)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .with(jwt().jwt(EMPLOYEE_JWT).authorities(customConverter)))
                .andDo(print())
                .andExpect(status().isNotFound());

        verify(serviceMock, times(1)).findById(anyLong());
    }

    @Test
    void findDirectorate_guest_unauthorized() throws Exception {
        mockMvc.perform(get("/directorates/1")
                        .with(csrf()))
                .andDo(print())
                .andExpect(status().isUnauthorized());
    }

    @Test
    void findAllDirectorates_anyUser_ok() throws Exception {
        DirectorateDtoOutput dto = new DirectorateDtoOutput(1L, "dir", "dir_description");
        when(serviceMock.findAll(anyInt(), anyInt())).thenReturn(List.of(dto));
        String jsonContent =
                mapper.writeValueAsString(new DirectorateDtoInput("dir", "dir_description"));

        mockMvc.perform(get("/directorates")
                        .content(jsonContent)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .with(jwt().jwt(EMPLOYEE_JWT).authorities(customConverter)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.*", hasSize(1)));

        verify(serviceMock, times(1)).findAll(anyInt(), anyInt());
    }
    @Test
    void findAllDirectorates_guest_unauthorized() throws Exception {
        mockMvc.perform(get("/directorates")
                        .with(csrf()))
                .andDo(print())
                .andExpect(status().isUnauthorized());
    }
}