package com.hand.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCcon {

	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/sakila?user=root&password=123456&serverTimezone=GMT");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void close(Connection con, PreparedStatement ps, ResultSet rs)
			throws SQLException {
		if(null!=con){
			con.close();
		}
		ps.close();
		if (null != rs) {
			rs.close();
		}
	}
}