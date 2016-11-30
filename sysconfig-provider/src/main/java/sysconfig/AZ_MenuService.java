package sysconfig;

import common.framework.annotation.AZ_LogMethod;
import common.framework.interfaces.BeanCopy;
import common.framework.util.ListUtils;
import common.framework.util.ObjectUtils;
import constant.AZ_Constant;
import constant.AZ_LogType;
import entity.Menu;
import entity.MenuExample;
import mapper.MenuMapper;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vo.AZ_MenuVo;
import vo.AZ_Object;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 系统配置服务
 * Created by Fuzhong.Yan on 16/10/29.
 */
@Service
public class AZ_MenuService extends AZ_Object implements AZ_MenuApi,Serializable {
    @Autowired
    private MenuMapper menuMapper;
    @AZ_LogMethod(appName = "view",type = {AZ_LogType.Log4j})
    public List<Menu> getAllMenus() throws Exception{
        MenuExample e = new MenuExample();
        List<Menu> menus = menuMapper.selectByExample(e);
        return menus;
    }
    public AZ_MenuVo getMenus(Integer parent_id) throws Exception{
        List<Menu> menus = getAllMenus();
        List<AZ_MenuVo> menuVos = new ArrayList<AZ_MenuVo>();
        ListUtils<Menu,AZ_MenuVo> listUtil = new ListUtils<Menu, AZ_MenuVo>();
        listUtil.copy(menus, menuVos, new BeanCopy<Menu, AZ_MenuVo>() {
            public AZ_MenuVo copy(Menu source) {
                AZ_MenuVo res = new AZ_MenuVo();
                BeanUtils.copyProperties(source,res);
                return res;
            }
        });
        AZ_MenuVo res = findMenuFamily(parent_id,menuVos);
        return res;
    }

    public AZ_MenuVo getOpenedMenus(Integer parent_id) throws Exception {
        Menu menu = new Menu();
        menu.setIsOpen(AZ_Constant.MENU_OPEN);
        List<Menu> ms = getMenus(menu);
        List<AZ_MenuVo> menuVos = new ArrayList<AZ_MenuVo>();
        ListUtils<Menu,AZ_MenuVo> listUtil = new ListUtils<Menu, AZ_MenuVo>();
        listUtil.copy(ms, menuVos, new BeanCopy<Menu, AZ_MenuVo>() {
            public AZ_MenuVo copy(Menu source) {
                AZ_MenuVo res = new AZ_MenuVo();
                BeanUtils.copyProperties(source,res);
                return res;
            }
        });

        AZ_MenuVo res = findMenuFamily(parent_id,menuVos);
        return res;
    }

    public Menu getMenuByID(Integer menu_id) throws Exception {
        Menu res = null;
        if (ObjectUtils.isNotEmpty(menu_id)){
            res = menuMapper.selectByPrimaryKey(menu_id);
        }
        return res;
    }

    public List<Menu> getMenus(Menu menu) throws Exception {
        List<Menu> res = new ArrayList<Menu>();
        MenuExample e = new MenuExample();
        if (ObjectUtils.isNotEmpty(menu)){
            MenuExample.Criteria mc = e.createCriteria();
            if (ObjectUtils.isNotEmpty(menu.getId())){
                mc.andIdEqualTo(menu.getId());
            }
            if (ObjectUtils.isNotEmpty(menu.getParentId())){
                mc.andParentIdEqualTo(menu.getParentId());
            }
            if (ObjectUtils.isNotEmpty(menu.getName())){
                mc.andNameLike("%"+menu.getName().replaceAll("\\s","%")+"%");
            }
            if (ObjectUtils.isNotEmpty(menu.getUrl())){
                mc.andUrlLike("%"+menu.getUrl().replaceAll("\\s","%")+"%");
            }
            if (ObjectUtils.isNotEmpty(menu.getIcon())){
                mc.andIconLike("%"+menu.getIcon().replaceAll("\\s","%")+"%");
            }
            if (ObjectUtils.isNotEmpty(menu.getIsOpen())){
                mc.andIsOpenEqualTo(menu.getIsOpen());
            }
            if (ObjectUtils.isNotEmpty(menu.getSort())){
                mc.andSortEqualTo(menu.getSort());
            }
            if (ObjectUtils.isNotEmpty(menu.getRemark())){
                mc.andRemarkLike("%"+menu.getRemark().replaceAll("\\s","%")+"%");
            }
        }
        List<Menu> temp = menuMapper.selectByExample(e);
        res.addAll(temp);
        return res;
    }

