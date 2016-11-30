package common.framework.annotation;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.UUID;

/**
 * Created by Fuzhong.Yan on 16/11/21.
 */
public class MemberService_Test {
    private AS_Test test;
    @Before
    public void init(){
        ClassPathXmlApplicationContext act = new ClassPathXmlApplicationContext("classpath:spring.xml");
        test = (AS_Test) act.getBean("test");
    }

    @Test
    public void testRegisterMember() throws Exception {
        test.before(null);
    }
}