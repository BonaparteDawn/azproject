package member;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import common.framework.service.AZ_ENV;
import common.framework.util.ObjectUtils;
import constant.AZ_Constant;
import entity.Member;
import entity.MemberExample;
import entity.Role;
import mapper.MemberMapper;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import vo.AZ_MemberVo;
import vo.AZ_RoleVo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Fuzhong.Yan on 16/11/21.
 */
@Service
public class AZ_MemberService implements AZ_MemberApi,Serializable{
    @Autowired
    private MemberMapper memberMapper;
    @Autowired
    private AZ_RoleApi azRoleService;
    /**
     * 系统环境
     */
    @Autowired
    private AZ_ENV azEnv;

    public List<Member> getMemberVo(int pageNum, int pageSize) {
        MemberExample e = new MemberExample();
        PageHelper.startPage(pageNum,pageSize);
        List<Member> res = memberMapper.selectByExample(e);
        System.out.println(azEnv.resolvePlaceholders("1 ${  MEMBER_MAX_LOGIN_FAILED_NUMBER  }我爱你"));
        System.out.println(azEnv.getProperty("MEMBER_MAX_LOGIN_FAILED_NUMBER",Integer.class,Integer.valueOf(2)));
        System.out.println(azRoleService);
        return res;
    }

    public Member getMemberByAccount(String account) throws Exception {
        if (ObjectUtils.isEmpty(account)){
            throw new Exception("MEMBER_ACCOUNT_EMPTY");
        }
        MemberExample example = new MemberExample();
        MemberExample.Criteria account_c = example.createCriteria();
        account_c.andAcountEqualTo(account);
        MemberExample.Criteria account_email = example.createCriteria();
        account_email.andEmailEqualTo(account);
        MemberExample.Criteria account_telephone = example.createCriteria();
        account_telephone.andTelephoneEqualTo(account);
        MemberExample.Criteria account_blog = example.createCriteria();
        account_blog.andBlogEqualTo(account);
        MemberExample.Criteria account_id_card = example.createCriteria();
        account_id_card.andIdcardEqualTo(account);
        example.or(account_c);
        example.or(account_email);
        example.or(account_id_card);
        example.or(account_telephone);
        example.or(account_blog);
        List<Member> member = memberMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(member)){
            throw new Exception("MEMBER_ACCOUNT_NOT_EXISTED");
        }
        if (member.size() !=1){
            throw new Exception("MEMBER_ACCOUNT_SIZE_E");
        }
        return member.get(0);
    }

    public AZ_MemberVo getMemberVoByAccount(String account) throws Exception {
        if (ObjectUtils.isEmpty(account)){
            throw new Exception("MEMBER_ACCOUNT_EMPTY");
        }
        Member member = getMemberByAccount(account);
        if (ObjectUtils.isEmpty(member)){
            throw new Exception("MEMBER_IS_EMPTY");
        }
        AZ_MemberVo temp = new AZ_MemberVo();
        BeanUtils.copyProperties(member,temp);
        if (ObjectUtils.isNotEmpty(temp.getRoleid())){
            AZ_RoleVo role = azRoleService.getRoleVoByID(temp.getRoleid());
            if (ObjectUtils.isNotEmpty(role)){
                temp.setAz_roleVo(role);
            }
        }
        return temp;
    }

    public Member getMemberById(Integer member_id) throws Exception {
        if (ObjectUtils.isEmpty(member_id)){
            throw new Exception("MEMBER_ID_EMPTY");
        }
        return memberMapper.selectByPrimaryKey(member_id);
    }

    public AZ_MemberVo getMemberVoById(Integer member_id) throws Exception {
        if (ObjectUtils.isEmpty(member_id)){
            throw new Exception("MEMBER_ID_EMPTY");
        }
        Member member = getMemberById(member_id);
        if (ObjectUtils.isEmpty(member)){
            throw new Exception("MEMBER_IS_EMPTY");
        }
        AZ_MemberVo temp = new AZ_MemberVo();
        BeanUtils.copyProperties(member,temp);
        if (ObjectUtils.isNotEmpty(temp.getRoleid())){
            AZ_RoleVo role = azRoleService.getRoleVoByID(temp.getRoleid());
            if (ObjectUtils.isNotEmpty(role)){
                temp.setAz_roleVo(role);
            }
        }
        return temp;
    }

    /**
     *
     * @param member
     * @return
     * @throws Exception
     */
    public boolean register(Member member) throws Exception {
        boolean res = false;
        if (ObjectUtils.isEmpty(member)){
            throw new Exception("MEMBER_IS_EMPTY");
        }
        //设置会员默认账号
        if (ObjectUtils.isEmpty(member.getAcount())){
            if (ObjectUtils.isNotEmpty(member.getTelephone())){
                member.setAcount(member.getTelephone());
            }else if (ObjectUtils.isNotEmpty(member.getEmail())){
                member.setAcount(member.getEmail());
            }else if (ObjectUtils.isNotEmpty(member.getIdcard())){
                member.setAcount(member.getIdcard());
            }else if (ObjectUtils.isNotEmpty(member.getBlog())){
                member.setAcount(member.getBlog());
            }else {
                throw new Exception("MEMBER_ACCOUNT_EMPTY");
            }
        }
        if (ObjectUtils.isNotEmpty(member.getAcount())){
            Member checkMember = getMemberByAccount(member.getAcount());
            if (ObjectUtils.isEmpty(checkMember)){
                throw new Exception("MEMBER_ACCOUNT_EXISTED");
            }
        }
        if (ObjectUtils.isNotEmpty(member.getTelephone())){
            Member checkMember = getMemberByAccount(member.getTelephone());
            if (ObjectUtils.isEmpty(checkMember)){
                throw new Exception("MEMBER_TELEPHONE_EXISTED");
            }
        }
        if (ObjectUtils.isNotEmpty(member.getEmail())){
            Member checkMember = getMemberByAccount(member.getEmail());
            if (ObjectUtils.isEmpty(checkMember)){
                throw new Exception("MEMBER_EMAIL_EXISTED");
            }
        }
        if (ObjectUtils.isNotEmpty(member.getIdcard())){
            Member checkMember = getMemberByAccount(member.getIdcard());
            if (ObjectUtils.isEmpty(checkMember)){
                throw new Exception("MEMBER_ID_CARD_EXISTED");
            }
        }
        if (ObjectUtils.isNotEmpty(member.getBlog())){
            Member checkMember = getMemberByAccount(member.getBlog());
            if (ObjectUtils.isEmpty(checkMember)){
                throw new Exception("MEMBER_BLOG_EXISTED");
            }
        }
        if (ObjectUtils.isEmpty(member.getSalt())){
            throw new Exception("MEMBER_SALT_EMPTY");
        }
        if (ObjectUtils.isEmpty(member.getPassword())){
            throw new Exception("MEMBER_PASSWORD_EMPTY");
        }
        member.setRegisttime(new Date());
        member.setIsLock(AZ_Constant.MEMBER_UNLOCK);
        member.setLevel(AZ_Constant.MEMBER_DEFAULT_LEVEL);
        if (ObjectUtils.isEmpty(member.getGender())){
            member.setGender(AZ_Constant.MEMBER_MALE);
        }
        if (ObjectUtils.isEmpty(member.getAuditstate())){
            member.setAuditstate(AZ_Constant.MEMBER_UN_AUDIT);
        }
        if (ObjectUtils.isEmpty(member.getRoleid())){
            member.setRoleid(AZ_Constant.ROLE_TYPE_ORDINARY);
        }
        if (ObjectUtils.isEmpty(member.getLanguage())){
            member.setLanguage(AZ_Constant.MEMBER_DEFAULT_LANGUAGE);
        }
        Role role = azRoleService.getRoleVoByID(member.getRoleid());
        if (ObjectUtils.isEmpty(role)){
            throw new Exception("MEMBER_ROLE_NOT_EXISTED");
        }else {
            if (ObjectUtils.isNotEmpty(role.getIsLock()) && role.getIsLock().equals(AZ_Constant.ROLE_LOCK)){
                throw new Exception("MEMBER_ROLE_LOCKED");
            }
            if (ObjectUtils.isNotEmpty(role.getSize()) && !role.getSize().equals(AZ_Constant.ROLE_SIZE_INFINITE)){
                MemberExample e = new MemberExample();
                MemberExample.Criteria ct = e.createCriteria();
                ct.andRoleidEqualTo(member.getRoleid());
                int member_role_size = memberMapper.countByExample(e);
                if (member_role_size >= role.getSize()){
                    throw new Exception("MEMBER_ROLE_SIZE_LIMIT");
                }
            }
            if (ObjectUtils.isNotEmpty(role.getStartTime()) && role.getStartTime().compareTo(new Date()) >0){
                throw new Exception("MEMBER_ROLE_START_TIME_E0");
            }
            if (ObjectUtils.isNotEmpty(role.getEndTime()) && role.getEndTime().compareTo(new Date())<0){
                throw new Exception("MEMBER_ROLE_END_TIME_E0");
            }
        }
        int res_insert = memberMapper.insert(member);
        if (res_insert > 0){
            res = true;
        }else{
            res = false;
        }
        return res;
    }

    /**
     * 传入的对象中必须id或者account不为空
     * @param member
     * @return
     * @throws Exception
     */
    public boolean changeMember(Member member) throws Exception {
        boolean res = false;
        if (ObjectUtils.isEmpty(member)){
            throw new Exception("MEMBER_IS_EMPTY");
        }
        if (ObjectUtils.isEmpty(member.getId()) && ObjectUtils.isEmpty(member.getAcount())){
            if (ObjectUtils.isEmpty(member.getId())){
                throw new Exception("MEMBER_ID_EMPTY");
            }
            if (ObjectUtils.isEmpty(member.getAcount())){
                throw new Exception("MEMBER_ACCOUNT_EMPTY");
            }
        }
        if (ObjectUtils.isEmpty(member.getId())){
            Member account_member = getMemberByAccount(member.getAcount());
            if (ObjectUtils.isEmpty(account_member)){
                throw new Exception("MEMBER_IS_EMPTY");
            }
            member.setId(account_member.getId());
        }
        int u = memberMapper.updateByPrimaryKeySelective(member);
        if (u > 0){
            res = true;
        }else {
            res =false;
        }
        return res;
    }

    public boolean login(String account, String password) throws Exception {
        boolean res = false;
        if (ObjectUtils.isEmpty(account)){
            throw new Exception("MEMBER_ACCOUNT_EMPTY");
        }
        if (ObjectUtils.isEmpty(password)){
            throw new Exception("MEMBER_PASSWORD_EMPTY");
        }
        AZ_MemberVo member = getMemberVoByAccount(account);
        if (ObjectUtils.isEmpty(member)){
            throw new Exception("MEMBER_IS_EMPTY");
        }
        if (member.getIsLock().equals(AZ_Constant.MEMBER_LOCK)){
            throw new Exception("MEMBER_LOCKED");
        }
        AZ_RoleVo role = member.getAz_roleVo();
        if (ObjectUtils.isNotEmpty(role)){
            if (ObjectUtils.isNotEmpty(role.getIsLock()) && role.getIsLock().equals(AZ_Constant.ROLE_LOCK)){
                throw new Exception("ROLE_LOCKED");
            }
            Date date = new Date();
            boolean start_time = ObjectUtils.isNotEmpty(role.getStartTime()) && date.compareTo(role.getStartTime())>0;
            boolean end_time = ObjectUtils.isNotEmpty(role.getEndTime()) && role.getEndTime().compareTo(date)>0;
            if (!start_time || !end_time){
                throw new Exception("MEMBER_ROLE_TIME_E");
            }
        }
        if (ObjectUtils.isNotEmpty(member.getPassword()) && member.getPassword().equals(password)){
            res = true;
        }else{
            res = false;
        }
        return res;
    }

    public boolean changePassword(String account, String password) throws Exception {
        if (ObjectUtils.isEmpty(account)){
            throw new Exception("MEMBER_ACCOUNT_EMPTY");
        }
        if (ObjectUtils.isEmpty(password)){
            throw new Exception("MEMBER_PASSWORD_EMPTY");
        }
        Member member = getMemberByAccount(account);
        if (ObjectUtils.isEmpty(member)){
            throw new Exception("MEMBER_IS_EMPTY");
        }
        Member temp = new Member();
        temp.setId(member.getId());
        temp.setPassword(password);
        boolean res = false;
        int u = memberMapper.updateByPrimaryKeySelective(temp);
        if (u>0){
            res = true;
        }
        return res;
    }

    public boolean lockMember(Integer member_id,boolean is_Lock) throws Exception {
        if (ObjectUtils.isEmpty(member_id)){
            throw new Exception("MEMBER_ID_EMPTY");
        }
        Member member = getMemberById(member_id);
        if (ObjectUtils.isEmpty(member)){
            throw new Exception("MEMBER_IS_EMPTY");
        }
        Member temp = new Member();
        temp.setId(member_id);
        if (is_Lock){
            temp.setIsLock(AZ_Constant.MEMBER_LOCK);
        }else{
            temp.setIsLock(AZ_Constant.MEMBER_UNLOCK);
        }
        boolean res = false;
        int u = memberMapper.updateByPrimaryKeySelective(temp);
        if (u>0){
            res = true;
        }
        return res;
    }

    public boolean auditMember(Integer member_id, Integer auditState) throws Exception {
        if (ObjectUtils.isEmpty(member_id)){
            throw new Exception("MEMBER_ID_EMPTY");
        }
        if (ObjectUtils.isEmpty(auditState)){
            throw new Exception("MEMBER_AUDIT_STATE_EMPTY");
        }
        Member member = getMemberById(member_id);
        if (ObjectUtils.isEmpty(member)){
            throw new Exception("MEMBER_IS_EMPTY");
        }
        Member temp = new Member();
        temp.setId(member_id);
        temp.setAuditstate(auditState);
        boolean res = false;
        int u = memberMapper.updateByPrimaryKeySelective(temp);
        if (u>0){
            res = true;
        }
        return res;
    }

    public boolean changeAccount(Integer member_id, String account) throws Exception {
        if (ObjectUtils.isEmpty(member_id)){
            throw new Exception("MEMBER_ID_EMPTY");
        }
        if (ObjectUtils.isEmpty(account)){
            throw new Exception("MEMBER_ACCOUNT_EMPTY");
        }
        Member member = getMemberById(member_id);
        if (ObjectUtils.isEmpty(member)){
            throw new Exception("MEMBER_IS_EMPTY");
        }
        Member temp = new Member();
        temp.setId(member_id);
        temp.setAcount(account);
        boolean res = false;
        int u = memberMapper.updateByPrimaryKeySelective(temp);
        if (u>0){
            res = true;
        }
        return res;
    }
}
