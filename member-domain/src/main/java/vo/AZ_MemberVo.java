package vo;

import entity.Member;

/**
 * Created by Fuzhong.Yan on 16/11/14.
 */
public class AZ_MemberVo extends Member{
    private AZ_RoleVo az_roleVo;

    public AZ_RoleVo getAz_roleVo() {
        return az_roleVo;
    }

    public void setAz_roleVo(AZ_RoleVo az_roleVo) {
        this.az_roleVo = az_roleVo;
    }
}