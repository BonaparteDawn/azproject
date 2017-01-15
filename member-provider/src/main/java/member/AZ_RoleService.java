package member;

import common.framework.service.AZ_ENV;
import common.framework.util.ObjectUtils;
import constant.AZ_Constant;
import entity.Role;
import mapper.RoleMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vo.AZ_RoleVo;

import java.util.Date;

/**
 * Created by Fuzhong.Yan on 16/11/23.
 */
@Service
public class AZ_RoleService implements AZ_RoleApi{
    @Autowired
    private RoleMapper roleMapper;

    /**
     * 系统环境
     */
    @Autowired
    private AZ_ENV azEnv;

    /**
     * 根据角色ID获得其实体
     * @param id
     * @return
     */
    public AZ_RoleVo getRoleVoByID(Integer id) throws Exception {
        Role role = getRoleByID(id);
        if (ObjectUtils.isEmpty(role)){
            return null;
        }
        AZ_RoleVo azRoleVo = new AZ_RoleVo();
        BeanUtils.copyProperties(role,azRoleVo);
        return azRoleVo;
    }

    /**
     * 根据角色ID获得其实体
     *
     * @param id
     * @return
     */
    public Role getRoleByID(Integer id) throws Exception {
        if (ObjectUtils.isEmpty(id)){
            throw new Exception("ROLE_ID_EMPTY");
        }
        Role role = roleMapper.selectByPrimaryKey(id);
        if (ObjectUtils.isEmpty(role)){
            return null;
        }
        return role;
    }

    /**
     * 添加角色
     *
     * @param role
     * @return
     * @throws Exception
     */
    public boolean addRole(Role role) throws Exception {
        if (ObjectUtils.isEmpty(role)){
            throw new Exception("ROLE_EMPTY");
        }
        if (ObjectUtils.isEmpty(role.getName())){
            throw new Exception("ROLE_NAME_EMPTY");
        }
        role.setId(null);
        if (ObjectUtils.isEmpty(role.getSize())){
            role.setSize(AZ_Constant.ROLE_SIZE_INFINITE);
        }
        if (ObjectUtils.isEmpty(role.getIs_lock())){
            role.setIs_lock(AZ_Constant.ROLE_UNLOCK);
        }
        if (ObjectUtils.isEmpty(role.getStart_time())){
            role.setStart_time(new Date());
        }
        int res = roleMapper.insert(role);
        return res>0?true:false;
    }

    /**
     * 锁定角色
     *
     * @param role_id
     * @param is_lock
     * @return
     */
    public boolean lockRole(Integer role_id, Integer is_lock) throws Exception {
        if (ObjectUtils.isEmpty(role_id)){
            throw new Exception("ROLE_ID_EMPTY");
        }
        if (ObjectUtils.isEmpty(is_lock)){
            throw new Exception("ROLE_IS_LOCK_EMPTY");
        }
        Role role = getRoleByID(role_id);
        if (ObjectUtils.isEmpty(role)){
            throw new Exception("ROLE_EXISTED_E");
        }
        role.setIs_lock(is_lock);
        int res = roleMapper.updateByPrimaryKey(role);
        return res > 0 ? true : false;
    }

    /**
     * 设置角色容量
     *
     * @param role_id
     * @param role_size
     * @return
     */
    public boolean setRoleSize(Integer role_id, Integer role_size) throws Exception {
        if (ObjectUtils.isEmpty(role_id)){
            throw new Exception("ROLE_ID_EMPTY");
        }
        if (ObjectUtils.isEmpty(role_size)){
            throw new Exception("ROLE_SIZE_EMPTY");
        }
        Role role = getRoleByID(role_id);
        if (ObjectUtils.isEmpty(role)){
            throw new Exception("ROLE_EXISTED_E");
        }
        role.setSize(role_size);
        int res = roleMapper.updateByPrimaryKey(role);
        return res > 0 ? true : false;
    }

    /**
     * 修改角色
     *
     * @param role
     * @return
     */
    public boolean changeRole(Role role) throws Exception {
        if (ObjectUtils.isEmpty(role)){
            throw new Exception("ROLE_IS_EMPTY");
        }
        if (ObjectUtils.isEmpty(role.getId())){
            throw new Exception("ROLE_ID_IS_EMPTY");
        }
        Role temp = getRoleByID(role.getId());
        if (ObjectUtils.isEmpty(temp)){
            throw new Exception("ROLE_EXISTED_E");
        }
        int res = roleMapper.updateByPrimaryKeySelective(role);
        return res > 0 ? true:false;
    }
}