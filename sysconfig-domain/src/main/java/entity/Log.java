package entity;

import java.util.Date;

public class Log {
    /**
     * 日志id
     */
    private Integer id;

    /**
     * aspect哈希码
     */
    private String aspectCode;

    /**
     * 记录类型（0、接口使用前日志记录，1、接口使用后日志记录，2、接口执行过程异常日志记录）
     */
    private Integer type;

    /**
     * 应用名
     */
    private String appName;

    /**
     * 应用方法描述
     */
    private String appDes;

    /**
     * 方法
     */
    private String method;

    /**
     * 方法参数
     */
    private String args;

    /**
     * 方法结果
     */
    private String result;

    /**
     * 执行时间
     */
    private Date time;

    /**
     * 备注
     */
    private String remark;

    /**
     * 日志id
     * @return id 日志id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 日志id
     * @param id 日志id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * aspect哈希码
     * @return aspectCode aspect哈希码
     */
    public String getAspectCode() {
        return aspectCode;
    }

    /**
     * aspect哈希码
     * @param aspectCode aspect哈希码
     */
    public void setAspectCode(String aspectCode) {
        this.aspectCode = aspectCode == null ? null : aspectCode.trim();
    }

    /**
     * 记录类型（0、接口使用前日志记录，1、接口使用后日志记录，2、接口执行过程异常日志记录）
     * @return type 记录类型（0、接口使用前日志记录，1、接口使用后日志记录，2、接口执行过程异常日志记录）
     */
    public Integer getType() {
        return type;
    }

    /**
     * 记录类型（0、接口使用前日志记录，1、接口使用后日志记录，2、接口执行过程异常日志记录）
     * @param type 记录类型（0、接口使用前日志记录，1、接口使用后日志记录，2、接口执行过程异常日志记录）
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 应用名
     * @return appName 应用名
     */
    public String getAppName() {
        return appName;
    }

    /**
     * 应用名
     * @param appName 应用名
     */
    public void setAppName(String appName) {
        this.appName = appName == null ? null : appName.trim();
    }

    /**
     * 应用方法描述
     * @return appDes 应用方法描述
     */
    public String getAppDes() {
        return appDes;
    }

    /**
     * 应用方法描述
     * @param appDes 应用方法描述
     */
    public void setAppDes(String appDes) {
        this.appDes = appDes == null ? null : appDes.trim();
    }

    /**
     * 方法
     * @return method 方法
     */
    public String getMethod() {
        return method;
    }

    /**
     * 方法
     * @param method 方法
     */
    public void setMethod(String method) {
        this.method = method == null ? null : method.trim();
    }

    /**
     * 方法参数
     * @return args 方法参数
     */
    public String getArgs() {
        return args;
    }

    /**
     * 方法参数
     * @param args 方法参数
     */
    public void setArgs(String args) {
        this.args = args == null ? null : args.trim();
    }

    /**
     * 方法结果
     * @return result 方法结果
     */
    public String getResult() {
        return result;
    }

    /**
     * 方法结果
     * @param result 方法结果
     */
    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }

    /**
     * 执行时间
     * @return time 执行时间
     */
    public Date getTime() {
        return time;
    }

    /**
     * 执行时间
     * @param time 执行时间
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * 备注
     * @return remark 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}