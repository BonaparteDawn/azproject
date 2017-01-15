package mapper;

import entity.File;
import entity.FileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FileMapper {
    /**
     *
     * @mbg.generated 2016-12-23
     */
    long countByExample(FileExample example);

    /**
     *
     * @mbg.generated 2016-12-23
     */
    int deleteByExample(FileExample example);

    /**
     *
     * @mbg.generated 2016-12-23
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2016-12-23
     */
    int insert(File record);

    /**
     *
     * @mbg.generated 2016-12-23
     */
    int insertSelective(File record);

    /**
     *
     * @mbg.generated 2016-12-23
     */
    List<File> selectByExample(FileExample example);

    /**
     *
     * @mbg.generated 2016-12-23
     */
    File selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2016-12-23
     */
    int updateByExampleSelective(@Param("record") File record, @Param("example") FileExample example);

    /**
     *
     * @mbg.generated 2016-12-23
     */
    int updateByExample(@Param("record") File record, @Param("example") FileExample example);

    /**
     *
     * @mbg.generated 2016-12-23
     */
    int updateByPrimaryKeySelective(File record);

    /**
     *
     * @mbg.generated 2016-12-23
     */
    int updateByPrimaryKey(File record);
}