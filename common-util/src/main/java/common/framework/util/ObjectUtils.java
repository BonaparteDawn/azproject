package common.framework.util;

import java.io.*;
import java.util.List;
import java.util.Map;

/**
 * Created by Fuzhong.Yan on 16/11/9.
 */
public class ObjectUtils {
    /**
     * 判断对象为空
     * @param temp
     * @return
     */
    public static boolean isEmpty(Object temp){
        boolean res = false;
        if (temp == null){
            res = true;
        }
        if (temp instanceof String){
            if ("".equals(temp)){
                return true;
            }
        }else if (temp instanceof List){
            List list = (List) temp;
            if (list.size()==0){
                return true;
            }
        }else if (temp instanceof Map){
            Map map  = (Map) temp;
            if (map.size()==0){
                return true;
            }
        }
        return res;
    }

    /**
     * 判断对象不为空
     * @param temp
     * @return
     */
    public static boolean isNotEmpty(Object temp){
        return !isEmpty(temp);
    }


    /**
     * 判断对象均不为空
     * @param temp
     * @return
     */
    public static boolean isNotEmpty(Object ...temp){
        if (temp == null){
            return false;
        }
        boolean res = false;
        for (Object o : temp){
            if (isEmpty(o)){
                res = false;
                break;
            }
        }
        return res;
    }

    /**
     * 序列化对象到文件
     * @param object
     * @param path
     * @return
     * @throws Exception
     */
    public static boolean writeObject(Object object,String path) throws  Exception{
        if (isEmpty(object) || isEmpty(path)){
            return false;
        }
        FileOutputStream fileOutputStream = new FileOutputStream(new File(path));
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(object);
        objectOutputStream.flush();
        objectOutputStream.close();
        fileOutputStream.close();
        return true;
    }

    /**
     * 反序列化对象
     * @param path
     * @return
     * @throws Exception
     */
    public static Object readObject(String path) throws  Exception{
        if (isEmpty(path)){
            return false;
        }
        Object res = null;
        FileInputStream fileInputStream = new FileInputStream(new File(path));
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        res = objectInputStream.readObject();
        objectInputStream.close();
        fileInputStream.close();
        return res;
    }
    public static <T> T setValue(T value,T defaultValue){
        T t = value;
        if (ObjectUtils.isEmpty(value)){
            t = defaultValue;
        }
        return t;
    }
}
