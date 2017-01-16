import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.framework.service.RedisClusterDataSource;
import redis.framework.service.SingleRedisDataSource;
import redis.framework.util.RedisClusterUtil;
import redis.framework.util.RedisSingleUtil;

import java.io.IOException;

/**
 * Created by Fuzhong.Yan on 17/1/10.
 */
public class Test {
    public static void main(String[] args) throws IOException {
        testClusterRedis();
    }
    public static void testClusterRedis(){
        RedisClusterDataSource clusterRedisDataSource = new RedisClusterDataSource();
        clusterRedisDataSource.addHostAndPort(new HostAndPort("127.0.0.1", 7000));
        clusterRedisDataSource.addHostAndPort(new HostAndPort("127.0.0.1", 7001));
        clusterRedisDataSource.addHostAndPort(new HostAndPort("127.0.0.1", 7002));
        clusterRedisDataSource.addHostAndPort(new HostAndPort("127.0.0.1", 7003));
        clusterRedisDataSource.addHostAndPort(new HostAndPort("127.0.0.1", 7004));
        clusterRedisDataSource.addHostAndPort(new HostAndPort("127.0.0.1", 7005));
        clusterRedisDataSource.initBean();
        JedisCluster jedisCluster = clusterRedisDataSource.getJedisCluster();
        jedisCluster.set("12345","2345");
        RedisClusterUtil.initRedisCluster(clusterRedisDataSource);
        RedisClusterUtil.getJedisCluster().set("1234","2345");
    }
    public static void testSingleRedis(){
        SingleRedisDataSource singleRedisDataSource = new SingleRedisDataSource();
        singleRedisDataSource.setHost("127.0.0.1");
        singleRedisDataSource.setPort(6379);
        singleRedisDataSource.setTimeout(1000);
        singleRedisDataSource.setPassword("admin");
//        singleRedisDataSource.initUtil();
        singleRedisDataSource.initBean();
        singleRedisDataSource.getRedis().set("yfz","yfz");
        RedisSingleUtil.initJedisPool(singleRedisDataSource);
        RedisSingleUtil.getJedis().set("aaa123","1233");
    }
}
