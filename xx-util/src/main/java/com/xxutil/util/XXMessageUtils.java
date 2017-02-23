package com.xxutil.util;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.web.servlet.LocaleResolver;

import java.util.Locale;

/**
 * 读取国际化资源文件
 *
 * @author li.fang
 * @sine 17/02/19
 */
@Component
@Lazy(false)
public class XXMessageUtils implements ApplicationContextAware, DisposableBean {

    private static ApplicationContext applicationContext;

    private XXMessageUtils() {
    }

    public void setApplicationContext(ApplicationContext applicationContext) {
        XXMessageUtils.applicationContext = applicationContext;
    }

    public void destroy() throws Exception {
        applicationContext = null;
    }

    public static Object getBean(String name) {
        Assert.hasText(name);
        return applicationContext.getBean(name);
    }

    public static <T> T getBean(String name, Class<T> type) {
        Assert.hasText(name);
        Assert.notNull(type);
        return applicationContext.getBean(name, type);
    }

    public static String getMessage(String code, Object... args) {
        LocaleResolver localeResolver = getBean("localeResolver", LocaleResolver.class);
        Locale locale = localeResolver.resolveLocale(null);
        return applicationContext.getMessage(code, args, locale);
    }
}
