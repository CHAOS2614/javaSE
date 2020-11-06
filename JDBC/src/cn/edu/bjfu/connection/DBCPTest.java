package cn.edu.bjfu.connection;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author Chao Huaiyu
 * @date 2020/11/6
 */
public class DBCPTest {

    @Test
    public void getConnectionTest() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql:///test");
        dataSource.setUsername("root");
        dataSource.setPassword("Chaos_1022");

        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(connection);
    }

    @Test
    public void getConnectionTest2() {
        Properties pros = new Properties();
        Connection connection = null;
        InputStream resourceAsStream = ClassLoader.getSystemClassLoader().getResourceAsStream("dbcp.properties");
        try {
            pros.load(resourceAsStream);
            DataSource dataSource = BasicDataSourceFactory.createDataSource(pros);
            connection = dataSource.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(connection);
    }
}
