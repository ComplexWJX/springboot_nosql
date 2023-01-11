package com.asiainfo.config;

import io.lettuce.core.AbstractRedisClient;
import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulConnection;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;
import io.lettuce.core.cluster.RedisClusterClient;
import io.lettuce.core.cluster.api.StatefulRedisClusterConnection;
import io.lettuce.core.cluster.api.async.RedisAdvancedClusterAsyncCommands;
import io.lettuce.core.codec.StringCodec;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * redis客户端创建 1.单机 2.集群 3.哨兵 4.订阅
 * @author Koala
 * @description
 * @date 2020/2/16 0016
 */
public class RedisClientFactory {

    public RedisClient getLettuceClientStandalone() {
        //单机
        return RedisClient.create("redis://redis:123456@10.62.10.162:6379");
    }

    public RedisClusterClient getLettuceClientCluster() {
        //集群
        List<RedisURI> list = new ArrayList<>();
        list.add(RedisURI.create("redis://192.168.3.31:6379"));
        list.add(RedisURI.create("redis://192.168.3.31:6380"));
        list.add(RedisURI.create("redis://192.168.3.31:6381"));
        list.add(RedisURI.create("redis://192.168.3.19:6379"));
        list.add(RedisURI.create("redis://192.168.3.19:6380"));
        list.add(RedisURI.create("redis://192.168.3.19:6381"));
        return RedisClusterClient.create(list);
    }

    public JedisCluster getJedisClientCluster() {
        Set<HostAndPort> jedisClusterNodes = new HashSet<>();
        //Jedis Cluster will attempt to discover cluster nodes automatically
        jedisClusterNodes.add(new HostAndPort("192.168.3.31", 6379));
        jedisClusterNodes.add(new HostAndPort("192.168.3.31", 6380));
        jedisClusterNodes.add(new HostAndPort("192.168.3.31", 6381));
        jedisClusterNodes.add(new HostAndPort("192.168.3.19", 6379));
        jedisClusterNodes.add(new HostAndPort("192.168.3.19", 6380));
        jedisClusterNodes.add(new HostAndPort("192.168.3.19", 6381));
        JedisCluster jc = new JedisCluster(jedisClusterNodes);
        return jc;
    }

    public RedisCommands<String,String> createSyncCommands () {
        StatefulRedisConnection<String, String> connect = getLettuceClientStandalone().connect();
        return connect.sync();
    }

//    public RedisCommands<String,Object> createSyncCommands () {
//        StatefulRedisConnection<String, Object> connect = getLettuceClientStandalone().connect(new StringCodec());
//        return connect.sync();
//    }

    public RedisAdvancedClusterAsyncCommands<String,String> createASyncCommands () {
        StatefulRedisClusterConnection<String, String> connect = getLettuceClientCluster().connect();
        return connect.async();
    }

    public void disconnect(StatefulConnection connection) {
        connection.close();
    }

    public void shutdownClient(AbstractRedisClient redisClient) {
        redisClient.shutdown();
    }

    public static RedisClientFactory getInstance() {
        return new RedisClientFactory();
    }
}
