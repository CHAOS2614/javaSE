package cn.edu.bjfu.collectionmap;

import cn.edu.bjfu.compare.Student;
import org.junit.Test;

import java.util.*;

/**
 * set:存储无序的，不可重复的数据
 *
 * @author Chao Huaiyu
 * @date 2020/10/24
 */
public class SetTest {
    @Test
    public void hashSetTest() {
        Set set = new HashSet();
        set.add(123);
        set.add(456);
        set.add(123);
        //保证添加的元素按照equals()判断时，不能返回true，
        //即相同的元素只能添加一个，但是。。。。。。
        set.add(new Student("ana", 78));
        set.add(new Student("ana", 78));
        set.add(new Student("tom", 98));
        set.add(new Student("ton", 87));

        Iterator iterator = set.iterator();
        //无序性不等于随机性
        //存储的数据在底层数组中并非按照数组索引顺序进行添加，而是根据哈希值
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void linkedHashSetTest() {
        //作为HashSet的子类，在添加数据的同时每个数据还维护了两个引用
        Set set = new LinkedHashSet();
        set.add(123);
        set.add(456);
        set.add(123);

        set.add(new Student("ana", 78));
        set.add(new Student("ana", 78));
        set.add(new Student("tom", 98));
        set.add(new Student("ton", 87));

        Iterator iterator = set.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void treeSetTest() {
        //不能添加不同类的对象

        Set<Student> set = new TreeSet<>();

        //比较相同直接用compare()方法
        set.add(new Student("ana", 78));
        set.add(new Student("ana", 79));
        set.add(new Student("tom", 98));
        set.add(new Student("ton", 87));
        set.add(new Student("same", 87));

        Iterator iterator = set.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void treeSetComparatorTest() {

        Set<Student> set = new TreeSet<>(new Comparator<Student>() {
            /**
             * 按照姓名排序，相同则看分数
             */
            @Override
            public int compare(Student o1, Student o2) {
                int nameCompare = o1.getName().compareTo(o2.getName());
                if (nameCompare != 0) {
                    return nameCompare;
                } else {
                    return Double.compare(o1.getScore(), o2.getScore());
                }
            }
        });

        set.add(new Student("ana", 78));
        set.add(new Student("ana", 79));
        set.add(new Student("tom", 98));
        set.add(new Student("ton", 87));
        set.add(new Student("same", 87));

        Iterator iterator = set.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
