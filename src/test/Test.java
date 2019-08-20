import com.gl.mgr.bean.*;
import com.gl.mgr.dao.LxyMapper;
import com.gl.mgr.dao.MemberMapper;
import com.gl.mgr.dao.ScatteredMapper;
import com.gl.mgr.dao.UserMapper;
import com.gl.mgr.web.SysController;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})
public class Test {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private LxyMapper lxyMapper;
    @Autowired
    private MemberMapper memberMapper;
    @Autowired
    private ScatteredMapper scatteredMapper;
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

    @org.junit.Test
    public void yearStatistic(){
        String year = "2019";
        Map<String,List<Integer>> resultMap = new HashMap<String,List<Integer>>();
        List<Statistic> lxyStatistic = lxyMapper.statistic(year);
        List<Statistic> skStatistic = scatteredMapper.statistic(year);
        List<BigDecimal> lxyYs = new ArrayList<BigDecimal>();
        for(int i=0;i<12;i++){
            lxyYs.add(new BigDecimal(0));
        }
        List<BigDecimal> lxySs = new ArrayList<BigDecimal>();
        for(int i=0;i<12;i++){
            lxySs.add(new BigDecimal(0));
        }
        List<BigDecimal> lxyB2bs = new ArrayList<BigDecimal>();
        for(int i=0;i<12;i++){
            lxyB2bs.add(new BigDecimal(0));
        }
        List<Integer> lxyNum = new ArrayList<Integer>();
        for(int i=0;i<12;i++){
            lxyNum.add(0);
        }

        List<BigDecimal> skYs = new ArrayList<BigDecimal>();
        for(int i=0;i<12;i++){
            skYs.add(new BigDecimal(0));
        }
        List<BigDecimal> skSs = new ArrayList<BigDecimal>();
        for(int i=0;i<12;i++){
            skSs.add(new BigDecimal(0));
        }
        List<BigDecimal> skB2bs = new ArrayList<BigDecimal>();
        for(int i=0;i<12;i++){
            skB2bs.add(new BigDecimal(0));
        }
        List<Integer> skNum = new ArrayList<Integer>();
        for(int i=0;i<12;i++){
            skNum.add(0);
        }
        for (int i =0 ;i<12;i++){
            for(Statistic lxyS:lxyStatistic){
                if(Integer.parseInt(lxyS.getTime().substring(5)) == i){
                    lxyYs.set(i,lxyS.getYs());
                    lxySs.set(i,lxyS.getSs());
                    lxyB2bs.set(i,lxyS.getB2bs());
                    lxyNum.set(i,lxyS.getNum());
                    break;
                }
            }
            for(Statistic skS:skStatistic){
                if(Integer.parseInt(skS.getTime().substring(5)) == i){
                    skYs.set(i,skS.getYs());
                    skSs.set(i,skS.getSs());
                    skB2bs.set(i,skS.getB2bs());
                    skNum.set(i,skS.getNum());
                    break;
                }
            }
        }
        System.out.println("ad");
    }

}
