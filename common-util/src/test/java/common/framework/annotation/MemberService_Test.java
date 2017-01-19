package common.framework.annotation;

import common.framework.bean.AZ_EmailBox;
import common.framework.runnable.AZ_MimeMessageConsumerRunnable;
import common.framework.runnable.AZ_SimpleEmailConsumerRunnable;
import common.framework.security.Base64Util;
import common.framework.security.MD5Util;
import common.framework.service.AZ_EmailHelper;
import common.framework.service.AZ_ThreadPoolService;
import common.framework.util.EmailUtil;
import common.framework.util.EnvironmentUtil;
import common.framework.util.InternetUtil;
import common.framework.util.RandomUtil;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Fuzhong.Yan on 16/11/21.
 */
public class MemberService_Test {
    @Before
    public void init(){
//        ClassPathXmlApplicationContext act = new ClassPathXmlApplicationContext("classpath*:spring.xml");
    }

    @Test
    public void testRegisterMember() throws Exception {
        File file = new File("/Users/Fuzhong.Yan/Downloads/1.mkv");
        FileInputStream inputStream = new FileInputStream(file);
        System.out.println(new MD5Util().productSummary(inputStream));
    }
    @Test
    public void rand(){
        for (int i = 0 ; i < 10 ; i++){
            System.out.println(RandomUtil.generate32UUID());
        }
    }
    @Test
    public void internet(){
        try {
            System.out.println(InternetUtil.ping("127.0.0.1"));
            System.out.println(InternetUtil.accessResource("http://www.baidu.com"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        EnvironmentUtil.printAllEnvirontmentInfo();
    }
    @Test
    public void testSendEmail() throws Exception {
        Scanner scanner = new Scanner(System.in);
        while (true){
            emailPush();
            emailPush1();
            String line = scanner.next();
            if (line.equals("0")){
                break;
            }
            for (int i= 0;i<line.length();i++){
                emailPush();
                emailPush1();
            }
        }
        System.exit(0);
    }
    public void emailPush(){
        SimpleMailMessage simpleMailMessage = AZ_EmailHelper.createSimpleMailMessage();
        simpleMailMessage.setTo("yanfuzhongchina@126.com");
        simpleMailMessage.setSubject("测试");
        simpleMailMessage.setText("test1");
        try {
            EmailUtil.push(simpleMailMessage);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void emailPush1(){
        MimeMessage mimeMessage = AZ_EmailHelper.createMimeMessage();
        try {
            MimeMessageHelper helper = AZ_EmailHelper.createMimeMessageHelper(mimeMessage);
            helper.setTo("yanfuzhongchina@126.com");
            helper.setSubject("测试");
            helper.setText(InternetUtil.accessResource("http://www.baidu.com"),true);
            EmailUtil.push(mimeMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}