package com.fantasy.xxbase.method;

/**
 * @author li.fang
 * @sine 17/02/28
 */
public class XXResponseBody<T> {

    public static final XXResponseBody SUCCEED = new XXResponseBody();

    private long code = 0L;

    private String message;

    private T data;

    private String runtime;

    private XXResponseBody(){}

    public XXResponseBody(T data){
        this.data = data;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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
