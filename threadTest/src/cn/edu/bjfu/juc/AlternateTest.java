package cn.edu.bjfu.juc;

import cn.edu.bjfu.Utils;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Chao Huaiyu
 * @date 2020/11/7
 */
public class AlternateTest {

    public static void main(String[] args) {
        AlternateDemo alternateDemo = new AlternateDemo();

        Utils.getExecutorService().execute(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 20; i++) {
                    alternateDemo.loopA(i);
                }
            }
        });

        Utils.getExecutorService().execute(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 20; i++) {
                    alternateDemo.loopB(i);
                }
            }
        });

        Utils.getExecutorService().execute(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 20; i++) {
                    alternateDemo.loopC(i);
                    System.out.println("-----------" + i + "-----------");
                }
            }
        });
    }
}

class AlternateDemo {
    private int number = 1;

    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    public void loopA(int totalLoop) {
        lock.lock();
        try {
            if (number != 1) {
                condition1.await();
            }
            for (int i = 1; i <= 1; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i + "\t" + totalLoop);
            }
            number = 2;
            condition2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public void loopB(int totalLoop) {
        lock.lock();
        try {
            if (number != 2) {
                condition2.await();
            }
            for (int i = 1; i <= 2; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i + "\t" + totalLoop);
            }
            number = 3;
            condition3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void loopC(int totalLoop) {
        lock.lock();
        try {
            if (number != 3) {
                condition3.await();
            }
            for (int i = 1; i <= 3; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i + "\t" + totalLoop);
            }
            number = 1;
            condition1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
