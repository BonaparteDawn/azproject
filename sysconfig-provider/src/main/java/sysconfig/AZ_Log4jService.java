package sysconfig;

import common.framework.annotation.AS_AspectBean;
import common.framework.interfaces.AZ_AnnotationAspectLog;
import common.framework.util.ObjectUtils;
import constant.AZ_LogType;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 * 使用Log4j框架记录日志
 * Created by Fuzhong.Yan on 16/11/27.
 */
@Service
public class AZ_Log4jService extends AZ_AnnotationAspectLog {

    public void before(AS_AspectBean bean) {
        System.out.println("爱你1");
        Logger logger = getLogger(bean);
        if (ObjectUtils.isNotEmpty(logger)){
            logger.info("test");
            logger.info(bean.getAppName());
            logger.debug(bean.getAppName());
            logger.error(bean.getAppName());
        }
    }

    public void after(AS_AspectBean bean) {
        System.out.println("爱你22");
    }

    public void exception(AS_AspectBean bean, Throwable throwable) {
        System.out.println("爱333");
    }
    private Logger getLogger(AS_AspectBean bean){
        Logger logger = null;
        if (ObjectUtils.isNotEmpty(bean) && ObjectUtils.isNotEmpty(bean.getAppName())){
            logger = Logger.getLogger(bean.getAppName());
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