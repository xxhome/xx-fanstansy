package com.fantasy.xxbase.cache;

import com.fantasy.xxbase.entity.XXBaseEntity;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * EHCache 实现缓存策略
 *
 * @author li.fang
 * @sine 17/02/19
 */
@Component("ehCacheProvider")
public class EhCacheProvider implements CacheProvider {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private static final String DEFAULT_CACHE_NAME = "DEFAULT_CACHE_CATEGORY";

    private static CacheManager ehCacheManager = null;

    private CacheManager getCacheManager() {
        if (this.ehCacheManager == null) {
            synchronized (CacheManager.class) {
                if (this.ehCacheManager == null) {
                    logger.info("Initializing EhCache CacheManager");
                    this.ehCacheManager = CacheManager.create();
                }
            }
        }
        return this.ehCacheManager;
    }

    private net.sf.ehcache.Cache getCache(String category) {
        if (StringUtils.isBlank(category)) {
            return getCache(DEFAULT_CACHE_NAME);
        }

        CacheManager cacheManager = getCacheManager();

        if (!cacheManager.cacheExists(category)) {
            //添加锁， 避免ObjectExistsException异常，category重复添加到缓存。
            synchronized (this) {
                if (!cacheManager.cacheExists(category)) {
                    cacheManager.addCache(category);
                }
            }
        }
        return cacheManager.getCache(category);
    }

    @Override
    public <T extends Serializable> void put(String category, String key, T obj) {
        Cache cache = getCache(category);
        put(cache, key, obj, -1);
    }

    @Override
    public <T extends Serializable> void put(String category, String key, T obj, int timeToLiveSeconds) {
        Cache cache = getCache(category);
        put(cache, key, obj, timeToLiveSeconds);
    }

    @Override
    public <T extends XXBaseEntity> void put(String category, Collection<T> objs) {
        Cache cache = getCache(category);
        objs.forEach(obj -> put(cache, String.valueOf(obj.getId()), obj, -1));
    }

    @Override
    public <T extends XXBaseEntity> void put(String category, Collection<T> objs, int timeToLiveSeconds) {
        Cache cache = getCache(category);
        objs.forEach(obj -> put(cache, String.valueOf(obj.getId()), obj, timeToLiveSeconds));
    }

    @Override
    public <T extends Serializable> T get(String category, String key) throws CacheNotExistException {
        Cache cache = getCache(category);

        if (!isExist(cache, key)) {
            //缓存不存在
            throw new CacheNotExistException("Ehcache缓存中不存在key=%s的缓存!", key);
        }

        Element element = cache.get(key);
        if (element == null) {
            return null;
        }
        return (T) element.getObjectValue();
    }


    @Override
    public <T extends XXBaseEntity> Collection<T> getCollection(String category) {
        Collection<T> collection = new ArrayList<>();

        Cache cache = getCache(category);

        List keys = cache.getKeys();

        keys.stream().forEach(key -> {
            Element element = cache.get(key);

            if (element != null) {
                collection.add((T) element.getObjectValue());
            }
        });

        return collection;
    }

    @Override
    public long getCacheSize() {
        CacheManager cacheManager = getCacheManager();
        String[] categoryArrays = cacheManager.getCacheNames();

        long size = 0;
        if (categoryArrays != null) {
            for (String category : categoryArrays) {
                Cache cache = getCache(category);
                if (cache != null) {
                    size += cache.getSize();
                }
            }
        }
        return size;
    }

    @Override
    public boolean isExist(String category, String key) {
        Cache cache = getCache(category);
        return isExist(cache, key);
    }

    @Override
    public void removeAll() {
        CacheManager cacheManager = getCacheManager();
        cacheManager.removalAll();
    }

    @Override
    public void remove(String category) {
        CacheManager cacheManager = getCacheManager();
        cacheManager.removeCache(category);
    }

    @Override
    public void remove(String category, String key) {
        Cache cache = getCache(category);
        cache.remove(key);
    }

    private <T extends Serializable> void put(Cache cache, String key, T obj, int timeToLiveSeconds) {
        Element element = new Element(key, obj);
        cache.put(element);

        if (timeToLiveSeconds >= 0) {
            element.setEternal(false);
            element.setTimeToLive(timeToLiveSeconds);
        } else {
            element.setEternal(true);
        }
    }

    private boolean isExist(Cache cache, Object key) {
        return cache.isKeyInCache(key);
    }
}
