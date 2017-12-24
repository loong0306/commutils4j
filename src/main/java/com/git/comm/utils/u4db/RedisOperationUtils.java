package com.git.comm.utils.u4db;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * Created by dragon on 12/24/2017.
 */
public class RedisOperationUtils {
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    public void set(String key, String value){
        ValueOperations<String, String> valueOps = stringRedisTemplate.opsForValue();
        valueOps.set(key,value);
    }
    public void set(String key,String value, Long time, TimeUnit timeUnit){
        ValueOperations<String, String> valueOps = stringRedisTemplate.opsForValue();
        valueOps.set(key,value,time, timeUnit);
    }


    public void increment(String key, Long value){
        ValueOperations<String, String> valueOps = stringRedisTemplate.opsForValue();
        valueOps.increment(key,value);
    }

    public boolean hasKey(String key){
        return stringRedisTemplate.hasKey(key);
    }

    public Long getValue(String key){
        ValueOperations<String, String> valueOps = stringRedisTemplate.opsForValue();
        return  Long.parseLong(valueOps.get(key));
    }

    public void deleteKey(String key){
        stringRedisTemplate.delete(key);
    }
}
