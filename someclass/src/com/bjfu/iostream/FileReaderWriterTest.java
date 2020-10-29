package com.bjfu.iostream;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Chao Huaiyu
 * @date 2020/10/26
 */
public class FileReaderWriterTest {

    @Test
    public void fileReaderReadTest() {
        //1.实例化File类对象，指明要操作的文件
        File file = new File("hello.txt");
        FileReader fr = null;
        try {
            //提供具体的流
            fr = new FileReader(file);
            //3.数据的读入
            //read()返回读入的一个字符，如果到达文件末尾，返回-1
            int data = fr.read();
            while (data != -1) {
                System.out.print((char) data);
                data = fr.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //流的关闭操作
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void fileReaderReadTest2() {

        File file = new File("hello.txt");
        FileReader fr = null;
        try {
            fr = new FileReader(file);
            char[] dateBuffer = new char[5];
            int len;
            while ((len = fr.read(dateBuffer)) != -1) {
                //注意循环结束条件，当读到最后的时候可能不够5个字符
                for (int i = 0; i < len; i++) {
                    System.out.print(dateBuffer[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 输出操作，对应的file文件可以不存在
     * 如果不存在，则自动创建
     * 如果存在,看构造器
     * 如果是（file，true）则不会覆盖，而是在文件末未追加
     * 如果是（file，false）则覆盖
     */
    @Test
    public void fileWriterTest() {
        File file = new File("hello1.txt");

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file, true);

            fileWriter.write("I love you!\n");
            fileWriter.write("You love me!\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void fileWriterTest2() {
        File srcFile = new File("hello.txt");
        File desFile = new File("helloDes.txt");

        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try {
            fileReader = new FileReader(srcFile);
            fileWriter = new FileWriter(desFile);

            char[] cbuf = new char[5];

            int len;
            while ((len = fileReader.read(cbuf)) != -1) {
                fileWriter.write(cbuf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
