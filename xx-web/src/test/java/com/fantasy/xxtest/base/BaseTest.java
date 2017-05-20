package com.fantasy.xxtest.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * @author li.fang
 * @sine 17/02/28
 */
public class BaseTest {

    protected Logger logger = LoggerFactory.getLogger(BaseTest.class);

    private long startTime;

    @BeforeClass
    public void before(){
        this.startTime = System.currentTimeMillis();
        logger.debug("===================================================================================================================================================");
    }

    @AfterClass
    public void after(){
        logger.debug("End of run, take {} seconds", (System.currentTimeMillis() - startTime) / 1000F);
        logger.debug("===================================================================================================================================================");
    }

    public void sleep(int seconds){
        logger.debug("Start dormancy, please wait {} seconds", seconds);
        try {
            do{
                logger.debug("Sleep for {} seconds", --seconds);
                Thread.sleep(1000);
            }while (seconds > 0);
        } catch (InterruptedException e) {
            logger.error(e.getMessage(), e);
        }
    }

    @Test
    public void test() throws IOException, ClassNotFoundException {
        logger.debug(SpringTest.class.getName());
    }

}
