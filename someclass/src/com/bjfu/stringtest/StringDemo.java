package com.bjfu.stringtest;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 关于String类的一些练习
 *
 * @author Chao Huaiyu
 * @date 2020/10/22
 */
public class StringDemo {

    @Contract(value = "null, _, _ -> false", pure = true)
    private static boolean canReverse(String str, int startIndex, int endIndex) {
        return str != null
                && endIndex <= str.length()
                && startIndex >= 0
                && startIndex < endIndex;
    }

    /**
     * 将str中从startIndex到endIndex的部分翻转
     *
     * @param str        字符串
     * @param startIndex 起始位置
     * @param endIndex   终止位置
     * @return 反转之后字符串
     */
    @Nullable
    public static String reverse(String str, int startIndex, int endIndex) {
        if (canReverse(str, startIndex, endIndex)) {
            char[] arr = str.toCharArray();
            for (int x = startIndex, y = endIndex; x < y; x++, y--) {
                char temp = arr[x];
                arr[x] = arr[y];
                arr[y] = temp;
            }
            return new String(arr);
        }
        return null;
    }

    /**
     * 将str中从startIndex到endIndex的部分翻转
     *
     * @param str        字符串
     * @param startIndex 起始位置
     * @param endIndex   终止位置
     * @return 反转之后字符串
     */
    @Nullable
    public static String reverse2(String str, int startIndex, int endIndex) {
        if (canReverse(str, startIndex, endIndex)) {
            StringBuilder stringBuilder = new StringBuilder(str.length());
            stringBuilder.append(str.substring(0, startIndex));
            for (int i = endIndex; i >= startIndex; i--) {
                stringBuilder.append(str.charAt(i));
            }
            stringBuilder.append(str.substring(endIndex + 1));
            return stringBuilder.toString();
        }
        return null;
    }

    /**
     * 获取subString在mainString中出现的的次数
     *
     * @param mainString 主字符串
     * @param subString  子字符串
     * @return 出现次数
     */
    public static int getSubStringCount(@NotNull String mainString, @NotNull String subString) {
        int count = 0;
        int mainLength = mainString.length();
        int subLength = subString.length();
        if (subLength > mainLength || mainLength == 0 || subLength == 0) {
            return 0;
        }
        for (int i = 0; i < mainLength; ) {
            i = mainString.indexOf(subString, i);
            if (i >= 0) {
                count++;
                i += subLength;
            } else {
                return count;
            }
        }
        return count;
    }

    /**
     * 查找两个字符串最大相同子串，如果有多个相同长度的相同子串，
     * 则返回第一个，改进可选择集合或者字符串拼接，使用字符数组
     * 不能确定数组大小，因此排除。
     * @param string1 字符串1
     * @param string2 字符串2
     * @return 最大相同子串，字符串不符合条件或者无相同子串返回null
     */
    @Contract("null, null -> null")
    public static String getMaxSameString(String string1, String string2) {
        if (string1 == null || string2 == null) {
            return null;
        }
        String maxString = (string1.length() >= string2.length()) ? string1 : string2;
        String minString = (string1.length() < string2.length()) ? string1 : string2;
        int length = minString.length();
        for (int i = 0; i < length; i++) {
            for (int x = 0, y = length - i; y <= length; x++, y++) {
                String subString = minString.substring(x, y);
                if (maxString.contains(subString)) {
                    return subString;
                }
            }
        }
        return null;
    }


}
