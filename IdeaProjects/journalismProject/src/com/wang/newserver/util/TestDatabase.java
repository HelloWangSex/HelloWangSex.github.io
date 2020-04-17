package com.wang.newserver.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Wang
 * @version 1.0
 * @date 2020/3/24  22:17
 */
public class TestDatabase {
    public static void main(String[] args) {
//        System.out.println("Hello World!");
        Connection connection;
        PreparedStatement preparedStatement;
        try {
            connection = Database1.getCon();
            System.out.println("成功连接上数据库的封装！！！");
            String sql = "insert into user(user_id,password,verify_password,mobile)values(?,?,?,?)";
           //String sql = "insert into test(name ,password)values(?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "88888888");
            preparedStatement.setString(2, "110");
            preparedStatement.setString(3, "110");
            preparedStatement.setString(4, "10086");
            preparedStatement.executeUpdate();
            System.out.println("完成添加！");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
