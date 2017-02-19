package com.xxbase.service;

import com.xxbase.entity.AbstractBaseEntity;
import com.xxbase.method.Page;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * Created by lifang on 2015/1/22.
 */
public interface BaseService<T extends AbstractBaseEntity, ID extends Serializable> {

    T findById(@NotNull ID id);

    T findOneByName(String name);

    Page<T> findAll();

    Page<T> findPages(int pageNo, int pageSize);

    void persist(@NotNull T t);

    void persist(@NotNull Collection<T> t);

    T merge(@NotNull T t);

    void remove(@NotNull T t);

    void remove(@NotNull ID id);

    Page<T> findByName(String name);

}
