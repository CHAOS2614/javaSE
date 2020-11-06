package cn.edu.bjfu.dbutils;

import cn.edu.bjfu.Utils;
import cn.edu.bjfu.javabean.Customer;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

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

    /**
     * MapHandler:是ResultSetHandler接口的实现类
     * 对应表中的一条记录
     * 将字段及相应的值作为map中的key和value
     */
    @Test
    public void queryTest3() {
        Connection connection = null;
        try {
            connection = Utils.getConnection();
            String sql = "select id,name,email,birth from customers where id = ?";
            QueryRunner runner = new QueryRunner();
            MapHandler handler = new MapHandler();
            Map<String, Object> map = runner.query(connection, sql, handler, 10);
            System.out.println(map);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Utils.closeResource(connection, null);
        }
    }

    /**
     * MapListHandler:是ResultSetHandler接口的实现类
     * 对应表中的多条记录
     * 将字段及相应的值作为map中的key和value
     * 构成map对象构成的list
     */
    @Test
    public void queryTest4() {
        Connection connection = null;
        try {
            connection = Utils.getConnection();
            String sql = "select id,name,email,birth from customers where id > ?";
            QueryRunner runner = new QueryRunner();
            MapListHandler handler = new MapListHandler();
            List<Map<String, Object>> list = runner.query(connection, sql, handler, 10);
            list.forEach(System.out::println);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Utils.closeResource(connection, null);
        }
    }

    /**
     * ScalarHandler:是ResultSetHandler接口的实现类
     * 对应表中的多条记录
     * 将字段及相应的值作为map中的key和value
     * 构成map对象构成的list
     */
    @Test
    public void queryTest5() {
        Connection connection = null;
        try {
            connection = Utils.getConnection();
            String sql = "select count(*) from customers";
            QueryRunner runner = new QueryRunner();
            ScalarHandler handler = new ScalarHandler();
            Long count = (Long) runner.query(connection, sql, handler);
            System.out.println("共" + count + "条数据");
            sql = "select max(birth) from customers";
            Date maxBirth = (Date) runner.query(connection, sql, handler);
            System.out.println("最大的生日是：" + maxBirth);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Utils.closeResource(connection, null);
        }
    }

}
