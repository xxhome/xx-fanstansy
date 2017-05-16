package com.fantasy.xxbase.exception;

/**
 * @author li.fang
 * @since 2017/5/16
 */
public class CommonRuntimeException extends RuntimeException{

    public CommonRuntimeException() {
    }


    public CommonRuntimeException(String message) {
        super(message);
    }

    public CommonRuntimeException(String message, Object[] args){
        this(String.format(message, args));
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return new Throwable();
    }

}
