package com.github.w4o.boot.ao;

import com.github.w4o.boot.common.BaseSearchPage;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author frank
 * @date 2020/4/29
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SearchEmployeeParam extends BaseSearchPage {

    private String name;
    private String contact;
    private String deptName;
}
