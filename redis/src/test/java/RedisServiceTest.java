import com.asiainfo.operation.list.RedisListService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author WJX
 * @version 1.0
 * @Date 2023/01/02/19:38
 * @Description
 */
@SpringBootTest(classes = RedisServiceTest.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class RedisServiceTest {

    @Autowired
    private RedisListService redisListService;

    @Test
    public void testList() {
        redisListService.lpush("waiterList", "tom");
    }
}
