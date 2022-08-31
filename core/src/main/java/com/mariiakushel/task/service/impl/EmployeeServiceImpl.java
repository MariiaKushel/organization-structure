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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Class represent implementation of DepartmentService
 */
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
        createUserForAuth(emp);
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
        emp.getUser().setActive(false);
        repository.save(emp);
    }


    @Override
    public EmployeeDtoOutput findById(Long id) throws CustomException {
        Employee emp = repository.findByIdAndActive(id, true)
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
    @Transactional
    public List<EmployeeDtoOutput> findAllByDepartment(Long idHead, int page, int size) throws CustomException {
        Employee head = repository.findByIdAndActive(idHead, true)
                .orElseThrow(() -> new CustomException("resource not found id=" + idHead, HttpStatus.NOT_FOUND));
        Department dep = head.getSubdepartment().getDepartment();
        Pageable paging = PageRequest.of(page - 1, size);
        List<Employee> emps = repository.findAllByActiveAndSubdepartmentDepartment(true, dep, paging);
        return DtoEntityConvertor.convertEmployees(emps);
    }

    @Override
    @Transactional
    public List<EmployeeDtoOutput> findAllByDirectorate(Long idDir, int page, int size) throws CustomException {
        Employee director = repository.findByIdAndActive(idDir, true)
                .orElseThrow(() -> new CustomException("resource not found id=" + idDir, HttpStatus.NOT_FOUND));
        Directorate dir = director.getSubdepartment().getDepartment().getDirectorate();
        Pageable paging = PageRequest.of(page - 1, size);
        List<Employee> emps =
                repository.findAllByActiveAndSubdepartmentDepartmentDirectorate(true, dir, paging);
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
        long numberOfWorkers = repository.countByActiveAndSubdepartment(true, subdep);
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
        if (oldPosition != newPosition || !oldIdDep.equals(newIdDep)) {
            emp.setPosition(dto.getPosition());
            Department dep = depRepository.findByIdAndActive(newIdDep, true)
                    .orElseThrow(() -> new CustomException("resource not found id=" + newIdDep, HttpStatus.NOT_FOUND));
            chooseSubdepartment(emp, dep);
        }
    }

    private void createUserForAuth(Employee emp) {
        User user = new User();
        user.setUsername(String.valueOf(emp.getPersonalId()));
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String secretPassword = encoder.encode(String.valueOf(emp.getPersonalId()));
        user.setPassword(secretPassword);
        user.setEmployee(emp);
        emp.setUser(user);
    }
}
