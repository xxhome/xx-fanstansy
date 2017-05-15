package com.fantasy.xxbase.cache;

import com.fantasy.xxbase.entity.XXBaseEntity;

import java.io.Serializable;
import java.util.Collection;

/**
 * Redis实现缓存策略
 *
 * @author li.fang
 * @sine 17/02/19
 */
public class RedisCacheProvider implements CacheProvider {

    @Override
    public <T extends Serializable> void put(String category, String key, T obj) {

    }

    @Override
    public <T extends Serializable> void put(String category, String key, T obj, int timeToLiveSeconds) {

    }

    @Override
    public <T extends XXBaseEntity> void put(String category, Collection<T> objs) {

    }

    @Override
    public <T extends XXBaseEntity> void put(String category, Collection<T> objs, int timeToLiveSeconds) {

    }

    @Override
    public <T extends Serializable> T get(String category, String key) {
        return null;
    }

    @Override
    public <T extends XXBaseEntity> Collection<T> getCollection(String category) {
        return null;
    }

    @Override
    public long getCacheSize() {
        return 0;
    }

    @Override
    public boolean isExist(String category, String key) {
        return false;
    }

    @Override
    public void removeAll() {

    }

    @Override
    public void remove(String category) {

    }

    @Override
    public void remove(String category, String key) {

    }
}
