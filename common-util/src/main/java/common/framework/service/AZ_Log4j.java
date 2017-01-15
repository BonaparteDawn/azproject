package common.framework.service;

import common.framework.interfaces.Log;
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
        logger.info(info);
    }

    public void debug(String debug) {
        Assert.hasLength(debug,"DEBUG_INFO_LEN_0");
        Assert.notNull(logger,"LOG4J_LOGGER_NULL");
        logger.debug(debug);
    }

    public void error(String error) {
        Assert.hasLength(error,"ERROR_INFO_LEN_0");
        Assert.notNull(logger,"LOG4J_LOGGER_NULL");
        logger.error(error);
    }

    public void info(String info, Throwable t) {
        Assert.hasLength(info,"INFO_LEN_0");
        Assert.notNull(logger,"LOG4J_LOGGER_NULL");
        logger.info(info,t);
    }

    public void debug(String debug, Throwable t) {
        Assert.hasLength(debug,"DEBUG_INFO_LEN_0");
        Assert.notNull(logger,"LOG4J_LOGGER_NULL");
        logger.debug(debug,t);
    }

    public void error(String error, Throwable t) {
        Assert.hasLength(error,"ERROR_INFO_LEN_0");
        Assert.notNull(logger,"LOG4J_LOGGER_NULL");
        logger.error(error,t);
    }

    public Logger getLogger() {
        return logger;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }
}
