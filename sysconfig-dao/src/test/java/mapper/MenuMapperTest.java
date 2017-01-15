package mapper;

import entity.Menu;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import dao.MenuTest;

/**
 * Created by Fuzhong.Yan on 16/10/30.
 */
public class MenuMapperTest {
    private  MenuMapper menuMapper;
    private MenuTest menuTest;
    @Before
    public  void setMapper(){
        ClassPathXmlApplicationContext act = new ClassPathXmlApplicationContext("classpath*:spring.xml");
        menuMapper = (MenuMapper) act.getBean("menuMapper");
//        menuTest = (MenuTest)act.getBean("MenuTest");
    }
    @Test
    public void selectByPrimaryKey() throws Exception {
        Menu vo = menuMapper.selectByPrimaryKey(1);
        System.out.println(vo.getId());
    }
    @Test
    public void select() throws Exception {
//        menuTest.getAll();
    }
}