package cn.edu.bjfu.iostream;

import org.junit.Test;

import java.io.*;

/**
 * @author Chao Huaiyu
 * @date 2020/10/26
 */
public class BufferedReaderWriterTest {

    @Test
    public void bufferedReaderWriterTest() {

        File srcFile = new File("hello.txt");
        File desFile = new File("hello01.txt");

        FileReader fr = null;
        FileWriter fw = null;
        BufferedReader br = null;
        BufferedWriter bw = null;

        try {
            fr = new FileReader(srcFile);
            fw = new FileWriter(desFile);

            br = new BufferedReader(fr);
            bw = new BufferedWriter(fw);
//            方式一：
//            char[] buffer = new char[1024];
//            int len;
//            while ((len = br.read(buffer)) != -1) {
//                bw.write(buffer, 0, len);
//            }

            String data;
            while ((data = br.readLine()) != null) {
                //不包含换行符
                bw.write(data);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭外层流的同时，内层流也会自动进行关闭，
            //fos.close();//fis.close()

            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
