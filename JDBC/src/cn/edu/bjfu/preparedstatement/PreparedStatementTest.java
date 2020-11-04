package cn.edu.bjfu.preparedstatement;

import cn.edu.bjfu.Utils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author Chao Huaiyu
 * @date 2020/11/3
 */
public class PreparedStatementTest {

    @Test
    public void insertTest() {

        //获取连接
        Connection connection = Utils.getConnection();
        System.out.println(connection);

        //预编译sql语句，返回PreparedStatement实例
        String insertSql = "insert into customers(name,email,birth)values(?,?,?)";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(insertSql);
            preparedStatement.setString(1, "哪吒");
            preparedStatement.setString(2, "nezha@gmail.com");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyy-MM-dd");
            java.util.Date date = null;
            try {
                date = simpleDateFormat.parse("1000-01-01");

            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (date != null) {
                preparedStatement.setDate(3, new Date(date.getTime()));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (preparedStatement != null) {
                preparedStatement.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Utils.closeResource(connection, preparedStatement);
    }
}
