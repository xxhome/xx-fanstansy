package com.xxbase.cache;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Collection;

/**
 * EHCache 实现缓存策略
 *
 * @author li.fang
 * @sine 17/02/19
 */
@Component
public class EhCacheProvider implements CacheProvider{

    @Override
    public <T extends Serializable> void put(String key, T obj) {

    }

    @Override
    public <T extends Serializable> void put(String key, T obj, int timeToLiveSeconds) {

    }

    @Override
    public <T extends Serializable> void put(String key, Collection<T> objs) {

    }

    @Override
    public <T extends Serializable> void put(String key, Collection<T> objs, int timeToLiveSeconds) {

    }

    @Override
    public <T extends Serializable> T get(String key) {
        return null;
    }

    @Override
    public <T extends Serializable> Collection<T> getCollection(String key) {
        return null;
    }

    @Override
    public void remove(String key) {

    }
}
