package mapper;

import entity.Log;
import entity.LogExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LogMapper {
    /**
     *
     * @mbg.generated 2017-01-19
     */
    long countByExample(LogExample example);

    /**
     *
     * @mbg.generated 2017-01-19
     */
    int deleteByExample(LogExample example);

    /**
     *
     * @mbg.generated 2017-01-19
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2017-01-19
     */
    int insert(Log record);

    /**
     *
     * @mbg.generated 2017-01-19
     */
    int insertSelective(Log record);

    /**
     *
     * @mbg.generated 2017-01-19
     */
    List<Log> selectByExample(LogExample example);

    /**
     *
     * @mbg.generated 2017-01-19
     */
    Log selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2017-01-19
     */
    int updateByExampleSelective(@Param("record") Log record, @Param("example") LogExample example);

    /**
     *
     * @mbg.generated 2017-01-19
     */
    int updateByExample(@Param("record") Log record, @Param("example") LogExample example);

    /**
     *
     * @mbg.generated 2017-01-19
     */
    int updateByPrimaryKeySelective(Log record);

    /**
     *
     * @mbg.generated 2017-01-19
     */
    int updateByPrimaryKey(Log record);
}