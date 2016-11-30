package sysconfig;

import common.framework.annotation.AS_AspectBean;
import common.framework.interfaces.AZ_AnnotationAspectLog;
import constant.AZ_LogType;
import org.springframework.stereotype.Service;

/**
 * 使用MySql数据库记录日志
 * Created by Fuzhong.Yan on 16/11/27.
 */
@Service
public class AZ_MySqlLogService extends AZ_AnnotationAspectLog {
    public AZ_MySqlLogService(){
        setLogType(AZ_LogType.MysqlDatabase);
    }
    public void before(AS_AspectBean bean) {
        System.out.println(2222222);
    }

    public void after(AS_AspectBean bean) {

    }

    public void exception(AS_AspectBean bean, Throwable throwable) {

    }
}
