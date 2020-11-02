package cn.edu.bjfu.proxy.staticproxy;

/**
 * 被代理类
 * @author Chaos
 */
public class NikeClothFactory implements ClothFactory{

    @Override
    public void produceCloth() {
        System.out.println("Nike生产衣服中。。。。。。");
    }
}
