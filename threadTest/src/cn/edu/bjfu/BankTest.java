package cn.edu.bjfu;

/**
 * 懒汉单例模式线程安全方法解决
 *
 * @author chaos
 */
public class BankTest {}

class Bank {
    private Bank() {
    }

    private static Bank instance = null;

    public static Bank getInstance() {
        /*synchronized (Bank.class){
            if(instance==null)
                instance = new Bank();
            return instance;
        }*/

        if (instance == null) {
            synchronized (Bank.class) {
                if (instance == null) {
                    instance = new Bank();
                }
            }
        }
        return instance;
    }
}