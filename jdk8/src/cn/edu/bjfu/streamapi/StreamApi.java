package cn.edu.bjfu.streamapi;

import cn.edu.bjfu.lambda.Employee;
import cn.edu.bjfu.lambda.EmployeeData;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 创建Stream的四种方式
 * @author Chao Huaiyu
 * @date 2020/11/2
 */
public class StreamApi {

    @Test
    public void streamApiTest1() {

        List<Employee> employees = EmployeeData.getEmployees();
        //default Stream<E> stream();返回一个顺序流
        Stream<Employee> stream = employees.stream();
        //default Stream<E> parallelStream():返回一个并行流
        Stream<Employee> parallelStream = employees.parallelStream();
    }

    /**
     * 数组创建
     */
    @Test
    public void streamApiTest2() {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        IntStream stream = Arrays.stream(arr);
    }

    /**
     * Stream的of创建
     */
    @Test
    public void streamApiTest3() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6);
    }

    /**
     * 创建无限流
     */
    @Test
    public void streamApiTest4() {
        Stream.iterate(0,t ->t+2).limit(10).forEach(System.out::println);
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }

}
