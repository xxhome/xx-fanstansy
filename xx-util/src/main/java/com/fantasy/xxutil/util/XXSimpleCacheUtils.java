package com.fantasy.xxutil.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lifang@winployee.com
 * @since 2018-02-23
 */
public class XXSimpleCacheUtils {

    public final static Map<String, Object> cacheMap = new HashMap<>();

    public static void put(String key, Object value){
        cacheMap.put(key, value);
    }

    public static Object get(String key){
        return cacheMap.get(key);
    }

    public static Object getOrDefault(String key, Object defaultValue){
        return cacheMap.getOrDefault(key, defaultValue);
    }

    public static void remove(String key){
        cacheMap.remove(key);
    }

    public static void clean(){
        cacheMap.clear();
    }

}
