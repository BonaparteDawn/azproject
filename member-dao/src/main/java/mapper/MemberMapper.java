package mapper;

import entity.Member;
import entity.MemberExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MemberMapper {
    /**
     *
     * @mbg.generated 2016-12-23
     */
    long countByExample(MemberExample example);

    /**
     *
     * @mbg.generated 2016-12-23
     */
    int deleteByExample(MemberExample example);

    /**
     *
     * @mbg.generated 2016-12-23
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2016-12-23
     */
    int insert(Member record);

    /**
     *
     * @mbg.generated 2016-12-23
     */
    int insertSelective(Member record);

    /**
     *
     * @mbg.generated 2016-12-23
     */
    List<Member> selectByExample(MemberExample example);

    /**
     *
     * @mbg.generated 2016-12-23
     */
    Member selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2016-12-23
     */
    int updateByExampleSelective(@Param("record") Member record, @Param("example") MemberExample example);

    /**
     *
     * @mbg.generated 2016-12-23
     */
    int updateByExample(@Param("record") Member record, @Param("example") MemberExample example);

    /**
     *
     * @mbg.generated 2016-12-23
     */
    int updateByPrimaryKeySelective(Member record);

    /**
     *
     * @mbg.generated 2016-12-23
     */
    int updateByPrimaryKey(Member record);
}