package com.bjfu.stringtest;

import org.junit.Test;

public class StringMethod {

    @Test
    public void methodTest1(){
        String str = "Hello World!";
        System.out.println(str);
        System.out.println(str.length());//12
        System.out.print(str.charAt(4));
        System.out.print(str.charAt(5));
        System.out.println(str.charAt(6));
        System.out.println(str.isEmpty());
        System.out.println(str);//Hello World!
        System.out.println(str.toLowerCase());//hello world!
        System.out.println(str.toUpperCase());//HELLO WORLD!
    }

    @Test
    public void methodTest2(){
        String s1 = "    hello    world    ";
        System.out.println(s1.trim());

        String s2 = "HelloWorld";
        String s3 = "helloworld";
        System.out.println(s2.equals(s3));//false
        System.out.println(s2.equalsIgnoreCase(s3));//true

        System.out.println(s2.compareTo(s3));//-32
        System.out.println('A'-'a');//-32

        System.out.println(s2.substring(5));
        System.out.println(s2.substring(5,6));
    }

    @Test
    public void methodTest3(){
        String s1 = "HelloWorld";

        System.out.println(s1.endsWith("world"));//false
        System.out.println(s1.startsWith("Hello"));//true
        System.out.println(s1.startsWith("lo", 3));//true

        System.out.println("***************");

        System.out.println(s1.indexOf("lo"));//3
        System.out.println(s1.indexOf("hehe"));//-1
        System.out.println(s1.indexOf("l"));//2
        System.out.println(s1.indexOf("l",3));//3 从索引之后开始找
        System.out.println(s1.lastIndexOf("l"));//8
        System.out.println(s1.lastIndexOf("l",6));//3 从索引开始向前找
        System.out.println(s1.lastIndexOf("ro"));//-1
    }

    @Test
    public void methodTest4(){
        String s1 = "北京林业大学北京林业大学";
        String s2 = s1.replace("大","小");

        System.out.println(s1);//北京林业大学北京林业大学
        System.out.println(s2);//北京林业小学北京林业小学
        String s3 = s1.replace("北京", "上海");
        System.out.println(s3);//上海林业大学上海林业大学
        System.out.println("***************");

    }
}
