package com.github.w4o.boot.ao;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

/**
 * @author frank
 * @date 2020/4/22
 */
@ApiModel(value = "修改商品请求参数")
@Data
public class ModifyProductParam {

    /**
     * 商品名
     */
    @ApiModelProperty(value = "商品名", example = "大宝剑")
    @NotBlank
    private String name;

    /**
     * 商品价格
     */
    @ApiModelProperty(value = "商品价格", example = "123.45")
    @DecimalMin(value = "0.01")
    private BigDecimal price;
}
