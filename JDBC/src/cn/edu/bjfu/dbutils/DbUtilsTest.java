package cn.edu.bjfu.dbutils;

import cn.edu.bjfu.Utils;
import cn.edu.bjfu.javabean.Customer;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * commons-dbutils 是Apache 组织提供的一个开源的JDBC工具类库
 * 封装了针对于数据库的增删改查操作
 *
 * @author Chao Huaiyu
 * @date 2020/11/6
 */
public class DbUtilsTest {

    @Test
    public void insertTest() {
        Connection connection = null;
        try {
            QueryRunner runner = new QueryRunner();
            connection = Utils.getConnection();
            String sql = "insert into customers(name,email,birth)values(?,?,?)";
            int insertCount = runner.update(connection, sql, "陈彭京昊", "haohao@gmail.com", new Date(System.currentTimeMillis()));
            System.out.println("插入" + insertCount + "条数据！");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Utils.closeResource(connection, null);
        }
    }

    /**
     * BeanHandler:是ResultSetHandler接口的实现类
     * 用于封装表中的一条记录
     */
    @Test
    public void queryTest() {
        Connection connection = null;
        try {
            connection = Utils.getConnection();
            String sql = "select id,name,email,birth from customers where id = ?";
            QueryRunner runner = new QueryRunner();
            BeanHandler<Customer> handler = new BeanHandler<>(Customer.class);
            Customer customer = runner.query(connection, sql, handler, 25);
            System.out.println(customer);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Utils.closeResource(connection, null);
        }
    }

    /**
     * BeanListHandler:是ResultSetHandler接口的实现类
     * 用于封装表中的多条记录构成的集合
     */
    @Test
    public void queryTest2() {
        Connection connection = null;
        try {
            connection = Utils.getConnection();
            String sql = "select id,name,email,birth from customers where id > ?";
            QueryRunner runner = new QueryRunner();
            BeanListHandler<Customer> handler = new BeanListHandler<>(Customer.class);
            List<Customer> customers = runner.query(connection, sql, handler, 10);
            customers.forEach(System.out::println);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Utils.closeResource(connection, null);
        }
    }
}
