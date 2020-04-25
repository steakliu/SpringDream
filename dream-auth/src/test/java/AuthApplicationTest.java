import org.dream.auth.service.AuthService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @Author 刘牌
 * @Date 2020/4/24 0024 15:36
 * @Version 1.0
 */

@SpringBootTest
public class AuthApplicationTest {

    @Resource
    private AuthService authService;
    @Test
    public void test(){
        authService.getUserInfo("admin");
    }
}
