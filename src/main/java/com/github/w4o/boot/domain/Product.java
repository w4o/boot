package com.github.w4o.boot.domain;

import com.github.w4o.boot.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @author frank
 * @date 2020/4/22
 */
@Entity
@Table(name = "product")
@Data
@EqualsAndHashCode(callSuper = false)
public class Product extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "deleted")
    private Boolean deleted;

}
