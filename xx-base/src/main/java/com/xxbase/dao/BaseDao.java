package com.xxbase.dao;


import com.xxbase.entity.AbstractBaseEntity;
import com.xxbase.exception.EntityNoExistNameException;
import com.xxbase.method.Page;
import com.xxbase.method.Pageable;
import com.xxbase.method.QueryParam;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * <pre>
 *     持久层基本接口,对于每一个Entity基本上都有此接口方法.
 * </pre>
 * Created by lifang on 2015/1/21.
 */
public interface BaseDao<T extends AbstractBaseEntity, ID extends Long> {

    Page<T> find(List<QueryParam> queryParams);
    Page<T> find(List<QueryParam> queryParams, Pageable pageable);

    T findById(@NotNull ID id);

    Page<T> findByName(String name) throws EntityNoExistNameException;

    T findOneByName(String name) throws EntityNoExistNameException;

    Page<T> findAll();

    Page<T> findPages(int pageNo, int pageSize);

    long count();

    void persist(@NotNull T t);

    T merge(@NotNull T t);

    void remove(@NotNull T t);
}
