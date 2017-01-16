package redis.framework.interfaced;

/**
 * Created by Fuzhong.Yan on 17/1/16.
 */
public interface RedisApi {
    /**
     * 保存到Redis里面
     * @param t
     * @param <T>
     * @return
     */
    public <T> boolean save(String key,T t);

    /**
     * 读取对象
     * @param key
     * @param <T>
     * @return
     */
    public <T> T read(String key,Class<T> tClass);

    /**
     * 删除指定key的值
     * @param key
     * @return
     */
    public boolean delete(String key);


}
