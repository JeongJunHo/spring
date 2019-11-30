package edu.ssafy.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCProxy {
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("class load fail!");
		}
	}

	public static Connection getConnection() {
		Connection conn = null;

		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/springweb?serverTimezone=UTC&useSSL=false&useUniCode=yes&characterEncoding=UTF-8",
					"ssafy", "ssafy");
		} catch (SQLException e) {
			System.out.println("Database Connection fail....!");
		}
		return conn;
	}

	public static void close(Statement st, Connection conn, ResultSet rs) {
		try {
			if (rs != null) rs.close();
			if (st != null) st.close();
			if (conn != null) conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void close(Statement st, Connection conn) {
		try {
			if (st != null) st.close();
			if (conn != null) conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
