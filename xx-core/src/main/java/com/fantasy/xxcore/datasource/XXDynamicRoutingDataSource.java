package com.fantasy.xxcore.datasource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author li.fang
 * @since 2017/6/8
 */
public class XXDynamicRoutingDataSource extends AbstractRoutingDataSource {

    private Logger logger = LoggerFactory.getLogger(XXDynamicRoutingDataSource.class);

    @Override
    protected Object determineCurrentLookupKey() {
        Object object = XXDynamicDataSourceHolder.getDataSource();
        logger.info("Current Use Datasource : {}", object);
        return object;
    }
}
