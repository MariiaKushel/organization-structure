package com.mariiakushel.task.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Class represent the abstract database entity
 */
@Data
@AllArgsConstructor
@MappedSuperclass
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "active", nullable = false, columnDefinition = "boolean default true")
    private boolean active;

    public BaseEntity() {
        this.active = true;
    }

    public BaseEntity(Long id) {
        this();
        this.id = id;
    }
}
