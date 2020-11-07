package cn.edu.bjfu.iostream;

import org.jetbrains.annotations.NotNull;
import org.junit.Test;

import java.io.File;

/**
 * @author Chao Huaiyu
 * @date 2020/10/25
 */
public class FileTest {

    @Test
    public void test1() {
        File file = new File("hello.txt");
        File file1 = new File("D:\\Java\\project\\atguigu\\someclass\\hello1.txt");
        System.out.println(file.getName());
        System.out.println(file.getAbsolutePath());
        File file2 = new File("D:\\Java\\project\\atguigu", "someclass");
        System.out.println(file2);
        File file3 = new File(file2, "hello.txt");
        System.out.println(file3);
    }

    @Test
    public void test2() {
        File file = new File("hello.txt");
        File file1 = new File("D:\\Java\\project\\atguigu\\someclass\\hello1.txt");

        System.out.println(file.getAbsolutePath());
        System.out.println(file.getName());
        System.out.println(file.getParent());
        System.out.println(file.length());
        System.out.println(file.lastModified());

        System.out.println(file1.getAbsolutePath());
        System.out.println(file1.getName());
        System.out.println(file1.getParent());
        System.out.println(file1.length());
        System.out.println(file1.lastModified());
    }

    @Test
    public void test3() {
        File file = new File("D:\\Java\\project\\atguigu\\someclass");
        String[] list = file.list();
        for (String s : list) {
            System.out.println(s);
        }

        File[] files = file.listFiles();
        for (File file1 : files) {
            System.out.println(file1);
        }

    }

    @Test
    public void test4() {
        File file = new File("hello.txt");
        File file1 = new File("hello1.txt");
        //renameTo();要保证返回true，需要file在磁盘中时存在的，且file1是不存在的。
        boolean renameTo = file.renameTo(file1);
    }

    @Test
    public void test5() {
        File file = new File("hello1.txt");

        showFileInfo(file);

        file = new File("src");
        showFileInfo(file);
    }

    private void showFileInfo(@NotNull File file) {
        System.out.println("------" + file.getName() + "------");
        System.out.println(file.isDirectory());
        System.out.println(file.isFile());
        System.out.println(file.exists());
        System.out.println(file.canRead());
        System.out.println(file.canWrite());
        System.out.println(file.isHidden());
    }
}
