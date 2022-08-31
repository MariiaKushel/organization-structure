package com.mariiakushel.task.repository.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

/**
 * Class represent Department entity.
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true, exclude = {"subdepartments", "directorate"})
@ToString(callSuper = true, exclude = {"subdepartments", "directorate"})
@Entity
@Table(name = "departments")
public class Department extends BaseEntity {
    @Column(name = "department_name", length = 200, nullable = false)
    private String name;
    @Column(name = "department_description", length = 400, nullable = false)
    private String description;
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "directorate")
    private Directorate directorate;
    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Subdepartment> subdepartments;

    public Department(Long id) {
        super(id);
    }
}

