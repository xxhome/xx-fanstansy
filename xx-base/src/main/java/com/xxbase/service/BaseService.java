package com.xxbase.service;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * Created by lifang on 2015/1/22.
 */
public interface BaseService<T, ID extends Serializable> {

    T findById(@NotNull ID id);

    T findByName(String name);

    List<T> findAll();

    void persist(@NotNull T t);

    void persist(@NotNull Collection<T> t);

    T merge(@NotNull T t);

    void remove(@NotNull T t);

    void remove(@NotNull ID id);

    List<T> findAllByName(String name);

}
