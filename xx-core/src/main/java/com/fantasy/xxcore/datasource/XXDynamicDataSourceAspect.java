package com.fantasy.xxcore.datasource;

import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class XXDynamicDataSourceAspect {

    private static Logger logger = LoggerFactory.getLogger(XXDynamicDataSourceAspect.class);


    /**
     * 拦截目标方法，获取由@DataSource指定的数据源标识，设置到线程存储中以便切换数据源
     */
    public void intercept(JoinPoint point) {
        Class<?> target = point.getTarget().getClass();
        resolveDataSource(target);
    }

    /**
     * 提取目标对象方法注解和类型注解中的数据源标识
     */
    private void resolveDataSource(Class<?> clazz) {
        try {

            XXDynamicDataSource dynamicDataSource = clazz.getAnnotation(XXDynamicDataSource.class);

            if (dynamicDataSource == null) return;

            XXDynamicDataSourceHolder.setDataSource(dynamicDataSource.value());

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

}
