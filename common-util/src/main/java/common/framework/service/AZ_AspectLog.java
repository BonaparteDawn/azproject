package common.framework.service;

import common.framework.bean.AS_AspectBean;
import common.framework.annotation.AZ_LogMethod;
import common.framework.abstracted.AZ_AnnotationAspectLog;
import common.framework.util.ListUtils;
import enums.AZ_LogTime;
import enums.AZ_LogType;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.List;

/**
 * 记录日志的Aspect
 * Created by Fuzhong.Yan on 16/11/27.
 */
@Aspect
public class AZ_AspectLog {

    private List<AZ_AnnotationAspectLog> annotationAspectLogs;

    @Around(value = "@annotation(log)")
    public Object run(ProceedingJoinPoint proceedingJoinPoint, AZ_LogMethod log) throws Exception {
        Object result = null;
        AS_AspectBean asAspectBean = null;
        try {
            if (annotationAspectLogs!=null && annotationAspectLogs.size()>0){
                    asAspectBean = new AS_AspectBean();
                    asAspectBean.setArgs(proceedingJoinPoint.getArgs());
                    asAspectBean.setKind(proceedingJoinPoint.getKind());
                    asAspectBean.setSignature(proceedingJoinPoint.getSignature());
                    asAspectBean.setSourceLocation(proceedingJoinPoint.getSourceLocation());
                    asAspectBean.setStaticPart(proceedingJoinPoint.getStaticPart());
                    asAspectBean.setThisObj(proceedingJoinPoint.getThis());
                    asAspectBean.setType(log.type());
                    asAspectBean.setAppName(log.appName());
                    asAspectBean.setAppDesc(log.appDesc());
                    asAspectBean.setLogTimes(log.logTime());
                for (AZ_AnnotationAspectLog annotationAspectLog:annotationAspectLogs){
                    if (annotationAspectLog.getLogType()!=null){
                        AZ_LogType[] types = log.type();
                        if (types != null){
                            for (AZ_LogType t:types){
                                if (annotationAspectLog != null && asAspectBean !=null && ListUtils.isNotEmpty(asAspectBean.getLogTimes()) && t.equals(annotationAspectLog.getLogType()) ){
                                    for (AZ_LogTime azLogTime:asAspectBean.getLogTimes()){
                                        if (azLogTime.equals(AZ_LogTime.BeforeMethod)){
                                            annotationAspectLog.before(asAspectBean);
                                        }
                                    }
                                }
                            }
                        }
                    }else {
                        throw new Exception("LOG_TYPE_IS_NULL");
                    }
                }
            }
            result = proceedingJoinPoint.proceed();
            asAspectBean.setResult(result);
            if (annotationAspectLogs!=null && annotationAspectLogs.size()>0){
                for (AZ_AnnotationAspectLog annotationAspectLog:annotationAspectLogs){
                    AZ_LogType[] types = log.type();
                    if (types != null){
                        for (AZ_LogType t:types){
                            if (annotationAspectLog != null && asAspectBean !=null && ListUtils.isNotEmpty(asAspectBean.getLogTimes()) && t.equals(annotationAspectLog.getLogType()) ){
                                for (AZ_LogTime azLogTime:asAspectBean.getLogTimes()){
                                    if (azLogTime.equals(AZ_LogTime.AfterMethod)){
                                        annotationAspectLog.after(asAspectBean);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Throwable e) {
            if (annotationAspectLogs!=null && annotationAspectLogs.size()>0){
                for (AZ_AnnotationAspectLog annotationAspectLog:annotationAspectLogs){
                    AZ_LogType[] types = log.type();
                    if (types != null){
                        for (AZ_LogType t:types){
                            if (annotationAspectLog != null && asAspectBean !=null && ListUtils.isNotEmpty(asAspectBean.getLogTimes()) && t.equals(annotationAspectLog.getLogType()) ){
                                for (AZ_LogTime azLogTime:asAspectBean.getLogTimes()){
                                    if (azLogTime.equals(AZ_LogTime.ExceptionMethod)){
                                        annotationAspectLog.exception(asAspectBean,e);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            throw new Exception(e.getMessage());
        }
        return result;
    }

    public List<AZ_AnnotationAspectLog> getAnnotationAspectLogs() {
        return annotationAspectLogs;
    }

    public void setAnnotationAspectLogs(List<AZ_AnnotationAspectLog> annotationAspectLogs) {
        this.annotationAspectLogs = annotationAspectLogs;
    }
}
