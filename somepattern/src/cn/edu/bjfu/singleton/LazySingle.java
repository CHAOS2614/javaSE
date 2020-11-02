package cn.edu.bjfu.singleton;

/**
 * 线程安全的懒汉式单例模式
 *
 * @author Chao Huaiyu
 * @date 2020/11/2
 */
public class LazySingle {

    private static LazySingle instance;

    private LazySingle() {
    }

    /**
     * 获取类的单例实例，线程安全且效率较高
     *
     * @return 类的唯一实例
     */
    public static LazySingle getInstance() {
        if (instance == null) {
            synchronized (LazySingle.class) {
                if (instance == null) {
                    instance = new LazySingle();
                }
            }
        }
        return instance;
    }
}
