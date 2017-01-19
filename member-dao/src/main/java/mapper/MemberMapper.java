package mapper;

import entity.Member;
import entity.MemberExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MemberMapper {
    /**
     *
     * @mbg.generated 2017-01-19
     */
    long countByExample(MemberExample example);

    /**
     *
     * @mbg.generated 2017-01-19
     */
    int deleteByExample(MemberExample example);

    /**
     *
     * @mbg.generated 2017-01-19
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2017-01-19
     */
    int insert(Member record);

    /**
     *
     * @mbg.generated 2017-01-19
     */
    int insertSelective(Member record);

    /**
     *
     * @mbg.generated 2017-01-19
     */
    List<Member> selectByExample(MemberExample example);

    /**
     *
     * @mbg.generated 2017-01-19
     */
    Member selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2017-01-19
     */
    int updateByExampleSelective(@Param("record") Member record, @Param("example") MemberExample example);

    /**
     *
     * @mbg.generated 2017-01-19
     */
    int updateByExample(@Param("record") Member record, @Param("example") MemberExample example);

    /**
     *
     * @mbg.generated 2017-01-19
     */
    int updateByPrimaryKeySelective(Member record);

    /**
     *
     * @mbg.generated 2017-01-19
     */
    int updateByPrimaryKey(Member record);
}