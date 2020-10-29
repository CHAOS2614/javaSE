package com.bjfu.collectionmap.generic;

import java.util.List;

/**
 * @author Chao Huaiyu
 * @date 2020/10/25
 */
public class DAOTest {

    public static void main(String[] args) {
        DAO<User> dao = new DAO<>();

        dao.save("1001",new User(1001,12,"ana"));
        dao.save("1002",new User(1002,24,"tom"));
        dao.save("1003",new User(1003,32,"sam"));
        List<User> list = dao.list();
        list.forEach(System.out::println);

        System.out.println("------update------");
        dao.update("1003",new User(1003,30,"tin"));
        list = dao.list();
        list.forEach(System.out::println);

        System.out.println("------delete------");
        dao.delete("1002");
        list = dao.list();
        list.forEach(System.out::println);
    }
}
