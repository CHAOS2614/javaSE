package cn.edu.bjfu.stringtest;

import org.junit.Test;

/**
 * @author Chao Huaiyu
 * @date 2020/10/22
 */
public class StringDemoTest {

    @Test
    public void reverseTest() {
        String str = "abcdefg";
        String reverse = StringDemo.reverse(str,1,5);
        System.out.println(reverse);
        reverse = StringDemo.reverse2(str,1,5);
        System.out.println(reverse);
    }

    @Test
    public void subStringCountTest() {
        String mainString = "ababababab";
        System.out.println(StringDemo.getSubStringCount(mainString, "ba"));
        System.out.println(StringDemo.getSubStringCount(mainString, "ab"));
        System.out.println(StringDemo.getSubStringCount(mainString, " "));
        System.out.println(StringDemo.getSubStringCount(mainString, "aa"));
        System.out.println(StringDemo.getSubStringCount(mainString, "dddddddddd"));
    }

    @Test
    public void maxSameStringTest() {
        String string1 = "dfasahfiuehfkjhsfukehsaef";
        String string2 = "eahf";
        String sameString = StringDemo.getMaxSameString(string1, string2);
        System.out.println(sameString);
    }

}