package cn.edu.bjfu.preparedstatement;

import cn.edu.bjfu.Utils;
import cn.edu.bjfu.javabean.Customer;
import cn.edu.bjfu.javabean.Order;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.*;

/**
 * @author Chao Huaiyu
 * @date 2020/11/4
 */
public class PreparedStatementQueryTest {

    @Test
    public void getInstanceTest(){
        String sql = "select id,name,email,birth from customers where id = ?";
        Customer customer = getInstance(Customer.class, sql, 12);
        System.out.println(customer);

        //因为表中属性名与javabean中的不一致，sql语句中要有别名
        String sql1= "select order_id orderId,order_name orderName from `order` where order_name = ?";
        Order order = getInstance(Order.class,sql1,"AA");
        System.out.println(order);

    }

    public  <T> T getInstance(Class<T> clazz, String sql,Object...args){

        Connection connection = Utils.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = connection.prepareStatement(sql);
            for(int i=0;i<args.length;i++){
                preparedStatement.setObject(i+1,args[i]);
            }
            resultSet = preparedStatement.executeQuery();
            //获取结果集的元数据ResultSetMetaData
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            //通过ResultSetMetaData获取结果集中的列数
            int columnCount = resultSetMetaData .getColumnCount();

            if(resultSet.next()){
                T t = clazz.newInstance();
                //处理结果集一行数据的每一列
                for (int i = 0; i < columnCount; i++) {
                    //获取列值
                    Object columnValue = resultSet.getObject(i+1);
                    //回去列的别名
                    String columnLabel = resultSetMetaData.getColumnLabel(i+1);
                    //通过反射，给对象t的指定columnLabel属性赋值为columnValue
                    Field field = clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t,columnValue);
                }
                return t;
            }
        } catch (SQLException | InstantiationException | IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        } finally {
            Utils.closeResource(connection,preparedStatement,resultSet);
        }
        return  null;
    }
}
