package cn.edu.bjfu.juc;

import static java.lang.Thread.sleep;

/**
 * volatile：当多个线程操作共享数据时，可以保证内存中的数据可见性
 *           相较于synchronized是一种较为轻量级的同步策略
 *           但是不具备“互斥性”，不能保证“原子性”
 * @author Chao Huaiyu
 * @date 2020/11/7
 */
public class VolatileTest {

    public static void main(String[] args) {
        ThreadDemo threadDemo = new ThreadDemo();
        new Thread(threadDemo).start();
        //可以通过加锁解决内存可见性问题，但是效率低
        while (true){
            if(threadDemo.isFlag()){
                System.out.println("-------while结束--------");
                break;
            }
        }
    }
}

/**
 * 存在数据可见性问题
 */
class ThreadDemo implements Runnable {

    private volatile boolean flag = false;

    @Override
    public void run() {
        try {
            sleep(200);
            setFlag(true);
            System.out.println("flag = " + isFlag());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
