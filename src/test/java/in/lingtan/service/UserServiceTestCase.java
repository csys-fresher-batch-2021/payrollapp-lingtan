package in.lingtan.service;

import static org.junit.Assert.*;
import org.junit.Test;

public class UserServiceTestCase {

	/**
	 * Valid employeeID and Password
	 */
	@Test
	public void adminValidationTestBothValid() {
		String employeeId = "Ling12007";
		String password = "@Lingtan1112";
		boolean inValidCredentials = UserService.adminValidation(employeeId, password);
		assertTrue(inValidCredentials);
	}

	/**
	 * valid employeeId and invalid password
	 */
	@Test
	public void credentialsMismatchTestCase() {
		try {
			String employeeId = "Ling12007";
			String password = "@Password1";
			boolean inValidCredentials = UserService.adminValidation(employeeId, password);
			assertFalse(inValidCredentials);
		} catch (Exception e) {
			assertEquals("Invalid Admin Credentials", e.getMessage());
		}

	}

}
