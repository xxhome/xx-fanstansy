package com.fantasy.xxtest.thread;

import com.fantasy.xxcore.thread.Task;
import com.fantasy.xxcore.thread.XXThreadPoolTaskExecutor;
import com.fantasy.xxtest.base.SpringTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class XXThreadManagerServiceTest extends SpringTest {


    @Autowired
    private XXThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Test
    public void test() throws InterruptedException, ExecutionException {

        List<Task> taskList = Lists.newArrayList();
        int n = 1;
        for(int i = 1; i <= 250; i++) {

            String taskName = String.format("task-%s", i);
            TaskCallable taskCallable = new TaskCallable(taskName, 1, i);
            taskList.add(new Task(taskCallable));

            if(i % 60 == 0) {
                threadPoolTaskExecutor.execute("task-group-" + n, taskList);
                taskList.clear();
                n++;
            }
        }

        threadPoolTaskExecutor.execute("task-group-" + n, taskList);

        TimeUnit.SECONDS.sleep(60);
    }

    class TaskCallable implements Callable<Integer>{

        private String taskName;

        private int timeout;

        private int value;

        public TaskCallable(String taskName, int timeout, int value){
            this.taskName = taskName;
            this.timeout = timeout;
            this.value = value;
        }

        @Override
        public Integer call() throws Exception {

            TimeUnit.SECONDS.sleep(timeout);

            logger.info("------------------ {}", taskName);

            return value;
        }
    }
}
