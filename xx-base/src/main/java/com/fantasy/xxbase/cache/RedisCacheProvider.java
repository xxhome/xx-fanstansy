package com.fantasy.xxbase.cache;

import com.fantasy.xxbase.entity.XXBaseEntity;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

import java.io.Serializable;
import java.util.Collection;

/**
 * Redis实现缓存策略
 *
 * @author li.fang
 * @sine 17/02/19
 */
public class RedisCacheProvider implements CacheProvider {

    private RedisTemplate<String, Object> redisTemplate;

    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public <T extends Serializable> void put(final String category, final String key, T obj) {
        put(category, key, obj, -1);
    }

    @Override
    public <T extends Serializable> void put(final String category, final String key, T obj, int timeToLiveSeconds) {
        final String categoryKey = String.format("%s:%s", category, key);

        redisTemplate.execute((RedisCallback<Serializable>) redisConnection -> {

            RedisSerializer<Serializable> value = (RedisSerializer<Serializable>) redisTemplate.getValueSerializer();

            byte[] byteKey = redisTemplate.getStringSerializer().serialize(categoryKey);

            redisConnection.set(byteKey, value.serialize(obj));

            if(timeToLiveSeconds > 0){
                redisConnection.expire(byteKey, timeToLiveSeconds);
            }
            return null;
        });
    }

    @Override
    public <T extends XXBaseEntity> void put(final String category, Collection<T> objs) {

    }

    @Override
    public <T extends XXBaseEntity> void put(final String category, Collection<T> objs, int timeToLiveSeconds) {

    }

    @Override
    public <T extends Serializable> T get(final String category, final String key) {
        final String categoryKey = String.format("%s:%s", category, key);

        Serializable serializable = redisTemplate.execute((RedisCallback<Serializable>) redisConnection -> {
            byte[] byteKey = redisTemplate.getStringSerializer().serialize(categoryKey);

            if(redisConnection.exists(byteKey)) return null;

            byte[] value = redisConnection.get(byteKey);
            Serializable valueSerial = (Serializable) redisTemplate.getValueSerializer().deserialize(value);
            return valueSerial;
        });
        return (T) serializable;
    }

    @Override
    public <T extends XXBaseEntity> Collection<T> getCollection(final String category) {
        return null;
    }

    @Override
    public long getCacheSize() {
        return 0;
    }

    @Override
    public boolean isExist(final String category, final String key) {
        return false;
    }

    @Override
    public void removeAll() {

    }

    @Override
    public void remove(final String category) {

    }

    @Override
    public void remove(final String category, final String key) {
        final String categoryKey = String.format("%s:%s", category, key);
        redisTemplate.delete(categoryKey);
    }
}
