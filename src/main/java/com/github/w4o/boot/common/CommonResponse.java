package com.github.w4o.boot.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.data.domain.Page;

/**
 * @author frank
 * @date 2020/4/22
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommonResponse<T> {

    private Integer status;
    private String message;
    private Object data;

    public CommonResponse<T> ok() {
        this.status = 200;
        return this;
    }

    public CommonResponse<T> ok(T data) {
        this.ok();
        this.data = data;
        return this;
    }

    public CommonResponse<T> okPage(Page<Object> page) {
        this.ok();
        this.data = PageData.builder()
                .total(page.getTotalElements())
                .page(page.getNumber())
                .size(page.getSize())
                .list(page.getContent())
                .build();
        return this;
    }

}
