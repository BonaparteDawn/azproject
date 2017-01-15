package common.framework.service;

import common.framework.bean.AS_AspectBean;
import common.framework.abstracted.AZ_AnnotationAspectLog;
import common.framework.interfaces.Log;
import common.framework.util.JsonUtil;
import common.framework.util.ObjectUtils;
import enums.AZ_LogType;
import org.springframework.stereotype.Service;

/**
 * 使用Log4j框架记录日志
 * Created by Fuzhong.Yan on 16/11/27.
 */
@Service
public class AZ_Log4jService extends AZ_AnnotationAspectLog {

    public void before(AS_AspectBean bean) {
        Log logger = getLogger(bean);
        if (ObjectUtils.isNotEmpty(logger)){

            String appName = bean.getAppName();
            String appDes = bean.getAppDesc();
            Object[] args = bean.getArgs();
            Object staticPart = bean.getStaticPart();
            String info = "[Before] aspectCode:"+bean.hashCode()+";appName:"+appName+";appDes:"+appDes+";staticPart:"+staticPart+";args:"+ JsonUtil.toJson(args);
            logger.info(info);
        }
    }

    public void after(AS_AspectBean bean) {
        Log logger = getLogger(bean);
        if (ObjectUtils.isNotEmpty(logger)){
            String appName = bean.getAppName();
            String appDes = bean.getAppDesc();
            Object[] args = bean.getArgs();
            Object staticPart = bean.getStaticPart();
            Object result = bean.getResult();
            String info = "[After] aspectCode:"+bean.hashCode()+";appName:"+appName+";appDes:"+appDes+";staticPart:"+staticPart+";args:"+ JsonUtil.toJson(args)+";res:"+JsonUtil.toJson(result);
            logger.info(info);
        }
    }

    public void exception(AS_AspectBean bean, Throwable throwable) {
        Log logger = getLogger(bean);
        if (ObjectUtils.isNotEmpty(logger)){
            String appName = bean.getAppName();
            String appDes = bean.getAppDesc();
            Object[] args = bean.getArgs();
            Object staticPart = bean.getStaticPart();
            String info = "[Exception] aspectCode:"+bean.hashCode()+";appName:"+appName+";appDes:"+appDes+";staticPart:"+staticPart+";args:"+ JsonUtil.toJson(args);
            logger.info(info,throwable);
        }
    }
    private Log getLogger(AS_AspectBean bean){
        Log logger = null;
        if (ObjectUtils.isNotEmpty(bean) && ObjectUtils.isNotEmpty(bean.getAppName())){
//            logger = Logger.getLogger(bean.getAppName());
            Log log = AZ_LogFactory.productLog(AZ_LogType.Log4j,bean.getAppName());
            if (ObjectUtils.isEmpty(logger)){
                System.err.println("Log4j can not find "+bean.getAppName() +" logger");
            }
        }
        return logger;
    }
    public AZ_Log4jService(){
        setLogType(AZ_LogType.Log4j);
    }
}