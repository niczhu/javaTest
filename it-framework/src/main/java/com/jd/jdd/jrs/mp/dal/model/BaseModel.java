package com.jd.jdd.jrs.mp.dal.model;

/**
 * BaseModel
 *
 * @author zhuhaipeng6 in 2020/5/11 15:54
 * @version 1.0
 **/
public class BaseModel {

    /**
     * 当前页
     */
    private long currentPage = 0;

    /**
     * 每页条数
     */
    private long pageSize = 10;

    public long getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(long currentPage) {
        this.currentPage = currentPage;
    }

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }
}
