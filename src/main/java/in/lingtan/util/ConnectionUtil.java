package in.lingtan.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionUtil {
	
	private ConnectionUtil() {
		//Default constructor
	}
	
	/**
	 * This method creates a database connection.
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		
		String driverClass = "org.postgresql.Driver";
		String url = "jdbc:postgresql://localhost/employeedb";
		String userName = "postgres";
		String password = "@Lingtan1112";
	
		Class.forName(driverClass);
		
		return DriverManager.getConnection(url, userName, password);
		
	
	}
	
	/**
	 * This method is used to close the connection of Resultset connection and prepared statement
	 * Method overloading
	 * @param con
	 */
	public static void close( ResultSet rs, Statement statement, Connection con) {
		try {
			
			if(rs!=null) {
				rs.close();
			}
			
			if(statement!= null) {
				statement.close();
			}
			
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method closes the connections for statement and connection.
	 * @param statement
	 * @param con
	 */
	public static void close(Statement statement, Connection con) {
		try {
			if (statement != null) {
				statement.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
