package com.fantasy.xxbase.interceptor;

import com.fantasy.xxbase.method.XXResponseBody;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author li.fang
 * @since 17/03/27
 */
@Aspect
@Component
public class XXResponseBodyInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(XXResponseBodyInterceptor.class);

    @Pointcut("@annotation(com.fantasy.xxbase.annotation.XXRequestMapping)")
    public void doAroundRequestMapping() {
    }


    @Around("doAroundRequestMapping()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        final long startTime = System.currentTimeMillis();

        Object obj = null;
        try {
            obj = pjp.proceed();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }

        final String runtime = ((System.currentTimeMillis() - startTime) / 1000F) + "ms";

        if(obj instanceof XXResponseBody){
            ((XXResponseBody) obj).setRuntime(runtime);
        }else{
            logger.debug("runtime : {}", runtime);
        }
        return obj;
    }

}
