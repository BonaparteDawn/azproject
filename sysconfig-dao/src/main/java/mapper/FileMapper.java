package mapper;

import entity.File;
import entity.FileExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FileMapper {
    /**
     *
     * @mbg.generated 2017-01-19
     */
    long countByExample(FileExample example);

    /**
     *
     * @mbg.generated 2017-01-19
     */
    int deleteByExample(FileExample example);

    /**
     *
     * @mbg.generated 2017-01-19
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2017-01-19
     */
    int insert(File record);

    /**
     *
     * @mbg.generated 2017-01-19
     */
    int insertSelective(File record);

    /**
     *
     * @mbg.generated 2017-01-19
     */
    List<File> selectByExample(FileExample example);

    /**
     *
     * @mbg.generated 2017-01-19
     */
    File selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2017-01-19
     */
    int updateByExampleSelective(@Param("record") File record, @Param("example") FileExample example);

    /**
     *
     * @mbg.generated 2017-01-19
     */
    int updateByExample(@Param("record") File record, @Param("example") FileExample example);

    /**
     *
     * @mbg.generated 2017-01-19
     */
    int updateByPrimaryKeySelective(File record);

    /**
     *
     * @mbg.generated 2017-01-19
     */
    int updateByPrimaryKey(File record);
}