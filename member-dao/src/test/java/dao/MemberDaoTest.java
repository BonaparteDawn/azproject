package dao;

import entity.Member;
import entity.MemberExample;
import mapper.MemberMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Fuzhong.Yan on 16/11/14.
 */
public class MemberDaoTest {
    private MemberMapper memberMapper;
    @Before
    public  void setMapper(){
        ClassPathXmlApplicationContext act = new ClassPathXmlApplicationContext("classpath:spring.xml");
        memberMapper = (MemberMapper) act.getBean("memberMapper");
    }
    @Test
    public void test(){
        MemberExample e = new MemberExample();
        int i  = memberMapper.countByExample(e);
        Member member = new Member();
        System.out.println(i);
    }
}
