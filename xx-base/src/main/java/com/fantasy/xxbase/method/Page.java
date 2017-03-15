package com.fantasy.xxbase.method;

import com.fantasy.xxbase.entity.AbstractBaseEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author li.fang
 * @sine 17/02/19
 */
public class Page<T extends AbstractBaseEntity> extends Pageable{

    private List<T> context = new ArrayList<>();

    public Page() {
    }

    public Page(long pageNo, long pageSize, long total, List<T> context) {
        this.setPageNo(pageNo);
        this.setPageSize(pageSize);
        this.setTotal(total);
        this.context = context;
    }

    public Page(long total, List<T> context) {
        this.setTotal(total);
        this.context = context;
    }

    public List<T> getContext() {
        return context;
    }

    public void setContext(List<T> context) {
        this.context = context;
    }
}
