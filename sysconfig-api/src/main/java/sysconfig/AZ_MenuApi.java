package sysconfig;

import entity.Menu;
import vo.AZ_MenuVo;

import java.util.List;

/**
 * 菜单接口
 * Created by Fuzhong.Yan on 16/10/29.
 */
public interface AZ_MenuApi {
    /**
     * 获得数据库中菜单的所有数据
     * @return
     */
    public List<Menu> getAllMenus() throws Exception;
    /**
     * 根据菜单的父ID获得其整个家族(以树的形式返回)
     * @param parent_id
     * @return AZ_MenuVo
     */
    public AZ_MenuVo getMenus(Integer parent_id) throws Exception;

    /**
     * 根据菜单的父ID获得开启的菜单(以树的形式返回)
     * @param parent_id
     * @return AZ_MenuVo
     */
    public AZ_MenuVo getOpenedMenus(Integer parent_id) throws Exception;

    /**
     * 根据菜单ID获得菜单
     * @param menu_id
     * @return
     * @throws Exception
     */
    public Menu getMenuByID(Integer menu_id) throws Exception;

    /**
     * 根据AZ_MenuVo获取菜单列表
     * @param menu
     * @return
     * @throws Exception
     */
    public List<Menu> getMenus(Menu menu) throws Exception;

    /**
     * 添加一个菜单
     * @param menu
     * @return
     */
    public boolean addMenu(Menu menu) throws  Exception;

    /**
     * 关闭菜单
     * @param menu_id
     * @return
     */
    public  boolean closeMenu(int menu_id) throws Exception;

    /**
     * 删除菜单
     * @param menu_id
     * @return
     */
    public boolean deleteMenu(int menu_id) throws Exception;

    /**
     * 修改菜单数据
     * @param menu
     * @return
     */
    public boolean modifyMenu(Menu menu) throws Exception;

    /**
     * 添加子菜单
     * @param parent_id
     * @param child
     * @return
     */
    public boolean addChildMenu(Integer parent_id,Menu child) throws Exception;
}