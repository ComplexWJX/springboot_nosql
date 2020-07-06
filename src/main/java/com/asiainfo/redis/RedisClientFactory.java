package com.asiainfo.redis;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisFuture;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.async.RedisAsyncCommands;
import io.lettuce.core.cluster.RedisClusterClient;
import io.lettuce.core.cluster.api.StatefulRedisClusterConnection;
import io.lettuce.core.cluster.api.async.RedisAdvancedClusterAsyncCommands;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Koala
 * @description
 * @date 2020/2/16 0016
 */
public class RedisClientFactory {
    public static void main(String[] args) {
        getInstance().getLettuceClient();
    }

    void getLettuceClient(){
        //单机
        RedisClient redisClient = RedisClient.create("redis://@192.168.3.31:6379");
        StatefulRedisConnection<String, String> connect = redisClient.connect();
        RedisAsyncCommands<String, String> singleAsync = connect.async();
        RedisFuture<String> redisFuture = singleAsync.get("name");


        //集群
        List<RedisURI> list = new ArrayList<>();
        list.add(RedisURI.create("redis://192.168.3.31:6379"));
        list.add(RedisURI.create("redis://192.168.3.31:6380"));
        list.add(RedisURI.create("redis://192.168.3.31:6381"));
        list.add(RedisURI.create("redis://192.168.3.19:6379"));
        list.add(RedisURI.create("redis://192.168.3.19:6380"));
        list.add(RedisURI.create("redis://192.168.3.19:6381"));
        RedisClusterClient clusterClient = RedisClusterClient.create(list);
        StatefulRedisClusterConnection<String, String> clusterConnection = clusterClient.connect();
        RedisAdvancedClusterAsyncCommands<String, String> clusterAsyncCommands = clusterConnection.async();
        RedisFuture<String> clusterFuture = clusterAsyncCommands.get("name");

        try {
//            System.out.println(redisFuture.get());
            System.out.println("========================================>>>"+clusterFuture.get());
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            connect.close();
            clusterConnection.close();
            redisClient.shutdown();
            clusterClient.shutdown();
        }
    }

    public JedisCluster getJedisClient(){
        Set<HostAndPort> jedisClusterNodes = new HashSet<>();
        //Jedis Cluster will attempt to discover cluster nodes automatically
        jedisClusterNodes.add(new HostAndPort("192.168.3.31", 6379));
        jedisClusterNodes.add(new HostAndPort("192.168.3.31", 6380));
        jedisClusterNodes.add(new HostAndPort("192.168.3.31", 6381));
        jedisClusterNodes.add(new HostAndPort("192.168.3.19", 6379));
        jedisClusterNodes.add(new HostAndPort("192.168.3.19", 6380));
        jedisClusterNodes.add(new HostAndPort("192.168.3.19", 6381));
        JedisCluster jc = new JedisCluster(jedisClusterNodes);
//        jc.set("foo", "bar");
        System.out.println(jc.get("name"));
        return jc;
    }

    public static RedisClientFactory getInstance(){
        return new RedisClientFactory();
    }
}
