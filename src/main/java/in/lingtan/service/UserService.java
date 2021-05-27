package in.lingtan.service;

import java.sql.SQLException;

import java.util.Map;

import in.lingtan.dao.UserServiceDAO;
import in.lingtan.exceptions.CannotGetCredentialException;
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
	 * @throws CannotGetCredentialException 
	 * @throws InvalidCredentialsException 
	 */
	
	public static boolean adminValidation(String adminUsername, String adminPassword) throws ClassNotFoundException, SQLException, CannotGetCredentialException  {
		UserServiceDAO userServiceDAO = new UserServiceDAO();
		boolean isValidCredentials = false;
		Map<String, String> userCredetials = userServiceDAO.adminCredentialData();
		if (userCredetials.containsKey(adminUsername) && adminPassword.equals(userCredetials.get(adminUsername))) {
			isValidCredentials =  true;
		}
		return isValidCredentials;
	}
	
	/**
	 * This method validates the employee username and password and returns true if credentials are valid else raises an exception.
	 * @param employeeId
	 * @param password
	 * @return
	 * @throws InvalidCredentialsException
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws CannotGetCredentialException 
	 */
	public static boolean employeeLoginValidation(String employeeId, String password) throws InvalidCredentialsException, ClassNotFoundException, SQLException, CannotGetCredentialException {
				
		UserServiceDAO userServiceDAO = new UserServiceDAO();
		Map<String, String> employeeCredentials = userServiceDAO.employeeCredentialData();
		if (employeeCredentials.containsKey(employeeId) && password.equals(employeeCredentials.get(employeeId))) {
			return true;
		} else {
			throw new InvalidCredentialsException("Invalid Credentials");
		}
		
	}
	
}
