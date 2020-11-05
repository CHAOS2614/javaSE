package cn.edu.bjfu.transaction;

import cn.edu.bjfu.Utils;
import cn.edu.bjfu.dao.BaseDAO;
import cn.edu.bjfu.preparedstatement.PreparedStatementTest;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 事务处理示例
 *
 * @author Chao Huaiyu
 * @date 2020/11/5
 */
public class TransactionTest {

    /**
     * 针对数据表user_table来说
     * AA给BB转账100
     * <p>
     * update user_table set balance = balance - 100 where user = 'AA";
     * update user_table set balance = balance + 100 where user = 'BB";
     */
    @Test
    public void updateTest() {

        String sql1 = "update user_table set balance = balance - 100 where user = ?";
        update(sql1, "AA");

        //模拟网络异常,则AA转账，BB没收到
        System.out.println(10 / 0);

        String sql2 = "update user_table set balance = balance + 100 where user = ?";
        update(sql2, "BB");

        System.out.println("success");

    }

    @Test
    public void updateTest2() {

        Connection connection = null;
        try {
            connection = Utils.getConnection();
            //取消数据的自动提交
            connection.setAutoCommit(false);
            String sql1 = "update user_table set balance = balance - 100 where user = ?";
            update(connection, sql1, "AA");

            //模拟网络异常,则AA转账，BB没收到
            System.out.println(10 / 0);

            String sql2 = "update user_table set balance = balance + 100 where user = ?";
            update(connection, sql2, "BB");
            connection.commit();
        } catch (Exception e) {
            //出现异常，回滚
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            if(connection!=null){
                try {
                    connection.setAutoCommit(true);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            Utils.closeResource(connection, null);
        }


    }

    private int update(String sql, Object... args) {
        PreparedStatementTest ps = new PreparedStatementTest();
        return ps.update(sql, args);
    }

    public int update(Connection connection, String sql, Object... args) {

        BaseDAO baseDAO = new BaseDAO();
        return baseDAO.update(connection,sql,args);
    }
}
