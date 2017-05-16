package com.fantasy.xxbase.exception;

/**
 * @author li.fang
 * @since 2017/5/16
 */
public class CommonException extends Exception{

    public CommonException() {
    }


    public CommonException(String message) {
        super(message);
    }

    public CommonException(String message, Object[] args){
        this(String.format(message, args));
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return new Throwable();
    }
}
