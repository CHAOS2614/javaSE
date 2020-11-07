package cn.edu.bjfu;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @author Chaos
 */
public class ThreadPool {
    public static void main(String[] args) {

        NumberThread numberThread = new NumberThread();
        ThreadFactory namedFactory = new ThreadFactoryBuilder().setNameFormat("retryClient-pool-%d").build();
        ExecutorService executorService = new ThreadPoolExecutor(10,
                20,
                200L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(),
                namedFactory);

        executorService.execute(numberThread);
        executorService.execute(numberThread);
    }
}

class NumberThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }
}