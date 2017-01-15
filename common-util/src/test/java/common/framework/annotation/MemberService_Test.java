package common.framework.annotation;

import common.framework.security.MD5Util;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.io.FileInputStream;
import java.util.UUID;

/**
 * Created by Fuzhong.Yan on 16/11/21.
 */
public class MemberService_Test {
    @Before
    public void init(){
        ClassPathXmlApplicationContext act = new ClassPathXmlApplicationContext("classpath:spring.xml");
    }

    @Test
    public void testRegisterMember() throws Exception {
        File file = new File("/Users/Fuzhong.Yan/Downloads/1.mkv");
        FileInputStream inputStream = new FileInputStream(file);
        System.out.println(new MD5Util().productSummary(inputStream));
    }
}