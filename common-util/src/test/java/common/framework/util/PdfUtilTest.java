package common.framework.util;

import common.framework.service.AZ_Performance;
import constant.AZ_Constant;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by Fuzhong.Yan on 17/1/30.
 */
public class PdfUtilTest {
    @Before
    public void setUp() throws Exception {

    }
    @Test
    public void test(){
        AZ_Performance.test(100, new Runnable() {
            public void run() {
                try {
                    PdfUtil.html2pdf(FileUtil.path(AZ_Constant.TEST_BASE_PATH_AZ,"pdf","index.html"),FileUtil.path(AZ_Constant.TEST_BASE_PATH_OUT,"test.pdf"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}