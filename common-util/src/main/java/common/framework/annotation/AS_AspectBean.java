package common.framework.annotation;

import constant.AZ_LogType;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;


/**
 * Created by Fuzhong.Yan on 16/11/27.
 */
public class AS_AspectBean {
    private Object sourceLocation;
    private Object target;
    private Object[] args;
    private String kind;
    private JoinPoint.StaticPart staticPart;
    private Object thisObj;
    private Object result;
    private Signature signature;

    /**日志记录类型*/
    private AZ_LogType[] type;
    /**应用名*/
    private String appName;
    /**应用描述*/
    private String appDesc;

    public Object getSourceLocation() {
        return sourceLocation;
    }

    public void setSourceLocation(Object sourceLocation) {
        this.sourceLocation = sourceLocation;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public JoinPoint.StaticPart getStaticPart() {
        return staticPart;
    }

    public void setStaticPart(JoinPoint.StaticPart staticPart) {
        this.staticPart = staticPart;
    }

    public Object getThisObj() {
        return thisObj;
    }

    public void setThisObj(Object thisObj) {
        this.thisObj = thisObj;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }


    public void setSignature(Signature signature) {
        this.signature = signature;
    }

    public Signature getSignature() {
        return signature;
    }

    public AZ_LogType[] getType() {
        return type;
    }

    public void setType(AZ_LogType[] type) {
        this.type = type;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppDesc() {
        return appDesc;
    }

    public void setAppDesc(String appDesc) {
        this.appDesc = appDesc;
    }
}
