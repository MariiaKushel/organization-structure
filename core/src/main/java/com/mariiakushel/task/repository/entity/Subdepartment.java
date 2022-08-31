package com.mariiakushel.task.repository.entity;

import com.mariiakushel.task.enumeration.SubdepartmentType;
import com.mariiakushel.task.repository.PostgresEnumType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

/**
 * Class represent Subdepartment entity
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true, exclude = "employees")
@ToString(callSuper = true, exclude = "employees")
@Entity
@Table(name = "subdepartments")
@TypeDef(
        name = "postgres_enum_type",
        typeClass = PostgresEnumType.class
)
public class Subdepartment extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "parent")
    private Department department;
    @Column(name = "subdepartment_type", nullable = false, columnDefinition = "subdepartment_type default 'EMPLOYEES'")
    @Enumerated(EnumType.STRING)
    @Type(type = "postgres_enum_type")
    private SubdepartmentType type;
    @OneToMany(mappedBy = "subdepartment", fetch = FetchType.LAZY)
    private Set<Employee> employees;

    public Subdepartment(Long id) {
        super(id);
    }
}
