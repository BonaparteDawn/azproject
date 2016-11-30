package common.framework.util;

/**
 * Created by Fuzhong.Yan on 16/11/9.
 */
public class StringUtils{
    /**
     * 判断字符串是空
     * @param temp
     * @return
     */
    public static boolean isEmpty(String temp){
        boolean res = false;
        if (temp == null || "".equals(temp)){
            res = true;
        }
        return res;
    }

    /**
     * 判断字符串不为空
     * @param temp
     * @return
     */
    public static boolean isNotEmpty(String temp){
        return !isEmpty(temp);
    }

}
