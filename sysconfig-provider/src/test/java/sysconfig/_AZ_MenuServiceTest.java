package sysconfig;

import common.framework.util.ObjectUtils;
import entity.Menu;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import vo.AZ_MenuVo;
import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Fuzhong.Yan on 16/10/30.
 */
public class _AZ_MenuServiceTest {
    @Resource
    private AZ_MenuApi menuApi;
    @Before
    public void init(){
        ClassPathXmlApplicationContext act = new ClassPathXmlApplicationContext("classpath*:spring.xml");
        menuApi = (AZ_MenuApi) act.getBean("AZ_MenuService");
    }
    @Test
    public void addMenu() throws Exception{
        AZ_MenuVo menu = new AZ_MenuVo();
        menu.setIcon("ICON1111");
        menu.setName("设置");
        menu.setParentId(1);
        menu.setUrl("url");
        menu.setRemark("remark");
        boolean res = menuApi.addMenu(menu);
        System.out.println(res);
    }
    @Test
    public void testGetAllMenus() throws Exception {
        List<Menu> menus = menuApi.getAllMenus();
        if (!ObjectUtils.isEmpty(menus)){
            for (Menu vo : menus){
                System.out.println(vo.getId());
            }
        }
    }
    @Test
    public void testGetMenus() throws Exception {
        AZ_MenuVo vo = menuApi.getMenus(0);
        vo.printInfo();
    }
    @Test
    public void testGetOpenedMenus() throws Exception {
        AZ_MenuVo vo1 = menuApi.getOpenedMenus(0);
        vo1.printInfo();
    }

    @Test
    public void modifyMenu() throws Exception {
        AZ_MenuVo menuVo = new AZ_MenuVo();
        menuVo.setId(7);
        menuVo.setRemark("remark_modify");
        menuVo.setUrl("URL_M");
        menuVo.setName("N_M");
        menuVo.setIcon("i_m");
        menuVo.setSort(123);
        menuVo.setParentId(2);
        menuVo.setIsOpen(0);
        boolean res = menuApi.modifyMenu(menuVo);
        System.out.println(res);
    }
    public void closeMenu() throws Exception {
        boolean res = menuApi.closeMenu(6);
        System.out.println(res);
    }
    public void deleteMenu() throws Exception {
        boolean res = menuApi.deleteMenu(6);
        System.out.println(res);
    }
}