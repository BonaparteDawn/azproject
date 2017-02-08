package common.framework.util;

import common.framework.service.AZ_ThreadPoolService;

/**
 * Created by Fuzhong.Yan on 17/1/18.
 */
public class ThreadUtil {
    /**
     * 线程池
     */
    private static AZ_ThreadPoolService THREAD_POOL_SERVICE = null;

    /**
     * 线程池里面的处理线程数量
     */
    private static int DEFAULTTHREADNUMBER = 3;
    static {
        THREAD_POOL_SERVICE = new AZ_ThreadPoolService(DEFAULTTHREADNUMBER);
    }

    /**
     * 创建一个守护线程
     * @param runnable
     * @param name
     * @return
     */
    public static Thread createThread(Runnable runnable,String name){
        Thread thread = new Thread(runnable,name);
        thread.setDaemon(true);
        return thread;
    }

    /**
     * 获取线程池
     * @return
     */
    public static AZ_ThreadPoolService getThreadPool(){
        return THREAD_POOL_SERVICE;
    }

    /**
     *创建一个线程池
     * @param thread_number
     * @return
     */
    public static AZ_ThreadPoolService createThreadPool(int thread_number){
        if (thread_number <= 0){
            thread_number = DEFAULTTHREADNUMBER;
        }
        return new AZ_ThreadPoolService(thread_number);
    }
}
