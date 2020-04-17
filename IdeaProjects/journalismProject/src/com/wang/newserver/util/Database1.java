package com.wang.newserver.util;

import java.sql.*;

/**
 * @author Wang
 * @version 1.0
 * @date 2020/4/15  18:46
 */
public class Database1 {
    public static final String dbDriver = "com.mysql.cj.jdbc.Driver";
    public static final String dbURL = "jdbc:mysql://127.0.0.1:3306/yang?serverTimezone=UTC";
    public static final String dbUserName = "root";
    public static final String dbPassword = "root";
    public static Connection con = null;
    public static PreparedStatement pst = null;
    public static ResultSet rst = null;
    public static Statement stt = null;

    public static Connection getCon() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            con = DriverManager.getConnection(dbURL, dbUserName, dbPassword);
            System.out.println("数据库连接成功...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    public static void close(Connection con, Statement stt, ResultSet rst) {
        if (rst != null) {
            try {
                rst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stt != null) {
            try {
                stt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public static void close(Connection con, PreparedStatement pst) {
        if (pst != null) {
            try {
                pst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
