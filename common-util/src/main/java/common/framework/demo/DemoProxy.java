package common.framework.demo;

import common.framework.abstracted.AZ_Proxy;

import java.lang.reflect.Method;

/**
 * Created by Fuzhong.Yan on 17/2/6.
 */
public class DemoProxy extends AZ_Proxy<DemoPeople> {

    public DemoProxy(DemoPeople target) {
        super(target);
    }

    public void before(Object proxy, Method method, Object[] args) {
        System.out.println("之前。。。");
    }

    public void after(Object proxy, Method method, Object[] args, Object result) {
        System.out.println("之后。。。");
    }
}
