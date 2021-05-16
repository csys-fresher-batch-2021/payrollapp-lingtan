package in.lingtan.service;

import java.util.HashMap;
import java.util.Map;

import in.lingtan.EmployeeExceptions.InvalidCredentialsException;


public class UserService {
	
	private UserService() {
		//Default constructor
	}

	private static final Map<String, String> adminCredentialHashTable = new HashMap<>();

	static {
		adminCredentialHashTable.put("Ling12007", "@Lingtan1112");
	}

	/**
	 * This method is used to validate the admin credentials that he is a valid
	 * admin or not
	 * 
	 * @param adminUsername
	 * @param adminPassword
	 * @return
	 * @throws InvalidCredentialsException 
	 */

	public static boolean adminValidation(String adminUsername, String adminPassword) throws InvalidCredentialsException {
			
		
		if (adminCredentialHashTable.containsKey(adminUsername) && adminPassword.equals(adminCredentialHashTable.get(adminUsername))) {
					return true;
		}
		else {
			throw new InvalidCredentialsException("Invalid Admin Credentials");
		}
		
	}
}
