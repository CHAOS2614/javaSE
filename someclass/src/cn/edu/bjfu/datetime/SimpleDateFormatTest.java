package cn.edu.bjfu.datetime;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Chao Huaiyu
 * @date 2020/10/23
 */
public class SimpleDateFormatTest {

    /*
    1.两个操作：
    1.1 格式化：日期-->字符串
    1.2 解析：字符串-->日期
     */

    @Test
    public void simpleDateFormatTest1() throws ParseException {

        System.out.println("******使用默认建SimpleDateFormat对象******");
        SimpleDateFormat sdf = new SimpleDateFormat();

        System.out.println("******格式化******");
        Date date = new Date();
        System.out.println(date);

        String format = sdf.format(date);
        System.out.println(format);

        System.out.println("******解析******");
        String dateString = "20-10-22 下午3:09";
        Date date1 = sdf.parse(dateString);
        System.out.println(date1);

        System.out.println("******使用自定义格式建SimpleDateFormat对象******");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
        String format2 = sdf2.format(date);
        System.out.println(format2);
        Date date2 = sdf2.parse("2020.11.22 03:20:30");
        System.out.println(date2);
    }
}
