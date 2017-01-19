package common.framework.util;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.util.Assert;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by Fuzhong.Yan on 17/1/15.
 */
public class PropertiesUtil {
    /**
     *支持查询某个JAR包下的属性文件
     * @param classPath
     * @return
     * @throws IOException
     */
    public static Properties getProperties(String classPath) throws IOException {
        Assert.hasLength(classPath,"CLASS_PATH_LEN0");
        Properties properties = new Properties();
        properties.load(new ClassPathResource(classPath).getInputStream());
        return properties;
    }

    /**
     * 查找属性文件(支持classpath:filePath格式)
     * @param classPath
     * @return
     * @throws IOException
     */
    public static Properties getPropertiesByPathMatching(String classPath) throws IOException {
        Assert.hasLength(classPath,"CLASS_PATH_LEN0");
        Properties properties = new Properties();
        PathMatchingResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        Resource p = resourcePatternResolver.getResource(classPath);
        Assert.notNull(p,"CLASS_PATH_RESOURCE_NULL");
        properties.load(p.getInputStream());
        return properties;
    }
}
