package cn.edu.bjfu.inetaddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author Chao Huaiyu
 * @date 2020/10/28
 */
public class InetAddressTest {
    public static void main(String[] args) {
        InetAddress inetAddress = null;
        try {
            inetAddress = InetAddress.getLocalHost();
            InetAddress inetAddress1 = InetAddress.getByName("www.baidu.com");
            System.out.println(inetAddress1);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        System.out.println(inetAddress);
    }
}
