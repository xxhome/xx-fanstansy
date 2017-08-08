package com.fantasy.xxbase.service.impl;

import com.fantasy.xxbase.entity.XXBaseEntity;
import com.fantasy.xxbase.service.BaseService;
import com.fantasy.xxbase.vo.Page;
import com.fantasy.xxbase.vo.Pageable;
import com.fantasy.xxbase.dao.BaseDao;
import com.fantasy.xxbase.exception.EntityNoExistNameException;
import com.fantasy.xxbase.vo.QueryParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.List;

/**
 * @author li.fang
 * @since 2017/02/18
 */
public class BaseServiceImpl<T extends XXBaseEntity> implements BaseService<T> {

    public Logger logger = LoggerFactory.getLogger(BaseServiceImpl.class);

    private BaseDao<T> baseDao;

    public void setBaseDao(BaseDao<T> baseDao) {
        this.baseDao = baseDao;
    }


    @Override
    public Page<T> find(List<QueryParam> queryParams) {
        return baseDao.find(queryParams);
    }

    @Override
    public Page<T> find(List<QueryParam> queryParams, Pageable pageable) {
        return baseDao.find(queryParams, pageable);
    }

    @Override
    public T findById(@NotNull String id) {
        if (id != null) {
            return baseDao.findById(id);
        }
        return null;
    }

    @Override
    public T findOneByName(String name) {
        try {
            return baseDao.findOneByName(name);
        } catch (EntityNoExistNameException e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public Page<T> findAll() {
        return baseDao.findAll();
    }

    @Override
    public Page<T> page(int pageNo, int pageSize) {
        return baseDao.page(pageNo, pageSize);
    }

    @Override
    public void persist(@NotNull T t) {
        if (t != null) {
            baseDao.persist(t);
        }
    }

    @Override
    public void persist(@NotNull Collection<T> t) {
        if (CollectionUtils.isEmpty(t)) return;
        for (T e : t) {
            persist(e);
        }
    }

    @Override
    public T merge(@NotNull T t) {
        if (t != null) {
            return baseDao.merge(t);
        }
        return t;
    }

    @Override
    public void remove(@NotNull T t) {
        if (t != null) {
            baseDao.remove(t);
        }
    }

    @Override
    public void remove(@NotNull String id) {
        if (id != null) {
            T t = findById(id);
            if (t != null) {
                baseDao.remove(t);
            }
        }
    }

    @Override
    public long clean() {
        return baseDao.clean();
    }

    @Override
    public Page<T> findByName(String name) {
        try {
            return baseDao.findByName(name);
        } catch (EntityNoExistNameException e) {
            logger.error(e.getMessage(), e);
            return null;
        }
    }
}
