
package com.jaxon.config.listener;

import io.lettuce.core.RedisURI;
import io.lettuce.core.cluster.RedisClusterClient;
import io.lettuce.core.cluster.models.partitions.RedisClusterNode;
import io.lettuce.core.cluster.pubsub.RedisClusterPubSubAdapter;
import io.lettuce.core.cluster.pubsub.StatefulRedisClusterPubSubConnection;
import io.lettuce.core.cluster.pubsub.api.async.NodeSelectionPubSubAsyncCommands;
import io.lettuce.core.cluster.pubsub.api.async.PubSubAsyncNodeSelection;
import io.lettuce.core.pubsub.RedisPubSubAdapter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ClusterSubscriber extends RedisPubSubAdapter implements ApplicationRunner {

    private static final String EXPIRED_CHANNEL = "__keyevent@0__:expired";

    @Value("${spring.redis.host}")
    private String clusterNodes;

    @Value("${spring.redis.password}")
    private String password;


    public void run(ApplicationArguments args) throws Exception {
        log.info("集群过期事件，启动监听......");
        startListener();
    }

    public void startListener() {
        String[] redisNodes = this.clusterNodes.split(",");
        RedisURI redisURI = RedisURI.create("redis://" + redisNodes[0]);
        redisURI.setPassword(this.password);
        RedisClusterClient clusterClient = RedisClusterClient.create(redisURI);
        StatefulRedisClusterPubSubConnection<String, String> pubSubConnection = clusterClient.connectPubSub();
        pubSubConnection.setNodeMessagePropagation(true);
        pubSubConnection.addListener(new RedisClusterPubSubAdapter() {
            public void message(RedisClusterNode node, Object channel, Object message) {
                String msg = message.toString();
                System.out.println(msg);
            }
        });
        PubSubAsyncNodeSelection<String, String> masters = pubSubConnection.async().masters();
        NodeSelectionPubSubAsyncCommands<String, String> commands = masters.commands();
        commands.subscribe(new String[]{"__keyevent@0__:expired"});
    }
}
