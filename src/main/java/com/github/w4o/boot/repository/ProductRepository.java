package com.github.w4o.boot.repository;

import com.github.w4o.boot.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author frank
 * @date 2020/4/22
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
