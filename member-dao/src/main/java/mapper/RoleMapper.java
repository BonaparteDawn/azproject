package mapper;

import entity.Role;
import entity.RoleExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {
    /**
     *
     * @mbg.generated 2017-01-19
     */
    long countByExample(RoleExample example);

    /**
     *
     * @mbg.generated 2017-01-19
     */
    int deleteByExample(RoleExample example);

    /**
     *
     * @mbg.generated 2017-01-19
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2017-01-19
     */
    int insert(Role record);

    /**
     *
     * @mbg.generated 2017-01-19
     */
    int insertSelective(Role record);

    /**
     *
     * @mbg.generated 2017-01-19
     */
    List<Role> selectByExample(RoleExample example);

    /**
     *
     * @mbg.generated 2017-01-19
     */
    Role selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2017-01-19
     */
    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example);

    /**
     *
     * @mbg.generated 2017-01-19
     */
    int updateByExample(@Param("record") Role record, @Param("example") RoleExample example);

    /**
     *
     * @mbg.generated 2017-01-19
     */
    int updateByPrimaryKeySelective(Role record);

    /**
     *
     * @mbg.generated 2017-01-19
     */
    int updateByPrimaryKey(Role record);
}