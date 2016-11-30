package common.framework.annotation;

import constant.AZ_LogType;

import java.lang.annotation.*;
import java.util.List;

/**
 * Created by Fuzhong.Yan on 16/11/27.
 * 记录日志的标签
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface AZ_LogMethod {
     /**日志记录类型*/
     AZ_LogType[] type();
     /**应用名*/
     String appName();
     /**应用描述*/
     String appDesc() default "";

}