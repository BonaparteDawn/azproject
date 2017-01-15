package member;

import entity.Role;
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
    public AZ_RoleVo getRoleVoByID(Integer id) throws Exception;

    /**
     * 根据角色ID获得其实体
     * @param id
     * @return
     */
    public Role getRoleByID(Integer id) throws Exception;

    /**
     * 添加角色
     * @param role
     * @return
     * @throws Exception
     */
    public boolean addRole(Role role) throws  Exception;

    /**
     * 锁定角色
     * @param role_id
     * @param is_lock
     * @return
     */
    public boolean lockRole(Integer role_id,Integer is_lock) throws  Exception;

    /**
     * 设置角色容量
     * @param role_id
     * @param role_size
     * @return
     */
    public boolean setRoleSize(Integer role_id,Integer role_size) throws  Exception;

    /**
     * 修改角色
     * @param role
     * @return
     */
    public boolean changeRole(Role role) throws  Exception;
}
