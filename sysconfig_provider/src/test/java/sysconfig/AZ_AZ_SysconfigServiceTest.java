package sysconfig;

import org.junit.Test;
import vo.AZ_MenuVo;

import javax.annotation.Resource;
import java.util.List;
/**
 * Created by Fuzhong.Yan on 16/10/30.
 */
public class SysconfigServiceTest extends BaseTest {
    @Resource
    private AZ_AZ_SysconfigService AZSysconfigService;
    @Test
    public void testGetAllMenus() throws Exception {
        List<AZ_MenuVo> menus = AZSysconfigService.getAllMenus();
        for (AZ_MenuVo vo : menus){
            System.out.println(vo.getId());
        }
    }
    @Test
    public void testGetMenus() throws Exception {
        AZ_MenuVo vo = AZSysconfigService.getMenus(0);
        vo.printInfo();
    }

}