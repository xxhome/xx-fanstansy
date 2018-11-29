package com.fantasy.xxbase.cache;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author li.fang
 * @since 2017/10/22 21:27
 */
@Aspect
@Component
public class XXCacheableInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(XXCacheableInterceptor.class);

    @Pointcut("@annotation(com.fantasy.xxbase.cache.XXCacheable)")
    public void doCacheable() {
    }

    @Around("doCacheable()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        return pjp.proceed();
    }
}
