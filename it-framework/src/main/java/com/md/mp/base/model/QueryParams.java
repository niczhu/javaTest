package com.md.mp.base.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * QueryParams
 *
 * @author zhuhaipeng6 in 2020/7/10 17:52
 * @version 1.0
 **/
@Builder
@Getter
@Setter
public class QueryParams {

    private String currentPage;

    private String pageSize;
}
