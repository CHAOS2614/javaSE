package cn.edu.bjfu.collectionmap;

import cn.edu.bjfu.compare.Student;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * @author Chao Huaiyu
 * @date 2020/10/23
 */
public class CollectionTest {

    @Test
    public void test1() {
        Collection collection = new ArrayList();
        collection.add("aa");
        collection.add("bb");
        collection.add(123);
        collection.add(new Date());

        System.out.println(collection.size());
        System.out.println(collection);
        System.out.println(collection.isEmpty());
        collection.clear();
        System.out.println(collection.isEmpty());
    }

    @Test
    public void test2() {

        Collection collection = new ArrayList();
        Collection collection1 = new ArrayList();
        collection.add(123);
        collection.add(456);
        collection1.add(123);
        collection1.add(456);
        collection.add(new String("abc"));
        collection.add(false);

        //重写equal()方法
        collection.add(new Student("zhangsan", 99));

        System.out.println(collection.contains(123));
        System.out.println(collection.contains(new String("abc")));
        System.out.println(collection.contains(new Student("zhangsan", 99)));

        System.out.println(collection.containsAll(collection1));
    }

    @Test
    public void test3() {
        Collection collection = new ArrayList();
        collection.add(123);
        collection.add(456);
        collection.add(new String("abc"));
        collection.add(false);
        collection.add(new Student("zhangsan", 99));
        System.out.println(collection);
        collection.remove(123);
        System.out.println(collection);
    }

    @Test
    public void test4() {
        //removeAll()相当于求差集
        //retainAll()相当于求交集
        //equals()要想true，需要当前集合和形参集合元素都相同
        //hashCode()返回哈希值
        //toArray()返回Object型数组
        //Arrays.asList(数组)数组-->集合
        //iterator()返回Iterator接口实例，用于遍历集合元素
    }
}
