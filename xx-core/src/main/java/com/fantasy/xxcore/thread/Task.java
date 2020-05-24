package com.fantasy.xxcore.thread;

import java.util.UUID;
import java.util.concurrent.Callable;

public class Task<T> {

    /**
     * 任务唯一标识
     */
    private String taskKey;

    private Runnable runnable;

    private Callable<T> callable;

    /**
     * 是否需要接受返回值
     */
    private boolean future;

    public Task(Runnable runnable){
        this(runnable, false);
    }

    public Task(Callable callable){
        this(callable, false);
    }

    public Task(Runnable runnable, boolean future){
        this.taskKey = String.format("%s-%s", "task-runnable-", UUID.randomUUID().toString());
        this.runnable = runnable;
        this.future = future;
    }

    public Task(Callable callable, boolean future){
        this.taskKey = String.format("%s-%s", "task-callable-", UUID.randomUUID().toString());
        this.callable = callable;
        this.future = future;
    }


    public String getTaskKey() {
        return taskKey;
    }

    public Runnable getRunnable() {
        return runnable;
    }

    public Callable<T> getCallable() {
        return callable;
    }

    public boolean isFuture() {
        return future;
    }
}
