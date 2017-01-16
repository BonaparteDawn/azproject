package redis.framework.abstracted;

import redis.framework.bean.RedisDataSource;

import java.util.Properties;

/**
 * Redis数据源
 * Created by Fuzhong.Yan on 17/1/10.
 */
public abstract class AbstractRedisDatasource extends RedisDataSource{

    /**
     * 初始化实用实体
     */
    public abstract void initUtil();

    /**
     * 初始化数据源
     */
    public abstract void initBean();

    /**
     * 获取到操作实体
     * @return
     */
    public abstract  Object getOperateEntity();
}