    /**
     *
     * @param menu
     * @return
     * @throws Exception
     * <br/>PARENT_MENU_DO_NOT_EXIST:父菜单不存在
     * <br/>PARENT_ID_EMPTY:父菜单为空
     */
    public boolean addMenu(Menu menu) throws Exception{
        boolean res = false;
        if (ObjectUtils.isNotEmpty(menu)){
            if (ObjectUtils.isNotEmpty(menu.getParentId())){
                Menu parentMenu = menuMapper.selectByPrimaryKey(menu.getParentId());
                if (ObjectUtils.isEmpty(parentMenu)){
                    throw  new Exception("PARENT_MENU_DO_NOT_EXIST");
                }
            }else {
                throw  new Exception("PARENT_ID_EMPTY");
            }
            menu.setIsOpen(AZ_Constant.MENU_OPEN);
            int i  = menuMapper.insert(menu);
            if (i > 0){
                res = true;
            }
        }
        return res;
    }

    /**
     *
     * @param menu_id
     * @return
     * @throws Exception
     * <br/>MENU_CLOSED:菜单关闭
     * <br/>MENU_DO_NOT_EXIST:菜单不存在
     */
    public boolean closeMenu(int menu_id) throws  Exception{
        boolean res = false;
        Menu menu = menuMapper.selectByPrimaryKey(menu_id);
        if (ObjectUtils.isNotEmpty(menu)){
            if (menu.getIsOpen() == AZ_Constant.MENU_CLOSE){
                throw new Exception("MENU_CLOSED");
            }else {
                menu.setIsOpen(AZ_Constant.MENU_CLOSE);
                int i  = menuMapper.updateByPrimaryKeySelective(menu);
                if (i > 0){
                    res = true;
                }
            }
        }else {
            throw new Exception("MENU_DO_NOT_EXIST");
        }
        return res;
    }

    /**
     *
     * @param menu_id
     * @return
     * @throws Exception
     * <br/>MENU_DO_NOT_EXIST:菜单不存在
     */
    public boolean deleteMenu(int menu_id) throws  Exception{
        boolean res = false;
        Menu menu = menuMapper.selectByPrimaryKey(menu_id);
        if (ObjectUtils.isNotEmpty(menu)){
            int i = menuMapper.deleteByPrimaryKey(menu_id);
            if (i > 0 ){
                res = true;
            }
        }else {
            throw new Exception("MENU_DO_NOT_EXIST");
        }
        return res;
    }

    /**
     *
     * @param vo
     * @return
     * @throws Exception
     * <br/>PARENT_MENU_DO_NOT_EXIST:父菜单不存在
     * <br/>MENU_DO_NOT_EXIST:菜单不存在
     */
    public boolean modifyMenu(Menu vo) throws Exception{
        boolean res = false;
        if (ObjectUtils.isNotEmpty(vo)){
            Menu menu = menuMapper.selectByPrimaryKey(vo.getId());
            if (ObjectUtils.isNotEmpty(menu)){
                Menu parentMenu = menuMapper.selectByPrimaryKey(vo.getParentId());
                if (ObjectUtils.isEmpty(parentMenu)){
                    throw  new Exception("PARENT_MENU_DO_NOT_EXIST");
                }
                int i = menuMapper.updateByPrimaryKeySelective(vo);
                if (i > 0){
                    res = true;
                }
            }else {
                throw new Exception("MENU_DO_NOT_EXIST");
            }
        }
        return res;
    }

    /**
     *
     * @param parent_id
     * @param child
     * @return
     * @throws Exception
     * <br/>PARENT_ID_EMPTY:父菜单不存在
     */
    public boolean addChildMenu(Integer parent_id, Menu child) throws Exception {
        boolean res = false;
        if (ObjectUtils.isEmpty(parent_id)){
            throw  new Exception("PARENT_ID_EMPTY");
        }
        if (ObjectUtils.isNotEmpty(child)){
            child.setParentId(parent_id);
            res = addMenu(child);
        }
        return res;
    }

    /**
     *查找指定父ID的家族成员
     */
    private AZ_MenuVo findMenuFamily(Integer parent_id, List<AZ_MenuVo> menus) throws Exception{
        AZ_MenuVo family = new AZ_MenuVo();
        family.setId(parent_id);
        if (parent_id != null && CollectionUtils.isNotEmpty(menus)){
            for (int i = 0; i < menus.size(); i++) {
                AZ_MenuVo temp = menus.get(i);
                if (temp.getParentId() != null && temp.getParentId() == parent_id){
                    menus.remove(temp);
                    AZ_MenuVo temp_f = findMenuFamily(temp.getId(), menus);
                    temp.getChildren().addAll(temp_f.getChildren());
                    family.getChildren().add(temp);
                    i -- ;
                }
            }
            Collections.sort(family.getChildren());
        }
        return  family;
    }
}
