package in.lingtan.service;

import java.util.HashMap;
import java.util.Map;


public class UserService {
	
	private UserService() {
		//Default constructor
	}

	private final static Map<String, String> adminCredentialHashTable = new HashMap<>();

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
	 */

	public static boolean adminValidation(String adminUsername, String adminPassword) {
			
		boolean isValidAdmin = false;
		if (adminCredentialHashTable.containsKey(adminUsername) && adminPassword.equals(adminCredentialHashTable.get(adminUsername))) {
						isValidAdmin = true;
						return isValidAdmin;
		}
		else {
			throw new RuntimeException("Invalid Admin Credentials");
		}
		
	}
}
