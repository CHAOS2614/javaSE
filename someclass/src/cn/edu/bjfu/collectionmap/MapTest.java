package cn.edu.bjfu.collectionmap;

import cn.edu.bjfu.compare.Student;
import org.jetbrains.annotations.NotNull;
import org.junit.Test;

import java.util.*;

/**
 * @author Chao Huaiyu
 * @date 2020/10/24
 */
public class MapTest {

    private void showMap(@NotNull Map map) {
        if (map.isEmpty()) {
            return;
        }
        if (map == null) {
            return;
        }
        Set entrySet = map.entrySet();
        Iterator iterator1 = entrySet.iterator();
        while (iterator1.hasNext()) {
            Object o = iterator1.next();
            Map.Entry entry = (Map.Entry) o;
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

    @Test
    public void mapMethodTest() {

        Map map = new HashMap();
        map.put("AA", 123);
        map.put("AA", 88);
        map.put(12, 123);
        map.put("CC", 56);
        map.put("DD", 65);

        System.out.println(map);

        //remove(Object key)
        //clear()与map = null不同，只是清空数据
        //get(Object key)
        //isEmpty()
        //equals()

        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("------------------");
        Collection collection = map.values();
        for (Object o : collection) {
            System.out.println(o);
        }

        //遍历方法一
        showMap(map);

        //遍历方法二，通过keySet()全部的key，再通过key获得相应value;
    }

    @Test
    public void treeMapTest() {
        TreeMap<Student, Integer> map = new TreeMap<Student, Integer>();
        map.put(new Student("ana", 78), 11);
        map.put(new Student("ana", 79), 99);
        map.put(new Student("tom", 98), 87);
        map.put(new Student("ton", 87), 69);
        map.put(new Student("same", 87), 78);

        showMap(map);
    }

    @Test
    public void treeMapTest2() {
        TreeMap<Student, Integer> map = new TreeMap<Student, Integer>(new Comparator<Student>() {
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

        map.put(new Student("ana", 78), 11);
        map.put(new Student("ana", 79), 24);
        map.put(new Student("tom", 98), 87);
        map.put(new Student("ton", 87), 69);
        map.put(new Student("same", 87), 78);

        showMap(map);


    }
}
