package sysconfig;

import entity.Menu;
import entity.MenuExample;
import mapper.MenuMapper;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vo.AZ_MenuVo;
import vo.AZ_Object;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 系统配置服务
 * Created by Fuzhong.Yan on 16/10/29.
 */
@Service
public class AZ_SysconfigService extends AZ_Object implements AZ_SysconfigApi {
    @Autowired
    private MenuMapper menuMapper;

    public List<AZ_MenuVo> getAllMenus() {
        List<AZ_MenuVo> res = new ArrayList<AZ_MenuVo>();
        MenuExample e = new MenuExample();
        List<Menu> menus = menuMapper.selectByExample(e);
        if (CollectionUtils.isNotEmpty(menus))
        {
            for(Menu temp : menus){
                AZ_MenuVo vo = new AZ_MenuVo();
                BeanUtils.copyProperties(temp,vo);
                res.add(vo);
            }
        }
        return res;
    }

    public AZ_MenuVo getMenus(Integer parent_id) {
        List<AZ_MenuVo> menus = getAllMenus();
         AZ_MenuVo res = findMenuFamily(parent_id,menus);
        return res;
    }
    /**
     *查找指定父ID的家族成员
     */
    private AZ_MenuVo findMenuFamily(Integer parent_id, List<AZ_MenuVo> menus){
        AZ_MenuVo family = new AZ_MenuVo();
        if (parent_id != null && CollectionUtils.isNotEmpty(menus)){
            for (int i = 0; i < menus.size(); i++) {
                AZ_MenuVo temp = menus.get(i);
                if (temp.getParentId() != null && temp.getParentId() == parent_id && temp.getIsOpen() == 1){
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
