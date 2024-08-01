package com.jaxon.operation;

import com.jaxon.config.RedisClientFactory;
import com.jaxon.utils.SerializationUtil;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author WJX
 * @version 1.0
 * @date 2024/04/24/09:35
 * @description
 */
public class JedisClient {

    public Long lpush(String key, List<?> dataList) {

        Long lpush = 0L;

        Jedis jedis = null;

        try {
            // 根据database获取默认的redisClient 如果为空则默认取配置文件中的第一个
            jedis = RedisClientFactory.getInstance().getJedisClientStandalone();

            // 将对象序列化
            byte[][] rawValues = new byte[dataList.size()][];
            int i = 0;
            for (Object value : dataList) {
                rawValues[i++] = SerializationUtil.serialize(value);
            }
            lpush = jedis.lpush(SerializationUtil.serialize(key), rawValues);

//            log.info("mem.append({},{},value)", key);
        } catch (Exception e) {
//            log.error("mem.append({},{},{}) Exception:{}", key, dataList, e.getMessage());
            e.printStackTrace();

        } finally {
            if (null != jedis) {
                try {
                    jedis.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return lpush;

    }

    /**
     * 获得缓存的list对象
     *
     * @param key 缓存的键值
     * @return 缓存键值对应的数据
     */
    public <T> List<T> lrange(String key) {
        Jedis jedis = null;
        List<T> result = new ArrayList<>();

        try {
            // 根据database获取默认的redisClient 如果为空则默认取配置文件中的第一个
            jedis = RedisClientFactory.getInstance().getJedisClientStandalone();
            List<byte[]> lrange = jedis.lrange(SerializationUtil.serialize(key), 0, -1);
            lrange.forEach(e -> {
                result.add((T) SerializationUtil.deserialize(e));
            });
            return result;

        } catch (Exception e) {
//            log.error("mem.append({},{},{}) Exception:{}", key, e.getMessage());
            e.printStackTrace();
        } finally {
            if (null != jedis) {
                try {
                    jedis.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
