package common.framework.annotation;

import common.framework.interfaces.AZ_AnnotationAspectLog;
import constant.AZ_LogType;
import org.springframework.stereotype.Service;

/**
 * Created by Fuzhong.Yan on 16/11/27.
 */
@Service("test")
public class AS_Test extends AZ_AnnotationAspectLog{
    @AZ_LogMethod(type = AZ_LogType.Log4j,appName = "123")
    public void before(AS_AspectBean bean) {
        System.out.println(1111111111);
    }
    public void after(AS_AspectBean bean) {

    }

    public void exception(AS_AspectBean bean, Throwable throwable) {

    }
}
