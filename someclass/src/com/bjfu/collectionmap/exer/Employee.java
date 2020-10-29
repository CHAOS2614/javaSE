package com.bjfu.collectionmap.exer;

import org.jetbrains.annotations.NotNull;

/**
 * @author Chao Huaiyu
 * @date 2020/10/24
 */
public class Employee implements Comparable<Employee>{
    private String name;
    private int age;
    private MyDate birthday;

    public Employee() {
    }

    public Employee(String name, int age, MyDate birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
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

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (!(o instanceof Employee)){
            return false;
        }

        Employee employee = (Employee) o;

        if (age != employee.age){
            return false;
        }
        if (!name.equals(employee.name)) {
            return false;
        }
        return birthday.equals(employee.birthday);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + age;
        result = 31 * result + birthday.hashCode();
        return result;
    }

    @Override
    public int compareTo(@NotNull Employee o) {
        return this.name.compareTo(o.getName());
    }
}
