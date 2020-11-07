package cn.edu.bjfu.iostream;

import java.io.Serializable;

/**
 * 要想实现序列化，需要
 * 1.实现Serializable接口
 * 2.需要提供一个全局常量：serialVersionUID
 * 3.保证其内部所有属性必须是可序列化的（默认情况下基本数据类型可序列化）
 * 4.不能序列化static和transient修饰的成员变量
 * @author Chao Huaiyu
 * @date 2020/10/28
 */
public class Person implements Serializable {

    public static final long serialVersionUID = 897645632L;

    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
