package cn.edu.bjfu.compare;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * @author Chao Huaiyu
 * @date 2020/10/23
 */
public class Student implements Comparable{

    private String name;
    private double score;

    public Student() {}

    public Student(String name, double score) {
        this.name = name;
        this.score = score;
    }



    public String getName() {
        return name;
    }

    public double getScore() {
        return score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public int compareTo(@NotNull Object o) {
        if(o instanceof Student){
            Student student = (Student)o;
            return Double.compare(this.score, student.getScore());
        }
        throw new RuntimeException("输入数据类型不一致！");
    }

    @Override
    public String toString(){
        return "Student{"+
                "name:"+name+
                ",score:"+score+
                '}';
    }

    @Contract(value = "null -> false", pure = true)
    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (!(o instanceof Student)){
            return false;
        }
        Student student = (Student) o;
        return Double.compare(student.score, score) == 0 &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, score);
    }
}
