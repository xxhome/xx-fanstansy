package com.fantasy.xxcore.redis;

import com.fantasy.xxbase.cache.RedisCacheProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author lifang@winployee.com
 * @since 2018-02-23
 */
public class RedisBeanConfig{

    @Value("${redis.host}")
    public String host;

    @Value("${redis.port}")
    public int port;

    @Value("${redis.password}")
    public String password;

    @Value("${redis.maxIdle}")
    public int maxIdle;

    @Value("${redis.testOnBorrow}")
    public boolean testOnBorrow;

    /**
     * <bean id="jedisConnectionFactory" class="org.springframework.data.redis.connection.jedis.JedisConnectionFactory">
     *      <property name="hostName" value="${redis.host}"/>
     *      <property name="port" value="${redis.port}"/>
     *      <property name="password" value="${redis.password}"/>
     *      <property name="usePool" value="true"></property>
     *      <property name="poolConfig" ref="poolConfig"/>
     * </bean>
     */
    @Bean
    @Conditional(RedisEnabledCondition.class)
    public JedisConnectionFactory jedisConnectionFactory(JedisPoolConfig jedisPoolConfig){
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
        jedisConnectionFactory.setHostName(host);
        jedisConnectionFactory.setPort(port);
        jedisConnectionFactory.setPassword(password);
        jedisConnectionFactory.setUsePool(true);
        jedisConnectionFactory.setPoolConfig(jedisPoolConfig);
        return jedisConnectionFactory;
    }


    /**
     * <bean id="redisTemplate" class="org.springframework.data.redis.core.StringRedisTemplate">
     *      <property name="connectionFactory" ref="jedisConnectionFactory"/>
     * </bean>
     */
    @Bean
    @Conditional(RedisEnabledCondition.class)
    public RedisTemplate redisTemplate(JedisConnectionFactory jedisConnectionFactory){
        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
        stringRedisTemplate.setConnectionFactory(jedisConnectionFactory);
        return stringRedisTemplate;
    }

    /**
     * <bean id="poolConfig" class="redis.clients.jedis.JedisPoolConfig">
     *      <property name="maxIdle" value="${redis.maxIdle}"/>
     *      <property name="testOnBorrow" value="${redis.testOnBorrow}"/>
     * </bean>
     * @return Redis连接处
     */
    @Bean
    @Conditional(RedisEnabledCondition.class)
    public JedisPoolConfig jedisPoolConfig(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setTestOnBorrow(testOnBorrow);
        return jedisPoolConfig;
    }

    /**
     * <bean id="redisCacheProvider" class="com.fantasy.xxbase.cache.RedisCacheProvider">
     *       <property name="redisTemplate" ref="redisTemplate"/>
     * </bean>
     */
    @Bean
    @Conditional(RedisEnabledCondition.class)
    public RedisCacheProvider redisCacheProvider(RedisTemplate redisTemplate){
        RedisCacheProvider redisCacheProvider = new RedisCacheProvider();
        redisCacheProvider.setRedisTemplate(redisTemplate);
        return redisCacheProvider;
    }
}
