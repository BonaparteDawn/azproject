package common.framework.util;

import common.framework.abstracted.AZ_Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 代理工具类
 * @author Fuzhong.Yan
 */
public class ProxyUtil {
    private static ClassLoader CLASS_LODER = EnvironmentUtil.getClassLoader();
    public static <E> E newProxyInstance(Object object,InvocationHandler handler) {
        Class<?>[] interfaces = object.getClass().getInterfaces();
        return (E) Proxy.newProxyInstance(CLASS_LODER, interfaces, handler);
    }
    public static <E> E newProxyInstance(Object object,Class<?> invocationHandlerClass) throws Exception{
        E res = null;
        if (invocationHandlerClass.getSuperclass().equals(AZ_Proxy.class)) {
            AZ_Proxy<?> handler = ReflectUtil.newInstance(invocationHandlerClass, object);
            Class<?>[] interfaces = object.getClass().getInterfaces();
            res = (E) Proxy.newProxyInstance(CLASS_LODER, interfaces, handler);
        }else {
            throw new NoSuchMethodException("superclass_exception");
        }
        return res;
    }
}
