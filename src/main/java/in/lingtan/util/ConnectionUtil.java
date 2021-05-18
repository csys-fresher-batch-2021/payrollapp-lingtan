package in.lingtan.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	
	private ConnectionUtil() {
		//Default constructor
	}

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		
		String driverClass = "org.postgresql.Driver";
		String url = "jdbc:postgresql://localhost/employeedb";
		String userName = "postgres";
		String password = "@Lingtan1112";
	
		Class.forName(driverClass);
		
		Connection connection = DriverManager.getConnection(url, userName, password);
		System.out.println("Connection Initiated");
		return connection;
	}
	
	public static void close(Connection con) {
		try {
			if (con != null) {
				con.close();
				System.out.println("Connection Released");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
