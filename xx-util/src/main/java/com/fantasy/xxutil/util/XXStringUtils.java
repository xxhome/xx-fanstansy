package com.fantasy.xxutil.util;

import org.apache.commons.lang3.StringUtils;

/**
 * @author li.fang
 * @sine 17/03/07
 */
public final class XXStringUtils {

    private XXStringUtils() {
    }

    public static String getUpperCase(final String str) {
        if (StringUtils.isBlank(str)) return "";

        StringBuilder sb = new StringBuilder();
        int len = str.length();
        for (int i = 0; i < len; i++) {
            char s = str.charAt(i);
            if (Character.isUpperCase(s)) {
                sb.append(s);
            }
        }
        return sb.toString();
    }
}
