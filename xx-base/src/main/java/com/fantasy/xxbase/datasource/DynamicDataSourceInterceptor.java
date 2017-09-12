package com.fantasy.xxbase.datasource;

import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;

/**
 * @author li.fang
 * @since 2017/9/12 17:25
 */
@Component
public class DynamicDataSourceInterceptor {

    public void setDataSourceBase(JoinPoint jp) {
        DynamicDataSourceHolder.setDataSource(DynamicDataSourceHolder.DATASOURCE_BASE);
    }

    public void setDataSourceBlog(JoinPoint jp) {
        DynamicDataSourceHolder.setDataSource(DynamicDataSourceHolder.DATASOURCE_BLOG);
    }

    public static void clearDataSourceBase(String dataSource){
        DynamicDataSourceHolder.clearDataSource();
    }

    public static void clearDataSourceBlog(String dataSource){
        DynamicDataSourceHolder.clearDataSource();
    }
}
