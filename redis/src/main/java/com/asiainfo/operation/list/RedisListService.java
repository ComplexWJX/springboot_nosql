package com.asiainfo.operation.list;

import com.asiainfo.config.RedisClientFactory;
import io.lettuce.core.api.sync.RedisCommands;
import org.springframework.stereotype.Service;

/**
 * [一句话描述类功能]
 *
 * @author rukawa
 * Created on 2022/12/02 13:41 by rukawa
 */
@Service
public class RedisListService {

    private final RedisCommands<String, String> redisCommands = RedisClientFactory.getInstance().getLettuceClientStandalone().connect().sync();

    public void rpush(String k, String v) {
        redisCommands.rpush(k ,v);
    }
}
