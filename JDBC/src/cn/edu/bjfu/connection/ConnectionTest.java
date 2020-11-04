package cn.edu.bjfu.connection;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author Chao Huaiyu
 * @date 2020/11/3
 */
public class ConnectionTest {

    /**
     * 方式一：
     */
    @Test
    public void connectionTest() throws SQLException {

        Driver driver = new com.mysql.jdbc.Driver();
        String url = "jdbc:mysql://localhost:3306/test";
        Properties info = new Properties();
        info.setProperty("user","root");
        info.setProperty("password","Chaos_1022");

        Connection connection = driver.connect(url,info);
        System.out.println(connection);
    }

    /**
     * 方式二：对方式一的迭代
     * 目的是在程序中不出现第三方的api
     * 增加可移植性
     */
    @Test
    public void connectionTest2() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) aClass.newInstance();
        String url = "jdbc:mysql://localhost:3306/test";
        Properties info = new Properties();
        info.setProperty("user","root");
        info.setProperty("password","Chaos_1022");

        Connection connect = driver.connect(url, info);
        System.out.println(connect);
    }

    /**
     * 方式三：使用 DriverManager替换Driver
     */
    @Test
    public void connectionTest3(){
        //获取Driver的实例类对象
        Class<?> aClass = null;
        Driver driver = null;
        try {
            aClass = Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
           if(aClass!=null){
               driver = (Driver) aClass.newInstance();
           }
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        //提供另外三个连接的基本信息
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "Chaos_1022";

        //注册驱动
        try {
            if(driver!=null){
                DriverManager.registerDriver(driver);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        //获取连接
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(connection);
        try {
            if(connection!=null){
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void connectionTest4() throws ClassNotFoundException, SQLException {
        //提供另外三个连接的基本信息
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "Chaos_1022";

        //com.mysql.jdbc.Driver中有一个静态代码块帮忙做了
        Class.forName("com.mysql.jdbc.Driver");

        Connection connection = DriverManager.getConnection(url,user,password);
        System.out.println(connection);
    }

    /**
     * 方式五：将数据库需要的四个基本信息声明在配置文件中，
     * 通过读取配置文件获取
     *
     * 好处：
     *      实现了数据与代码的分离，实现了解耦：换数据库只需改配置文件
     *      如果需要修改配置文件信息，不需要重新打包
     */

    @Test
    public void getConnection(){

        //读取配置文件中的基本信息
        InputStream resourceAsStream = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");

        Properties properties = new Properties();
        try {
            properties.load(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driverClass = properties.getProperty("driverClass");

        //加载驱动
        try {
            Class.forName(driverClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //获取连接
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
