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

    /**
     * 增删改通用操作
     * @param sql 带占位符的sql语句
     * @param args 填充占位符的可变形参，长度等于sql中占位符个数
     */
    public void update(String sql, Object... args) {

        Connection connection = Utils.getConnection();
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Utils.closeResource(connection, preparedStatement);
        }
    }

    @Test
    public void insertTest() {

        //获取连接
        Connection connection = Utils.getConnection();
        PreparedStatement preparedStatement = null;

        try {
            //预编译sql语句，返回PreparedStatement实例
            String insertSql = "insert into customers(name,email,birth)values(?,?,?)";
            preparedStatement = connection.prepareStatement(insertSql);
            //填充占位符
            preparedStatement.setString(1, "哪吒");
            preparedStatement.setString(2, "nezha@gmail.com");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyy-MM-dd");
            java.util.Date date = simpleDateFormat.parse("1000-01-01");
            if (date != null) {
                preparedStatement.setDate(3, new Date(date.getTime()));
            }
            //执行
            preparedStatement.execute();
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            Utils.closeResource(connection, preparedStatement);
        }
    }

    @Test
    public void updateTest() {
        //1.获取数据库连接
        Connection connection = Utils.getConnection();
        PreparedStatement preparedStatement = null;

        try {
            //2.预编译sql语句，换回PreparedStatement的实例
            String updateSql = "update customers set name = ? where id = ?";
            preparedStatement = connection.prepareStatement(updateSql);

            //3.填充占位符
            preparedStatement.setObject(1, "莫扎特");
            preparedStatement.setObject(2, 18);

            //4.执行
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //5.关闭资源
            Utils.closeResource(connection, preparedStatement);
        }
    }

    @Test
    public void commonUpdateDeleteTest(){
        String sql = "delete from customers where id = ?";
        update(sql,21);
    }

    @Test
    public void commonUpdateInsertTest(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyy-MM-dd");
        java.util.Date date = null;
        try {
             date = simpleDateFormat.parse("1000-01-01");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //order表名是关键字，要加``，否则报错
        String sql = "insert into `order`(order_name,order_date)values(?,?)";
        update(sql,"DD",date);
    }

}
