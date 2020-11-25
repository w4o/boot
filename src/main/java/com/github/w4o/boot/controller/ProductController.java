package com.github.w4o.boot.controller;

import com.github.w4o.boot.ao.AddProductParam;
import com.github.w4o.boot.ao.ModifyProductParam;
import com.github.w4o.boot.common.CommonResponse;
import com.github.w4o.boot.domain.Product;
import com.github.w4o.boot.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author frank
 * @date 2020/4/22
 */
@RestController
@RequestMapping(value = "/product")
@Api
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * 获取商品信息
     */
    @GetMapping(value = "/{id}")
    @ApiOperation(value = "获取商品信息", notes = "根据id获取商品信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "商品id", required = true, defaultValue = "1")
    })
    public CommonResponse<Product> get(@PathVariable Integer id) {
        Product product = productService.getProductById(id);
        return new CommonResponse<Product>().ok(product);
    }

    /**
     * 添加商品信息
     */
    @PutMapping
    @ApiOperation(value = "添加商品信息", notes = "")
    public CommonResponse<Product> put(@RequestBody AddProductParam param) {
        Product product = productService.addProduct(param);
        return new CommonResponse<Product>().ok(product);
    }

    /**
     * 修改商品信息
     */
    @PostMapping(value = "/{id}")
    @ApiOperation(value = "修改商品信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "商品id", required = true, defaultValue = "1")
    })
    public CommonResponse<Product> post(@PathVariable Integer id, @RequestBody @Valid ModifyProductParam param) {
        Product product = productService.modifyProduct(id, param);
        return new CommonResponse<Product>().ok(product);
    }

    /**
     * 删除商品信息
     */
    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "删除商品信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "商品id", required = true, defaultValue = "1")
    })
    public CommonResponse<Product> delete(@PathVariable Integer id) {
        productService.removeProductById(id);
        return new CommonResponse<Product>().ok();
    }

}
