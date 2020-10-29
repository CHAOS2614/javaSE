package com.bjfu.stringbufferbuilder;

import org.junit.Test;

/**
 * @author Chao Huaiyu
 *
 */
public class StringBufferBuilderTest {
    /*
    StringBuffer:可变字符序列，线程安全，效率低
    StringBuilder：可变字符序列，线程不安全，效率高
     */

    @Test
    public void BufferTest(){
        StringBuffer sb1 = new StringBuffer("abc");
        sb1.append(1);
        sb1.append("1");
        sb1.append("def");
        System.out.println(sb1);
        sb1.delete(3,5);//左闭右开
        System.out.println(sb1);//abcdef
    }

    @Test
    public void BufferTest2(){
        StringBuffer sb1 = new StringBuffer("abc");
        StringBuffer sb2 = sb1;
        System.out.println(sb2);
        sb1.append(1);
        sb1.append("1");
        sb1.append("def");
        System.out.println(sb2);
    }
}
