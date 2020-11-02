package cn.edu.bjfu.streamapi;

import cn.edu.bjfu.lambda.Employee;
import cn.edu.bjfu.lambda.EmployeeData;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Stream的终止操作
 *
 * @author Chao Huaiyu
 * @date 2020/11/2
 */
public class StreamApi2 {

    @Test
    public void test1() {
        List<Employee> list = EmployeeData.getEmployees();

        //allMatch(Predicate p)--检查是否匹配所有元素
        System.out.println(list.stream().allMatch(e -> e.getAge() > 18));

        //anyMatch(Predicate p)--检查是否有匹配的
        System.out.println(list.stream().anyMatch(e -> e.getAge() > 18));

        //noneMatch(Predicate p)--检查是否没有匹配的元素
        System.out.println(list.stream().noneMatch(e -> e.getName().contains("雷")));

        //findFirst
        System.out.println(list.stream().findFirst());

        //findAny
        System.out.println(list.stream().findAny());
        System.out.println(list.parallelStream().findAny());
    }

    @Test
    public void test2() {

        List<Employee> employees = EmployeeData.getEmployees();

        //count
        System.out.println(employees.stream().filter(e -> e.getSalary() > 5000).count());

        //max
        Stream<Double> doubleStream = employees.stream().map(e -> e.getSalary());
        System.out.println(doubleStream.max(Double::compareTo));

        System.out.println("---------------------------");
        Optional<Employee> min = employees.stream().min(
                (e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(min);

        System.out.println("----------------内部迭代----------------");
        employees.stream().forEach(System.out::println);
        System.out.println("-------------集合的遍历操作-------------");
        employees.forEach(System.out::println);
        System.out.println("----------------外部迭代----------------");
        Iterator<Employee> employeeIterator = employees.iterator();
        while (employeeIterator.hasNext()){
            System.out.println(employeeIterator.next());
        }
    }
}
