package cn.edu.bjfu.streamapi;

import cn.edu.bjfu.lambda.Employee;
import cn.edu.bjfu.lambda.EmployeeData;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 创建Stream的四种方式
 *
 * @author Chao Huaiyu
 * @date 2020/11/2
 */
public class StreamApi {

    @Test
    public void streamApiTest1() {

        List<Employee> employees = EmployeeData.getEmployees();
        //default Stream<E> stream();返回一个顺序流
        Stream<Employee> stream = employees.stream();
        stream.filter(e -> e.getSalary() > 7000).forEach(System.out::println);
        //default Stream<E> parallelStream():返回一个并行流
        System.out.println("-----------------------------------------------");
        System.out.println("-----------------------------------------------");
        Stream<Employee> parallelStream = employees.parallelStream();
        parallelStream.limit(3).forEach(System.out::println);

        System.out.println("-----------------------------------------------");
        employees.stream().skip(3).forEach(System.out::println);

        System.out.println("-----------------------------------------------");
        employees.add(new Employee(1010,"张三",20,8000));
        employees.add(new Employee(1010,"张三",20,8000));
        employees.add(new Employee(1010,"张三",20,8000));
        System.out.println(employees.size());
        employees.stream().distinct().forEach(System.out::println);
        System.out.println(employees.size());
    }

    /**
     * 数组创建
     * 映射
     */
    @Test
    public void streamApiTest2() {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        IntStream stream = Arrays.stream(arr);
        stream.map(num -> ++num).forEach(System.out::println);

        List<Employee> employees = EmployeeData.getEmployees();
        Stream<String> stringStream = employees.stream().map(Employee::getName);
        stringStream.filter(name -> name.length()>3).forEach(System.out::println);
    }

    /**
     * Stream的of创建
     * map 与 flatMap：可以理解为list的add与addAll
     */
    @Test
    public void streamApiTest3() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6);
        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bb");
        list.add("cc");
        Stream<Stream<Character>> streamStream = list.stream().map(StreamApi::formStringToStream);
        streamStream.forEach(s -> {
            s.forEach(System.out::println);
        });
        System.out.println();

        Stream<Character> characterStream = list.stream().flatMap(StreamApi::formStringToStream);
        characterStream.forEach(System.out::println);


    }

    public static Stream<Character> formStringToStream(String str){
        ArrayList<Character> list = new ArrayList<>();
        for(Character c : str.toCharArray()){
            list.add(c);
        }
        return list.stream();
    }

    /**
     * 创建无限流
     */
    @Test
    public void streamApiTest4() {
        Stream.iterate(0, t -> t + 2).limit(10).forEach(System.out::println);
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }

    @Test
    public void sortTest(){
        //sorted--自然排序
        List<Integer> list = new ArrayList<>(6);
        //list.add(Supplier::get);

    }
}
