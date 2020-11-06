package cn.edu.bjfu.dao;

import cn.edu.bjfu.javabean.Customer;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

/**
 * @author Chao Huaiyu
 * @date 2020/11/6
 */
public class CustomerDAOImpl extends BaseDAO implements CustomerDAO {


    @Override
    public void insert(Connection connection, Customer customer) {
        String insertSql = "insert into customers(name,email,birth)values(?,?,?)";
        update(connection, insertSql, customer.getName(), customer.getEmail(), customer.getBirth());
    }

    @Override
    public void deleteById(Connection connection, int id) {
        String deleteSql = "delete from customers where id = ?";
        update(connection, deleteSql, id);
    }

    @Override
    public void update(Connection connection, Customer customer) {
        String updateSql = "update customers set name = ?,email = ?,birth = ? where id = ?";
        update(connection, updateSql, customer.getName(), customer.getEmail(), customer.getBirth(), customer.getId());
    }

    @Override
    public Customer getCustomerById(Connection connection, int id) {
        String sql = "select id,name,email,birth from customers where id = ?";
        return getInstance(connection, Customer.class, sql, id);
    }

    @Override
    public List<Customer> getAll(Connection connection) {
        String sql = "select id,name,email,birth from customers";
        return getForList(connection, Customer.class, sql);
    }

    @Override
    public Long getCount(Connection connection) {
        String sql = "select count(*) from customers";
        return getValue(connection, sql);
    }

    @Override
    public Date getMaxBirth(Connection connection) {
        String sql = "select max(birth) from customers";
        return getValue(connection, sql);
    }
}
