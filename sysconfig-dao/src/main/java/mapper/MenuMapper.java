package mapper;

import entity.Menu;
import entity.MenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MenuMapper {
    /**
     *
     * @mbg.generated 2016-12-23
     */
    long countByExample(MenuExample example);

    /**
     *
     * @mbg.generated 2016-12-23
     */
    int deleteByExample(MenuExample example);

    /**
     *
     * @mbg.generated 2016-12-23
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2016-12-23
     */
    int insert(Menu record);

    /**
     *
     * @mbg.generated 2016-12-23
     */
    int insertSelective(Menu record);

    /**
     *
     * @mbg.generated 2016-12-23
     */
    List<Menu> selectByExample(MenuExample example);

    /**
     *
     * @mbg.generated 2016-12-23
     */
    Menu selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2016-12-23
     */
    int updateByExampleSelective(@Param("record") Menu record, @Param("example") MenuExample example);

    /**
     *
     * @mbg.generated 2016-12-23
     */
    int updateByExample(@Param("record") Menu record, @Param("example") MenuExample example);

    /**
     *
     * @mbg.generated 2016-12-23
     */
    int updateByPrimaryKeySelective(Menu record);

    /**
     *
     * @mbg.generated 2016-12-23
     */
    int updateByPrimaryKey(Menu record);
}