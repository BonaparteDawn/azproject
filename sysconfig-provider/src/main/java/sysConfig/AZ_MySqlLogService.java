package sysConfig;

import common.framework.bean.AS_AspectBean;
import common.framework.abstracted.AZ_AnnotationAspectLog;
import common.framework.service.AZ_ENV;
import common.framework.util.JsonUtil;
import common.framework.util.StringUtils;
import constant.AZ_Constant;
import enums.AZ_LogType;
import entity.Log;
import mapper.LogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 使用MySql数据库记录日志
 * Created by Fuzhong.Yan on 16/11/27.
 */
@Service
public class AZ_MySqlLogService extends AZ_AnnotationAspectLog {
    @Autowired
    private LogMapper logMapper;
    @Autowired
    private AZ_ENV azEnv;
    public AZ_MySqlLogService(){
        setLogType(AZ_LogType.MysqlDatabase);
    }
    public void before(AS_AspectBean bean) {
        Log log = new Log();
        log.setType(AZ_Constant.LOG_BEFORE_METHOD_INVOKE);
        log.setAspectCode(bean.hashCode()+"");
        log.setAppName(bean.getAppName());
        log.setAppDes(bean.getAppDesc());
        log.setMethod(bean.getSignature().toString());
        String args = JsonUtil.toJson(bean.getArgs());
        Integer log_content_max_size = azEnv.getProperty("LOG_CONTENT_MAX_SIZE",Integer.class,AZ_Constant.LOG_CONTENT_MAX_SIZE);
        if (log_content_max_size < args.length()){
            args = StringUtils.subString(args,0,log_content_max_size);
        }
        log.setArgs(args);
        log.setTime(new Date());
        logMapper.insert(log);
    }

    public void after(AS_AspectBean bean) {
        Log log = new Log();
        log.setType(AZ_Constant.LOG_AFTER_METHOD_INVOKE);
        log.setAspectCode(bean.hashCode()+"");
        log.setAppName(bean.getAppName());
        log.setAppDes(bean.getAppDesc());
        log.setMethod(bean.getSignature().toString());
        String args = JsonUtil.toJson(bean.getArgs());
        String res = JsonUtil.toJson(bean.getResult());
        Integer log_content_max_size = azEnv.getProperty("LOG_CONTENT_MAX_SIZE",Integer.class,AZ_Constant.LOG_CONTENT_MAX_SIZE);
        if (log_content_max_size < args.length()){
            args = StringUtils.subString(args,0,log_content_max_size);
        }
        if (log_content_max_size < res.length()){
            res = StringUtils.subString(res,0,log_content_max_size);
        }
        log.setArgs(args);
        log.setResult(res);
        log.setTime(new Date());
        logMapper.insert(log);
    }

    public void exception(AS_AspectBean bean, Throwable throwable) {
        Log log = new Log();
        log.setType(AZ_Constant.LOG_EXCEPTION_METHOD_INVOKE);
        log.setAspectCode(bean.hashCode()+"");
        log.setAppName(bean.getAppName());
        log.setAppDes(bean.getAppDesc());
        log.setMethod(bean.getSignature().toString());
        String args = JsonUtil.toJson(bean.getArgs());
        String res = JsonUtil.toJson(throwable.getStackTrace());
        Integer log_content_max_size = azEnv.getProperty("LOG_CONTENT_MAX_SIZE",Integer.class,AZ_Constant.LOG_CONTENT_MAX_SIZE);
        if (log_content_max_size < args.length()){
            args = StringUtils.subString(args,0,log_content_max_size);
        }
        if (log_content_max_size < res.length()){
            res = StringUtils.subString(res,0,log_content_max_size);
        }
        log.setArgs(args);
        log.setResult(res);
        log.setTime(new Date());
        logMapper.insert(log);
    }
}
