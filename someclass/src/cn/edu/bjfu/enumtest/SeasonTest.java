package cn.edu.bjfu.enumtest;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * @author Chao Huaiyu
 * @date 2020/10/23
 */
public class SeasonTest {

    public static void main(String[] args) {
        Season spring = Season.SPRING;

        System.out.println(spring);
    }
}

enum Season{
    /**
     * 春天
     */
    SPRING("春天","春暖花开"),
    /**
     * 夏天
     */
    SUMMER("夏天","夏日炎炎"),
    /**
     * 秋天
     */
    AUTUMN("春天","秋高气爽"),
    /**
     * 冬天
     */
    WINTER("春天","冰天雪地");

    private final String name;
    private final String description;

    Season(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @NotNull
    @Contract(pure = true)
    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}