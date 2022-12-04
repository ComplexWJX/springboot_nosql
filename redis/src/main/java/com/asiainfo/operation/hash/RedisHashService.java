package com.asiainfo.operation.hash;

import com.asiainfo.config.RedisClientFactory;
import io.lettuce.core.api.sync.RedisCommands;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * [hash类型常用基础命令]
 *
 * @author rukawa
 * Created on 2022/12/02 13:41 by rukawa
 */
@Service
public class RedisHashService {

    private final RedisCommands<String, String> redisCommands = RedisClientFactory.getInstance().getLettuceClientStandalone().connect().sync();

    public Boolean hset(String k, String filed, String v) {
        return redisCommands.hset(k, filed, v);
    }

    public String hget(String k, String filed) {
        return redisCommands.hget(k, filed);
    }

    /**
     * @param k
     * @param filed
     * @return 成功删除的hash表中的key键
     */
    public Long hdel(String k, String filed) {
        return redisCommands.hdel(k, filed);
    }

    public Boolean hexists(String k, String filed) {
        return redisCommands.hexists(k, filed);
    }

    /**
     * @param k
     * @return 返回hash所有key键集合
     */
    public List<String> hkeys(String k) {
        return redisCommands.hkeys(k);
    }

    /**
     * @param k
     * @return 返回hash所有key键总数
     */
    public Long hlen(String k) {
        return redisCommands.hlen(k);
    }
}
