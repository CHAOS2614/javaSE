package cn.edu.bjfu.iostream;

import org.junit.Test;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author Chao Huaiyu
 * @date 2020/10/28
 */
public class RandomAccessFileTest {

    @Test
    public void randomAccessFileTest(){

        RandomAccessFile randomAccessFile = null;
        RandomAccessFile randomAccessFile2 = null;
        try {
            randomAccessFile = new RandomAccessFile("images\\fragile.JPG","r");
            randomAccessFile2 = new RandomAccessFile("images\\fragile2.JPG","rw");

            byte[] buffer = new byte[1024];
            int len;
            while((len = randomAccessFile.read(buffer))!=-1){
                randomAccessFile2.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(randomAccessFile!=null){
                try {
                    randomAccessFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(randomAccessFile2!=null){
                try {
                    randomAccessFile2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
