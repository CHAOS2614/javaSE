package cn.edu.bjfu.datetime;

import org.junit.Test;

import java.time.Instant;

/**
 * @author Chao Huaiyu
 * @date 2020/10/23
 */
public class InstantTest {

    @Test
    public void instantTest(){
        Instant instant = Instant.now();
        System.out.println(instant);

        long milli = instant.toEpochMilli();
        System.out.println(milli);
    }
}
