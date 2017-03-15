package com.fantasy.xxbase.cache;

/**
 * @author li.fang
 * @sine 17/02/19
 */
public class CacheNotExistException extends Exception{

    public CacheNotExistException(String message) {
        super(message);
    }

    public CacheNotExistException(String message, String... args) {
        super(String.format(message, args));
    }
}
