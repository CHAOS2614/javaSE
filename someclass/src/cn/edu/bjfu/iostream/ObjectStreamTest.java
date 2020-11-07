package cn.edu.bjfu.iostream;

import org.junit.Test;

import java.io.*;

/**
 * @author Chao Huaiyu
 * @date 2020/10/28
 */
public class ObjectStreamTest {

    @Test
    public void objectOutputStreamTest() {

        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("person.dat"));
            oos.writeObject(new Person("张三",23));
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void objectInputStreamTest(){
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("person.dat"));
            Object o = ois.readObject();
            Person person = (Person)o;
            System.out.println(person);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
