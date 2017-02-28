package com.xxbase.service;

import com.xxbase.dao.BaseDao;
import com.xxbase.entity.AbstractBaseEntity;
import com.xxbase.exception.EntityNoExistNameException;
import com.xxbase.method.Page;
import com.xxbase.method.Pageable;
import com.xxbase.method.QueryParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.List;

/**
 * @author li.fang
 * @since 2017/02/18
 */
public class BaseServiceImpl<T extends AbstractBaseEntity, ID extends Long> implements BaseService<T, ID> {

    public Logger logger = LoggerFactory.getLogger(BaseServiceImpl.class);

    private BaseDao<T, ID> baseDao;

    public void setBaseDao(BaseDao<T, ID> baseDao) {
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
    public T findById(@NotNull ID id) {
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
    public Page<T> findPages(int pageNo, int pageSize) {
        return baseDao.findPages(pageNo, pageSize);
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
    public void remove(@NotNull ID id) {
        if (id != null) {
            T t = findById(id);
            if (t != null) {
                baseDao.remove(t);
            }
        }
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
