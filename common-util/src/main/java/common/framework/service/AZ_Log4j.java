package common.framework.service;

import common.framework.interfaces.Log;
import common.framework.util.EnvironmentUtil;
import org.apache.log4j.Logger;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Fuzhong.Yan on 17/1/10.
 */
public class AZ_Log4j implements Log {
    private Logger logger = null;

    public void info(String info) {
        Assert.hasLength(info,"INFO_LEN_0");
        Assert.notNull(logger,"LOG4J_LOGGER_NULL");
        logger.info(addLocation(info));
    }

    public void debug(String debug) {
        Assert.hasLength(debug,"DEBUG_INFO_LEN_0");
        Assert.notNull(logger,"LOG4J_LOGGER_NULL");
        logger.debug(addLocation(debug));
    }

    public void error(String error) {
        Assert.hasLength(error,"ERROR_INFO_LEN_0");
        Assert.notNull(logger,"LOG4J_LOGGER_NULL");
        logger.error(addLocation(error));
    }

    public void info(String info, Throwable t) {
        Assert.hasLength(info,"INFO_LEN_0");
        Assert.notNull(logger,"LOG4J_LOGGER_NULL");
        logger.info(addLocation(info),t);
    }

    public void debug(String debug, Throwable t) {
        Assert.hasLength(debug,"DEBUG_INFO_LEN_0");
        Assert.notNull(logger,"LOG4J_LOGGER_NULL");
        logger.debug(addLocation(debug),t);
    }

    public void error(String error, Throwable t) {
        Assert.hasLength(error,"ERROR_INFO_LEN_0");
        Assert.notNull(logger,"LOG4J_LOGGER_NULL");
        logger.error(addLocation(error),t);
    }

    private String addLocation(String temp){
        StackTraceElement[] stackTrace = EnvironmentUtil.getThreadStackTrace();
        String res = temp;
        if (stackTrace != null && stackTrace.length >= 4){
            res = "method:"+stackTrace[4].getClassName()+"."+stackTrace[4].getMethodName()+"(line:"+stackTrace[3].getLineNumber()+")-----"+res;
        }
        return  res;
    }

    public Logger getLogger() {
        return logger;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }
}
