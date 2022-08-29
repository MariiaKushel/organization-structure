package com.mariiakushel.task.service.util;

import com.mariiakushel.task.repository.entity.Department;
import com.mariiakushel.task.repository.entity.Directorate;
import com.mariiakushel.task.repository.entity.Employee;
import com.mariiakushel.task.service.dto.DepartmentDtoInput;
import com.mariiakushel.task.service.dto.DepartmentDtoOutput;
import com.mariiakushel.task.service.dto.DirectorateDtoInput;
import com.mariiakushel.task.service.dto.DirectorateDtoOutput;
import com.mariiakushel.task.service.dto.EmployeeDtoInputCreate;
import com.mariiakushel.task.service.dto.EmployeeDtoOutput;

import java.util.List;

public class DtoEntityConvertor {

    public static Directorate convert(DirectorateDtoInput dto) {
        Directorate dir = new Directorate();
        dir.setName(dto.getName());
        dir.setDescription(dto.getDescription());
        return dir;
    }

    public static DirectorateDtoOutput convert(Directorate dir) {
        DirectorateDtoOutput dto = new DirectorateDtoOutput();
        dto.setId(dir.getId());
        dto.setName(dir.getName());
        dto.setDescription(dir.getDescription());
        return dto;
    }

    public static List<DirectorateDtoOutput> convertDirectorates(List<Directorate> dirs) {
        return dirs.stream()
                .map(DtoEntityConvertor::convert)
                .toList();
    }

    public static Department convert(DepartmentDtoInput dto) {
        Department dep = new Department();
        dep.setName(dto.getName());
        dep.setDescription(dto.getDescription());
        return dep;
    }

    public static DepartmentDtoOutput convert(Department dep) {
        DepartmentDtoOutput dto = new DepartmentDtoOutput();
        dto.setId(dep.getId());
        dto.setName(dep.getName());
        dto.setDescription(dep.getDescription());
        DirectorateDtoOutput dirDto = convert(dep.getDirectorate());
        dto.setDirectorate(dirDto);
        return dto;
    }

    public static List<DepartmentDtoOutput> convertDepartments(List<Department> deps) {
        return deps.stream()
                .map(DtoEntityConvertor::convert)
                .toList();
    }

    public static Employee convert(EmployeeDtoInputCreate dto) {
        Employee emp = new Employee();
        emp.setName(dto.getName());
        emp.setSurname(dto.getSurname());
        emp.setPersonalId(dto.getPersonalId());
        emp.setAge(dto.getAge());
        emp.setPosition(dto.getPosition());
        return emp;
    }

    public static EmployeeDtoOutput convert(Employee emp) {
        EmployeeDtoOutput dto = new EmployeeDtoOutput();
        dto.setId(emp.getId());
        dto.setName(emp.getName());
        dto.setSurname(emp.getSurname());
        dto.setPersonalId(emp.getPersonalId());
        dto.setAge(emp.getAge());
        dto.setPosition(emp.getPosition());
        Department dep = emp.getSubdepartment().getDepartment();
        DepartmentDtoOutput depDto = convert(dep);
        dto.setDepartment(depDto);
        return dto;
    }

    public static List<EmployeeDtoOutput> convertEmployees(List<Employee> emps) {
        return emps.stream()
                .map(DtoEntityConvertor::convert)
                .toList();
    }
}
