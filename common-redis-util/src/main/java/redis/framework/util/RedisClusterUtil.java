package redis.framework.util;

import common.framework.util.ObjectUtils;
import org.springframework.util.Assert;
import redis.clients.jedis.JedisCluster;
import redis.framework.service.RedisClusterDataSource;

/**
 * Created by Fuzhong.Yan on 17/1/15.
 */
public class RedisClusterUtil {
    private static RedisClusterDataSource datasource;
    private static JedisCluster jedisCluster;
    /**
     * 初始化Redis连接池
     */
    public synchronized static void initRedisCluster() {
        try {
            Assert.notNull(datasource,"REDIS_DATASOURCE_NULL");
            Assert.notEmpty(datasource.getHostAndPorts(),"HOST_AND_PORT_EMPTY");
            jedisCluster = new JedisCluster(datasource.getHostAndPorts(),datasource);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized static void initRedisCluster(RedisClusterDataSource temp){
        if (ObjectUtils.isNotEmpty(jedisCluster)){
            jedisCluster.close();
        }
        Assert.notNull(temp,"REDIS_DATASOURCE_NULL");
        Assert.notEmpty(temp.getHostAndPorts(),"HOST_AND_PORT_EMPTY");
        datasource = temp;
        initRedisCluster();
    }

    /**
     * 获取Jedis实例
     * @return
     */
    public synchronized static JedisCluster getJedisCluster() {
        try {
            if (jedisCluster != null) {
                return jedisCluster;
            } else {
                initRedisCluster();
                return jedisCluster;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
