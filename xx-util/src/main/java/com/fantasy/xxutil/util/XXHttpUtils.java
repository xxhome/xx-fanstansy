package com.fantasy.xxutil.util;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @author li.fang
 * @since 2017/6/5
 */
public final class XXHttpUtils {

    private static Logger logger = LoggerFactory.getLogger(XXHttpUtils.class);

    public static void main(String[] args) {
        get("http://127.0.0.1/xx-fantasy/xxblog/group/list.xhtml");
    }


    public static String get(final String url) {
        String result = null;
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            HttpGet httpget = new HttpGet(url);
            try (CloseableHttpResponse response = httpclient.execute(httpget)) {
                // 获取响应实体
                HttpEntity entity = response.getEntity();
                logger.debug("---------------------------------------------------------------------------------------");
                // 打印响应状态
                logger.debug("Response status : {}", response.getStatusLine());
                if (entity != null) {
                    result = EntityUtils.toString(entity);

                    // 打印响应内容长度
                    logger.debug("Response content length : {}", entity.getContentLength());
                    // 打印响应内容
                    logger.debug("Response content : {}", result);

                }
                logger.debug("---------------------------------------------------------------------------------------");
            }
        } catch (ParseException | IOException e) {
            logger.debug(e.getMessage(), e);
        }
        return result;
    }

}
