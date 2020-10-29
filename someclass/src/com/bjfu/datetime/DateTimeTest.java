package com.bjfu.datetime;

import org.junit.Test;

import java.util.Date;

/**
 * @author Chao Huaiyu
 * @date 2020/10/22
 */
public class DateTimeTest {

    @Test
    public void dateTime1(){
        long time = System.currentTimeMillis();
        //返回当前时间与1970年1月1日0时0分0秒之间以毫秒为单位的时间差。
        //通常称为时间戳。
        System.out.println(time);
    }

    @Test
    public void dateTime2(){
        Date date1 = new Date();
        //Thu Oct 22 14:27:01 CST 2020
        // 显示当前星期 月 日 时 分 秒 时区 年
        System.out.println(date1.toString());
        System.out.println(date1.getTime());
        //获取当前时间对象的时间戳1603348021761

        Date date2 = new Date(1603348021761L);
        //创建指定毫秒数的时间对象
        System.out.println(date2);

        System.out.println("*************");

        //java.sql.Date与java.util.Date之间转换;
        //java.util.Date->java.sql.Date
        Date date3 = new Date();
        System.out.println(date3);
        java.sql.Date date4 = new java.sql.Date(date3.getTime());

        //java.sql.Date->java.util.Date
        Date date5 = date4;
        System.out.println(date5.toString());

    }
}
