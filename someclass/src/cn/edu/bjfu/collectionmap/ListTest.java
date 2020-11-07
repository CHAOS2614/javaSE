package cn.edu.bjfu.collectionmap;

import cn.edu.bjfu.compare.Student;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @author Chao Huaiyu
 * @date 2020/10/24
 */
public class ListTest {

    @Test
    public void test1() {
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("abc");
        list.add(new Student("lisa",90));

        System.out.println(list);
        list.add(2,789);
        System.out.println(list);
        list.set(3,"ABC");
        System.out.println(list);
        System.out.println(list.get(4));
        //index();
        //indexOf();
        //addAll();
        //lastIndexOf();
        //remove(int index);
        //remove(Object o);
        //subList(int , int);左闭右开

    }

}
