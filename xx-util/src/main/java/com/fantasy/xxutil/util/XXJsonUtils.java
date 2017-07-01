package com.fantasy.xxutil.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

/**
 * @author li.fang
 * @since 2017/7/1
 */
public final class XXJsonUtils {

    private static Logger logger = LoggerFactory.getLogger(XXJsonUtils.class);

    public static String toJsonStr(Object object) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    public static <T> T parseObject(String jsonStr, Class<T> tClass) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(jsonStr, tClass);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    public static <T> List<T> parseArray(String jsonStr, Class<T> tClass){
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(jsonStr, new TypeReference<List<T>>() {});
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }
}
