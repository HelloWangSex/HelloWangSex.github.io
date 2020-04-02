package com.xtgj.j2ee.chapter02.user.biz;

import java.sql.*;

import com.xtgj.j2ee.chapter02.db.DBUtil;


public class UserManager {
    Connection conn = null;
    Statement st = null;
    ResultSet rs = null;

    public UserManager() {
        this.conn = DBUtil.getConn();
    }

    public boolean check(String uname) throws SQLException {
        try {
            st = conn.createStatement();
            String sql = "select * from user_table where username='" + uname
                    + "'";
            System.out.println(sql);
            rs = st.executeQuery(sql);
            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, st, conn);
        }
        return false;
    }

    public boolean register(String uname, String pwd) throws SQLException {
        try {
            st = conn.createStatement();
            String sql = "insert into user_table(username,passwd) values('" + uname + "','" + pwd + "')";
            System.out.println(sql);
            boolean b1 = st.execute(sql);
            return b1;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, st, conn);
        }
        return false;
    }
}

