package cn.edu.bjfu.iostream;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 转换流：属于字符流
 * InputStreamReader：字节输入流—>字符输入流
 * OutputStreamWriter：字符输出流—>字节输出流
 * 作用提供字节流与字符流之间的转换
 *
 * @author Chao Huaiyu
 * @date 2020/10/27
 */
public class InputStreamReaderTest {

    @Test
    public void test() {
        FileInputStream fis = null;
        InputStreamReader inputStreamReader = null;
        try {
            fis = new FileInputStream("hello.txt");
            inputStreamReader = new InputStreamReader(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
