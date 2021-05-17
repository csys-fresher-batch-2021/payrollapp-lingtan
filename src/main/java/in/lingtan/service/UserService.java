package in.lingtan.service;

import java.util.HashMap;
import java.util.Map;

import in.lingtan.exceptions.InvalidCredentialsException;


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

	public static boolean adminValidation(String adminUsername, String adminPassword)  {
			
		boolean isValidCredentials = false;
		if (adminCredentialHashTable.containsKey(adminUsername) && adminPassword.equals(adminCredentialHashTable.get(adminUsername))) {
			isValidCredentials =  true;
		}
		return isValidCredentials;
	}
}
