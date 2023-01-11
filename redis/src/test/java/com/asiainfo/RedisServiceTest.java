package com.asiainfo;

import com.asiainfo.operation.list.RedisListService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author WJX
 * @version 1.0
 * @Date 2023/01/02/19:38
 * @Description
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class RedisServiceTest {

    @Autowired
    private RedisListService redisListService;

    @Test
    public void testList() {
        List<String> waiterList = redisListService.lrange("waitlist", 0, -1);
        System.out.println(waiterList);
    }
}
