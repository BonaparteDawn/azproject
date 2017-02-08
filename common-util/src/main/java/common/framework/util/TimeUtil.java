package common.framework.util;

import org.springframework.util.Assert;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Fuzhong.Yan on 17/2/8.
 */
public class TimeUtil {
    /**
     * 单位:毫秒
     */
    public static long M_SECOND = 1;
    /**
     * 单位:秒
     */
    public static long SECOND = 1000 * M_SECOND;
    /**
     * 单位:分
     */
    public static long MINUTE = 60 * SECOND;
    /**
     * 单位:小时
     */
    public static long HOUR = 60 * MINUTE;
    /**
     * 单位:小时
     */
    public static long DAY = 24 * HOUR;
    /**
     * 单位:周
     */
    public static long WEEK = 7 * DAY;

    public static Date currentTime(){
        return EnvironmentUtil.getOperatingSystemCurrentTime();
    }
    public static Date addYear(int year){
        return addYear(currentTime(),year);
    }
    public static Date addYear(Date date,int year){
        Calendar calendar = newInstance();
        calendar.setTime(date);
        calendar.set(Calendar.YEAR,calendar.get(Calendar.YEAR)+1);
        return calendar.getTime();
    }
    public static GregorianCalendar newInstance(){
        return new GregorianCalendar();
    }

    /**
     * 两个时间之差
     * @param end
     * @param start
     * @return
     */
    public static long difference2Long(Date end,Date start){
        Assert.notNull(end,"timeUtil_end_exception");
        Assert.notNull(end,"timeUtil_start_exception");
        long res = end.getTime() - start.getTime();
        if (res < 0){
            new IllegalArgumentException("start_end_compare_exception");
        }
        return res;
    }
}
