package com.jaxon.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.alibaba.fastjson.JSONObject;
import com.jaxon.config.Config;
import com.jaxon.service.IUserService;

public class JunitTest {

    @Test
    public void test1() {
        //读取配置
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Config.class);
        IUserService iUserService = ac.getBean(IUserService.class);
        iUserService.sayHello("mike");
        ac.close();
    }

    @Test
    public void test2() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("aaa", "hello");
        Map m = jsonObject;
        Map<String, String> map = new HashMap<>();
        map.put("bbb", null);
        map.putAll(m);
//    	m.putAll(map);
    }

}
