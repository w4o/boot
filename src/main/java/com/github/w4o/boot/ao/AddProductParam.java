package com.github.w4o.boot.ao;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 添加商品请求参数
 *
 * @author frank
 * @date 2020/4/22
 */
@ApiModel(value = "添加商品请求参数")
@Data
public class AddProductParam {

    /**
     * 商品名
     */
    @ApiModelProperty(value = "商品名", example = "大宝剑")
    private String name;

    /**
     * 商品编码
     */
    @ApiModelProperty(value = "商品编码", example = "Z00001")
    private String code;

    /**
     * 商品价格
     */
    @ApiModelProperty(value = "商品价格", example = "123.45")
    private BigDecimal price;
}
