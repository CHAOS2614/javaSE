package come.bjfu;

/**
 * @author Chaos
 */
public class ThreadTest {
    public static void main(String[] args) {

        WindowsExtends windows1 = new WindowsExtends();
        WindowsExtends windows2 = new WindowsExtends();
        WindowsExtends windows3 = new WindowsExtends();

        windows1.setName("窗口1");
        windows2.setName("窗口2");
        windows3.setName("窗口3");

        windows1.start();
        windows2.start();
        windows3.start();
        /*
        WindowsImplements windows = new WindowsImplements();

        Thread thread1 = new Thread(windows);
        Thread thread2 = new Thread(windows);
        Thread thread3 = new Thread(windows);

        thread1.setName("window1");
        thread2.setName("window2");
        thread3.setName("window3");

        thread1.start();
        thread2.start();
        thread3.start();
        */
    }
}