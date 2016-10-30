package sysconfig;

import org.junit.Test;
import vo.MenuVo;

import javax.annotation.Resource;
import java.util.List;
/**
 * Created by Fuzhong.Yan on 16/10/30.
 */
public class SysconfigServiceTest extends BaseTest {
    @Resource
    private  SysconfigService sysconfigService;
    @Test
    public void testGetAllMenus() throws Exception {
        List<MenuVo> menus = sysconfigService.getAllMenus();
        for (MenuVo vo : menus){
            System.out.println(vo.getId());
        }
    }
    @Test
    public void testGetMenus() throws Exception {
        MenuVo vo = sysconfigService.getMenus(0);
        vo.printInfo();
    }

}