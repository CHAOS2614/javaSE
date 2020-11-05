package cn.edu.bjfu.preparedstatement;

import cn.edu.bjfu.Utils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Chao Huaiyu
 * @date 2020/11/5
 */
public class PrepareStatementInsertTest {

    /**
     * 批量插入
     */
    @Test
    public void insertTest() {
        Connection connection = Utils.getConnection();
        String sql = "insert into goods(name)values(?)";
        PreparedStatement ps = null;
        try {

            long start = System.currentTimeMillis();
            ps = connection.prepareStatement(sql);
            for (int i = 0; i < 20000; i++) {
                ps.setObject(1, "name_" + i + 1);
                ps.execute();
            }
            long end = System.currentTimeMillis();
            System.out.println(end - start);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Utils.closeResource(connection, ps);
        }
    }

    /**
     * addBatch();
     * exe
     */
    @Test
    public void insertTest2() {
        Connection connection = Utils.getConnection();
        String sql = "insert into goods(name)values(?)";
        PreparedStatement ps = null;
        try {
            long start = System.currentTimeMillis();
            ps = connection.prepareStatement(sql);
            for (int i = 0; i < 20000; i++) {
                ps.setObject(1, "name_" + i + 1);

                //1.“攒”sql
                ps.addBatch();

                if(i%500 == 0){
                    //执行
                    ps.executeBatch();

                    //清空batch
                    ps.clearBatch();
                }
            }
            long end = System.currentTimeMillis();
            System.out.println(end - start);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Utils.closeResource(connection, ps);
        }
    }

    @Test
    public void insertTest3() {
        Connection connection = Utils.getConnection();
        String sql = "insert into goods(name)values(?)";
        PreparedStatement ps = null;
        try {
            connection.setAutoCommit(false);
            long start = System.currentTimeMillis();
            ps = connection.prepareStatement(sql);
            for (int i = 0; i < 20000; i++) {
                ps.setObject(1, "name_" + i + 1);

                //1.“攒”sql
                ps.addBatch();

                if(i%500 == 0){
                    //执行
                    ps.executeBatch();

                    //清空batch
                    ps.clearBatch();
                }
            }
            connection.commit();
            long end = System.currentTimeMillis();
            System.out.println(end - start);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Utils.closeResource(connection, ps);
        }
    }
    @Test
    public void deleteTest() {

        Connection connection = Utils.getConnection();
        String sql = "delete from goods";

        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Utils.closeResource(connection, ps);
        }
    }
}
