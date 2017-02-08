package common.framework.util;

import common.framework.service.AZ_Performance;
import constant.AZ_Constant;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Fuzhong.Yan on 17/1/28.
 */
public class QRCodeUtilTest {
    @Before
    public void setUp() throws Exception {

    }
    @Test
    public void create() throws Exception {
        AZ_Performance.test("生成二维码", 100, new Runnable() {
            public void run() {
                try {
                    String path = AZ_Constant.TEST_BASE_PATH_OUT+"/qr.png";
                    QRCodeUtil.encode("nihao",path);
                    System.out.println(QRCodeUtil.decode(path));
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
}