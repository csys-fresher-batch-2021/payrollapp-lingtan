package in.lingtan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import in.lingtan.exceptions.CannotChangePasswordException;
import in.lingtan.exceptions.CannotGetCredentialException;
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
	 * @throws CannotGetCredentialException 
	 */
	
	public Map<String, String>  adminCredentialData() throws ClassNotFoundException, SQLException, CannotGetCredentialException {
		
		Map<String, String> userCredetials = new HashMap<>();
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			userCredetials = new HashMap<>();
			
			connection = ConnectionUtil.getConnection();
						
			String sql = "select * from user_service";
			pst = connection.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				String username = rs.getString("username");
				String password = rs.getString("password");
				userCredetials.put(username,password);
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new CannotGetCredentialException(e.getMessage());
		}
		finally {
			ConnectionUtil.close(rs, pst,  connection);
		}		
		return userCredetials;
	}

	/**
	 * This method returns a HashMap containing username and password to the service class calling it.
	 * @return
	 * @throws CannotGetCredentialException 
	 */
	public Map<String, String> employeeCredentialData() throws ClassNotFoundException, SQLException, CannotGetCredentialException{
		
		Map<String, String> employeeCredetials = new HashMap<>();
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			employeeCredetials = new HashMap<>();
			
			connection = ConnectionUtil.getConnection();
			
			String sql = "select employee_id,password from employee_data";
			pst = connection.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				String username = rs.getString("employee_id");
				String password = rs.getString("password");
				employeeCredetials.put(username,password);
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new CannotGetCredentialException(e.getMessage());
		}
		finally {
			ConnectionUtil.close(rs, pst,  connection);
		}	
		
		return employeeCredetials;
	}
	
	/**
	 * This method gets the new password and employeeid as parameter and updates the new password with the old password.
	 * @param employeeId
	 * @param newPassword
	 * @return
	 * @throws CannotGetCredentialException
	 * @throws CannotChangePasswordException
	 */
	public boolean changePassword(String employeeId, String newPassword) throws CannotGetCredentialException, CannotChangePasswordException {
		
		boolean isChanged = false;
		Connection connection = null;
		PreparedStatement pst = null;
		
		try {
			connection = ConnectionUtil.getConnection();
			
			String sql = "update employee_data set password=? where employee_id=?";
			pst = connection.prepareStatement(sql);
			pst.setString(1, newPassword);
			pst.setString(2, employeeId);
			
			int rs = pst.executeUpdate();
			
			if(rs==1) {
				 isChanged = true;
			}
			else {
				throw new CannotChangePasswordException("Cannot Change the password");
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new CannotGetCredentialException(e.getMessage());
		}
		finally {
			ConnectionUtil.close(pst,  connection);
		}	
			
		return isChanged;
		
	}
	
}
