package cn.edu.bjfu;

/**
 * @author Chaos
 */
public class WindowsExtends extends Thread {

    private static int tickets = 100;
    private static final Object OBJECT_SYNCHRONIZED = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (OBJECT_SYNCHRONIZED) {
                if (tickets > 0) {
                    System.out.println(Thread.currentThread().getName() + "买票，票号:" + tickets);
                    tickets--;
                } else {
                    break;
                }
            }
        }
    }
}
