package cn.edu.bjfu.proxy.proxy;

/**
 * @author Chao Huaiyu
 * @date 2020/11/2
 */
public class SuperMan implements Human{

    @Override
    public String getBelief() {
        return "I can fly";
    }

    @Override
    public void eat(String food) {
        System.out.println("I eat " + food);
    }
}
