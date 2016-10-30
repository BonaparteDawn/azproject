package sysconfig;

import vo.AZ_MenuVo;

import java.util.List;

/**
 * 系统配置API接口
 * Created by Fuzhong.Yan on 16/10/29.
 */
public interface AZ_SysconfigApi {
    /**
     * 获得数据库中菜单的所有数据
     * @return
     */
    public List<AZ_MenuVo> getAllMenus();
    /**
     * 根据菜单的父ID获得其整个家族
     * @param parent_id
     * @return AZ_MenuVo
     */
    public AZ_MenuVo getMenus(Integer parent_id);
}