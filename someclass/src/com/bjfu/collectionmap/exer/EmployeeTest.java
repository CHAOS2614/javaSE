package com.bjfu.collectionmap.exer;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author Chao Huaiyu
 * @date 2020/10/24
 */
public class EmployeeTest {

    @Test
    public void treeSet() {
        TreeSet<Employee> treeSet = new TreeSet<>(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getBirthday().compareTo(o2.getBirthday());
            }
        });
//            new Comparator() {
//            @Override
//            public int compare(Object o1, Object o2) {
//                if (o1 instanceof Employee && o2 instanceof Employee) {
//                    return ((Employee) o1).getBirthday().compareTo(((Employee) o2).getBirthday());
//                } else {
//                    throw new RuntimeException("类型不一致");}}};

        Employee employee1 = new Employee("ana", 25, new MyDate(1997, 12, 21));
        Employee employee2 = new Employee("tom", 33, new MyDate(1988, 11, 10));
        Employee employee3 = new Employee("jerry", 34, new MyDate(1988, 11, 8));
        Employee employee4 = new Employee("sam", 23, new MyDate(2001, 2, 3));
        Employee employee5 = new Employee("tiny", 36, new MyDate(1987, 3, 12));

        treeSet.add(employee1);
        treeSet.add(employee2);
        treeSet.add(employee3);
        treeSet.add(employee4);
        treeSet.add(employee5);

        Iterator iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
