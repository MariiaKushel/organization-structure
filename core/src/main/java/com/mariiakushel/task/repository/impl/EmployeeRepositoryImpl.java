package com.mariiakushel.task.repository.impl;

import antlr.debug.DebuggingParser;
import com.mariiakushel.task.repository.EmployeeRepository;
import com.mariiakushel.task.repository.entity.Department;
import com.mariiakushel.task.repository.entity.Department_;
import com.mariiakushel.task.repository.entity.Directorate;
import com.mariiakushel.task.repository.entity.Directorate_;
import com.mariiakushel.task.repository.entity.Employee;
import com.mariiakushel.task.repository.entity.Employee_;
import com.mariiakushel.task.repository.entity.Subdepartment;
import com.mariiakushel.task.repository.entity.Subdepartment_;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.util.List;

@Component
public class EmployeeRepositoryImpl {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Employee> findAllByActiveAndDepartment(boolean active, Long idDep, Pageable paging) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> query = builder.createQuery(Employee.class);

        Root<Department> root = query.from(Department.class);
        Join<Department, Subdepartment> joinSubdep = root.join(Department_.subdepartments);
        Join<Subdepartment, Employee> joinEmp = joinSubdep.join(Subdepartment_.employees);

        query.select(joinEmp);
        query.where(
                builder.equal(root.get(Department_.id), idDep),
                builder.equal(joinEmp.get(Employee_.active), active)
        );
        int page = paging.getPageNumber();
        int size = paging.getPageSize();
        return entityManager.createQuery(query)
                .setFirstResult((page) * size)
                .setMaxResults(size)
                .getResultList();
    }

    public List<Employee> findAllByActiveAndDirectorate(boolean active, Long idDir, Pageable paging) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> query = builder.createQuery(Employee.class);

        Root<Directorate> root = query.from(Directorate.class);
        Join<Directorate, Department> joinDep = root.join(Directorate_.departments);
        Join<Department, Subdepartment> joinSubdep = joinDep.join(Department_.subdepartments);
        Join<Subdepartment, Employee> joinEmp = joinSubdep.join(Subdepartment_.employees);

        query.select(joinEmp);
        query.where(
                builder.equal(root.get(Directorate_.id), idDir),
                builder.equal(joinEmp.get(Employee_.active), active)
        );
        int page = paging.getPageNumber();
        int size = paging.getPageSize();
        return entityManager.createQuery(query)
                .setFirstResult((page) * size)
                .setMaxResults(size)
                .getResultList();
    }


    public long countByActiveAndDepartment(boolean active, Long idDep) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> query = builder.createQuery(Long.class);

        Root<Department> root = query.from(Department.class);
        Join<Department, Subdepartment> joinSubdep = root.join(Department_.subdepartments);
        Join<Subdepartment, Employee> joinEmp = joinSubdep.join(Subdepartment_.employees);

        query.select(builder.count(joinEmp.get(Employee_.id)));
        query.where(
                builder.equal(root.get(Department_.id), idDep),
                builder.equal(joinEmp.get(Employee_.active), active)
        );
        return entityManager.createQuery(query)
                .getSingleResult();
    }

    public long countByActiveAndDirectorate(boolean active, Long idDir) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> query = builder.createQuery(Long.class);

        Root<Directorate> root = query.from(Directorate.class);
        Join<Directorate, Department> joinDep = root.join(Directorate_.departments);
        Join<Department, Subdepartment> joinSubdep = joinDep.join(Department_.subdepartments);
        Join<Subdepartment, Employee> joinEmp = joinSubdep.join(Subdepartment_.employees);

        query.select(builder.count(joinEmp.get(Employee_.id)));
        query.where(
                builder.equal(root.get(Directorate_.id), idDir),
                builder.equal(joinEmp.get(Employee_.active), active)
        );
        return entityManager.createQuery(query)
                .getSingleResult();
    }

    public long countByActiveAndSubdepartment(boolean active, Long idSubdep) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> query = builder.createQuery(Long.class);

        Root<Subdepartment> root = query.from(Subdepartment.class);
        Join<Subdepartment, Employee> joinEmp = root.join(Subdepartment_.employees);

        query.select(builder.count(joinEmp.get(Employee_.id)));
        query.where(
                builder.equal(root.get(Subdepartment_.id), idSubdep),
                builder.equal(joinEmp.get(Employee_.active), active)
        );
        return entityManager.createQuery(query)
                .getSingleResult();
    }
}
