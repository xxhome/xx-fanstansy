package com.xxtest.cache;

import com.xxbase.cache.CacheNotExistException;
import com.xxbase.cache.CacheProvider;
import com.xxblog.entity.AccountEntity;
import com.xxtest.base.SpringTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.testng.Assert;
import org.testng.TestNG;
import org.testng.annotations.Test;

/**
 * @author li.fang
 * @sine 17/02/19
 */
public class CacheServiceTest extends SpringTest{

    @Autowired
    @Qualifier(value = "ehCacheProvider")
    private CacheProvider cacheProvider;

    @Test
    public void testPut(){
        String category = "CACHE_CATEGORY_ACCOUNT_10000";
        String key = "10000";
        AccountEntity accountEntity1 = new AccountEntity();
        cacheProvider.put(category, key, accountEntity1);
        try {
            AccountEntity accountEntity2 = cacheProvider.get(category, key);
            Assert.assertTrue(accountEntity1 == accountEntity2);
        } catch (CacheNotExistException e) {
            logger.error(e.getMessage(), e);
        }
    }

    @Test
    public void testGet(){
        String category = "CACHE_CATEGORY_ACCOUNT_10000";
        String key = "10000";
        try {
            cacheProvider.put(category, key, new AccountEntity(), 15);
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
