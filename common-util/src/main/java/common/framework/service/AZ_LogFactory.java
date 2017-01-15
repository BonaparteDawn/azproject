package common.framework.service;

import enums.AZ_LogType;
import common.framework.interfaces.Log;
import org.apache.log4j.Logger;
import org.springframework.util.Assert;

/**
 * Created by Fuzhong.Yan on 17/1/10.
 */
public class AZ_LogFactory {
    public static Log productLog(AZ_LogType type,Class classed){
        Assert.notNull(type,"AZ_LOG_TYPE_NULL");
        Assert.notNull(classed,"CLASS_NULL");
        Log log = null;
        switch (type){
            case  Log4j:
            AZ_Log4j azLog4j = new AZ_Log4j();
            azLog4j.setLogger(Logger.getLogger(classed.getClass()));
            log = azLog4j;
            break;
            default:
                break;
        }
        return log;
    }
    public static Log productLog(AZ_LogType type,String name){
        Assert.notNull(type,"AZ_LOG_TYPE_NULL");
        Assert.notNull(name,"NAME_NULL");
        Log log = null;
        switch (type){
            case  Log4j:
                AZ_Log4j azLog4j = new AZ_Log4j();
                azLog4j.setLogger(Logger.getLogger(name));
                log = azLog4j;
                break;
            default:
                break;
        }
        return log;
    }
}
