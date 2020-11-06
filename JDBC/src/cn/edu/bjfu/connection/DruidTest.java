package cn.edu.bjfu.connection;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author Chao Huaiyu
 * @date 2020/11/6
 */
public class DruidTest {

    @Test
    public  void getConnection(){
        InputStream resourceAsStream = ClassLoader.getSystemClassLoader().getResourceAsStream("druid.properties");
        Properties pros = new Properties();
        Connection connection = null;
        try {
            pros.load(resourceAsStream);
            DataSource dataSource = DruidDataSourceFactory.createDataSource(pros);
            System.out.println(dataSource);
            connection = dataSource.getConnection();
            System.out.println(dataSource);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
