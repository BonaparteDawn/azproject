package mapper;

import entity.Role;
import entity.RoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleMapper {
    /**
     *
     * @mbg.generated 2016-12-23
     */
    long countByExample(RoleExample example);

    /**
     *
     * @mbg.generated 2016-12-23
     */
    int deleteByExample(RoleExample example);

    /**
     *
     * @mbg.generated 2016-12-23
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2016-12-23
     */
    int insert(Role record);

    /**
     *
     * @mbg.generated 2016-12-23
     */
    int insertSelective(Role record);

    /**
     *
     * @mbg.generated 2016-12-23
     */
    List<Role> selectByExample(RoleExample example);

    /**
     *
     * @mbg.generated 2016-12-23
     */
    Role selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2016-12-23
     */
    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example);

    /**
     *
     * @mbg.generated 2016-12-23
     */
    int updateByExample(@Param("record") Role record, @Param("example") RoleExample example);

    /**
     *
     * @mbg.generated 2016-12-23
     */
    int updateByPrimaryKeySelective(Role record);

    /**
     *
     * @mbg.generated 2016-12-23
     */
    int updateByPrimaryKey(Role record);
}