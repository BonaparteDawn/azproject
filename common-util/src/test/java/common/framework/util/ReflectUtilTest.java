package common.framework.util;

import common.framework.bean.AZ_ResultEntity;
import common.framework.security.SecurityCoder;
import common.framework.service.AZ_JarClassLoader;
import common.framework.service.AZ_Performance;
import constant.AZ_Constant;
import enums.AZ_ServerResponseCode;
import org.junit.Test;

import java.io.*;

/**
 * Created by Fuzhong.Yan on 17/2/5.
 */
public class ReflectUtilTest {

    @Test
    public void newInstance() throws Exception {
        AZ_ResultEntity a = ReflectUtil.newInstance(AZ_ResultEntity.class);
        System.out.println(a);
    }

    @Test
    public void newInstance1() throws Exception {
        AZ_ResultEntity a = ReflectUtil.newInstance(AZ_ResultEntity.class, AZ_ServerResponseCode.SUCCESS,"成功");
        System.out.println(a);
    }
    @Test
    public void classLoad() throws Exception {
        AZ_Performance.test("加载二进制类", 100, new Runnable() {
            public void run() {
                Object a = null;
                try {
                    a = ReflectUtil.newInstance(new AZ_JarClassLoader("demo", AZ_Constant.TEST_BASE_PATH_AZ+"/email_jar/"), "email.Email");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(a);
            }
        });
    }
    @Test
    public void base64classLoad() throws Exception {

        AZ_Performance.test("加载加密class类", 1, new Runnable() {
            public void run() {
                try {
                    String pre = AZ_Constant.TEST_BASE_PATH_AZ+"/email_jar/email/";
                    String encodePre = AZ_Constant.TEST_BASE_PATH_OUT +"/email_jar/email/";
                    SecurityCoder s = SecurityUtil.Base64();

                    OutputStream outputStream = null;
                    InputStream inputStream = null;
                    inputStream = new FileInputStream(new File(pre+"EmailServerAgent.class"));
                    byte[] bytes = IOUtils.copy2Bytes(inputStream);
                    inputStream.close();

                    outputStream = new FileOutputStream(new File(encodePre+"EmailServerAgent.class"));
                    IOUtils.write2outputStream(s.encrypt(bytes),outputStream);
                    outputStream.close();

                    inputStream = new FileInputStream(new File(pre+"EmailServer.class"));
                    bytes = IOUtils.copy2Bytes(inputStream);
                    inputStream.close();

                    outputStream = new FileOutputStream(new File(encodePre+"EmailServer.class"));
                    IOUtils.write2outputStream(s.encrypt(bytes),outputStream);
                    outputStream.close();

                    ClassLoader classLoader = new AZ_JarClassLoader(s,"demo",AZ_Constant.TEST_BASE_PATH_OUT+"/email_jar/");
                    Object a = ReflectUtil.newInstance(classLoader, "email.EmailServerAgent");
                    System.out.println(a);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });



    }
}