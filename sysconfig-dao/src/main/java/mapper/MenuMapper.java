package mapper;

import entity.Menu;
import entity.MenuExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuMapper {
    /**
     *
     * @mbg.generated 2017-01-19
     */
    long countByExample(MenuExample example);

    /**
     *
     * @mbg.generated 2017-01-19
     */
    int deleteByExample(MenuExample example);

    /**
     *
     * @mbg.generated 2017-01-19
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2017-01-19
     */
    int insert(Menu record);

    /**
     *
     * @mbg.generated 2017-01-19
     */
    int insertSelective(Menu record);

    /**
     *
     * @mbg.generated 2017-01-19
     */
    List<Menu> selectByExample(MenuExample example);

    /**
     *
     * @mbg.generated 2017-01-19
     */
    Menu selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2017-01-19
     */
    int updateByExampleSelective(@Param("record") Menu record, @Param("example") MenuExample example);

    /**
     *
     * @mbg.generated 2017-01-19
     */
    int updateByExample(@Param("record") Menu record, @Param("example") MenuExample example);

    /**
     *
     * @mbg.generated 2017-01-19
     */
    int updateByPrimaryKeySelective(Menu record);

    /**
     *
     * @mbg.generated 2017-01-19
     */
    int updateByPrimaryKey(Menu record);
}