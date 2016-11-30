package member;

import entity.Member;
import vo.AZ_MemberVo;
import java.util.List;

/**
 * Created by Fuzhong.Yan on 16/11/14.
 */
public interface AZ_MemberApi {
    /**
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    public List<Member> getMemberVo(int pageNum, int pageSize);
    /**
     * 根据会员账号获得会员的信息
     * @param account
     * @return
     * @throws Exception
     */
    public Member getMemberByAccount(String account) throws Exception;
    /**
     * 根据会员账号获得会员的信息
     * @param account
     * @return
     * @throws Exception
     */
    public AZ_MemberVo getMemberVoByAccount(String account) throws Exception;

    /**
     * 获得会员信息
     * @param member_id
     * @return
     */
    public Member getMemberById(Integer member_id) throws Exception;

    /**
     * 获得会员信息
     * @param member_id
     * @return
     */
    public AZ_MemberVo getMemberVoById(Integer member_id)throws Exception;

    /**
     * 注册会员
     * @param member
     * @return
     */
    public boolean register(Member member)throws Exception;

    /**
     * 修改会员信息
     * @param member
     * @return
     */
    public boolean changeMember(Member member) throws Exception;

    /**
     * 会员登陆
     * @param account
     * @param password
     * @return
     */
    public boolean login(String account,String password) throws Exception;

    /**
     * 修改密码
     * @param account
     * @param password
     * @return
     */
    public boolean changePassword(String account,String password) throws Exception;

    /**
     * 锁定会员
     */
    public boolean lockMember(Integer member_id,boolean is_Lock) throws Exception ;

    /**
     * 审核会员
     * @param member_id
     * @param auditState
     * @return
     */
    public boolean auditMember(Integer member_id,Integer auditState) throws Exception;

    /**
     * 修改账号
     * @param member_id
     * @param account
     * @return
     */
    public boolean changeAccount(Integer member_id,String account) throws Exception;
}
