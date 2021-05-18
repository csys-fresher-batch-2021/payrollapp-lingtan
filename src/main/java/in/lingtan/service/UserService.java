package in.lingtan.service;

import java.sql.SQLException;
import java.util.Map;

import in.lingtan.dao.UserServiceDAO;
import in.lingtan.exceptions.InvalidCredentialsException;


public class UserService {
	
	private UserService() {
		//Default constructor
	}

	/**
	 * This method is used to validate the admin credentials that he is a valid
	 * admin or not
	 * 
	 * @param adminUsername
	 * @param adminPassword
	 * @return
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws InvalidCredentialsException 
	 */
	
	public static boolean adminValidation(String adminUsername, String adminPassword) throws ClassNotFoundException, SQLException  {
		UserServiceDAO userServiceDAO = new UserServiceDAO();
		boolean isValidCredentials = false;
		Map<String, String> userCredetials = userServiceDAO.adminCredentialData();
		if (userCredetials.containsKey(adminUsername) && adminPassword.equals(userCredetials.get(adminUsername))) {
			isValidCredentials =  true;
		}
		return isValidCredentials;
	}
}
