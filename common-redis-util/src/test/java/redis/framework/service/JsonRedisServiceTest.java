package redis.framework.service;

import common.framework.util.ObjectUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCommands;
import redis.framework.bean.RedisDataSource;
import redis.framework.interfaced.RedisApi;
import redis.framework.util.RedisClusterUtil;

import static org.junit.Assert.*;

/**
 * Created by Fuzhong.Yan on 17/1/16.
 */
public class JsonRedisServiceTest {
    private String name = "JsonRedisService";
    private RedisApi redisApi = null;
    @Before
    public void setUp() throws Exception {
        RedisClusterDataSource clusterRedisDataSource = new RedisClusterDataSource();
        clusterRedisDataSource.addHostAndPort(new HostAndPort("127.0.0.1", 7000));
        clusterRedisDataSource.addHostAndPort(new HostAndPort("127.0.0.1", 7001));
        clusterRedisDataSource.addHostAndPort(new HostAndPort("127.0.0.1", 7002));
        clusterRedisDataSource.addHostAndPort(new HostAndPort("127.0.0.1", 7003));
        clusterRedisDataSource.addHostAndPort(new HostAndPort("127.0.0.1", 7004));
        clusterRedisDataSource.addHostAndPort(new HostAndPort("127.0.0.1", 7005));
        clusterRedisDataSource.initUtil();
        JsonRedisService jsonRedisService = new JsonRedisService();
        jsonRedisService.afterPropertiesSet();
        redisApi = jsonRedisService;
    }

    @Test
    public void test() throws Exception{
        String key = "test";
        RedisDataSource value = new RedisDataSource();
        value.setMaxIdle(10000);
        save(key,value);
        read(key);
        del(key);
    }

    public void save(String key ,Object value) throws Exception {
        key = ObjectUtils.setValue(key,"test");
        value = ObjectUtils.setValue(value,new RedisDataSource());
        boolean res = redisApi.save("test",value);
        Assert.assertTrue(name + "保持失败",res);
    }

    public void read(String key) throws Exception {
        key = ObjectUtils.setValue(key,"test");
        RedisDataSource value = redisApi.read("test",RedisDataSource.class);
        Assert.assertNotNull(name+"读取失败",value);
        System.out.println(value.getMaxIdle());
    }
    public void del(String key) throws Exception {
        key = ObjectUtils.setValue(key,"test");
        boolean res = redisApi.delete("test");
        Assert.assertTrue(name+"删除失败",res);
    }
}