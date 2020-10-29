package com.bjfu.stringtest;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class StringTranslate {

    @Test
    public void intTest() {
        String s1 = "123";
        int num = Integer.parseInt(s1);
        System.out.println(num);

        String s2 = String.valueOf(num);
        String s3 = num + "";
        System.out.println(s2 == s3);//false
    }

    @Test
    public void charTest() {
        String s1 = "abc123";

        char[] charArray = s1.toCharArray();

        for (int i = 0; i < charArray.length; i++){
            System.out.print(charArray[i] + " ");
        }

        char[] arr = {'h', 'e', 'l', 'l', 'o'};

        String s2 = new String(arr);
        System.out.println(s2);
    }

    @Test
    public void byteTest() throws UnsupportedEncodingException {

        System.out.println("******编码过程******");
        String s1 = "abc123中国";
        byte[] bytes = s1.getBytes();
        System.out.println(Arrays.toString(bytes));//UTF-8 一个汉字占3位
        byte[] gbk = s1.getBytes("gbk");
        System.out.println(Arrays.toString(gbk));//gbk 一个汉字占2位

        System.out.println("******解码过程******");
        String s2 = new String(bytes);//默认字符集进行解码
        System.out.println(s2);
        String s3 = new String(gbk);//乱码
        System.out.println(s3);
        String s4 = new String(gbk,"gbk");
        System.out.println(s4);
    }
}
