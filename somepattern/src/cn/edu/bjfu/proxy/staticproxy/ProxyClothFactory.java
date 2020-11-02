package cn.edu.bjfu.proxy.staticproxy;

/**
 * 代理类
 * @author Chao Huaiyu
 * @date 2020/11/2
 */
public class ProxyClothFactory implements ClothFactory {

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