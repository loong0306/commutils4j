package com.git.comm.utils.u4db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by dragon on 11/7/2017.
 */
@Component
public class RedisUtils {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private StringRedisTemplate rt;

    public String getNowCode(String envLock, String prefix, int prefixLen){
        SimpleDateFormat df = new SimpleDateFormat("yyMMdd");
        String dateStr = df.format(new Date());
        String key = envLock + prefix +dateStr;
        String valuePrefix = prefix +dateStr;
        Long newValue =1L;
        try {
            synchronized (this) {
                ValueOperations<String,String> ops  = rt.opsForValue();
                if (!rt.hasKey(key)) {
                    ops.set(key, String.valueOf(1L));
                    rt.expire(key, 1L, TimeUnit.DAYS);
                } else {
                    newValue = ops.increment(key, 1L);
                }
            }
        } catch (Exception ex) {
            logger.error("Redis生成序列号发生错误", ex);
        }
        String zeroStr = "";
        if (null != newValue && prefixLen > 0 && String.valueOf(newValue).length() < prefixLen) {
            for (int i = 0; i < prefixLen - String.valueOf(newValue).length(); i++) {
                zeroStr += "0";
            }
        }
        return valuePrefix + zeroStr + newValue;
    }
}
