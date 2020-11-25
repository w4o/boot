package com.github.w4o.boot.common;

import lombok.Data;

/**
 * @author frank
 * @date 2020/4/29
 */
@Data
public abstract class BaseSearchPage {

    private Integer page;
    private Integer size;

}
