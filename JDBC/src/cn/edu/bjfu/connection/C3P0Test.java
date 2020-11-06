package cn.edu.bjfu.connection;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Chao Huaiyu
 * @date 2020/11/6
 */
public class C3P0Test {

    /**
     * 方式一：
     */
    @Test
    public void getConnectionTest() throws PropertyVetoException {
        //获取c3p0连接池
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        cpds.setDriverClass("com.mysql.jdbc.Driver");
        cpds.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        cpds.setUser("root");
        cpds.setPassword("Chaos_1022");
        System.out.println(cpds);
        //设置初始时数据库连接池中的连接数
        cpds.setInitialPoolSize(10);
        //DataSources.destroy(cpds);一般不会关闭连接池
    }

    /**
     * 方式二：配置文件
     */
    @Test
    public void getConnectionTest2() throws PropertyVetoException, SQLException {
        //获取c3p0连接池
        ComboPooledDataSource cpds = new ComboPooledDataSource("myc3p0");
        Connection connection = cpds.getConnection();
        System.out.println(connection);
    }
}
