package com.github.w4o.boot.common;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author frank
 */
@Data
@Builder
public class PageData {
    private Long total;
    private Integer page;
    private Integer size;
    private List<Object> list;
}