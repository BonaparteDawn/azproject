package common.framework.util;

import constant.AZ_Constant;
import org.junit.Test;

/**
 * Created by Fuzhong.Yan on 17/2/6.
 */
public class MusicUtilTest {
    @Test
    public void play() throws Exception {
        String path = FileUtil.path(AZ_Constant.TEST_BASE_PATH_AZ,"1.wav");
        MusicUtil.play(path);
    }
}