package com.fantasy.xxtest.lock;

import com.fantasy.xxtest.base.BaseTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest extends BaseTest {

    private ReentrantLock lock = new ReentrantLock();

    private int index = 0;


    @Test
    public void testReentrantLock() {
        new Thread(new Thread01("线程A")).start();
        new Thread(new Thread01("线程B")).start();
        new Thread(new Thread01("线程C")).start();
        new Thread(new Thread01("线程D")).start();
        Thread e = new Thread(new Thread01("线程E"));
        e.start();
        e.interrupt();
    }


    class Thread01 implements Runnable{

        private String name;

        public Thread01(String name) {
            this.name = name;
        }

        @Override
        public void run() {

            try {
                lock.lock();
                for (int i = 0; i <= 100; i++) {
                    index++;
                }
                logger.info("name：{}, index:{}", name, index);
                TimeUnit.SECONDS.sleep(2 * 1000);
            }catch (Exception e){
                logger.error(e.getMessage(), e);
            }finally {
                lock.unlock();
            }
        }
    }


}
