package com.mariiakushel.task.repository.entity;

import com.mariiakushel.task.enumeration.Position;
import com.mariiakushel.task.repository.PostgresEnumType;
import lombok.Data;
import lombok.NoArgsConstructor;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@Entity
@Table(name = "employees")
@TypeDef(
        name = "postgres_enum_type",
        typeClass = PostgresEnumType.class
)
public class Employee extends BaseEntity {
    @Column(name = "employee_name", length = 100, nullable = false)
    private String name;
    @Column(name = "employee_surname", length = 100, nullable = false)
    private String surname;
    @Column(name = "employee_personal_id", length = 11, nullable = false)
    private String personalId;
    @Column(name = "employee_age", nullable = false)
    private Integer age;
    @Column(name = "employee_position", columnDefinition = "position default 'EMPLOYEE'")
    @Enumerated(EnumType.STRING)
    @Type(type = "postgres_enum_type")
    private Position position;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subdepartment")
    private Subdepartment subdepartment;
    @OneToOne(mappedBy = "employee")
    private User user;

}
