package cn.edu.bjfu;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
    public static void main(String[] args) {

       ExecutorService service = Executors.newFixedThreadPool(10);

       service.execute(new NumberThread());
       service.submit(new NumberThread());

       service.shutdown();
    }
}

class NumberThread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
    }
}