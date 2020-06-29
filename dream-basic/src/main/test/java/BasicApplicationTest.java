import lombok.val;
import org.dream.basic.service.UserService;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class BasicApplicationTest {

    @Resource
    private UserService userService;

    @Test
    public void test(){
        val list = userService.list(1);
        System.out.println(list);
    }
}
