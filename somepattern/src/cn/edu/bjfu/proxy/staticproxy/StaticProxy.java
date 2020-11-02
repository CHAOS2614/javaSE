package cn.edu.bjfu.proxy.staticproxy;

/**
 * 静态代理模式简单示例
 *
 * 特点：代理类和被代理类在编译期间就确定下来了
 *      随着代理类的增加会增加内存占用
 *
 * @author Chao Huaiyu
 * @date 2020/11/2
 */

/**
 * @author Chaos
 */
public class StaticProxy {
    public static void main(String[] args) {
        ClothFactory nike = new NikeClothFactory();
        ClothFactory proxyFactory = new ProxyClothFactory(nike);
        proxyFactory.produceCloth();
    }
}














