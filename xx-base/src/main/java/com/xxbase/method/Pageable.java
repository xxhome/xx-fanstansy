package com.xxbase.method;

import java.io.Serializable;

/**
 * @author li.fang
 * @sine 17/02/19
 */
public class Pageable implements Serializable{

    private long pageSize = 0L;

    private long pageNo = 1L;

    private long total;

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

    public long getPageNo() {
        return pageNo;
    }

    public void setPageNo(long pageNo) {
        this.pageNo = pageNo;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
