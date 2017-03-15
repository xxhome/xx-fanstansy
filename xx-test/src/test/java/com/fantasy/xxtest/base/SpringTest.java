package com.fantasy.xxtest.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author li.fang
 * @sine 17/02/19
 */
@Test
@ContextConfiguration(locations = "classpath:spring-base.xml")
public class SpringTest extends AbstractTestNGSpringContextTests {

    protected Logger logger = LoggerFactory.getLogger(SpringTest.class);

    private long startTime;

    @BeforeClass
    public void before() {
        this.startTime = System.currentTimeMillis();
        logger.debug("===================================================================================================================================================");
    }

    @AfterClass
    public void after() {
        logger.debug("End of run, take {} seconds", (System.currentTimeMillis() - startTime) / 1000F);
        logger.debug("===================================================================================================================================================");
    }

    public void sleep(int seconds) {
        logger.debug("Start dormancy, please wait {} seconds", seconds);
        try {
            do {
                logger.debug("Sleep for {} seconds", --seconds);
                Thread.sleep(1000);
            } while (seconds > 0);
        } catch (InterruptedException e) {
            logger.error(e.getMessage(), e);
        }
    }

    @Test
    public void test() {
        logger.debug(SpringTest.class.getName());
    }

}
