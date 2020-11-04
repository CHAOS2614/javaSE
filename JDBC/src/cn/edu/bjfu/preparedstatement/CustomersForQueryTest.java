package cn.edu.bjfu.preparedstatement;

import cn.edu.bjfu.Utils;
import cn.edu.bjfu.javabean.Customer;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

/**
 * @author Chao Huaiyu
 * @date 2020/11/4
 */
public class CustomersForQueryTest {

    @Test
    public void queryTest1() {
        Connection connection = Utils.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String querySql = "select id,name,email,birth from customers where id = ?";
        try {
            preparedStatement = connection.prepareStatement(querySql);
            preparedStatement.setObject(1,1);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String email = resultSet.getString(3);
                Date birth = resultSet.getDate(4);

                Customer customer = new Customer(id,name,email,birth);
                System.out.println(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Utils.closeResource(connection,preparedStatement,resultSet);
        }

    }
}
