package com.fantasy.xxbase.job;

import com.fantasy.xxutil.util.XXMathUtils;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Trigger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @author li.fang
 * @since 17/03/21
 */
public class SysMemoryListenerJob extends QuartzJobBean{

    private Logger logger = LoggerFactory.getLogger(SysMemoryListenerJob.class);


    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        Runtime run = Runtime.getRuntime();

        double totalMemory = XXMathUtils.toMByte(run.totalMemory());
        double maxMemory = XXMathUtils.toMByte(run.maxMemory());
        double freeMemory = XXMathUtils.toMByte(run.freeMemory());

        Trigger trigger = jobExecutionContext.getTrigger();
        String triggerName = trigger.getKey().getName();

        logger.debug("trigger name : {}", triggerName);
        logger.debug("total memory : {}, max memory : {}, free memory : {}", totalMemory, maxMemory, freeMemory);
    }
}
