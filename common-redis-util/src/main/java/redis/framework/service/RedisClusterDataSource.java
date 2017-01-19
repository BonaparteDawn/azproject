package redis.framework.service;

import common.framework.interfaces.Log;
import common.framework.service.AZ_LogFactory;
import common.framework.util.ObjectUtils;
import enums.AZ_LogType;
import org.springframework.util.Assert;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.framework.abstracted.AbstractRedisDatasource;
import redis.framework.util.RedisClusterUtil;
import java.util.HashSet;

/**
 * Redis集群数据源
 * Created by Fuzhong.Yan on 17/1/15.
 */
public class RedisClusterDataSource extends AbstractRedisDatasource{
    private Log log = AZ_LogFactory.productLog(AZ_LogType.Log4j,RedisClusterDataSource.class);

    private JedisCluster jedisCluster = null;

    private  HashSet<HostAndPort> hostAndPorts = new HashSet<HostAndPort>();
    /**
     * 初始化实用实体
     */
    public void initUtil() {
        Assert.notEmpty(getHostAndPorts(),"HOST_AND_PORT_EMPTY");
        RedisClusterUtil.initRedisCluster(this);
        log.info("RedisClusterUtil成功初始化池");
    }

    /**
     * 初始化数据源
     */
    public void initBean() {
        if (ObjectUtils.isEmpty(jedisCluster)){
            Assert.notEmpty(getHostAndPorts(),"HOST_AND_PORT_EMPTY");
            try {
                jedisCluster = new JedisCluster(hostAndPorts,this);
                Assert.notNull(jedisCluster,"JEDIS_CLUSTER_NULL");
                log.info("分布式redis实体成功创建!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            log.info("jedisCluster 实体已经存在,略过创建!");
        }
    }

    /**
     * 获取到操作实体
     *
     * @return
     */
    public Object getOperateEntity() {
        Assert.notNull(getJedisCluster(),"JEDIS_CLUSTER_NULL");
        return getJedisCluster();
    }

    public void addHostAndPort(HostAndPort hostAndPort){
        Assert.notNull(hostAndPort,"HOST_AND_PORT_EMPTY");
        getHostAndPorts().add(hostAndPort);
    }

    public JedisCluster getJedisCluster() {
        return jedisCluster;
    }

    public void setJedisCluster(JedisCluster jedisCluster) {
        this.jedisCluster = jedisCluster;
    }

    public HashSet<HostAndPort> getHostAndPorts() {
        return hostAndPorts;
    }

    public void setHostAndPorts(HashSet<HostAndPort> hostAndPorts) {
        this.hostAndPorts = hostAndPorts;
    }
}
