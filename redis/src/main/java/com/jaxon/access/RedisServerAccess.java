package com.jaxon.access;

import com.jaxon.operation.list.RedisListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * [一句话描述类功能]
 *
 * @author rukawa
 * Created on 2023/01/11 9:14 by rukawa
 */
@RestController
@RequestMapping("redis")
public class RedisServerAccess {
    @Autowired
    private RedisListService redisListService;

    @PutMapping("/lpush/{key}/{value}")
    public String executeCommand(@PathVariable("key") String key, @PathVariable("value") String value) {
        redisListService.lpush(key, value);
        return "success";
    }
}
