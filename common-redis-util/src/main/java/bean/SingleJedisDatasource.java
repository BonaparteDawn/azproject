package bean;

import abstracted.AbstractRedisDatasource;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisShardInfo;

import java.util.Properties;

/**
 * Created by Fuzhong.Yan on 17/1/10.
 */
public class SingleJedisDatasource extends AbstractRedisDatasource{
    private int timeout;
    private String host;
    private int port;
    private String password;
    private String name;
    private Properties properties;

}
