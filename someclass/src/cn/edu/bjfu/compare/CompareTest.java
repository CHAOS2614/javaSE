package cn.edu.bjfu.compare;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Chao Huaiyu
 * @date 2020/10/23
 */
public class CompareTest {

    private static Student[] students = new Student[5];

    private void initArray() {
        students[0] = new Student("zhangsan", 79);
        students[1] = new Student("lisi", 68);
        students[2] = new Student("wangwu", 97);
        students[3] = new Student("zhaoliu", 75);
        students[4] = new Student("qiqi", 86);
    }

    @Test
    public void comparableTest() {

        initArray();
        Student[] students = new Student[5];
        students[0] = new Student("zhangsan", 79);
        students[1] = new Student("lisi", 68);
        students[2] = new Student("wangwu", 97);
        students[3] = new Student("zhaoliu", 75);
        students[4] = new Student("qiqi", 86);

        Arrays.sort(students);
        System.out.println(Arrays.toString(students));
    }

    @Test
    public void comparator() {
        initArray();
        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1 != null && o2 != null) {
                    return -((Student) o1).compareTo((Student) o2);
                }
                throw new RuntimeException("类型不一致！");
            }
        });
        System.out.println(Arrays.toString(students));
    }
}
