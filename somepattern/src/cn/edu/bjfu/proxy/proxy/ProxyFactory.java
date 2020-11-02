package cn.edu.bjfu.proxy.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 问题一：如何根据加载到内存中的被代理类，动态的创建一个代理类及其对象
 * 问题二：当通过代理类的对象调用方法是，如何动态的去调用被代理类中的同名方法
 *
 * @author Chao Huaiyu
 * @date 2020/11/2
 */
public class ProxyFactory {
    /**
     * 返回一个代理类对象，解决问题一
     *
     * @param object 被代理类
     * @return 代理类对象（类似于接口的匿名实现类，我们没有写这个对象对应的类）
     */
    public static Object getProxyInstance(Object object) {
        MyInvocationHandler handler = new MyInvocationHandler();
        handler.bind(object);
        return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), handler);
    }
}

class MyInvocationHandler implements InvocationHandler {

    /**
     * 被代理类对象
     */
    private Object object;

    /**
     * 对被代理类进行赋值
     *
     * @param object 被代理类
     */
    public void bind(Object object) {
        this.object = object;
    }

    /**
     * 当我们通过代理类对象调用方法a时，就会自动调用invoke（）
     * 将被代理类要执行的方法a的功能就声明在invoke（）中
     *
     * @param proxy  代理类
     * @param method 代理类对象调用的方法，也就作为了被代理类对象要调用的方法
     * @param args   方法的参数
     * @return method的返回值
     * @throws Throwable 异常
     */
    @Override

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object returnValue = method.invoke(object, args);
        return returnValue;
    }
}
