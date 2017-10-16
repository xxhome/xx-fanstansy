package com.fantasy.xxbase.annotation;

import org.springframework.core.annotation.AliasFor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.*;

/**
 * @author li.fang
 * @since 2017/10/16 9:50
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@RestController
@RequestMapping
public @interface XXRestController {

    String value() default "";

    @AliasFor(annotation = RequestMapping.class, attribute = "path")
    String[] path() default {};
}
