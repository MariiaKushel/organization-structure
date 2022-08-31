package com.mariiakushel.task.service.impl;

import com.mariiakushel.task.enumeration.Position;
import com.mariiakushel.task.enumeration.SubdepartmentType;
import com.mariiakushel.task.exception.CustomException;
import com.mariiakushel.task.repository.DepartmentRepository;
import com.mariiakushel.task.repository.EmployeeRepository;
import com.mariiakushel.task.repository.entity.Department;
import com.mariiakushel.task.repository.entity.Directorate;
import com.mariiakushel.task.repository.entity.Employee;
import com.mariiakushel.task.repository.entity.Subdepartment;
import com.mariiakushel.task.repository.entity.User;
import com.mariiakushel.task.service.EmployeeService;
import com.mariiakushel.task.service.dto.EmployeeDtoInputCreate;
import com.mariiakushel.task.service.dto.EmployeeDtoInputUpdate;
import com.mariiakushel.task.service.dto.EmployeeDtoOutput;
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

class EmployeeServiceImplTest {

    private EmployeeService service;
    private EmployeeRepository empRepositoryMock;
    private DepartmentRepository depRepositoryMock;

    public EmployeeServiceImplTest() {
        this.empRepositoryMock = mock(EmployeeRepository.class);
        this.depRepositoryMock = mock(DepartmentRepository.class);
        this.service = new EmployeeServiceImpl(empRepositoryMock, depRepositoryMock);
    }

