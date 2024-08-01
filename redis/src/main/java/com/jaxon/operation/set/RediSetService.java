package com.jaxon.operation.set;

import com.jaxon.config.RedisClientFactory;
import io.lettuce.core.api.sync.RedisCommands;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * [set类型常用基础命令]
 *
 * @author rukawa
 * Created on 2022/12/02 13:41 by rukawa
 */
@Service
public class RediSetService {

    private final RedisCommands<String, String> redisCommands = RedisClientFactory.getInstance().getLettuceClientStandalone().connect().sync();

    /**
     * @param k
     * @param v
     * @return 添加成功元素个数
     */
    public long sadd(String k, String v) {
        return redisCommands.sadd(k, v);
    }

    /**
     * @param k
     * @param mem
     * @return 删除成功元素个数
     */
    public long sremove(String k, String mem) {
        return redisCommands.srem(k, mem);
    }

    public Set<String> getAllMembers(String k) {
        return redisCommands.smembers(k);
    }

    /**
     * 集合中某个元素是否存在
     *
     * @param k   集合名称
     * @param mem 元素
     */
    public boolean isMemExists(String k, String mem) {
        return redisCommands.sismember(k, mem);
    }


}
