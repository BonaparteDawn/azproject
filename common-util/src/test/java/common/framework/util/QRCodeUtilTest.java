package common.framework.util;

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
        String path = "/Users/Fuzhong.Yan/Desktop/1.png";
        QRCodeUtil.encode("nihao",path);
        System.out.println(QRCodeUtil.decode(path));
        FileUtil.delete(path);
    }
}