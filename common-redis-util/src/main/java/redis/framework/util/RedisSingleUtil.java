package redis.framework.util;

import common.framework.util.ObjectUtils;
import org.springframework.util.Assert;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.framework.service.SingleRedisDataSource;

public final class RedisSingleUtil {
    private static SingleRedisDataSource datasource;
    private static JedisPool jedisPool = null;

    /**
     * 初始化Redis连接池
     */
    public synchronized static void initJedisPool() {
        try {
            jedisPool = new JedisPool(datasource, datasource.getHost(), datasource.getPort(), datasource.getTimeout(), datasource.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized static void initJedisPool(SingleRedisDataSource temp){
        if (ObjectUtils.isNotEmpty(jedisPool)){
            jedisPool.destroy();
        }
        Assert.notNull(temp,"REDIS_DATASOURCE_NULL");
        Assert.notNull(temp.getHost(),"REDIS_HOST_NULL");
        Assert.notNull(temp.getPort(),"REDIS_PORT_NULL");
        datasource = temp;
        initJedisPool();
    }

    /**
     * 获取Jedis实例
     * @return
     */
    public synchronized static Jedis getJedis() {
        Jedis resource = null;
        try {
            if (jedisPool != null) {
                resource = jedisPool.getResource();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resource;
    }

    /**
     * 释放jedis资源
     * @param jedis
     */
    public static void returnResource(final Jedis jedis) {
        if (jedis != null) {
            jedisPool.returnResource(jedis);
        }
    }
}