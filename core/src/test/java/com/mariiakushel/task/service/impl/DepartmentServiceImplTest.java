package com.mariiakushel.task.service.impl;

import com.mariiakushel.task.exception.CustomException;
import com.mariiakushel.task.repository.DepartmentRepository;
import com.mariiakushel.task.repository.DirectorateRepository;
import com.mariiakushel.task.repository.EmployeeRepository;
import com.mariiakushel.task.repository.entity.Department;
import com.mariiakushel.task.repository.entity.Directorate;
import com.mariiakushel.task.repository.entity.Subdepartment;
import com.mariiakushel.task.service.DepartmentService;
import com.mariiakushel.task.service.dto.DepartmentDtoInput;
import com.mariiakushel.task.service.dto.DepartmentDtoOutput;
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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class DepartmentServiceImplTest {

    private DepartmentService service;
    private DirectorateRepository dirRepositoryMock;
    private DepartmentRepository depRepositoryMock;
    private EmployeeRepository empRepositoryMock;

    public DepartmentServiceImplTest() {
        this.dirRepositoryMock = mock(DirectorateRepository.class);
        this.depRepositoryMock = mock(DepartmentRepository.class);
        this.empRepositoryMock = mock(EmployeeRepository.class);
        this.service = new DepartmentServiceImpl(depRepositoryMock, empRepositoryMock, dirRepositoryMock);
    }

    @Test
    void create() throws CustomException {
        Directorate dir = new Directorate(1L);
        dir.setName("dir");
        dir.setDescription("dir_description");
        dir.setActive(true);
        Department dep = new Department();
        dep.setId(1L);
        dep.setName("new_dep");
        dep.setDescription("new_dep_description");
        dep.setDirectorate(dir);
        when(dirRepositoryMock.findByIdAndActive(anyLong(), eq(true))).thenReturn(Optional.of(dir));
        when(depRepositoryMock.findByNameAndDirectorateAndActive(anyString(), any(Directorate.class), eq(true)))
                .thenReturn(Optional.empty());
        when(depRepositoryMock.save(any(Department.class))).thenReturn(dep);
        DepartmentDtoOutput expected = DtoEntityConvertor.convert(dep);
        DepartmentDtoInput dto = new DepartmentDtoInput("new_dep", "new_dep_description");
        DepartmentDtoOutput actual = service.create(1L, dto);

        verify(dirRepositoryMock, times(1)).findByIdAndActive(anyLong(), eq(true));
        verify(depRepositoryMock, times(1))
                .findByNameAndDirectorateAndActive(anyString(), any(Directorate.class), eq(true));
        verify(depRepositoryMock, times(1)).save(any(Department.class));
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void create_notFoundEx() {
        when(dirRepositoryMock.findByIdAndActive(anyLong(), eq(true))).thenReturn(Optional.empty());
        DepartmentDtoInput dto = new DepartmentDtoInput("new_dep", "new_dep_description");
        CustomException e = Assertions.assertThrows(CustomException.class, () -> service.create(1L, dto));
        HttpStatus expected = HttpStatus.NOT_FOUND;
        HttpStatus actual = e.getErrorCode();

        verify(dirRepositoryMock, times(1)).findByIdAndActive(anyLong(), eq(true));
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void create_conflictEx() {
        Directorate dir = new Directorate(1L);
        dir.setName("dir");
        dir.setDescription("dir_description");
        dir.setActive(true);
        Department dep = new Department();
        dep.setId(1L);
        dep.setName("new_dep");
        dep.setDescription("new_dep_description");
        dep.setDirectorate(dir);
        when(dirRepositoryMock.findByIdAndActive(anyLong(), eq(true))).thenReturn(Optional.of(dir));
        when(depRepositoryMock.findByNameAndDirectorateAndActive(anyString(), any(Directorate.class), eq(true)))
                .thenReturn(Optional.of(dep));
        DepartmentDtoInput dto = new DepartmentDtoInput("new_dep", "new_dep_description");
        CustomException e = Assertions.assertThrows(CustomException.class, () -> service.create(1L, dto));
        HttpStatus expected = HttpStatus.CONFLICT;
        HttpStatus actual = e.getErrorCode();

        verify(dirRepositoryMock, times(1)).findByIdAndActive(anyLong(), eq(true));
        verify(depRepositoryMock, times(1))
                .findByNameAndDirectorateAndActive(anyString(), any(Directorate.class), eq(true));
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void update() throws CustomException {
        Directorate dir = new Directorate(1L);
        dir.setName("dir");
        dir.setDescription("dir_description");
        dir.setActive(true);
        Department oldDep = new Department();
        oldDep.setId(1L);
        oldDep.setName("old_dep");
        oldDep.setDescription("old_dep_description");
        oldDep.setDirectorate(dir);
        Department updetedDep = new Department();
        updetedDep.setId(1L);
        updetedDep.setName("new_dep");
        updetedDep.setDescription("new_dep_description");
        updetedDep.setDirectorate(dir);
        when(depRepositoryMock.findByIdAndActive(anyLong(), eq(true))).thenReturn(Optional.of(oldDep));
        when(depRepositoryMock.findByNameAndDirectorateAndActive(anyString(), any(Directorate.class), eq(true)))
                .thenReturn(Optional.empty());
        when(depRepositoryMock.save(any(Department.class))).thenReturn(updetedDep);
        DepartmentDtoOutput expected = DtoEntityConvertor.convert(updetedDep);
        DepartmentDtoInput dto = new DepartmentDtoInput("new_dep", "new_dep_description");
        DepartmentDtoOutput actual = service.update(1L, dto);

        verify(depRepositoryMock, times(1)).findByIdAndActive(anyLong(), eq(true));
        verify(depRepositoryMock, times(1))
                .findByNameAndDirectorateAndActive(anyString(), any(Directorate.class), eq(true));
        verify(depRepositoryMock, times(1)).save(any(Department.class));
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void updateOnlyDescription() throws CustomException {
        Directorate dir = new Directorate(1L);
        dir.setName("dir");
        dir.setDescription("dir_description");
        dir.setActive(true);
        Department oldDep = new Department();
        oldDep.setId(1L);
        oldDep.setName("dep");
        oldDep.setDescription("old_dep_description");
        oldDep.setDirectorate(dir);
        Department updetedDep = new Department();
        updetedDep.setId(1L);
        updetedDep.setName("dep");
        updetedDep.setDescription("new_dep_description");
        updetedDep.setDirectorate(dir);
        when(depRepositoryMock.findByIdAndActive(anyLong(), eq(true))).thenReturn(Optional.of(oldDep));
        when(depRepositoryMock.findByNameAndDirectorateAndActive(anyString(), any(Directorate.class), eq(true)))
                .thenReturn(Optional.of(oldDep));
        when(depRepositoryMock.save(any(Department.class))).thenReturn(updetedDep);
        DepartmentDtoOutput expected = DtoEntityConvertor.convert(updetedDep);
        DepartmentDtoInput dto = new DepartmentDtoInput("new_dep", "new_dep_description");
        DepartmentDtoOutput actual = service.update(1L, dto);

        verify(depRepositoryMock, times(1)).findByIdAndActive(anyLong(), eq(true));
        verify(depRepositoryMock, times(1))
                .findByNameAndDirectorateAndActive(anyString(), any(Directorate.class), eq(true));
        verify(depRepositoryMock, times(1)).save(any(Department.class));
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void update_notFoundEx() {
        when(depRepositoryMock.findByIdAndActive(anyLong(), eq(true))).thenReturn(Optional.empty());
        DepartmentDtoInput dto = new DepartmentDtoInput("new_dep", "new_dep_description");
        CustomException e = Assertions.assertThrows(CustomException.class, () -> service.update(1L, dto));
        HttpStatus expected = HttpStatus.NOT_FOUND;
        HttpStatus actual = e.getErrorCode();

        verify(depRepositoryMock, times(1)).findByIdAndActive(anyLong(), eq(true));
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void update_conflictEx() {
        Directorate dir = new Directorate(1L);
        dir.setName("dir");
        dir.setDescription("dir_description");
        dir.setActive(true);
        Department dep1 = new Department();
        dep1.setId(1L);
        dep1.setName("new_dep");
        dep1.setDescription("new_dep_description");
        dep1.setDirectorate(dir);
        Department dep2 = new Department();
        dep2.setId(2L);
        dep2.setName("new_dep");
        dep2.setDescription("other_dep_description");
        dep2.setDirectorate(dir);
        when(depRepositoryMock.findByIdAndActive(anyLong(), eq(true))).thenReturn(Optional.of(dep1));
        when(depRepositoryMock.findByNameAndDirectorateAndActive(anyString(), any(Directorate.class), eq(true)))
                .thenReturn(Optional.of(dep2));
        DepartmentDtoInput dto = new DepartmentDtoInput("new_dep", "new_dep_description");
        CustomException e = Assertions.assertThrows(CustomException.class, () -> service.update(1L, dto));
        HttpStatus expected = HttpStatus.CONFLICT;
        HttpStatus actual = e.getErrorCode();

        verify(depRepositoryMock, times(1)).findByIdAndActive(anyLong(), eq(true));
        verify(depRepositoryMock, times(1))
                .findByNameAndDirectorateAndActive(anyString(), any(Directorate.class), eq(true));
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void deactivate() throws CustomException {
        Department dep = new Department();
        dep.setId(1L);
        dep.setName("dep");
        dep.setDescription("dep_description");
        Subdepartment subdep = new Subdepartment();
        subdep.setId(1L);
        dep.setSubdepartments(Set.of(subdep));
        when(depRepositoryMock.findByIdAndActive(anyLong(), eq(true))).thenReturn(Optional.of(dep));
        when(empRepositoryMock.countByActiveAndSubdepartmentDepartment(eq(true), any(Department.class)))
                .thenReturn(0L);
        when(depRepositoryMock.save(any(Department.class))).thenReturn(dep);
        service.deactivate(1L);

        verify(depRepositoryMock, times(1)).findByIdAndActive(anyLong(), eq(true));
        verify(empRepositoryMock, times(1))
                .countByActiveAndSubdepartmentDepartment(eq(true), any(Department.class));
        verify(depRepositoryMock, times(1)).save(any(Department.class));
    }

    @Test
    void deactivate_notFoundEx() {
        when(depRepositoryMock.findByIdAndActive(anyLong(), eq(true))).thenReturn(Optional.empty());
        CustomException e = Assertions.assertThrows(CustomException.class, () -> service.deactivate(1L));
        HttpStatus expected = HttpStatus.NOT_FOUND;
        HttpStatus actual = e.getErrorCode();

        verify(depRepositoryMock, times(1)).findByIdAndActive(anyLong(), eq(true));
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void deactivate_conflictEx() {
        Department dep = new Department();
        dep.setId(1L);
        dep.setName("dep");
        dep.setDescription("dep_description");
        when(depRepositoryMock.findByIdAndActive(anyLong(), eq(true))).thenReturn(Optional.of(dep));
        when(empRepositoryMock.countByActiveAndSubdepartmentDepartment(eq(true), any(Department.class)))
                .thenReturn(5L);
        CustomException e = Assertions.assertThrows(CustomException.class, () -> service.deactivate(1L));
        HttpStatus expected = HttpStatus.CONFLICT;
        HttpStatus actual = e.getErrorCode();

        verify(depRepositoryMock, times(1)).findByIdAndActive(anyLong(), eq(true));
        verify(empRepositoryMock, times(1))
                .countByActiveAndSubdepartmentDepartment(eq(true), any(Department.class));
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void findById() throws CustomException {
        Directorate dir = new Directorate(1L);
        dir.setName("dir");
        dir.setDescription("dir_description");
        dir.setActive(true);
        Department dep = new Department();
        dep.setId(1L);
        dep.setName("dep");
        dep.setDescription("dep_description");
        dep.setDirectorate(dir);
        when(depRepositoryMock.findByIdAndActive(anyLong(), eq(true))).thenReturn(Optional.of(dep));
        DepartmentDtoOutput expected = DtoEntityConvertor.convert(dep);
        DepartmentDtoOutput actual = service.findById(1L);

        verify(depRepositoryMock, times(1)).findByIdAndActive(anyLong(), eq(true));
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void findById_notFoundEx() {
        when(depRepositoryMock.findByIdAndActive(anyLong(), eq(true))).thenReturn(Optional.empty());
        CustomException e = Assertions.assertThrows(CustomException.class, () -> service.findById(1L));
        HttpStatus expected = HttpStatus.NOT_FOUND;
        HttpStatus actual = e.getErrorCode();

        verify(depRepositoryMock, times(1)).findByIdAndActive(anyLong(), eq(true));
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void findAll() {
        Directorate dir = new Directorate(1L);
        dir.setName("dir");
        dir.setDescription("dir_description");
        dir.setActive(true);
        Department dep = new Department();
        dep.setId(1L);
        dep.setName("dep");
        dep.setDescription("dep_description");
        dep.setDirectorate(dir);
        Page<Department> deps = new PageImpl<>(List.of(dep));
        when(depRepositoryMock.findAllByActive(eq(true), any(Pageable.class))).thenReturn(deps);
        List<DepartmentDtoOutput> expected = DtoEntityConvertor.convertDepartments(deps.toList());
        List<DepartmentDtoOutput> actual = service.findAll(1, 10);

        verify(depRepositoryMock, times(1)).findAllByActive(eq(true), any(Pageable.class));
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void findAllByDirectorate() {
        Directorate dir = new Directorate(1L);
        dir.setName("dir");
        dir.setDescription("dir_description");
        dir.setActive(true);
        Department dep = new Department();
        dep.setId(1L);
        dep.setName("dep");
        dep.setDescription("dep_description");
        dep.setDirectorate(dir);
        Page<Department> deps = new PageImpl<>(List.of(dep));
        when(depRepositoryMock.findAllByDirectorateAndActive(any(Directorate.class), eq(true), any(Pageable.class)))
                .thenReturn(deps);
        List<DepartmentDtoOutput> expected = DtoEntityConvertor.convertDepartments(deps.toList());
        List<DepartmentDtoOutput> actual = service.findAllByDirectorate(1L, 1, 10);

        verify(depRepositoryMock, times(1))
                .findAllByDirectorateAndActive(any(Directorate.class), eq(true), any(Pageable.class));
        Assertions.assertEquals(expected, actual);
    }
}