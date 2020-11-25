package com.github.w4o.boot.domain;

import com.github.w4o.boot.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * 员工实体
 *
 * @author frank
 * @date 2020/4/23
 */
@Entity
@Table(name = "employee")
@Data
@EqualsAndHashCode(callSuper = false)
public class Employee extends BaseEntity {

    /**
     * 员工姓名
     */
    @Column(name = "name")
    private String name;

    /**
     * 联系方式
     */
    @Column(name = "contact")
    private String contact;

    /**
     * 部门id
     */
    @Column(name = "dept_id")
    private Integer deptId;

    /**
     * 删除标识
     */
    @Column(name = "deleted")
    private Boolean deleted;

    /**
     * 入职时间
     */
    @Column(name = "in_the_date")
    private Date inTheDate;
}
