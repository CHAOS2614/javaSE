package cn.edu.bjfu.datetime;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author Chao Huaiyu
 * @date 2020/10/23
 */
public class Jdk8NewDateApiTest {

    @Test
    public void localTimeTest(){

        System.out.println("******now()******");
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

        System.out.println("******of()******");
        LocalDateTime localDateTime1 = LocalDateTime.of(2020,10,23,15,56);
        System.out.println(localDateTime1);

        System.out.println("******getXxx()******");
        System.out.println(localDateTime1.getDayOfMonth());
    }
}
