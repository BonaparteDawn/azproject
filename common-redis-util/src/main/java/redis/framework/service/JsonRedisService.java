package redis.framework.service;

import common.framework.interfaces.JsonSerializable;
import common.framework.interfaces.Log;
import common.framework.service.AZ_LogFactory;
import common.framework.util.JsonUtil;
import common.framework.util.ObjectUtils;
import enums.AZ_LogType;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;
import redis.clients.jedis.JedisCommands;
import redis.framework.interfaced.RedisApi;
import redis.framework.util.RedisClusterUtil;
import redis.framework.util.RedisSingleUtil;

/**
 * Created by Fuzhong.Yan on 17/1/16.
 */
public class JsonRedisService implements RedisApi,InitializingBean,JsonSerializable {
    private Log log = AZ_LogFactory.productLog(AZ_LogType.Log4j,JsonRedisService.class);

    private JedisCommands jedisCommands = null;

    /**
     * 保存到Redis里面
     *
     * @param t
     * @return
     */
    public <T> boolean save(String key,T t) {
        boolean res = false;
        Assert.hasLength(key,"KEY_NO_LEN");
        Assert.notNull(t,"SAVE_DATE_NULL");
        Assert.notNull(jedisCommands,"JEDIS_COMMAND_NULL");
        String value = JsonUtil.toJson(t);
        String temp  = jedisCommands.set(key,value);
        if (ObjectUtils.isNotEmpty(temp)){
            res = true;
            log.info("保存key="+key+";value="+t+";成功!");
        }else {
            log.info("保存key="+key+";value="+t+";失败!");
        }
        return res;
    }

    /**
     * 读取对象
     *
     * @param key
     * @return
     */
    public <T> T read(String key,Class<T> c) {
        T  t = null;
        Assert.hasLength(key,"KEY_NO_LEN");
        Assert.notNull(c,"CLASS_NULL");
        Assert.notNull(jedisCommands,"JEDIS_COMMAND_NULL");
        String value = jedisCommands.get(key);
        if (ObjectUtils.isNotEmpty(value)){
            t = JsonUtil.toObject(value,c);
            log.info("读取key="+key+"的值成功!");
        }else {
            log.info("读取key="+key+"的值失败!");
        }
        return t;
    }

    /**
     * 删除指定key的值
     *
     * @param key
     * @return
     */
    public boolean delete(String key) {
        Assert.hasLength(key,"KEY_NO_LEN");
        Assert.notNull(jedisCommands,"JEDIS_COMMAND_NULL");
        boolean res = false;
        Long t = jedisCommands.del(key);
        if (t == 1){
            res = true;
            log.info("删除key="+key+"的值成功!");
        }else {
            log.info("删除key="+key+"的值失败!");
        }
        return res;
    }

    public JedisCommands getJedisCommands() {
        return jedisCommands;
    }

    public void setJedisCommands(JedisCommands jedisCommands) {
        this.jedisCommands = jedisCommands;
    }

    public void afterPropertiesSet() throws Exception {
        if (ObjectUtils.isEmpty(getJedisCommands())){
            if (ObjectUtils.isNotEmpty(RedisSingleUtil.getJedis())){
                setJedisCommands(RedisSingleUtil.getJedis());
                return;
            }
            if (ObjectUtils.isNotEmpty(RedisClusterUtil.getJedisCluster())){
                setJedisCommands(RedisClusterUtil.getJedisCluster());
                return;
            }
        }
    }
}
