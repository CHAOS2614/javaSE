package cn.edu.bjfu;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @author Chaos
 */
public class ThreadPool {
    public static void main(String[] args) {

        ThreadFactory namedFactory = new ThreadFactoryBuilder().setNameFormat("retryClient-pool-%d").build();
        ExecutorService executorService = new ThreadPoolExecutor(10,
                20,
                200L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(),
                namedFactory);
    }
}

class NumberThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
    }
}