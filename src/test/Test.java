import com.gl.common.user.bean.User;
import com.gl.common.user.dao.UserMapper;
import com.gl.common.user.service.UserService;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})
public class Test {
    @Resource
    private UserService userService;

    @Resource
    private UserMapper userMapper;
    @org.junit.Test
    public void inserBatchTest(){
        List<User> users = new ArrayList<User>();
        User user1 = new User();
        user1.setUsername("admin");
        user1.setPassword("admin123");
        user1.setPhonenumber("123123123");
        user1.setRole("1");
        user1.setAddress("beilun");
        User user2 = new User();
        user2.setUsername("admin");
        user2.setPassword("admin123");
        user2.setPhonenumber("123123123");
        user2.setRole("1");
        user2.setAddress("beilun");
        users.add(user1);
        users.add(user2);
        //userService.insertBatch(users);
        //userService.loginCheck(user1);
        Integer id = 1;
        User user = userMapper.test(1,user2);
        System.out.println("ok");
    }
}
