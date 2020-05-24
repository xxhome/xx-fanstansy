package com.fantasy.xxcore.thread;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class XXThreadPoolTaskExecutor extends ThreadPoolTaskExecutor {

    private static final Logger logger = LoggerFactory.getLogger(XXThreadPoolTaskExecutor.class);


    private static final int taskQueueCapacity = 50;

    private static final ExecutorService executorService = Executors.newSingleThreadExecutor();

    /**
     * 等待执行的任务列表
     * key:任务分组名称
     * value:等待执行的任务列表
     */
    private static Map<String, Vector<Task>> WAITING_TASK_GROUP_MAP = new ConcurrentHashMap<>();

    private static Map<String, Future> RUNNING_TASK_GROUP_MAP = new ConcurrentHashMap<>();

    private static ReentrantLock lock = new ReentrantLock();


    public XXThreadPoolTaskExecutor(){
        setQueueCapacity(taskQueueCapacity);
        run();
    }


    @Override
    public void execute(Runnable runnable) {
        String taskGroupName = UUID.randomUUID().toString();

        Task task = new Task<>(runnable, true);

        putWaitingTaskGroupMap(taskGroupName, task);
    }

    public void execute(String taskGroupName, List<Task> tasks){
        if(CollectionUtils.isEmpty(tasks)) return;
        putWaitingTaskGroupMap(taskGroupName, tasks);
    }


    @Override
    public Future<?> submit(Runnable runnable) {
        String taskGroupName = UUID.randomUUID().toString();

        Task task = new Task<>(runnable, true);

        return submit(taskGroupName, task);
    }

    @Override
    public <T> Future<T> submit(Callable<T> callable) {
        String taskGroupName = UUID.randomUUID().toString();

        Task<T> task = new Task<>(callable, true);

        return submit(taskGroupName, task);
    }


    public <T> Future<T> submit(String taskGroupName, Task<T> task) {
        putWaitingTaskGroupMap(taskGroupName, task);

        if(task.isFuture()) {

            //需要接收返回值
            return getRunningTaskFuture(task.getTaskKey());

        }else{

            return null;
        }
    }


    private void run(){
        executorService.execute(() -> {
            while (true){
                lock.lock();
                try {

                    if(CollectionUtils.isEmpty(WAITING_TASK_GROUP_MAP)) {
                        //没有待执行的任务，等待新任务唤醒。
                        TimeUnit.SECONDS.sleep(1);
                        continue;
                    }

                    int currentTaskCount = getThreadPoolExecutor().getQueue().size();

                    logger.info("current thread pool executor queue size : {}", currentTaskCount);

                    if(currentTaskCount >= taskQueueCapacity) {
                        //当前任务列表饱和状态，等待500毫秒再次判断。
                        TimeUnit.MILLISECONDS.sleep(500);
                        continue;
                    }

                    int index = currentTaskCount;
                    do{

                        Iterator<Map.Entry<String, Vector<Task>>> iterator = WAITING_TASK_GROUP_MAP.entrySet().iterator();

                        while (iterator.hasNext()){

                            Map.Entry<String, Vector<Task>> next = iterator.next();
                            String taskGroupName = next.getKey();
                            Vector<Task> waitingTasks = next.getValue();

                            if(CollectionUtils.isEmpty(waitingTasks)) {
                                logger.info("TaskGroupName:{}, 任务已经全部执行完毕!", taskGroupName);
                                iterator.remove();
                                continue;
                            }

                            Task task = waitingTasks.get(0);
                            Callable callable = task.getCallable();
                            Runnable runnable = task.getRunnable();

                            if(!Objects.isNull(callable)){

                                Future<?> future = super.submit(callable);
                                if(task.isFuture()) {
                                    putRunningTaskMap(task.getTaskKey(), future);
                                }

                            }else if(!Objects.isNull(runnable)){

                                if(task.isFuture()) {
                                    Future<?> future = super.submit(runnable);
                                    putRunningTaskMap(task.getTaskKey(), future);
                                }else{
                                    super.execute(runnable);
                                }
                            }

                            waitingTasks.remove(task);
                            index++;
                        }
                    }while (index < taskQueueCapacity);

                }catch (Exception e){
                    logger.error(e.getMessage(), e);
                }finally {
                    lock.unlock();
                }
            }

        });
    }


    private <T> void putWaitingTaskGroupMap(String taskGroupName, List<Task> tasks){
        Vector<Task> vector = WAITING_TASK_GROUP_MAP.getOrDefault(taskGroupName, new Vector<>());

        vector.addAll(tasks);

        WAITING_TASK_GROUP_MAP.put(taskGroupName, vector);
    }

    private <T> void putWaitingTaskGroupMap(String taskGroupName, Task<T> task){

        Vector<Task> vector = WAITING_TASK_GROUP_MAP.getOrDefault(taskGroupName, new Vector<>());

        vector.add(task);

        WAITING_TASK_GROUP_MAP.put(taskGroupName, vector);
    }

    private void putRunningTaskMap(String taskKey, Future future){
        RUNNING_TASK_GROUP_MAP.put(taskKey, future);
    }

    private Future getRunningTaskFuture(String taskKey){
        Future future = null;
        do {

            future = RUNNING_TASK_GROUP_MAP.get(taskKey);

            if(future != null) break;

            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                logger.error(e.getMessage(), e);
            }

        }while (true);

        RUNNING_TASK_GROUP_MAP.remove(taskKey);

        return future;
    }
}
