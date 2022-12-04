package com.asiainfo.operation.zset;

import com.asiainfo.config.RedisClientFactory;
import io.lettuce.core.api.sync.RedisCommands;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * [zset类型常用基础命令]
 *
 * @author rukawa
 * Created on 2022/12/02 13:41 by rukawa
 */
@Service
public class RedisZsetService {

    private final RedisCommands<String, String> redisCommands = RedisClientFactory.getInstance().getLettuceClientStandalone().connect().sync();

    public Long zadd(String k, double score, String v) {
        return redisCommands.zadd(k ,score,v);
    }

    public Double zaddincr(String k, double score, String v) {
        return redisCommands.zaddincr(k ,score,v);
    }

    /**
     * 返回集合元素总数
     * @param k
     * @return
     */
    public Long zcard(String k) {
        return redisCommands.zcard(k);
    }
}
