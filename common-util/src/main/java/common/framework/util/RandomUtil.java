package common.framework.util;

import java.util.Random;
import java.util.UUID;

/**
 * Created by Fuzhong.Yan on 17/1/18.
 */
public class RandomUtil {
    /**
     * 创建一个UUID值
     * @return
     */
    public static String generate32UUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }
    public static int rand(){
        Random random = new Random();
        return random.nextInt();
    }
    public static int rand(int max){
        Random random = new Random();
        return random.nextInt(max);
    }
    public static int rand(int min,int max){
        if (min < 0){
            min = 0;
        }
        if (max < 0) {
            throw new IllegalArgumentException("max_illegal");
        }
        if (min > max){
            int temp = min;
            min = max;
            max = temp;
        }
        return min + rand(max - min);
    }
}
