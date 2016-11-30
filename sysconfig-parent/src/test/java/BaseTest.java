import junit.framework.TestCase;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 测试基类
 * Created by Fuzhong.Yan on 16/10/30.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring.xml"})
public abstract class BaseTest extends TestCase {

}