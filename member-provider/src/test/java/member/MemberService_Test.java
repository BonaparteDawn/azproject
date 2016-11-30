package member;

import entity.Member;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.UUID;

/**
 * Created by Fuzhong.Yan on 16/11/21.
 */
public class MemberService_Test {
    private AZ_MemberApi memberApi;
    @Before
    public void init(){
        ClassPathXmlApplicationContext act = new ClassPathXmlApplicationContext("classpath*:spring.xml");
        memberApi = (AZ_MemberApi) act.getBean("AZ_MemberService");
    }
    @Test
    public void testGetMember(){
        List<Member> a = memberApi.getMemberVo(1, 2);
        System.out.println(a.size());
    }
    @Test
    public void testRegisterMember() throws Exception {
        Member member = new Member();
        member.setEmail("18380403901");
        member.setSalt(UUID.randomUUID().toString());
        member.setPassword("password");
//        boolean res = memberApi.register(member);
//        System.out.println("add res : "+res);
    }
}