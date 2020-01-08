package com.fantasy.xxbase.cache;

import java.lang.annotation.*;

/**
 * @author li.fang
 * @since 2017/10/22 21:26
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface XXCacheable {

    String key();

    Class provider() default RedisCacheProvider.class;
}
