package com.mariiakushel.task.service.impl;

import com.mariiakushel.task.exception.CustomException;
import com.mariiakushel.task.repository.DirectorateRepository;
import com.mariiakushel.task.repository.EmployeeRepository;
import com.mariiakushel.task.repository.entity.Department;
import com.mariiakushel.task.repository.entity.Directorate;
import com.mariiakushel.task.repository.entity.Subdepartment;
import com.mariiakushel.task.service.DirectorateService;
import com.mariiakushel.task.service.dto.DirectorateDtoInput;
import com.mariiakushel.task.service.dto.DirectorateDtoOutput;
import com.mariiakushel.task.service.util.DtoEntityConvertor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class DirectorateServiceImplTest {

    private DirectorateService service;
    private DirectorateRepository dirRepositoryMock;
    private EmployeeRepository empRepositoryMock;

    public DirectorateServiceImplTest() {
        this.dirRepositoryMock = mock(DirectorateRepository.class);
        this.empRepositoryMock = mock(EmployeeRepository.class);
        this.service = new DirectorateServiceImpl(dirRepositoryMock, empRepositoryMock);
    }

    @Test
    void create() throws CustomException {
        Directorate dir = new Directorate(1L);
        dir.setName("new_dir");
        dir.setDescription("new_dir_description");
        dir.setActive(true);
        when(dirRepositoryMock.findByNameAndActive(anyString(), eq(true))).thenReturn(Optional.empty());
        when(dirRepositoryMock.save(any(Directorate.class))).thenReturn(dir);
        DirectorateDtoOutput expected = DtoEntityConvertor.convert(dir);
        DirectorateDtoInput dto = new DirectorateDtoInput("new_dir", "new_dir_description");
        DirectorateDtoOutput actual = service.create(dto);

        verify(dirRepositoryMock, times(1)).findByNameAndActive(anyString(), eq(true));
        verify(dirRepositoryMock, times(1)).save(any(Directorate.class));
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void create_conflictEx() {
        Directorate dir = new Directorate(1L);
        dir.setName("new_dir");
        dir.setDescription("new_dir_description");
        dir.setActive(true);
        when(dirRepositoryMock.findByNameAndActive(anyString(), eq(true))).thenReturn(Optional.of(dir));
        DirectorateDtoInput dto = new DirectorateDtoInput("new_dir", "new_dir_description");
        CustomException e = Assertions.assertThrows(CustomException.class, () -> service.create(dto));
        HttpStatus expected = HttpStatus.CONFLICT;
        HttpStatus actual = e.getErrorCode();

        verify(dirRepositoryMock, times(1)).findByNameAndActive(anyString(), eq(true));
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void update() throws CustomException {
        Directorate oldDir = new Directorate(1L);
        oldDir.setName("old_dir");
        oldDir.setDescription("old_dir_description");
        oldDir.setActive(true);
        Directorate updatedDir = new Directorate(1L);
        updatedDir.setName("new_dir");
        updatedDir.setDescription("new_dir_description");
        updatedDir.setActive(true);
        when(dirRepositoryMock.findByIdAndActive(anyLong(), eq(true))).thenReturn(Optional.of(oldDir));
        when(dirRepositoryMock.findByNameAndActive(anyString(), eq(true))).thenReturn(Optional.empty());
        when(dirRepositoryMock.save(any(Directorate.class))).thenReturn(updatedDir);
        DirectorateDtoOutput expected = DtoEntityConvertor.convert(updatedDir);
        DirectorateDtoInput dto = new DirectorateDtoInput("new_dir", "new_dir_description");
        DirectorateDtoOutput actual = service.update(1L, dto);

        verify(dirRepositoryMock, times(1)).findByIdAndActive(anyLong(), eq(true));
        verify(dirRepositoryMock, times(1)).findByNameAndActive(anyString(), eq(true));
        verify(dirRepositoryMock, times(1)).save(any(Directorate.class));
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void updateOnlyDescription() throws CustomException {
        Directorate oldDir = new Directorate(1L);
        oldDir.setName("dir");
        oldDir.setDescription("old_dir_description");
        oldDir.setActive(true);
        Directorate updatedDir = new Directorate(1L);
        updatedDir.setName("dir");
        updatedDir.setDescription("new_dir_description");
        updatedDir.setActive(true);
        when(dirRepositoryMock.findByIdAndActive(anyLong(), eq(true))).thenReturn(Optional.of(oldDir));
        when(dirRepositoryMock.findByNameAndActive(anyString(), eq(true))).thenReturn(Optional.of(oldDir));
        when(dirRepositoryMock.save(any(Directorate.class))).thenReturn(updatedDir);
        DirectorateDtoOutput expected = DtoEntityConvertor.convert(updatedDir);
        DirectorateDtoInput dto = new DirectorateDtoInput("dir", "new_dir_description");
        DirectorateDtoOutput actual = service.update(1L, dto);

        verify(dirRepositoryMock, times(1)).findByIdAndActive(anyLong(), eq(true));
        verify(dirRepositoryMock, times(1)).findByNameAndActive(anyString(), eq(true));
        verify(dirRepositoryMock, times(1)).save(any(Directorate.class));
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void update_notFoundEx() {
        when(dirRepositoryMock.findByIdAndActive(anyLong(), eq(true))).thenReturn(Optional.empty());
        DirectorateDtoInput dto = new DirectorateDtoInput("new_dir", "new_dir_description");
        CustomException e = Assertions.assertThrows(CustomException.class, () -> service.update(1L, dto));
        HttpStatus expected = HttpStatus.NOT_FOUND;
        HttpStatus actual = e.getErrorCode();

        verify(dirRepositoryMock, times(1)).findByIdAndActive(anyLong(), eq(true));
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void update_conflictEx() {
        Directorate dir1 = new Directorate(1L);
        dir1.setName("dir");
        dir1.setDescription("dir_description");
        dir1.setActive(true);
        Directorate dir2 = new Directorate(1L);
        dir2.setName("new_dir");
        dir2.setDescription("dir_description");
        dir2.setActive(true);
        when(dirRepositoryMock.findByIdAndActive(anyLong(), eq(true))).thenReturn(Optional.of(dir1));
        when(dirRepositoryMock.findByNameAndActive(anyString(), eq(true))).thenReturn(Optional.of(dir2));
        DirectorateDtoInput dto = new DirectorateDtoInput("new_dir", "new_dir_description");
        CustomException e = Assertions.assertThrows(CustomException.class, () -> service.update(1L, dto));
        HttpStatus expected = HttpStatus.CONFLICT;
        HttpStatus actual = e.getErrorCode();

        verify(dirRepositoryMock, times(1)).findByIdAndActive(anyLong(), eq(true));
        verify(dirRepositoryMock, times(1)).findByNameAndActive(anyString(), eq(true));
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void deactivate() throws CustomException {
        Directorate dir = new Directorate(1L);
        dir.setName("dir");
        dir.setDescription("dir_description");
        dir.setActive(true);
        Department dep = new Department(1L);
        dep.setSubdepartments(Set.of(new Subdepartment(1L)));
        dir.setDepartments(Set.of(dep));
        when(dirRepositoryMock.findByIdAndActive(anyLong(), eq(true))).thenReturn(Optional.of(dir));
        when(empRepositoryMock.countByActiveAndSubdepartmentDepartmentDirectorate(eq(true), any(Directorate.class)))
                .thenReturn(0L);
        when(dirRepositoryMock.save(any(Directorate.class))).thenReturn(dir);
        service.deactivate(1L);

        verify(dirRepositoryMock, times(1)).findByIdAndActive(anyLong(), eq(true));
        verify(empRepositoryMock, times(1))
                .countByActiveAndSubdepartmentDepartmentDirectorate(eq(true), any(Directorate.class));
        verify(dirRepositoryMock, times(1)).save(any(Directorate.class));
    }

    @Test
    void deactivate_notFoundEx() {
        when(dirRepositoryMock.findByIdAndActive(anyLong(), eq(true))).thenReturn(Optional.empty());
        CustomException e = Assertions.assertThrows(CustomException.class, () -> service.deactivate(1L));
        HttpStatus expected = HttpStatus.NOT_FOUND;
        HttpStatus actual = e.getErrorCode();

        verify(dirRepositoryMock, times(1)).findByIdAndActive(anyLong(), eq(true));
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void deactivate_conflictEx() {
        Directorate dir = new Directorate(1L);
        dir.setName("dir");
        dir.setDescription("dir_description");
        dir.setActive(true);
        when(dirRepositoryMock.findByIdAndActive(anyLong(), eq(true))).thenReturn(Optional.of(dir));
        when(empRepositoryMock.countByActiveAndSubdepartmentDepartmentDirectorate(eq(true), any(Directorate.class)))
                .thenReturn(5L);
        CustomException e = Assertions.assertThrows(CustomException.class, () -> service.deactivate(1L));
        HttpStatus expected = HttpStatus.CONFLICT;
        HttpStatus actual = e.getErrorCode();

        verify(dirRepositoryMock, times(1)).findByIdAndActive(anyLong(), eq(true));
        verify(empRepositoryMock, times(1))
                .countByActiveAndSubdepartmentDepartmentDirectorate(eq(true), any(Directorate.class));
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void findById() throws CustomException {
        Directorate dir = new Directorate(1L);
        dir.setName("dir");
        dir.setDescription("dir_description");
        dir.setActive(true);
        when(dirRepositoryMock.findByIdAndActive(anyLong(), eq(true))).thenReturn(Optional.of(dir));
        DirectorateDtoOutput expected = DtoEntityConvertor.convert(dir);
        DirectorateDtoOutput actual = service.findById(1L);

        verify(dirRepositoryMock, times(1)).findByIdAndActive(anyLong(), eq(true));
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void findById_notFoundEx() {
        when(dirRepositoryMock.findByIdAndActive(anyLong(), eq(true))).thenReturn(Optional.empty());
        CustomException e = Assertions.assertThrows(CustomException.class, () -> service.findById(1L));
        HttpStatus expected = HttpStatus.NOT_FOUND;
        HttpStatus actual = e.getErrorCode();

        verify(dirRepositoryMock, times(1)).findByIdAndActive(anyLong(), eq(true));
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void findAll() {
        Directorate dir = new Directorate(1L);
        dir.setName("dir");
        dir.setDescription("dir_description");
        dir.setActive(true);
        Page<Directorate> dirs = new PageImpl<>(List.of(dir));
        when(dirRepositoryMock.findAllByActive(eq(true), any(Pageable.class))).thenReturn(dirs);
        List<DirectorateDtoOutput> expected = DtoEntityConvertor.convertDirectorates(dirs.toList());
        List<DirectorateDtoOutput> actual = service.findAll(1, 10);

        verify(dirRepositoryMock, times(1)).findAllByActive(eq(true), any(Pageable.class));
        Assertions.assertEquals(expected, actual);
    }
}