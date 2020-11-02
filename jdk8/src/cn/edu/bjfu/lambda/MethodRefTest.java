package cn.edu.bjfu.lambda;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 方法引用的使用
 *
 * @author Chaos
 */
public class MethodRefTest {


    /**
     * 情况一：对象 :: 实例方法
     * Consumer中的void accept(T t)
     * PrintStream中的void println(T t)
     */
    @Test
    public void test1() {
        Consumer<String> con1 = str -> System.out.println(str);
        con1.accept("北京");

        System.out.println("-------------------");

        Consumer con2 = System.out::println;
        con2.accept("beijing");

    }


    /**
     * Supplier中的T get()
     * Employee中的String getName()
     */
    @Test
    public void test2() {
        Employee employee = new Employee(1001, "tom", 20, 5000);
        Supplier<String> supplier1 = () -> employee.getName();
        System.out.println(supplier1.get());

        System.out.println("-------------------");
        Supplier<String> supplier2 = employee::getName;
        System.out.println(supplier2.get());

    }


    /**
     * 情况二：类 :: 静态方法
     * Comparator中的int compare(T t1,T t2)
     * Integer中的int compare(T t1,T t2)
     */
    @Test
    public void test3() {
        Comparator<Integer> comparator = (t1, t2) -> Integer.compare(t1, t2);
        System.out.println(comparator.compare(12, 21));

        System.out.println("-------------------");
        Comparator<Integer> comparator1 = Integer::compareTo;
        System.out.println(comparator1.compare(12, 2));
    }


    /**
     * Function中的R apply(T t)
     * Math中的Long round(Double d)
     */
    @Test
    public void test4() {
        Function<Double, Long> function = new Function<Double, Long>() {
            @Override
            public Long apply(Double aDouble) {
                return Math.round(aDouble);
            }
        };
        System.out.println(function.apply(11.1));

        System.out.println("----------");
        Function<Double, Long> function1 = d -> Math.round(d);
        System.out.println(function1.apply(12.3));

        System.out.println("----------");
        Function<Double, Long> function2 = Math::round;
        System.out.println(function2.apply(12.6));
    }


    /**
     * 情况三：类 :: 实例方法
     * Comparator中的int compare(T t1,T t2)
     * String中的int t1.compareTo(t2)
     */
    @Test
    public void test5() {
        Comparator<String> comparator = (s1, s2) -> s1.compareTo(s2);
        System.out.println(comparator.compare("a", "A"));

        System.out.println("----------");
        Comparator<String> comparator2 = String::compareTo;
        System.out.println(comparator2.compare("A", "a"));
    }


    /**
     * BiPredicate中的boolean test(T t1, T t2);
     * String中的boolean t1.equals(t2)
     */
    @Test
    public void test6() {
        BiPredicate<String, String> predicate = (s1, s2) -> s1.equals(s2);
        System.out.println(predicate.test("abc", "abd"));

        System.out.println("----------");
        BiPredicate<String, String> predicate1 = String::contains;
        System.out.println(predicate1.test("abc", "abc"));
    }


    /**
     * Function中的R apply(T t)
     * Employee中的String getName();
     */
    @Test
    public void test7() {

        Employee employee = new Employee(1001, "tom", 20, 5000);

        Function<Employee, String> function = e -> e.getName();
        System.out.println(function.apply(employee));

        System.out.println("------------");
        Function<Employee, String> function2 = Employee::getName;
        System.out.println(function2.apply(employee));
    }

}
