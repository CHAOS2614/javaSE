package com.bjfu.stringtest;

import org.junit.Test;

public class StringTest {

    @Test
    public void testSting1() {
        String s1 = "hello";
        String s2 = "hello";
        String s3 = new String("hello");

        System.out.println(s1 == s2);
        System.out.println(s1 == s3);

        System.out.println("**************************");

        s2 += " world";
        System.out.println(s1);
        System.out.println(s2);

        System.out.println("**************************");

        String s4 = "abc";
        String s5 = s4.replace("a", "A");
        System.out.println(s4);
        System.out.println(s5);
    }

    @Test
    public void test2() {

        String s1 = "Hello";
        String s2 = "World";

        String s3 = "HelloWorld";
        String s4 = "Hello" + "World";
        String s5 = s1 + "World";
        String s6 = "Hello" + s2;
        String s7 = s1 + s2;

        System.out.println(s3 == s4);//true
        System.out.println(s3 == s5);//false
        System.out.println(s3 == s6);//false
        System.out.println(s5 == s6);//false
        System.out.println(s3 == s7);//false

        System.out.println("**************************");

        String s8 = s5.intern();
        System.out.println(s3 == s8);
    }
}

