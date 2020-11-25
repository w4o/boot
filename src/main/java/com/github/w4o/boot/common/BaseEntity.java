package com.github.w4o.boot.common;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author frank
 */
@MappedSuperclass
@Data
public abstract class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
}