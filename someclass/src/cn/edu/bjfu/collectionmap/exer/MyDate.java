package cn.edu.bjfu.collectionmap.exer;

import org.jetbrains.annotations.NotNull;

/**
 * @author Chao Huaiyu
 * @date 2020/10/24
 */
public class MyDate implements Comparable<MyDate> {
    private int year;
    private int month;
    private int day;

    public MyDate() {
    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }


//    @Override
//    public int compareTo(@NotNull Object o) {
//        if(o instanceof MyDate){
//            if(this.year!=((MyDate) o).getYear()){
//                return Integer.compare(this.year,((MyDate) o).getYear());
//            }
//            if(this.month!=((MyDate) o).getMonth()){
//                return Integer.compare(this.month,((MyDate) o).getMonth());
//            }
//                return Integer.compare(this.day,((MyDate) o).getDay());
//        }else{
//            throw new RuntimeException("不是MyDate对象！");
//        }
//    }

    @Override
    public int compareTo(@NotNull MyDate o) {
        if (this.year != o.getYear()) {
            return Integer.compare(this.year, o.getYear());
        }
        if (this.month != o.getMonth()) {
            return Integer.compare(this.month, o.getMonth());
        }
        return Integer.compare(this.day, o.getDay());
    }
}
