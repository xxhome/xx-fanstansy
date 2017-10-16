package com.fantasy.xxbase.annotation;

import org.springframework.core.annotation.AliasFor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.annotation.*;

/**
 * @author li.fang
 * @since 2017/10/16 14:13
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@RequestMapping
public @interface XXRequestMapping {

    @AliasFor(annotation = RequestMapping.class, attribute = "path")
    String[] value();

    @AliasFor(annotation = RequestMapping.class, attribute = "produces")
    String[] produces() default MediaType.APPLICATION_ATOM_XML_VALUE;
}
