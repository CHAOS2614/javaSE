package cn.edu.bjfu.proxy.proxy;

/**
 * @author Chao Huaiyu
 * @date 2020/11/2
 */
public interface Human {
    /**
     * 获得确定人的信仰
     * @return 人的信仰
     */
    String getBelief();

    /**
     * 人吃饭
     * @param food 食物
     */
    void eat(String food);
}
