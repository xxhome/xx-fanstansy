package com.xxbase.dao;


import org.hibernate.service.spi.ServiceException;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * <pre>
 *     持久层基本接口,对于每一个Entity基本上都有此接口方法.
 * </pre>
 * Created by lifang on 2015/1/21.
 */
public interface BaseDao<T, ID extends Long> {

    T findById(@NotNull ID id);

    T findByName(String name) throws ServiceException;

    List<T> findAll();

    void persist(@NotNull T t);

    T merge(@NotNull T t);

    void remove(@NotNull T t);

    List<T> findAllByName(String name);
}
