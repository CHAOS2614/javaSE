package com.bjfu.stringtest;

import org.jetbrains.annotations.NotNull;

/**
 * @author Chaos
 */
public class Exer {

    private String str = "good";
    private char[] ch = {'t', 'e', 's', 't'};

    private void change(String str, @NotNull char[] ch) {
        str = "test ok";
        ch[0] = 'b';
    }

    public static void main(String[] args) {
        Exer exer = new Exer();
        exer.change(exer.str, exer.ch);
        //good
        System.out.println(exer.str);
        //best
        System.out.println(exer.ch);
    }
}
