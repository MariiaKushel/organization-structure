package com.mariiakushel.task.service.impl;

import com.mariiakushel.task.enumeration.Position;
import com.mariiakushel.task.enumeration.SubdepartmentType;
import com.mariiakushel.task.exception.CustomException;
import com.mariiakushel.task.repository.DepartmentRepository;
import com.mariiakushel.task.repository.EmployeeRepository;
import com.mariiakushel.task.repository.entity.Department;
import com.mariiakushel.task.repository.entity.Employee;
import com.mariiakushel.task.repository.entity.Subdepartment;
import com.mariiakushel.task.service.EmployeeService;
import com.mariiakushel.task.service.dto.EmployeeDtoInputCreate;
import com.mariiakushel.task.service.dto.EmployeeDtoInputUpdate;
import com.mariiakushel.task.service.dto.EmployeeDtoOutput;
import com.mariiakushel.task.service.util.DtoEntityConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository repository;
    private DepartmentRepository depRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository repository, DepartmentRepository depRepository) {
        this.repository = repository;
        this.depRepository = depRepository;
    }

    @Override
    @Transactional
    public EmployeeDtoOutput create(Long idDep, EmployeeDtoInputCreate dto) throws CustomException {
        Department dep = depRepository.findByIdAndActive(idDep, true)
                .orElseThrow(() -> new CustomException("resource not found id=" + idDep, HttpStatus.NOT_FOUND));
        Optional<Employee> personalIdCheck = repository.findByPersonalIdAndActive(dto.getPersonalId(), true);
        if (personalIdCheck.isPresent()) {
            throw new CustomException(
                    new StringBuilder()
                            .append("Employee with personal id '")
                            .append(dto.getPersonalId())
                            .append("' already exist.")
                            .toString(),
                    HttpStatus.CONFLICT);
        }
        Employee emp = DtoEntityConvertor.convert(dto);
        chooseSubdepartment(emp, dep);
        Employee newEmp = repository.save(emp);
        return DtoEntityConvertor.convert(newEmp);
    }

    @Override
    @Transactional
    public EmployeeDtoOutput update(Long id, EmployeeDtoInputUpdate dto) throws CustomException {
        Optional<Employee> optEmp = repository.findByIdAndActive(id, true);
        Employee emp = optEmp
                .orElseThrow(() -> new CustomException("resource not found id=" + id, HttpStatus.NOT_FOUND));
        refreshData(emp, dto);
        Employee newEmp = repository.save(emp);
        return DtoEntityConvertor.convert(newEmp);
    }

    @Override
    public void deactivate(Long id) throws CustomException {
        Optional<Employee> optEmp = repository.findByIdAndActive(id, true);
        Employee emp = optEmp
                .orElseThrow(() -> new CustomException("resource not found id=" + id, HttpStatus.NOT_FOUND));
        emp.setActive(false);
        repository.save(emp);
    }


    @Override
    public EmployeeDtoOutput findById(Long id) throws CustomException {
        Optional<Employee> optEmp = repository.findByIdAndActive(id, true);
        Employee emp = optEmp
                .orElseThrow(() -> new CustomException("resource not found id=" + id, HttpStatus.NOT_FOUND));
        return DtoEntityConvertor.convert(emp);
    }

    @Override
    public List<EmployeeDtoOutput> findAll(int page, int size) {
        Pageable paging = PageRequest.of(page - 1, size);
        List<Employee> emps = repository.findAllByActive(true, paging).toList();
        return DtoEntityConvertor.convertEmployees(emps);
    }

    @Override
    public List<EmployeeDtoOutput> findAllByDepartment(Long idDep, int page, int size) {
        Pageable paging = PageRequest.of(page - 1, size);
        List<Employee> emps = repository.findAllByActiveAndDepartment(true, idDep, paging);
        return DtoEntityConvertor.convertEmployees(emps);
    }

    @Override
    public List<EmployeeDtoOutput> findAllByDirectorate(Long idDir, int page, int size) {
        Pageable paging = PageRequest.of(page - 1, size);
        List<Employee> emps = repository.findAllByActiveAndDirectorate(true, idDir, paging);
        return DtoEntityConvertor.convertEmployees(emps);
    }

    private void chooseSubdepartment(Employee emp, Department dep) throws CustomException {
        SubdepartmentType subdepartmentType = emp.getPosition().getSubdepartmentType();
        Optional<Subdepartment> subdepOpt = dep.getSubdepartments().stream()
                .filter(e -> e.getType().equals(subdepartmentType))
                .findFirst();
        Subdepartment subdep = subdepOpt
                .orElseThrow(() -> new CustomException("Current position is not available at this department.",
                        HttpStatus.CONFLICT));
        long capacity = subdepartmentType.getCapacity();
        long numberOfWorkers = repository.countByActiveAndSubdepartment(true, subdep.getId());
        if (numberOfWorkers >= capacity) {
            throw new CustomException("Capacity of subdepartment is overflow.", HttpStatus.CONFLICT);
        }
        emp.setSubdepartment(subdep);
    }

    private void refreshData(Employee emp, EmployeeDtoInputUpdate dto) throws CustomException {
        emp.setName(dto.getName());
        emp.setSurname(dto.getSurname());
        emp.setAge(dto.getAge());

        Position oldPosition = emp.getPosition();
        Long oldIdDep = emp.getSubdepartment().getDepartment().getId();
        Position newPosition = dto.getPosition();
        Long newIdDep = dto.getDepartmentId();
        if (oldPosition != newPosition || !oldPosition.equals(newPosition)) {
            emp.setPosition(dto.getPosition());
            Department dep = depRepository.findByIdAndActive(newIdDep, true)
                    .orElseThrow(() -> new CustomException("resource not found id=" + newIdDep, HttpStatus.NOT_FOUND));
            chooseSubdepartment(emp, dep);
        }
    }
}
