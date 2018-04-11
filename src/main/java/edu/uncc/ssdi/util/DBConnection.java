package edu.uncc.ssdi.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBConnection {
	public static Connection getDBConnection() {
		String myDriver = "com.mysql.jdbc.Driver";
		String myUrl = "jdbc:mysql://localhost:3306/db_example";
		Connection conn = null;
		try {
			Class.forName(myDriver);
			conn = DriverManager.getConnection(myUrl, "root", "root");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
		}
		return conn;
	}
} // end of class