    @Test
    void create() throws CustomException {
        Directorate dir = new Directorate(1L);
        dir.setName("dir");
        dir.setDescription("dir_description");
        dir.setActive(true);
        Department dep = new Department();
        dep.setId(1L);
        dep.setName("dep");
        dep.setDescription("dep_description");
        dep.setDirectorate(dir);
        Subdepartment subdep = new Subdepartment();
        subdep.setId(1L);
        subdep.setType(SubdepartmentType.EMPLOYEES);
        subdep.setDepartment(dep);
        dep.setSubdepartments(Set.of(subdep));
        Employee emp = new Employee();
        emp.setId(1L);
        emp.setName("name");
        emp.setSurname("surname");
        emp.setAge(30);
        emp.setPersonalId("999999999");
        emp.setPosition(Position.EMPLOYEE);
        emp.setSubdepartment(subdep);
        when(depRepositoryMock.findByIdAndActive(anyLong(), eq(true))).thenReturn(Optional.of(dep));
        when(empRepositoryMock.findByPersonalIdAndActive(anyString(), eq(true))).thenReturn(Optional.empty());
        when(empRepositoryMock.save(any(Employee.class))).thenReturn(emp);

        EmployeeDtoOutput expected = DtoEntityConvertor.convert(emp);
        EmployeeDtoInputCreate dto =
                new EmployeeDtoInputCreate("name", "surname", "999999999", 30, Position.EMPLOYEE);
        EmployeeDtoOutput actual = service.create(1L, dto);

        verify(depRepositoryMock, times(1)).findByIdAndActive(anyLong(), eq(true));
        verify(empRepositoryMock, times(1)).findByPersonalIdAndActive(anyString(), eq(true));
        verify(empRepositoryMock, times(1)).save(any(Employee.class));
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void create_notFoundEx() {
        when(depRepositoryMock.findByIdAndActive(anyLong(), eq(true))).thenReturn(Optional.empty());
        EmployeeDtoInputCreate dto =
                new EmployeeDtoInputCreate("name", "surname", "999999999", 30, Position.EMPLOYEE);
        CustomException e = Assertions.assertThrows(CustomException.class, () -> service.create(1L, dto));
        HttpStatus expected = HttpStatus.NOT_FOUND;
        HttpStatus actual = e.getErrorCode();

        verify(depRepositoryMock, times(1)).findByIdAndActive(anyLong(), eq(true));
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void create_conflictEx() {
        Department dep = new Department();
        dep.setId(1L);
        dep.setName("dep");
        dep.setDescription("dep_description");
        Employee emp = new Employee();
        emp.setId(1L);
        emp.setName("other_name");
        emp.setSurname("other_surname");
        emp.setAge(35);
        emp.setPersonalId("999999999");
        emp.setPosition(Position.HEAD_OF_DEPARTMENT);
        when(depRepositoryMock.findByIdAndActive(anyLong(), eq(true))).thenReturn(Optional.of(dep));
        when(empRepositoryMock.findByPersonalIdAndActive(anyString(), eq(true))).thenReturn(Optional.of(emp));
        EmployeeDtoInputCreate dto =
                new EmployeeDtoInputCreate("name", "surname", "999999999", 30, Position.EMPLOYEE);
        CustomException e = Assertions.assertThrows(CustomException.class, () -> service.create(1L, dto));
        HttpStatus expected = HttpStatus.CONFLICT;
        HttpStatus actual = e.getErrorCode();

        verify(depRepositoryMock, times(1)).findByIdAndActive(anyLong(), eq(true));
        verify(empRepositoryMock, times(1)).findByPersonalIdAndActive(anyString(), eq(true));
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void update_position() throws CustomException {
        Directorate dir = new Directorate(1L);
        dir.setName("dir");
        dir.setDescription("dir_description");
        dir.setActive(true);
        Department dep = new Department();
        dep.setId(1L);
        dep.setName("dep");
        dep.setDescription("dep_description");
        dep.setDirectorate(dir);
        Subdepartment subdep1 = new Subdepartment();
        subdep1.setId(1L);
        subdep1.setType(SubdepartmentType.EMPLOYEES);
        subdep1.setDepartment(dep);
        Subdepartment subdep2 = new Subdepartment();
        subdep2.setId(2L);
        subdep2.setType(SubdepartmentType.HEADS);
        subdep2.setDepartment(dep);
        dep.setSubdepartments(Set.of(subdep1, subdep2));
        Employee emp = new Employee();
        emp.setId(1L);
        emp.setName("name");
        emp.setSurname("surname");
        emp.setAge(30);
        emp.setPersonalId("999999999");
        emp.setPosition(Position.EMPLOYEE);
        emp.setSubdepartment(subdep1);
        Employee updatedEmp = new Employee();
        updatedEmp.setId(1L);
        updatedEmp.setName("name");
        updatedEmp.setSurname("surname");
        updatedEmp.setAge(30);
        updatedEmp.setPersonalId("999999999");
        updatedEmp.setPosition(Position.HEAD_OF_DEPARTMENT);
        updatedEmp.setSubdepartment(subdep1);
        when(empRepositoryMock.findByIdAndActive(anyLong(), eq(true))).thenReturn(Optional.of(emp));
        when(depRepositoryMock.findByIdAndActive(anyLong(), eq(true))).thenReturn(Optional.of(dep));
        when(empRepositoryMock.countByActiveAndSubdepartment(eq(true), any(Subdepartment.class))).thenReturn(0L);
        when(empRepositoryMock.save(any(Employee.class))).thenReturn(emp);

        EmployeeDtoOutput expected = DtoEntityConvertor.convert(updatedEmp);
        EmployeeDtoInputUpdate dto =
                new EmployeeDtoInputUpdate("name", "surname", 30, Position.HEAD_OF_DEPARTMENT, 1L);
        EmployeeDtoOutput actual = service.update(1L, dto);

        verify(empRepositoryMock, times(1)).findByIdAndActive(anyLong(), eq(true));
        verify(depRepositoryMock, times(1)).findByIdAndActive(anyLong(), eq(true));
        verify(empRepositoryMock, times(1)).countByActiveAndSubdepartment(eq(true), any(Subdepartment.class));
        verify(empRepositoryMock, times(1)).save(any(Employee.class));
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void update_position_conflictOverflowEx() {
        Directorate dir = new Directorate(1L);
        dir.setName("dir");
        dir.setDescription("dir_description");
        dir.setActive(true);
        Department dep = new Department();
        dep.setId(1L);
        dep.setName("dep");
        dep.setDescription("dep_description");
        dep.setDirectorate(dir);
        Subdepartment subdep1 = new Subdepartment();
        subdep1.setId(1L);
        subdep1.setType(SubdepartmentType.EMPLOYEES);
        subdep1.setDepartment(dep);
        Subdepartment subdep2 = new Subdepartment();
        subdep2.setId(2L);
        subdep2.setType(SubdepartmentType.HEADS);
        subdep2.setDepartment(dep);
        dep.setSubdepartments(Set.of(subdep1, subdep2));
        Employee emp = new Employee();
        emp.setId(1L);
        emp.setName("name");
        emp.setSurname("surname");
        emp.setAge(30);
        emp.setPersonalId("999999999");
        emp.setPosition(Position.EMPLOYEE);
        emp.setSubdepartment(subdep1);
        when(empRepositoryMock.findByIdAndActive(anyLong(), eq(true))).thenReturn(Optional.of(emp));
        when(depRepositoryMock.findByIdAndActive(anyLong(), eq(true))).thenReturn(Optional.of(dep));
        when(empRepositoryMock.countByActiveAndSubdepartment(eq(true), any(Subdepartment.class))).thenReturn(5L);

        EmployeeDtoInputUpdate dto =
                new EmployeeDtoInputUpdate("name", "surname", 30, Position.HEAD_OF_DEPARTMENT, 1L);
        CustomException e = Assertions.assertThrows(CustomException.class, () -> service.update(1L, dto));
        HttpStatus expected = HttpStatus.CONFLICT;
        HttpStatus actual = e.getErrorCode();

        verify(empRepositoryMock, times(1)).findByIdAndActive(anyLong(), eq(true));
        verify(depRepositoryMock, times(1)).findByIdAndActive(anyLong(), eq(true));
        verify(empRepositoryMock, times(1)).countByActiveAndSubdepartment(eq(true), any(Subdepartment.class));
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void update_position_conflictNotAvaliablePositionEx() {
        Directorate dir = new Directorate(1L);
        dir.setName("dir");
        dir.setDescription("dir_description");
        dir.setActive(true);
        Department dep = new Department();
        dep.setId(1L);
        dep.setName("dep");
        dep.setDescription("dep_description");
        dep.setDirectorate(dir);
        Subdepartment subdep1 = new Subdepartment();
        subdep1.setId(1L);
        subdep1.setType(SubdepartmentType.EMPLOYEES);
        subdep1.setDepartment(dep);
        Subdepartment subdep2 = new Subdepartment();
        subdep2.setId(2L);
        subdep2.setType(SubdepartmentType.HEADS);
        subdep2.setDepartment(dep);
        dep.setSubdepartments(Set.of(subdep1, subdep2));
        Employee emp = new Employee();
        emp.setId(1L);
        emp.setName("name");
        emp.setSurname("surname");
        emp.setAge(30);
        emp.setPersonalId("999999999");
        emp.setPosition(Position.EMPLOYEE);
        emp.setSubdepartment(subdep1);
        when(empRepositoryMock.findByIdAndActive(anyLong(), eq(true))).thenReturn(Optional.of(emp));
        when(depRepositoryMock.findByIdAndActive(anyLong(), eq(true))).thenReturn(Optional.of(dep));

        EmployeeDtoInputUpdate dto =
                new EmployeeDtoInputUpdate("name", "surname", 30, Position.DIRECTOR_OF_DIRECTORATE, 1L);
        CustomException e = Assertions.assertThrows(CustomException.class, () -> service.update(1L, dto));
        HttpStatus expected = HttpStatus.CONFLICT;
        HttpStatus actual = e.getErrorCode();

        verify(empRepositoryMock, times(1)).findByIdAndActive(anyLong(), eq(true));
        verify(depRepositoryMock, times(1)).findByIdAndActive(anyLong(), eq(true));
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void update_department() throws CustomException {
        Directorate dir = new Directorate(1L);
        dir.setName("dir");
        dir.setDescription("dir_description");
        dir.setActive(true);
        Department dep = new Department();
        dep.setId(1L);
        dep.setName("dep");
        dep.setDescription("dep_description");
        dep.setDirectorate(dir);
        Subdepartment subdep1 = new Subdepartment();
        subdep1.setId(1L);
        subdep1.setType(SubdepartmentType.EMPLOYEES);
        subdep1.setDepartment(dep);
        Subdepartment subdep2 = new Subdepartment();
        subdep2.setId(2L);
        subdep2.setType(SubdepartmentType.HEADS);
        subdep2.setDepartment(dep);
        dep.setSubdepartments(Set.of(subdep1, subdep2));
        Employee emp = new Employee();
        emp.setId(1L);
        emp.setName("name");
        emp.setSurname("surname");
        emp.setAge(30);
        emp.setPersonalId("999999999");
        emp.setPosition(Position.EMPLOYEE);
        emp.setSubdepartment(subdep1);
        Department otherDep = new Department();
        otherDep.setId(2L);
        otherDep.setName("dep");
        otherDep.setDescription("dep_description");
        otherDep.setDirectorate(dir);
        Subdepartment subdep3 = new Subdepartment();
        subdep3.setId(3L);
        subdep3.setType(SubdepartmentType.EMPLOYEES);
        subdep3.setDepartment(otherDep);
        otherDep.setSubdepartments(Set.of(subdep3));
        Employee updatedEmp = new Employee();
        updatedEmp.setId(1L);
        updatedEmp.setName("name");
        updatedEmp.setSurname("surname");
        updatedEmp.setAge(30);
        updatedEmp.setPersonalId("999999999");
        updatedEmp.setPosition(Position.EMPLOYEE);
        updatedEmp.setSubdepartment(subdep3);
        when(empRepositoryMock.findByIdAndActive(anyLong(), eq(true))).thenReturn(Optional.of(emp));
        when(depRepositoryMock.findByIdAndActive(anyLong(), eq(true))).thenReturn(Optional.of(otherDep));
        when(empRepositoryMock.countByActiveAndSubdepartment(eq(true), any(Subdepartment.class))).thenReturn(10L);
        when(empRepositoryMock.save(any(Employee.class))).thenReturn(emp);

        EmployeeDtoOutput expected = DtoEntityConvertor.convert(updatedEmp);
        EmployeeDtoInputUpdate dto =
                new EmployeeDtoInputUpdate("name", "surname", 30, Position.EMPLOYEE, 2L);
        EmployeeDtoOutput actual = service.update(1L, dto);

        verify(empRepositoryMock, times(1)).findByIdAndActive(anyLong(), eq(true));
        verify(depRepositoryMock, times(1)).findByIdAndActive(anyLong(), eq(true));
        verify(empRepositoryMock, times(1)).countByActiveAndSubdepartment(eq(true), any(Subdepartment.class));
        verify(empRepositoryMock, times(1)).save(any(Employee.class));
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void update_department_noFoundEx() {
        Directorate dir = new Directorate(1L);
        dir.setName("dir");
        dir.setDescription("dir_description");
        dir.setActive(true);
        Department dep = new Department();
        dep.setId(1L);
        dep.setName("dep");
        dep.setDescription("dep_description");
        dep.setDirectorate(dir);
        Subdepartment subdep1 = new Subdepartment();
        subdep1.setId(1L);
        subdep1.setType(SubdepartmentType.EMPLOYEES);
        subdep1.setDepartment(dep);
        Subdepartment subdep2 = new Subdepartment();
        subdep2.setId(2L);
        subdep2.setType(SubdepartmentType.HEADS);
        subdep2.setDepartment(dep);
        dep.setSubdepartments(Set.of(subdep1, subdep2));
        Employee emp = new Employee();
        emp.setId(1L);
        emp.setName("name");
        emp.setSurname("surname");
        emp.setAge(30);
        emp.setPersonalId("999999999");
        emp.setPosition(Position.EMPLOYEE);
        emp.setSubdepartment(subdep1);
        when(empRepositoryMock.findByIdAndActive(anyLong(), eq(true))).thenReturn(Optional.of(emp));
        when(depRepositoryMock.findByIdAndActive(anyLong(), eq(true))).thenReturn(Optional.empty());

        EmployeeDtoInputUpdate dto =
                new EmployeeDtoInputUpdate("name", "surname", 30, Position.EMPLOYEE, 2L);
        CustomException e = Assertions.assertThrows(CustomException.class, () -> service.update(1L, dto));
        HttpStatus expected = HttpStatus.NOT_FOUND;
        HttpStatus actual = e.getErrorCode();

        verify(empRepositoryMock, times(1)).findByIdAndActive(anyLong(), eq(true));
        verify(depRepositoryMock, times(1)).findByIdAndActive(anyLong(), eq(true));
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void deactivate() throws CustomException {
        Directorate dir = new Directorate(1L);
        dir.setName("dir");
        dir.setDescription("dir_description");
        dir.setActive(true);
        Department dep = new Department();
        dep.setId(1L);
        dep.setName("dep");
        dep.setDescription("dep_description");
        dep.setDirectorate(dir);
        Subdepartment subdep = new Subdepartment();
        subdep.setId(1L);
        subdep.setType(SubdepartmentType.EMPLOYEES);
        subdep.setDepartment(dep);
        dep.setSubdepartments(Set.of(subdep));
        Employee emp = new Employee();
        emp.setId(1L);
        emp.setName("name");
        emp.setSurname("surname");
        emp.setAge(30);
        emp.setPersonalId("999999999");
        emp.setPosition(Position.EMPLOYEE);
        emp.setSubdepartment(subdep);
        User user = new User();
        user.setId(5L);
        user.setUsername("username");
        user.setPassword("password");
        user.setActive(true);
        emp.setUser(user);
        when(empRepositoryMock.findByIdAndActive(anyLong(), eq(true))).thenReturn(Optional.of(emp));
        when(empRepositoryMock.save(any(Employee.class))).thenReturn(emp);
        service.deactivate(1L);

        verify(empRepositoryMock, times(1)).findByIdAndActive(anyLong(), eq(true));
        verify(empRepositoryMock, times(1)).save(any(Employee.class));
    }

    @Test
    void deactivate_notFoundEx() {
        when(empRepositoryMock.findByIdAndActive(anyLong(), eq(true))).thenReturn(Optional.empty());
        CustomException e = Assertions.assertThrows(CustomException.class, () -> service.deactivate(1L));
        HttpStatus expected = HttpStatus.NOT_FOUND;
        HttpStatus actual = e.getErrorCode();

        verify(empRepositoryMock, times(1)).findByIdAndActive(anyLong(), eq(true));
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
        Subdepartment subdep = new Subdepartment();
        subdep.setId(1L);
        subdep.setType(SubdepartmentType.EMPLOYEES);
        subdep.setDepartment(dep);
        dep.setSubdepartments(Set.of(subdep));
        Employee emp = new Employee();
        emp.setId(1L);
        emp.setName("name");
        emp.setSurname("surname");
        emp.setAge(30);
        emp.setPersonalId("999999999");
        emp.setPosition(Position.EMPLOYEE);
        emp.setSubdepartment(subdep);
        when(empRepositoryMock.findByIdAndActive(anyLong(), eq(true))).thenReturn(Optional.of(emp));
        EmployeeDtoOutput expected = DtoEntityConvertor.convert(emp);
        EmployeeDtoOutput actual = service.findById(1L);

        verify(empRepositoryMock, times(1)).findByIdAndActive(anyLong(), eq(true));
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void findById_notFoundEx() {
        when(empRepositoryMock.findByIdAndActive(anyLong(), eq(true))).thenReturn(Optional.empty());
        CustomException e = Assertions.assertThrows(CustomException.class, () -> service.findById(1L));
        HttpStatus expected = HttpStatus.NOT_FOUND;
        HttpStatus actual = e.getErrorCode();

        verify(empRepositoryMock, times(1)).findByIdAndActive(anyLong(), eq(true));
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
        Subdepartment subdep = new Subdepartment();
        subdep.setId(1L);
        subdep.setType(SubdepartmentType.EMPLOYEES);
        subdep.setDepartment(dep);
        dep.setSubdepartments(Set.of(subdep));
        Employee emp = new Employee();
        emp.setId(1L);
        emp.setName("name");
        emp.setSurname("surname");
        emp.setAge(30);
        emp.setPersonalId("999999999");
        emp.setPosition(Position.EMPLOYEE);
        emp.setSubdepartment(subdep);
        Page<Employee> emps = new PageImpl<>(List.of(emp));
        when(empRepositoryMock.findAllByActive(eq(true), any(Pageable.class))).thenReturn(emps);
        List<EmployeeDtoOutput> expected = DtoEntityConvertor.convertEmployees(emps.toList());
        List<EmployeeDtoOutput> actual = service.findAll(1, 10);

        verify(empRepositoryMock, times(1)).findAllByActive(eq(true), any(Pageable.class));
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void findAllByDepartment() throws CustomException {
        Directorate dir = new Directorate(1L);
        dir.setName("dir");
        dir.setDescription("dir_description");
        dir.setActive(true);
        Department dep = new Department();
        dep.setId(1L);
        dep.setName("dep");
        dep.setDescription("dep_description");
        dep.setDirectorate(dir);
        Subdepartment subdep = new Subdepartment();
        subdep.setId(1L);
        subdep.setType(SubdepartmentType.HEADS);
        subdep.setDepartment(dep);
        dep.setSubdepartments(Set.of(subdep));
        Employee emp = new Employee();
        emp.setId(1L);
        emp.setName("name");
        emp.setSurname("surname");
        emp.setAge(30);
        emp.setPersonalId("999999999");
        emp.setPosition(Position.HEAD_OF_DEPARTMENT);
        emp.setSubdepartment(subdep);
        List<Employee> emps = List.of(emp);
        when(empRepositoryMock.findByIdAndActive(anyLong(), eq(true))).thenReturn(Optional.of(emp));
        when(empRepositoryMock
                .findAllByActiveAndSubdepartmentDepartment(eq(true), any(Department.class), any(Pageable.class)))
                .thenReturn(emps);
        List<EmployeeDtoOutput> expected = DtoEntityConvertor.convertEmployees(emps);
        List<EmployeeDtoOutput> actual = service.findAllByDepartment(1L, 1, 10);

        verify(empRepositoryMock, times(1)).findByIdAndActive(anyLong(), eq(true));
        verify(empRepositoryMock, times(1))
                .findAllByActiveAndSubdepartmentDepartment(eq(true), any(Department.class), any(Pageable.class));
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void findAllByDepartment_notFoundEx() {
        when(empRepositoryMock.findByIdAndActive(anyLong(), eq(true))).thenReturn(Optional.empty());
        CustomException e = Assertions.assertThrows(CustomException.class, () -> service.findAllByDepartment(1L, 1, 10));
        HttpStatus expected = HttpStatus.NOT_FOUND;
        HttpStatus actual = e.getErrorCode();

        verify(empRepositoryMock, times(1)).findByIdAndActive(anyLong(), eq(true));
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void findAllByDirectorate() throws CustomException {
        Directorate dir = new Directorate(1L);
        dir.setName("dir");
        dir.setDescription("dir_description");
        dir.setActive(true);
        Department dep = new Department();
        dep.setId(1L);
        dep.setName("dep");
        dep.setDescription("dep_description");
        dep.setDirectorate(dir);
        Subdepartment subdep = new Subdepartment();
        subdep.setId(1L);
        subdep.setType(SubdepartmentType.HEADS);
        subdep.setDepartment(dep);
        dep.setSubdepartments(Set.of(subdep));
        Employee emp = new Employee();
        emp.setId(1L);
        emp.setName("name");
        emp.setSurname("surname");
        emp.setAge(30);
        emp.setPersonalId("999999999");
        emp.setPosition(Position.HEAD_OF_DEPARTMENT);
        emp.setSubdepartment(subdep);
        List<Employee> emps = List.of(emp);
        when(empRepositoryMock.findByIdAndActive(anyLong(), eq(true))).thenReturn(Optional.of(emp));
        when(empRepositoryMock
                .findAllByActiveAndSubdepartmentDepartmentDirectorate(eq(true), any(Directorate.class), any(Pageable.class)))
                .thenReturn(emps);
        List<EmployeeDtoOutput> expected = DtoEntityConvertor.convertEmployees(emps);
        List<EmployeeDtoOutput> actual = service.findAllByDirectorate(1L, 1, 10);

        verify(empRepositoryMock, times(1)).findByIdAndActive(anyLong(), eq(true));
        verify(empRepositoryMock, times(1))
                .findAllByActiveAndSubdepartmentDepartmentDirectorate(eq(true), any(Directorate.class), any(Pageable.class));
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void findAllByDirectorate_notFoundEx() {
        when(empRepositoryMock.findByIdAndActive(anyLong(), eq(true))).thenReturn(Optional.empty());
        CustomException e = Assertions.assertThrows(CustomException.class, () -> service.findAllByDirectorate(1L, 1, 10));
        HttpStatus expected = HttpStatus.NOT_FOUND;
        HttpStatus actual = e.getErrorCode();

        verify(empRepositoryMock, times(1)).findByIdAndActive(anyLong(), eq(true));
        Assertions.assertEquals(expected, actual);
    }
}