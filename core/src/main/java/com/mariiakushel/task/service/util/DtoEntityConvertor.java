package com.mariiakushel.task.service.util;

import com.mariiakushel.task.repository.entity.Department;
import com.mariiakushel.task.repository.entity.Directorate;
import com.mariiakushel.task.service.dto.DepartmentDtoInput;
import com.mariiakushel.task.service.dto.DepartmentDtoOutput;
import com.mariiakushel.task.service.dto.DirectorateDtoInput;
import com.mariiakushel.task.service.dto.DirectorateDtoOutput;

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
        return dto;
    }

    public static List<DepartmentDtoOutput> convertDepartments(List<Department> deps) {
        return deps.stream()
                .map(DtoEntityConvertor::convert)
                .toList();
    }
}
