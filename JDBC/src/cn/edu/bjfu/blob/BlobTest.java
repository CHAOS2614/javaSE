package cn.edu.bjfu.blob;

import cn.edu.bjfu.Utils;
import cn.edu.bjfu.dao.BaseDAO;
import cn.edu.bjfu.javabean.Customer;
import cn.edu.bjfu.preparedstatement.PreparedStatementTest;
import org.junit.Test;

import java.io.*;
import java.sql.*;

/**
 * @author Chao Huaiyu
 * @date 2020/11/5
 */
public class BlobTest {

    @Test
    public void insertTest() {
        String sql = "insert into customers(name,email,birth,photo)values(?,?,?,?)";

        String name = "美铃遥";
        String email = "love@fragtime.com";
        String birth = "2019-11-22";
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("images\\fragile.JPG");
            PreparedStatementTest pst = new PreparedStatementTest();
            pst.update(sql, name, email, birth, fileInputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void queryTest() {
        Connection connection = Utils.getConnection();
        String sql = "select id,name,email,birth from customers where id =?";
        BaseDAO psqt = new BaseDAO();
        Customer customer = psqt.getInstance(connection,Customer.class, sql, 20);
        System.out.println(customer);
        Utils.closeResource(connection,null);

        connection = Utils.getConnection();
        String sql2 = "select photo from customers where id = ?";
        InputStream binaryStream = null;
        FileOutputStream fos = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(sql2);
            ps.setInt(1, 20);

            rs = ps.executeQuery();
            if (rs.next()) {

                Blob photo = rs.getBlob("photo");
                binaryStream = photo.getBinaryStream();
                fos = new FileOutputStream("images\\fragile2.jpg");
                byte[] buffer = new byte[1024];
                int len;
                while ((len = binaryStream.read(buffer)) != -1) {
                    fos.write(buffer, 0, len);
                }
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        } finally {
            if (binaryStream != null) {
                try {
                    binaryStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            Utils.closeResource(connection, ps, rs);
        }
    }
}
