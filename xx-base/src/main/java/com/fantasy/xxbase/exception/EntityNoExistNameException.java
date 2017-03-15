package com.fantasy.xxbase.exception;

/**
 * @author li.fang
 * @sine 17/02/19
 */
public class EntityNoExistNameException extends Exception {

    public EntityNoExistNameException(String message) {
        super(message);
    }

    public EntityNoExistNameException(String message, String... args) {
        super(String.format(message, args));
    }
}
