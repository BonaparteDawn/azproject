package common.framework.annotation;

import enums.AZ_LogTime;
import enums.AZ_LogType;

import java.lang.annotation.*;

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
     /**日志记录时机*/
     AZ_LogTime[] logTime() default {AZ_LogTime.AfterMethod,AZ_LogTime.BeforeMethod,AZ_LogTime.ExceptionMethod};
}