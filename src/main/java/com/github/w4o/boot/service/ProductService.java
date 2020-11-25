package com.github.w4o.boot.service;

import com.github.w4o.boot.ao.AddProductParam;
import com.github.w4o.boot.ao.ModifyProductParam;
import com.github.w4o.boot.domain.Product;
import com.github.w4o.boot.exception.NotFoundException;
import com.github.w4o.boot.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author frank
 * @date 2020/4/22
 */
@Service
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * 通过商品id获取商品信息
     *
     * @param id 商品id
     * @return 商品信息
     */
    @Cacheable(value = "product", key = "#id")
    public Product getProductById(Integer id) {
        log.info("获取商品信息, ID: {}", id);
        return productRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    /**
     * 添加商品信息
     *
     * @param addProductParam 添加商品参数
     * @return 商品信息
     */
    @Cacheable(value = "product", key = "#result.id", condition = "#result.id gt 0")
    public Product addProduct(AddProductParam addProductParam) {
        Product product = new Product();
        BeanUtils.copyProperties(addProductParam, product);
        product.setDeleted(false);
        log.info("增加商品信息");
        return productRepository.save(product);
    }

    /**
     * 修改商品信息
     *
     * @param id                 商品id
     * @param modifyProductParam 修改商品参数
     * @return 商品信息
     */
    @CachePut(value = "product", key = "#id")
    public Product modifyProduct(Integer id, ModifyProductParam modifyProductParam) {
        Product product = productRepository.findById(id).orElseThrow(NotFoundException::new);
        BeanUtils.copyProperties(modifyProductParam, product);
        log.info("修改商品信息，ID：{}", id);
        return productRepository.save(product);
    }

    /**
     * 通过商品id 删除商品信息
     *
     * @param id 商品id
     */
    @CacheEvict(value = "product", allEntries = true, key = "#id")
    @Transactional(rollbackFor = Exception.class)
    public void removeProductById(Integer id) {
        Product product = productRepository.findById(id).orElseThrow(NotFoundException::new);
        product.setDeleted(true);
        log.info("删除商品信息，ID：{}", id);
    }
}
