package com.mariiakushel.task.repository.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true, exclude = "departments")
@ToString(callSuper = true, exclude = "departments")
@Entity
@Table(name = "directorates")
public class Directorate extends BaseEntity {
    @Column(name = "directorate_name", length = 200, nullable = false)
    private String name;
    @Column(name = "directorate_description", length = 400, nullable = false)
    private String description;
    @OneToMany(mappedBy = "directorate", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST})
    Set<Department> departments;
}
