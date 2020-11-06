package cn.edu.bjfu.dao;

import cn.edu.bjfu.javabean.Customer;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

/**
 * 此接口用于规范针对于customers表的常用操作
 *
 * @author Chao Huaiyu
 * @date 2020/11/6
 */
public interface CustomerDAO {

    /**
     * 将customer 对象添加到数据库中
     *
     * @param connection 数据库连接
     * @param customer   要添加的customer对象
     */
    void insert(Connection connection, Customer customer);

    /**
     * 根据指定的id，删除表中的一条数据
     *
     * @param connection 数据库连接
     * @param id         要删除数据的id
     */
    void deleteById(Connection connection, int id);

    /**
     * 根据customer对象，修改数据库表中的指定记录
     *
     * @param connection 数据库连接
     * @param customer   指定的customer对象
     */
    void update(Connection connection, Customer customer);

    /**
     * 通过指定的id，返回表中相应的数据
     *
     * @param connection 数据库连接
     * @param id         要活的数据的id
     * @return 查询的数据
     */
    Customer getCustomerById(Connection connection, int id);

    /**
     * 返回表中所有的数据
     *
     * @param connection 数据库连接
     * @return 所有数据
     */
    List<Customer> getAll(Connection connection);

    /**
     * 查询数据库中数据的条数
     *
     * @param connection 数据库连接
     * @return 数据条数
     */
    Long getCount(Connection connection);

    /**
     * 返回生日日期最大的数据
     *
     * @param connection 数据库连接
     * @return 日期
     */
    Date getMaxBirth(Connection connection);
}
