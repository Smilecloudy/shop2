import com.it.entity.User;
import com.it.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @auther: 曹云博
 * @create: 2020-06-2020/6/11 10:51
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class RegisterTest {
    @Autowired
    private UserService userService;
    @Test
    public void testRegister() throws Exception{
        User user = new User();
        user.setUsername("dawa");
        user.setPassword("123456");
        user.setName("大娃");
        user.setEmail("dawa@qq.com");
        user.setBirthday("2020-03-21");
        user.setTelephone("13412345678");
        user.setSex("男");

        userService.register(user);
    }

    @Test
    public void testCheckUserName() throws Exception{
        userService.checkUserName("siwa");

    }
}
