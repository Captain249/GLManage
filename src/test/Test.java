import com.gl.mgr.bean.*;
import com.gl.mgr.dao.LxyMapper;
import com.gl.mgr.dao.MemberMapper;
import com.gl.mgr.dao.UserMapper;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})
public class Test {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private LxyMapper lxyMapper;
    @Autowired
    private MemberMapper memberMapper;
    @org.junit.Test
    public void insertUser(){
        User user = new User();
        user.setUsername("admin");
        user.setPassword("admin123");
        user.setPhonenum("17858936213");
        user.setRole("管理员");
        int result = userMapper.insert(user);
    }

    @org.junit.Test
    public void insertLxy() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date startD = simpleDateFormat.parse("2019-06-27");
        Date endD = simpleDateFormat.parse("2019-07-27");
        Lxy lxy = new Lxy();
        lxy.setGrouptype("医院");
        lxy.setPrincipal("孙志涛");
        lxy.setNumcount(50);
        lxy.setPhonenum("17858936213");
        lxy.setName("后所一日游");
        lxy.setStartdate(startD);
        lxy.setFinishdate(endD);
        lxy.setStatus(0);
        int a = lxyMapper.insert(lxy);
        System.out.println(a);
    }

    @org.junit.Test
    public void insertMember(){
        Member member = new Member();
        member.setName("孙志涛");
        member.setPhonenum("17858936213");
        member.setIdcard("33020212321321321");
        member.setAddress("后所村");
        member.setPassport("10086");
        memberMapper.insert(member);
    }

    @org.junit.Test
    public void mem_lxytest(){
        List<Integer> idlist = memberMapper.queryMembersByLxyId(1);
        System.out.println("a");
    }
}
