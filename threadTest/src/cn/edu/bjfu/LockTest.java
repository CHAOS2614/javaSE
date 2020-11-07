package cn.edu.bjfu;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Chaos
 */
public class LockTest {
    public static void main(String[] args) {
        Window windows = new Window();

        Thread thread1 = new Thread(windows);
        Thread thread2 = new Thread(windows);
        Thread thread3 = new Thread(windows);

        thread1.setName("窗口1");
        thread2.setName("窗口2");
        thread3.setName("窗口3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}


class Window implements Runnable {

    private int tickets = 100;
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();
                if (tickets > 0) {
                    System.out.println(Thread.currentThread().getName() + "买票，票号:" + tickets);
                    tickets--;
                } else
                    break;
            } finally {
                lock.unlock();
            }
        }
    }
}