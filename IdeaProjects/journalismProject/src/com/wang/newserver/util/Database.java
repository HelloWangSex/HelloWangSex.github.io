package com.wang.newserver.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Wang
 * @version 1.0
 * @date 2020/4/9  13:38
 */
// 连接 远程数据库！！！
public class Database {/*
    static String url = "jdbc:mysql://123.207.150.143:3306/news?characterEncoding=UTF-8";
    static String userName = "news";
    static String password = "kRj7Dc7TLSMbzzSj";
    static String driverName = "com.mysql.jdbc.Driver";


    //静态代码块去加载驱动，只执行一次！
    static {
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, userName, password);
    }

    //测试数据库
    public static void main(String[] args) throws SQLException {
        Connection connection = getConnection();
        System.out.println(connection);
        connection.close();
    }*/

}
