package com.fantasy.xxtest.expression;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.joda.time.DateTime;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author li.fang
 * @since 2017/6/30
 */
public class ExprRootObject {

    private Map<String, Object> map = new HashMap<>();

    /**
     * 获取多少天之后的日期
     * @param param
     * @return
     */
    public String getAfterDate(String param){

        int hours = Integer.valueOf(param.substring(0, param.length() - 1));

        Date date;
        if(StringUtils.endsWithIgnoreCase(param, "h")){

            date = new DateTime(new Date()).plusHours(hours).toDate();

        }else{
            int day = Integer.valueOf(param.substring(0, param.length() - 1));

            date = new DateTime(new Date()).plusDays(day).toDate();

        }
        return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(date);
    }
}
