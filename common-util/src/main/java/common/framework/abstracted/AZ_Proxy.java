package common.framework.abstracted;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 代理抽象类
 * @author Fuzhong.Yan
 */
public abstract class AZ_Proxy<E> implements InvocationHandler {
    private E target;

    public AZ_Proxy(E target) {
        this.target = target;
    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before(proxy, method, args);
        Object result = method.invoke(target, args);
        after(proxy, method,args,result);
        return result;
    }
    public abstract void before(Object proxy, Method method, Object[] args);
    public abstract void after(Object proxy, Method method,Object[] args,Object result);
}
