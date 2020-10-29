package com.bjfu.iostream;

import org.junit.Test;

import java.io.*;

/**
 * @author Chao Huaiyu
 * @date 2020/10/26
 */
public class BufferedTest {

    @Test
    public void bufferedStreamTest() {

        File srcFile = new File("images\\fragile.JPG");
        File desFile = new File("images\\fragile1.JPG");

        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(desFile);

            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            byte[] buffer = new byte[10];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭外层流的同时，内层流也会自动进行关闭，
            //fos.close();
            //fis.close();
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
