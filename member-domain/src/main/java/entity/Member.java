package entity;

import java.util.Date;

public class Member {
    /**
     * 会员id
     */
    private Integer id;

    /**
     * 会员的账号
     */
    private String acount;

    /**
     * 角色id（0、表示普通会员）
     */
    private Integer roleID;

    /**
     * 会员名
     */
    private String name;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 性别（0、男，1、女）
     */
    private Integer gender;

    /**
     * 性别
     */
    private Date birth;

    /**
     * 国家
     */
    private String country;

    /**
     * 城市
     */
    private String city;

    /**
     * 地址
     */
    private String address;

    /**
     * 纬度
     */
    private Double latitude;

    /**
     * 经度
     */
    private Double longitude;

    /**
     * 电话号码
     */
    private String telephone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 身份证号
     */
    private String idcard;

    /**
     * 博客地址
     */
    private String blog;

    /**
     * 锁定（1、是，0、否）
     */
    private Integer is_lock;

    /**
     * 认证状态（2、已认证，1、认证中，0、否）
     */
    private Integer auditState;

    /**
     * 注册时间
     */
    private Date registTime;

    /**
     * 会员等级
     */
    private Integer level;

    /**
     * 最后登陆时间
     */
    private Date lastLoginTime;

    /**
     * 登陆失败次数
     */
    private Integer loginFailNumber;

    /**
     * 盐
     */
    private String salt;

    /**
     * 密码
     */
    private String password;

    /**
     * 个人介绍
     */
    private String introduce;

    /**
     * 个人备注
     */
    private String remark;

    /**
     * 语言
     */
    private String language;

    /**
     * 会员id
     * @return id 会员id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 会员id
     * @param id 会员id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 会员的账号
     * @return acount 会员的账号
     */
    public String getAcount() {
        return acount;
    }

    /**
     * 会员的账号
     * @param acount 会员的账号
     */
    public void setAcount(String acount) {
        this.acount = acount == null ? null : acount.trim();
    }

    /**
     * 角色id（0、表示普通会员）
     * @return roleID 角色id（0、表示普通会员）
     */
    public Integer getRoleID() {
        return roleID;
    }

    /**
     * 角色id（0、表示普通会员）
     * @param roleID 角色id（0、表示普通会员）
     */
    public void setRoleID(Integer roleID) {
        this.roleID = roleID;
    }

    /**
     * 会员名
     * @return name 会员名
     */
    public String getName() {
        return name;
    }

    /**
     * 会员名
     * @param name 会员名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 昵称
     * @return nickName 昵称
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * 昵称
     * @param nickName 昵称
     */
    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    /**
     * 性别（0、男，1、女）
     * @return gender 性别（0、男，1、女）
     */
    public Integer getGender() {
        return gender;
    }

    /**
     * 性别（0、男，1、女）
     * @param gender 性别（0、男，1、女）
     */
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    /**
     * 性别
     * @return birth 性别
     */
    public Date getBirth() {
        return birth;
    }

    /**
     * 性别
     * @param birth 性别
     */
    public void setBirth(Date birth) {
        this.birth = birth;
    }

    /**
     * 国家
     * @return country 国家
     */
    public String getCountry() {
        return country;
    }

    /**
     * 国家
     * @param country 国家
     */
    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    /**
     * 城市
     * @return city 城市
     */
    public String getCity() {
        return city;
    }

    /**
     * 城市
     * @param city 城市
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    /**
     * 地址
     * @return address 地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 地址
     * @param address 地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 纬度
     * @return latitude 纬度
     */
    public Double getLatitude() {
        return latitude;
    }

    /**
     * 纬度
     * @param latitude 纬度
     */
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    /**
     * 经度
     * @return longitude 经度
     */
    public Double getLongitude() {
        return longitude;
    }

    /**
     * 经度
     * @param longitude 经度
     */
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    /**
     * 电话号码
     * @return telephone 电话号码
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * 电话号码
     * @param telephone 电话号码
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    /**
     * 邮箱
     * @return email 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 邮箱
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 身份证号
     * @return idcard 身份证号
     */
    public String getIdcard() {
        return idcard;
    }

    /**
     * 身份证号
     * @param idcard 身份证号
     */
    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    /**
     * 博客地址
     * @return blog 博客地址
     */
    public String getBlog() {
        return blog;
    }

    /**
     * 博客地址
     * @param blog 博客地址
     */
    public void setBlog(String blog) {
        this.blog = blog == null ? null : blog.trim();
    }

    /**
     * 锁定（1、是，0、否）
     * @return is_lock 锁定（1、是，0、否）
     */
    public Integer getIs_lock() {
        return is_lock;
    }

    /**
     * 锁定（1、是，0、否）
     * @param is_lock 锁定（1、是，0、否）
     */
    public void setIs_lock(Integer is_lock) {
        this.is_lock = is_lock;
    }

    /**
     * 认证状态（2、已认证，1、认证中，0、否）
     * @return auditState 认证状态（2、已认证，1、认证中，0、否）
     */
    public Integer getAuditState() {
        return auditState;
    }

    /**
     * 认证状态（2、已认证，1、认证中，0、否）
     * @param auditState 认证状态（2、已认证，1、认证中，0、否）
     */
    public void setAuditState(Integer auditState) {
        this.auditState = auditState;
    }

    /**
     * 注册时间
     * @return registTime 注册时间
     */
    public Date getRegistTime() {
        return registTime;
    }

    /**
     * 注册时间
     * @param registTime 注册时间
     */
    public void setRegistTime(Date registTime) {
        this.registTime = registTime;
    }

    /**
     * 会员等级
     * @return level 会员等级
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * 会员等级
     * @param level 会员等级
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * 最后登陆时间
     * @return lastLoginTime 最后登陆时间
     */
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * 最后登陆时间
     * @param lastLoginTime 最后登陆时间
     */
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * 登陆失败次数
     * @return loginFailNumber 登陆失败次数
     */
    public Integer getLoginFailNumber() {
        return loginFailNumber;
    }

    /**
     * 登陆失败次数
     * @param loginFailNumber 登陆失败次数
     */
    public void setLoginFailNumber(Integer loginFailNumber) {
        this.loginFailNumber = loginFailNumber;
    }

    /**
     * 盐
     * @return salt 盐
     */
    public String getSalt() {
        return salt;
    }

    /**
     * 盐
     * @param salt 盐
     */
    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    /**
     * 密码
     * @return password 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 密码
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 个人介绍
     * @return introduce 个人介绍
     */
    public String getIntroduce() {
        return introduce;
    }

    /**
     * 个人介绍
     * @param introduce 个人介绍
     */
    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
    }

    /**
     * 个人备注
     * @return remark 个人备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 个人备注
     * @param remark 个人备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 语言
     * @return language 语言
     */
    public String getLanguage() {
        return language;
    }

    /**
     * 语言
     * @param language 语言
     */
    public void setLanguage(String language) {
        this.language = language == null ? null : language.trim();
    }
}