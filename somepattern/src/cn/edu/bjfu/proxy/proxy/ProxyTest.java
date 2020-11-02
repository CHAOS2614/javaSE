package cn.edu.bjfu.proxy.proxy;

import cn.edu.bjfu.proxy.staticproxy.ClothFactory;
import cn.edu.bjfu.proxy.staticproxy.NikeClothFactory;

/**
 * @author Chao Huaiyu
 * @date 2020/11/2
 */
public class ProxyTest {
    public static void main(String[] args) {

        SuperMan superMan = new SuperMan();
        //proxyInstance：代理类对象
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superMan);
        System.out.println(proxyInstance.getBelief());
        proxyInstance.eat("巧克力！");

        System.out.println("*****动态性，换一个被代理类*****");

        NikeClothFactory nikeClothFactory = new NikeClothFactory();
        ClothFactory proxyInstance1 = (ClothFactory) ProxyFactory.getProxyInstance(nikeClothFactory);
        proxyInstance1.produceCloth();
    }
}
