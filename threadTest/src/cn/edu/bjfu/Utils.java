package cn.edu.bjfu;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @author Chao Huaiyu
 * @date 2020/11/7
 */
public class Utils {

    private static ExecutorService executorService = new ThreadPoolExecutor(10,
            20,
            200L,
            TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(),
            new ThreadFactoryBuilder().setNameFormat("retryClient-pool-%d").build());

    public static ExecutorService getExecutorService(){

        return executorService;
    }

    public static void shutdownPool(){
        executorService.shutdown();
    }
}
