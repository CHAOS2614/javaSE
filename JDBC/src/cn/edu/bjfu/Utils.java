package cn.edu.bjfu;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**JDBC相关操作工具类
 * @author Chao Huaiyu
 * @date 2020/11/4
 */
public class Utils {

    /**
     * 获得数据库连接
     *
     * @return 数据库连接
     */
    public static Connection getConnection() {

        Connection connection = null;
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
        Properties pros = new Properties();

        try {
            pros.load(is);
            String user = pros.getProperty("user");
            String password = pros.getProperty("password");
            String url = pros.getProperty("url");
            String driverClass = pros.getProperty("driverClass");
            Class.forName(driverClass);
            connection = DriverManager.getConnection(url, user, password);
        } catch (IOException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    /**
     * 关闭资源
     *
     * @param connection 数据库连接
     * @param statement  其实关的是preparedStatement，写的大一点
     */
    public static void closeResource(Connection connection, Statement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeResource(Connection connection, Statement statement, ResultSet resultSet) {
        closeResource(connection,statement);
        if(resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
