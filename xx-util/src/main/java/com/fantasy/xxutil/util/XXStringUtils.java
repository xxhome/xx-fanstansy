package com.fantasy.xxutil.util;

import org.apache.commons.lang3.StringUtils;

/**
 * @author li.fang
 * @sine 17/03/07
 */
public final class XXStringUtils {

    private XXStringUtils() {
    }

    /**
     * 获取字符串中大写字母
     * <pre>
     *     1. XXStringUtils.getUpperCase("ABC") = ABC
     *     2. XXStringUtils.getUpperCase("ABc") = AB
     *     3. XXStringUtils.getUpperCase("abc") = ""
     *     4. XXStringUtils.getUpperCase("") = ""
     * </pre>
     * @param str 字符串
     * @return 字符串中的出现的大写字母
     */
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

    public static boolean isBlank(final String str){
        return StringUtils.isBlank(str);
    }

    public static boolean isNotBlank(final String str){
        return StringUtils.isNotBlank(str);
    }
}
