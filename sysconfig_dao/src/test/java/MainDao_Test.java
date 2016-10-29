import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.Temp;

/**
 * Created by Fuzhong.Yan on 16/7/24.
 */
public class MainDao_Test {
    public static void main(String[] args) {
        ApplicationContext spring  = new ClassPathXmlApplicationContext(new String[]{"spring.xml","spring-mybatis.xml"});
        Temp temp = (Temp) spring.getBean("temp");
        temp.printAll();
    }
}
