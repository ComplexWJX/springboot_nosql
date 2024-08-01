package com.jaxon.operation.string;

import com.jaxon.config.RedisClientFactory;
import io.lettuce.core.api.sync.RedisCommands;
import org.springframework.stereotype.Service;

/**
 * [string类型常用基础命令]
 *
 * @author rukawa
 * Created on 2022/12/02 13:41 by rukawa
 */
@Service
public class RedisStringService {

    private final RedisCommands<String, String> redisCommands = RedisClientFactory.getInstance().getLettuceClientStandalone().connect().sync();

    public void set(String k, String v) {
        redisCommands.set(k ,v);
    }

    public void get(String k) {
        redisCommands.get(k);
    }

    public void setnx(String k, String v) {
        redisCommands.setnx(k ,v);
    }

    /**
     * @param k
     * @param seconds expired time
     * @param v
     */
    public void setnx(String k, long seconds, String v) {
        redisCommands.setex(k , seconds, v);
    }

    /**
     * 获取键值长度
     * @param k
     * @return
     */
    public Long strlen(String k) {
        return redisCommands.strlen(k);
    }
}
