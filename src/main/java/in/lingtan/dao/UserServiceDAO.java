package in.lingtan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import in.lingtan.util.ConnectionUtil;


public class UserServiceDAO {
	
	public UserServiceDAO() {
		//Default constructor
	}
	
	/** 
	 * This method returns a hashmap of admin credentials required for the verification process
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	
	public Map<String, String>  adminCredentialData() throws ClassNotFoundException, SQLException {
		
		Map<String, String> userCredetials = new HashMap<>();
		
		Connection connection = ConnectionUtil.getConnection();
		
		
		String sql = "select * from user_service";
		PreparedStatement pst = connection.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		
		while(rs.next()) {
			String username = rs.getString("username");
			String password = rs.getString("password");
			userCredetials.put(username,password);
		}
		ConnectionUtil.close(rs, pst,  connection);
		
		return userCredetials;
	}
	
}
