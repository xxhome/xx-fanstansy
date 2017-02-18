package com.xxbase.cache;

import java.io.Serializable;
import java.util.Collection;

/**
 * 缓存接口
 *
 * @author li.fang
 * @since 2017/02/17
 */
public interface CacheProvider {

    <T extends Serializable> void put(String key, T obj);

    <T extends Serializable> void put(String key, T obj, int timeToLiveSeconds);

    <T extends Serializable> void put(String key, Collection<T> objs);

    <T extends Serializable> void put(String key, Collection<T> objs, int timeToLiveSeconds);

    <T extends Serializable> T get(String key);

    <T extends Serializable> Collection<T> getCollection(String key);

    void remove(String key);
}
