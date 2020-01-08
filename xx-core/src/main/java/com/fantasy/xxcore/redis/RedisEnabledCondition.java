package com.fantasy.xxcore.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author lifang@winployee.com
 * @since 2018-02-23
 */
public class RedisEnabledCondition implements Condition {

    private static Logger logger = LoggerFactory.getLogger(RedisEnabledCondition.class);

    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        return false;
    }
}
