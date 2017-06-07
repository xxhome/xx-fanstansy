package com.fantasy.xxtest.redis;

import com.fantasy.xxbase.cache.RedisCacheProvider;
import com.fantasy.xxtest.base.SpringTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

/**
 * @author li.fang
 * @since 2017/6/7
 */
public class RedisServiceTest extends SpringTest{

    @Autowired
    private RedisCacheProvider redisCacheProvider;

    @Test
    public void testRedis(){

        redisCacheProvider.put("employee", "E10001", "hello world");

    }

}
