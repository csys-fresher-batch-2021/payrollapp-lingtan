package in.lingtan.service;

import java.util.HashMap;
import java.util.Map;

import in.lingtan.validator.UserValidator;

public class UserService {
	
	private UserService() {
		//Default constructor
	}

	private final static Map<String, String> adminCredentialHashTable = new HashMap<>();

	static {
		adminCredentialHashTable.put("Ling2657", "@Password123");
	}

	/**
	 * This method is used to validate the admin credentials that he is a valid
	 * admin or not
	 * 
	 * @param adminUsername
	 * @param adminPassword
	 * @return
	 */

	public static boolean adminValidation(String adminUsername, String adminPassword) {
		boolean isValidAdmin = false;
		boolean isEmployeeIdValid = UserValidator.employeeIdValidation(adminUsername);
		boolean isValidPasswordFormat = UserValidator.isValidPasswordFormat(adminPassword);
		if (isEmployeeIdValid && isValidPasswordFormat && adminCredentialHashTable.containsKey(adminUsername) && adminPassword.equals(adminCredentialHashTable.get(adminUsername))) {
						isValidAdmin = true;
		}
		return isValidAdmin;

	}

}
