package common.framework.abstracted;

import common.framework.bean.AS_AspectBean;
import enums.AZ_LogType;

/**
 * 日志注解接口
 * Created by Fuzhong.Yan on 16/11/27.
 */
public abstract class AZ_AnnotationAspectLog {
    /**
     * 日志类型
     */
    private AZ_LogType logType;
    /**
     * 方法执行前记录日志操作
     * @param bean
     */
    public abstract void before(AS_AspectBean bean);
    /**
     * 方法执行后记录日志操作
     * @param bean
     */
    public abstract void after(AS_AspectBean bean);
    /**
     * 方法抛出异常记录日志操作
     * @param bean
     * @param throwable
     */
    public abstract void exception(AS_AspectBean bean,Throwable throwable);

    public AZ_LogType getLogType() {
        return logType;
    }

    public void setLogType(AZ_LogType logType) {
        this.logType = logType;
    }
}