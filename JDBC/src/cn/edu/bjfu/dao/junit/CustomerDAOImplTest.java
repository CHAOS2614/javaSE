package cn.edu.bjfu.dao.junit;

import cn.edu.bjfu.Utils;
import cn.edu.bjfu.dao.CustomerDAOImpl;
import cn.edu.bjfu.javabean.Customer;
import org.junit.Test;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author Chao Huaiyu
 * @date 2020/11/6
 */
public class CustomerDAOImplTest {

    private CustomerDAOImpl dao = new CustomerDAOImpl();

    @Test
    public void insert() {

        Connection connection = Utils.getConnection();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date birth = sdf.parse("2010-12-12");
            Customer customer = new Customer(12, "高子豪", "zihao@haoaho.com", new java.sql.Date(birth.getTime()));
            dao.insert(connection, customer);
            System.out.println("添加成功！");
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            Utils.closeResource(connection, null);
        }
    }

    @Test
    public void deleteById() {
        Connection connection = Utils.getConnection();
        try {
            dao.deleteById(connection, 23);
            System.out.println("删除成功！");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utils.closeResource(connection, null);
        }
    }

    @Test
    public void update() {
        Connection connection = Utils.getConnection();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date birth = sdf.parse("1887-12-12");
            Customer customer = new Customer(8, "贝多芬", "beiduofen@haoaho.com", new java.sql.Date(birth.getTime()));
            dao.update(connection, customer);
            System.out.println("修改成功！");
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            Utils.closeResource(connection, null);
        }
    }

    @Test
    public void getCustomerById() {
        Connection connection = Utils.getConnection();
        try {
            Customer customer = dao.getCustomerById(connection, 4);
            System.out.println(customer);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utils.closeResource(connection, null);
        }
    }

    @Test
    public void getAll() {
        Connection connection = Utils.getConnection();
        try {
            List<Customer> customers = dao.getAll(connection);
            customers.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utils.closeResource(connection, null);
        }
    }

    @Test
    public void getCount() {
        Connection connection = Utils.getConnection();
        try {
            Long count = dao.getCount(connection);
            System.out.println("数据总数为：" + count);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utils.closeResource(connection, null);
        }
    }

    @Test
    public void getMaxBirth() {
        Connection connection = Utils.getConnection();
        try {
            Date date = dao.getMaxBirth(connection);
            System.out.println("最大生日为：" + date);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utils.closeResource(connection, null);
        }
    }
}