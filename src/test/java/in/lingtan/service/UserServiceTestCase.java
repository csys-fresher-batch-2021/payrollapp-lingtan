package in.lingtan.service;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import in.lingtan.exceptions.CannotGetCredentialException;
import in.lingtan.exceptions.InvalidCredentialsException;

public class UserServiceTestCase {

	/**
	 * Valid employeeID and Password
	 * @throws InvalidCredentialsException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@Test
	public void adminValidationTestBothValid() throws InvalidCredentialsException, ClassNotFoundException, SQLException {
		String employeeId = "Ling12007";
		String password = "@Lingtan1112";
		boolean inValidCredentials=false;
		try {
			inValidCredentials = UserService.adminValidation(employeeId, password);
		} catch (ClassNotFoundException | SQLException | CannotGetCredentialException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
