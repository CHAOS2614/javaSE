package cn.edu.bjfu.lambda;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @author Chao Huaiyu
 * @date 2020/11/2
 */
public class LambdaTest {


    /**
     * 格式一：无参，无返回值
     */
    @Test
    public void lambdaTest1() {
        Runnable runnable = () -> {
            System.out.println("lambda runnable");
            System.out.println("lambda runnable");
        };
        runnable.run();
    }

    /**
     * 格式二：一个参数，无返回值
     */
    @Test
    public void lambdaTest2() {
        Consumer<String> con = (String s) -> {
            System.out.println(s);
        };
        con.accept("一个参数,无返回值！");
    }

    /**
     * 格式三：数据类型可以省略，因为可由编译器推断得出，称为“类型推断”
     */
    @Test
    public void lambdaTest3() {
        Consumer<String> con = (s) -> {
            System.out.println(s);
        };
        con.accept("类型推断！");
    }

    /**
     * 格式四：只需要一个参数时，参数的小括号可以省略
     */
    @Test
    public void lambdaTest4() {
        Consumer<String> con = s -> {
            System.out.println(s);
        };
        con.accept("类型推断！");
    }

    /**
     * 格式五：需要两个或以上的参数，多条执行语句，并且可以有返回值
     */
    @Test
    public void lambdaTest5() {
        Comparator<Integer> com = (o1, o2) -> {
            System.out.println(o1);
            System.out.println(o2);
            return o1.compareTo(o2);
        };
        System.out.println(com.compare(12, 21));
    }

    /**
     * 格式六：当只有一条语句是，return与大括号都可以省略
     */
    @Test
    public void lambdaTest6() {
        Comparator<Integer> com = (o1, o2) -> o1.compareTo(o2);
        System.out.println(com.compare(12, 21));

        Consumer<String> con = s -> System.out.println(s);
        con.accept("省略大括号!");
    }
}
