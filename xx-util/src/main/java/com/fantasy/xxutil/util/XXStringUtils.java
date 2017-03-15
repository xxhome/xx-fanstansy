package com.fantasy.xxutil.util;

/**
 * @author li.fang
 * @sine 17/03/07
 */
public final class XXStringUtils {

    private XXStringUtils() {
    }

    public static String getForwardPath(String view){
        return String.format("forward:%s", view);
    }
}
