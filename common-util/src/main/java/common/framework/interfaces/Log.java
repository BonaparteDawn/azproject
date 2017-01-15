package common.framework.interfaces;

/**
 * Created by Fuzhong.Yan on 17/1/10.
 */
public interface Log {
    public void info(String info);
    public void debug(String debug);
    public void error(String error);
    public void info(String info,Throwable t);
    public void debug(String debug,Throwable t);
    public void error(String error,Throwable t);
}
