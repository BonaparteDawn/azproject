package redis.framework.service;

import common.framework.interfaces.Log;
import common.framework.service.AZ_LogFactory;
import common.framework.util.ObjectUtils;
import enums.AZ_LogType;
import org.springframework.util.Assert;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisShardInfo;
import redis.framework.abstracted.AbstractRedisDatasource;
import redis.framework.util.RedisSingleUtil;

/**
 * 单个Redis数据源
 * Created by Fuzhong.Yan on 17/1/10.
 */
public class SingleRedisDataSource extends AbstractRedisDatasource{
    private Log log = AZ_LogFactory.productLog(AZ_LogType.Log4j,SingleRedisDataSource.class);
    /**
     * Jedis实体
     */
    private Jedis redis = null;

    private int timeout = 10000;
    private String host = "127.0.0.1";
    private int port = 6379;
    private String password = null;
    private String name = null;

    /**
     * 初始化实用实体
     */
    public synchronized void initUtil() {
        Assert.notNull(getHost(),"REDIS_HOST_NULL");
        Assert.notNull(getPort(),"REDIS_PORT_NULL");
        RedisSingleUtil.initJedisPool(this);
        log.info("REDIS_UTIL成功初始化池");
    }

    /**
     * 初始化数据源
     */
    public void initBean() {
        if (ObjectUtils.isEmpty(redis)){
            Assert.notNull(getHost(),"REDIS_HOST_NULL");
            Assert.notNull(getPort(),"REDIS_PORT_NULL");
            JedisShardInfo info = null;
            if (ObjectUtils.isNotEmpty(getName())){
                info = new JedisShardInfo(getHost(),getPort(),getName());
            }else {
                info = new JedisShardInfo(getHost(),getPort());
            }
            if (ObjectUtils.isNotEmpty(getPassword())){
                info.setPassword(getPassword());
            }
            if (ObjectUtils.isNotEmpty(getTimeout())){
                info.setConnectionTimeout(getTimeout());
            }
            redis = info.createResource();
            Assert.notNull(redis,"SINGLE_REDIS_ENTITY_NULL");
            log.info("redis实体成功创建!");
        }else {
            log.info("redis实体已经存在,略过创建!");
        }
    }

    /**
     * 获取到操作实体
     *
     * @return
     */
    public Object getOperateEntity() {
        Assert.notNull(getRedis(),"SINGLE_REDIS_ENTITY_NULL");
        return getRedis();
    }

    public Jedis getRedis() {
        return redis;
    }

    public void setRedis(Jedis redis) {
        this.redis = redis;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
