package common.framework.util;

import common.framework.demo.DemoPeople;
import common.framework.demo.DemoProxy;
import common.framework.demo.DemoRun;
import org.junit.Test;

/**
 * Created by Fuzhong.Yan on 17/2/6.
 */
public class ProxyUtilTest {
    @Test
    public void newProxyInstance() throws Exception {
        DemoPeople people = new DemoPeople();
        DemoRun a = ProxyUtil.newProxyInstance(people, new DemoProxy(people));
        a.run();
    }

    @Test
    public void newProxyInstance1() throws Exception {
        DemoPeople people = new DemoPeople();
        DemoRun a = ProxyUtil.newProxyInstance(people,DemoProxy.class);
        a.run();
    }
}