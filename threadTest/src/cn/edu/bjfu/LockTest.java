package cn.edu.bjfu;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Chaos
 */
public class LockTest {
    public static void main(String[] args) {
        Window windows = new Window();

        Utils.getExecutorService().execute(windows);
        Utils.getExecutorService().execute(windows);
        Utils.getExecutorService().execute(windows);

    }
}


class Window implements Runnable {

    private int tickets = 100;
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            lock.lock();
            try {
                if (tickets > 0) {
                    System.out.println(Thread.currentThread().getName() + "买票，票号:" + tickets);
                    tickets--;
                } else{
                    break;
                }
            } finally {
                lock.unlock();
            }
        }
    }
}