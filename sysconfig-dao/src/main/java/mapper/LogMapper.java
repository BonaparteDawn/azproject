package mapper;

import entity.Log;
import entity.LogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LogMapper {
    /**
     *
     * @mbg.generated 2016-12-23
     */
    long countByExample(LogExample example);

    /**
     *
     * @mbg.generated 2016-12-23
     */
    int deleteByExample(LogExample example);

    /**
     *
     * @mbg.generated 2016-12-23
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2016-12-23
     */
    int insert(Log record);

    /**
     *
     * @mbg.generated 2016-12-23
     */
    int insertSelective(Log record);

    /**
     *
     * @mbg.generated 2016-12-23
     */
    List<Log> selectByExample(LogExample example);

    /**
     *
     * @mbg.generated 2016-12-23
     */
    Log selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2016-12-23
     */
    int updateByExampleSelective(@Param("record") Log record, @Param("example") LogExample example);

    /**
     *
     * @mbg.generated 2016-12-23
     */
    int updateByExample(@Param("record") Log record, @Param("example") LogExample example);

    /**
     *
     * @mbg.generated 2016-12-23
     */
    int updateByPrimaryKeySelective(Log record);

    /**
     *
     * @mbg.generated 2016-12-23
     */
    int updateByPrimaryKey(Log record);
}