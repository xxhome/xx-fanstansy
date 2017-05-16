package com.fantasy.xxbase.exception;

/**
 * @author li.fang
 * @sine 17/02/19
 */
public class EntityNoExistNameException extends CommonException {

    public EntityNoExistNameException(){
        super();
    }

    public EntityNoExistNameException(String message, String... args) {
        super(String.format(message, args));
    }
}
