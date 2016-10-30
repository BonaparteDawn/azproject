package mapper;

import entity.Menu;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by Fuzhong.Yan on 16/10/30.
 */
public class MenuMapperTest extends BaseTest<MenuMapper> {
    @Autowired
    private ApplicationContext act;
    private  MenuMapper menuMapper;
    @Before
    public  void setMapper(){
        menuMapper = (MenuMapper) act.getBean("menuMapper");
    }
    @Test
    public void selectByPrimaryKey() throws Exception {
        Menu vo = menuMapper.selectByPrimaryKey(1);
        System.out.println(vo.getId());
    }
}