package com.xtgj.j2ee.chapter02.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;


public class DBUtil {

	private static String driver = "";
	private static String url = "";
	private static String username = "";
	private static String userpass = "";

	private static DBUtil db = new DBUtil();

	private DBUtil() {
		this.init();
		try {
			System.out.println(driver);
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			//pfe(e);
		}
	}

	/**
	 * 用于获取数据库连接对象
	 * @return
	 */
	public static Connection getConn() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, username, userpass);
		} catch (SQLException e) {
			pfe(e);
		}
		return conn;
	}
	

	/**
	 * 用于关闭数据库对象
	 * @param rs
	 * @param stmt
	 * @param conn
	 */
	public static void close(ResultSet rs, Statement stmt, Connection conn) {
		try {
			if (rs != null)	rs.close();
			if (stmt != null)	stmt.close();
			if (conn != null)	conn.close();
		} catch (SQLException e) {
			pfe(e);
		}
	}

	/**
	 * 这里要求db.properties文件必须在src根目录下
	 */
	private void init() {
		ResourceBundle rb = ResourceBundle.getBundle("db");
		driver = rb.getString("driverClassName");
		url = rb.getString("url");
		username = rb.getString("userName");
		userpass = rb.getString("password");
	}

	private static void pfe(Exception e) {
		System.out.println("===" + e.getMessage() + "===");
	}
}
