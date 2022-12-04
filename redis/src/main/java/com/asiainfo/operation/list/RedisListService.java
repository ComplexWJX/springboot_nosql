package com.asiainfo.operation.list;

import com.asiainfo.config.RedisClientFactory;
import io.lettuce.core.api.sync.RedisCommands;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * [list类型常用基础命令]
 *
 * @author rukawa
 * Created on 2022/12/02 13:41 by rukawa
 */
@Service
public class RedisListService {

    private final RedisCommands<String, String> redisCommands = RedisClientFactory.getInstance().getLettuceClientStandalone().connect().sync();

    /**
     * 插入元素到队头
     *
     * @param k
     * @param v
     * @return 插入后队列长度
     */
    public long rpush(String k, String v) {
        return redisCommands.rpush(k, v);
    }

    /**
     * 插入元素到队尾
     *
     * @param k
     * @param v
     * @return 插入后队列长度
     */
    public long lpush(String k, String v) {
        return redisCommands.rpush(k, v);
    }

    /**
     * 移除并返回队尾元素
     *
     * @param k
     * @return
     */
    public String rpop(String k) {
        return redisCommands.rpop(k);
    }

    /**
     * 移除并返回队头元素
     *
     * @param k
     * @return
     */
    public String lpop(String k) {
        return redisCommands.lpop(k);
    }

    public long llen(String k) {
        return redisCommands.llen(k);
    }

    /**
     * 获取指定范围内元素
     *
     * @param k
     * @param start
     * @param end
     */
    public List<String> lrange(String k, long start, long end) {
        return redisCommands.lrange(k, start, end);
    }

    /**
     * 获取指定下表位置元素
     *
     * @param k
     * @param index
     * @return
     */
    public String getFromIndex(String k, long index) {
        return redisCommands.lindex(k, index);
    }

    /**
     * 设置指定下表位置元素
     *
     * @param k
     * @param index
     * @param v
     * @return 替换后元素
     */
    public String setIndex(String k, long index, String v) {
        return redisCommands.lset(k, index, v);
    }
}
