package com.bjfu.collectionmap.generic;

import com.bjfu.compare.Student;
import org.junit.Test;

/**
 * @author Chao Huaiyu
 * @date 2020/10/25
 */
class Order<T> {
    private T orderT;

    public Order(T orderT) {
        this.orderT = orderT;
    }

    public T getOrderT() {
        return orderT;
    }
}

/**
 * @author Chaos
 */
public class OrderTest{

    @Test
    public void orderTest(){
        Order<Student> studentOrder = new Order<>(new Student("tom",12));
        Student student = studentOrder.getOrderT();
        System.out.println(student);
    }
}
