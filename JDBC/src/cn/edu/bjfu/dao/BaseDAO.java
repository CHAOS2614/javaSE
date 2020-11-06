package cn.edu.bjfu.dao;

import cn.edu.bjfu.Utils;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 封装了针对数据表的通用操作
 *
 * @author Chao Huaiyu
 * @date 2020/11/5
 */
public class BaseDAO {

    /**
     * update2.0,考虑上事务
     *
     * @param connection 数据库连接
     * @param sql        sql语句
     * @param args       填充占位符数据
     * @return 修改数据条数
     */
    public int update(Connection connection, String sql, Object... args) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }
            //返回修改数据的行数
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Utils.closeResource(null, preparedStatement);
        }
        return 0;
    }

    /**
     * 查询一条数据
     *
     * @param connection 数据库连接
     * @param clazz      要查询的类
     * @param sql        sql语句
     * @param args       占位符
     * @param <T>        泛型
     * @return 所查类
     */
    public <T> T getInstance(Connection connection, Class<T> clazz, String sql, Object... args) {

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }
            resultSet = preparedStatement.executeQuery();
            //获取结果集的元数据ResultSetMetaData
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            //通过ResultSetMetaData获取结果集中的列数
            int columnCount = resultSetMetaData.getColumnCount();
            if (resultSet.next()) {
                T t = clazz.newInstance();
                //处理结果集一行数据的每一列
                setColumn(clazz, resultSet, resultSetMetaData, columnCount, t);
                return t;
            }
        } catch (SQLException | InstantiationException | IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        } finally {
            Utils.closeResource(null, preparedStatement, resultSet);
        }
        return null;
    }

    /**
     * 查询多条数据
     *
     * @param connection 数据库连接
     * @param clazz      要查询的类
     * @param sql        sql语句
     * @param args       占位符
     * @param <T>        泛型
     * @return 所查类
     */
    public <T> List<T> getForList(Connection connection, Class<T> clazz, String sql, Object... args) {

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }
            resultSet = preparedStatement.executeQuery();
            //获取结果集的元数据ResultSetMetaData
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            //通过ResultSetMetaData获取结果集中的列数
            int columnCount = resultSetMetaData.getColumnCount();
            ArrayList<T> list = new ArrayList<>();
            while (resultSet.next()) {
                T t = clazz.newInstance();
                //处理结果集一行数据的每一列:给t对象指定的属性赋值
                setColumn(clazz, resultSet, resultSetMetaData, columnCount, t);
                list.add(t);
            }
            return list;
        } catch (SQLException | InstantiationException | IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        } finally {
            Utils.closeResource(null, preparedStatement, resultSet);
        }
        return null;
    }


    public <E> E getValue(Connection connection, String sql, Object... args) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            rs = ps.executeQuery();
            if (rs.next()) {
                return (E) rs.getObject(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Utils.closeResource(null, ps, rs);
        }
        return null;

    }

    /**
     * 给指定对象复制
     */
    private <T> void setColumn(Class<T> clazz, ResultSet resultSet, ResultSetMetaData resultSetMetaData, int columnCount, T t) throws SQLException, NoSuchFieldException, IllegalAccessException {
        for (int i = 0; i < columnCount; i++) {
            //获取列值
            Object columnValue = resultSet.getObject(i + 1);
            //回去列的别名
            String columnLabel = resultSetMetaData.getColumnLabel(i + 1);
            //通过反射，给对象t的指定columnLabel属性赋值为columnValue
            Field field = clazz.getDeclaredField(columnLabel);
            field.setAccessible(true);
            field.set(t, columnValue);
        }
    }
}
