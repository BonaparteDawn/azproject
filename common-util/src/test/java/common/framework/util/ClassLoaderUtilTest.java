package common.framework.util;

import common.framework.service.AZ_JarClassLoader;
import org.junit.Test;

/**
 * Created by Fuzhong.Yan on 17/2/6.
 */
public class ClassLoaderUtilTest {
    @Test
    public void loadClass() throws Exception {
        ClassLoaderUtil.loadClass(new AZ_JarClassLoader("demo"),"common.framework.util.EmailUtil");
    }
}