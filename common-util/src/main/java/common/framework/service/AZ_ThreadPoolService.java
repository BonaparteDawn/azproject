package common.framework.service;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;

import common.framework.interfaces.Log;
import enums.AZ_LogType;
import org.springframework.util.Assert;
/**
 * 线程池
 * @author Fuzhong.Yan
 */
public class AZ_ThreadPoolService {
    private Log log = AZ_LogFactory.productLog(AZ_LogType.Log4j,AZ_ThreadPoolService.class);
    private int DEFAULT_THREADS_NUMBER = 3;
    private  ExecutorService executorService = null;
    public AZ_ThreadPoolService(){
        executorService = new ScheduledThreadPoolExecutor(DEFAULT_THREADS_NUMBER);
        Runtime.getRuntime().addShutdownHook(new Thread(new AZ_ThreadPoolService.ThreadShutdownHook()));
    }
    public AZ_ThreadPoolService(Integer threadNumber){
        if (threadNumber != null && threadNumber > 0) {
            DEFAULT_THREADS_NUMBER = threadNumber;
        }
        executorService = new ScheduledThreadPoolExecutor(DEFAULT_THREADS_NUMBER);
        Runtime.getRuntime().addShutdownHook(new Thread(new AZ_ThreadPoolService.ThreadShutdownHook()));
    }
    /**
     * 所有的对象不能够有循环方法，否则会一直占用线程池里面的某个线程
     * @param runnables
     */
    public void execute(Runnable ... runnables){
        Assert.notNull(executorService,"executorService_null");
        for (Runnable runnable : runnables) {
            executorService.execute(runnable);
        }
    }
    /**
     * 所有的对象不能够有循环方法，否则会一直占用线程池里面的某个线程
     * @param runnable
     */
    public Future<?> submit(Runnable runnable){
        Assert.notNull(executorService,"executorService_null");
        return executorService.submit(runnable);
    }
    public List<Runnable> shutdownNow(){
        return this.executorService.shutdownNow();
    }
    public void shutdown(){
        this.executorService.shutdown();
    }
    class ThreadShutdownHook implements Runnable{
        public void run() {
            AZ_ThreadPoolService.this.shutdownNow();
            log.info("线程池关闭");
        }
    }
}
