package com.fantasy.xxbase.method;

import java.io.Serializable;

/**
 * @author li.fang
 * @sine 17/02/28
 */
public class XXResponseBody<T> implements Serializable{

    public static final XXResponseBody SUCCEED = new XXResponseBody();

    public static final XXResponseBody FAILURE = new XXResponseBody(10000, "呜呜~~中奖了，系统出现了未知异常~~");

    private long code = 0L;

    private String msg;

    private T data;

    private String runtime;

    private XXResponseBody(){}

    public XXResponseBody(T data){
        this.data = data;
    }

    public XXResponseBody(long code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }
}
