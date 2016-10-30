package sysconfig;

import entity.Menu;
import entity.MenuExample;
import mapper.MenuMapper;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vo.MenuVo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 系统配置服务
 * Created by Fuzhong.Yan on 16/10/29.
 */
@Service
public class SysconfigService implements  SysconfigApi{
    @Autowired
    private MenuMapper menuMapper;

    public List<MenuVo> getAllMenus() {
        List<MenuVo> res = new ArrayList<MenuVo>();
        MenuExample e = new MenuExample();
        List<Menu> menus = menuMapper.selectByExample(e);
        if (CollectionUtils.isNotEmpty(menus))
        {
            for(Menu temp : menus){
                MenuVo vo = new MenuVo();
                BeanUtils.copyProperties(temp,vo);
                res.add(vo);
            }
        }
        return res;
    }

    public MenuVo getMenus(Integer parent_id) {
        List<MenuVo> menus = getAllMenus();
         MenuVo res = findMenuFamily(parent_id,menus);
        return res;
    }
    /**
     *查找指定父ID的家族成员
     */
    private  MenuVo findMenuFamily(Integer parent_id,List<MenuVo> menus){
        MenuVo family = new MenuVo();
        if (parent_id != null && CollectionUtils.isNotEmpty(menus)){
            for (int i = 0; i < menus.size(); i++) {
                MenuVo temp = menus.get(i);
                if (temp.getParentId() != null && temp.getParentId() == parent_id && temp.getIsOpen() == 1){
                    menus.remove(temp);
                    MenuVo temp_f = findMenuFamily(temp.getId(), menus);
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
