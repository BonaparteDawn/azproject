import entity.Menu;
import mapper.MenuMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Fuzhong.Yan on 16/7/24.
 */
public class MainDao_Test {
    public static void main(String[] args) {
        ApplicationContext spring  = new ClassPathXmlApplicationContext("classpath*:spring.xml");
        MenuMapper temp = (MenuMapper) spring.getBean("menuMapper");
        Menu res = temp.selectByPrimaryKey(1);
        System.out.println(res);
    }
}
