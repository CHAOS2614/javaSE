package cn.edu.bjfu.proxy;

/**
 * 静态代理模式简单示例
 *
 * 特点：代理类和被代理类在编译期间就确定下来了
 *      随着代理类的增加会增加内存占用
 *
 * @author Chao Huaiyu
 * @date 2020/11/2
 */

interface ClothFactory {
    /**
     * 衣服工厂，制造衣服
     */
    void produceCloth();
}

/**
 * 代理类
 */
class ProxyClothFactory implements ClothFactory {

    /**
     * 用被代理类对象进行实例化
     */
    private ClothFactory factory;

    public ProxyClothFactory(ClothFactory factory) {
        this.factory = factory;
    }

    @Override
    public void produceCloth() {
        System.out.println("代理做一些准备工作。。。。。。");

        factory.produceCloth();

        System.out.println("代理做一些后续工作。。。。。。");
    }
}

/**
 * 被代理类
 */
class NikeClothFactory implements ClothFactory{

    @Override
    public void produceCloth() {
        System.out.println("Nike生产衣服中。。。。。。");
    }
}

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














