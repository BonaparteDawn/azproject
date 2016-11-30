package member;

import vo.AZ_RoleVo;

/**
 * Created by Fuzhong.Yan on 16/11/23.
 */
public interface AZ_RoleApi {
    /**
     * 根据角色ID获得其实体
     * @param id
     * @return
     */
    public AZ_RoleVo getRoleVoByID(Integer id);
}
