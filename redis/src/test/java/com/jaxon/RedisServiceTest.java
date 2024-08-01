package com.jaxon;

import com.jaxon.bean.DevResp;
import com.jaxon.operation.JedisClient;
import com.jaxon.operation.list.RedisListService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author WJX
 * @version 1.0
 * @Date 2023/01/02/19:38
 * @Description
 */
@SpringBootTest(classes = RedisApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class RedisServiceTest {

    @Autowired
    private RedisListService redisListService;

    @Autowired
    private Map<String, ComponentService> serviceMap;

    @Test
    public void testList() {
//        List<String> waiterList = redisListService.lrange("waitlist", 0, -1);
//        System.out.println(waiterList);
        List<DevResp> devRespList = new ArrayList<>();
        DevResp devResp = new DevResp();
        devResp.setDeviceId(1L);
        devResp.setVendorName("huawei");
        devResp.setDeviceIp("12.12.34.22");
        devResp.setReportTime(1000L);
        devResp.setLoid("ddff");
        devResp.setNetAccount("aabb");
        devResp.setNetType("");
        devResp.setOnlineTime("2024-02-02 12:12:12");
        devResp.setOnlineStatus("1");
        devResp.setOnlineStatusOld(1);
        devResp.setCpuRate("0.2");
        devResp.setMemRate("0.4");
        devResp.setUpRealRate("");
        devResp.setDownRealRate("");
//        devResp.setAdaptRate();
//        devResp.setLastTime();
//        devResp.setRmsModelName();
//        devResp.setCityName();
//        devResp.setCpeCurrentUpdateTime();
//        devResp.setSn();
//        devResp.setModel();
//        devResp.setDevType();
//        devResp.setManu();
//        devResp.setProdId();
//        devResp.setMac();
//        devResp.setHwv();
//        devResp.setSwv();
//        devResp.setProtType();
        devRespList.add(devResp);
//        new JedisClient().lpush("jedis-list-test", devRespList);

        List<Object> list = new JedisClient().lrange("jedis-list-test");
        System.out.println(list);
    }

    @Test
    public void testInjectSrv() {
        System.out.println(serviceMap);
    }
}
