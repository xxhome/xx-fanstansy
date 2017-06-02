package com.fantasy.xxtest.cache;

import com.fantasy.xxbase.cache.CacheNotExistException;
import com.fantasy.xxbase.cache.CacheProvider;
import com.fantasy.xxblog.entity.BlogAccountEntity;
import com.fantasy.xxtest.base.SpringTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author li.fang
 * @sine 17/02/19
 */
public class CacheServiceTest extends SpringTest {

    @Autowired
    @Qualifier(value = "ehCacheProvider")
    private CacheProvider cacheProvider;

    @Test
    public void testPut(){
        String category = "CACHE_CATEGORY_ACCOUNT_10000";
        String key = "10000";
        BlogAccountEntity blogAccountEntity1 = new BlogAccountEntity();
        cacheProvider.put(category, key, blogAccountEntity1);
        try {
            BlogAccountEntity blogAccountEntity2 = cacheProvider.get(category, key);
            Assert.assertTrue(blogAccountEntity1 == blogAccountEntity2);
        } catch (CacheNotExistException e) {
            logger.error(e.getMessage(), e);
        }
    }

    @Test
    public void testGet(){
        String category = "CACHE_CATEGORY_ACCOUNT_10000";
        String key = "10000";
        try {
            cacheProvider.put(category, key, new BlogAccountEntity(), 15);
            sleep(9);
            Assert.assertTrue(cacheProvider.get(category, key) != null);
            logger.debug("cache size : {}kb", cacheProvider.getCacheSize());
            Assert.assertTrue(cacheProvider.isExist(category, key));
            sleep(9);
            Assert.assertTrue(cacheProvider.get(category, key) == null);
        } catch (CacheNotExistException e) {
            logger.error(e.getMessage(), e);
        }
    }

}
