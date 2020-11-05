package cn.edu.bjfu.preparedstatement;

import cn.edu.bjfu.Utils;
import cn.edu.bjfu.dao.BaseDAO;
import cn.edu.bjfu.javabean.Customer;
import cn.edu.bjfu.javabean.Order;
import org.junit.Test;

import java.sql.Connection;
import java.util.List;

/**
 * @author Chao Huaiyu
 * @date 2020/11/4
 */
public class PreparedStatementQueryTest {

    @Test
    public void getInstanceTest(){

        Connection connection = Utils.getConnection();
        BaseDAO baseDAO = new BaseDAO();
        String sql = "select id,name,email,birth from customers where id = ?";
        Customer customer =baseDAO.getInstance(connection, Customer.class, sql, 12);
        System.out.println(customer);

        //因为表中属性名与javabean中的不一致，sql语句中要有别名
        String sql1= "select order_id orderId,order_name orderName from `order` where order_name = ?";
        Order order = baseDAO.getInstance(connection, Order.class,sql1,"AA");
        System.out.println(order);

    }

    @Test
    public void getList(){
        Connection connection = Utils.getConnection();
        BaseDAO baseDAO = new BaseDAO();
        String sql = "select id,name,email,birth from customers where id < ?";
        List<Customer> list =baseDAO.getForList(connection, Customer.class, sql, 12);
        list.forEach(System.out::println);

        String sql1= "select order_id orderId,order_name orderName from `order` ";
        List<Order> list1 = baseDAO.getForList(connection, Order.class,sql1);
        list1.forEach(System.out::println);
    }

}
