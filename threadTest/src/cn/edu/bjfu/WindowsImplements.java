package cn.edu.bjfu;

/**
 * @author Chaos
 */
public class WindowsImplements implements Runnable {

    private int tickets = 100;

    @Override
    public void run() {
        while (tickets > 0) {
            synchronized (this) {
                if (tickets < 1) {
                    break;
                }
                System.out.println(Thread.currentThread().getName() + "买票，票号:" + tickets);
                tickets--;
            }
        }
    }
}

