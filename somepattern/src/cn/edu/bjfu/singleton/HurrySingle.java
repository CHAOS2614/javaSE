package cn.edu.bjfu.singleton;

/**
 * 饿汉式单利模式，本身就是线程安全的，缺点可能是占用内存
 * @author Chao Huaiyu
 * @date 2020/11/2
 */
public class HurrySingle {

    private static HurrySingle instance = new HurrySingle();
    private HurrySingle(){}

    public static HurrySingle getInstance(){
        return instance;
    }
}
