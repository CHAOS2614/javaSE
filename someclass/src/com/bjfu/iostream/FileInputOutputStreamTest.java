package com.bjfu.iostream;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author Chao Huaiyu
 * @date 2020/10/26
 */
public class FileInputOutputStreamTest {

    @Test
    public void fileInputStreamTest() {

        File file = new File("Hello.txt");
        FileInputStream fis = null;

        try {
            fis = new FileInputStream(file);

            byte[] buffer = new byte[5];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                String str = new String(buffer, 0, len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
