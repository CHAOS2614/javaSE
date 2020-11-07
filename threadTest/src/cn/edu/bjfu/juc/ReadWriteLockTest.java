package cn.edu.bjfu.juc;

import cn.edu.bjfu.Utils;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author Chao Huaiyu
 * @date 2020/11/7
 */
public class ReadWriteLockTest {

    public static void main(String[] args) {
        ReadWrite readWrite = new ReadWrite();

        Utils.getExecutorService().execute(new Runnable() {
            @Override
            public void run() {
                readWrite.set(10);
            }
        });

        for (int i = 0; i < 10; i++) {
            Utils.getExecutorService().execute(new Runnable() {
                @Override
                public void run() {
                    readWrite.get();
                }
            });
        }
    }
}

class ReadWrite {
    private int number = 0;
    private ReadWriteLock rw = new ReentrantReadWriteLock();

    public void get() {
        rw.readLock().lock();
        try {
            System.out.println(number);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rw.readLock().unlock();
        }
    }

    public void set(int number) {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        rw.writeLock().lock();
        try {

            System.out.println(number);
            this.number = number;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rw.writeLock().unlock();
        }
    }
}
