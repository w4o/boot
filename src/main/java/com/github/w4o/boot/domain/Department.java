package com.github.w4o.boot.domain;

import com.github.w4o.boot.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 部门实体
 *
 * @author frank
 * @date 2020/4/23
 */
@Entity
@Table(name = "department")
@Data
@EqualsAndHashCode(callSuper = false)
public class Department extends BaseEntity {

    /**
     * 部门名字
     */
    @Column(name = "name")
    private String name;
}
