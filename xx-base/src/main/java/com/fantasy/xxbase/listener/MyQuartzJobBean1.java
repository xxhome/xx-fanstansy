package com.fantasy.xxbase.listener;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @author li.fang
 * @since 17/03/21
 */
public class MyQuartzJobBean1 extends QuartzJobBean{

    private Logger logger = LoggerFactory.getLogger(MyQuartzJobBean1.class);


    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        logger.debug("===============MyQuartzJobBean1===============");

    }
}
