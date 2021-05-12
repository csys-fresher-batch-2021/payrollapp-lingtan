package in.lingtan.service;

import static org.junit.Assert.*;

import org.junit.Test;


public class UserServiceTestCase {
   
	/**
	 * Valid employeeID and Password
	 */
	@Test
	public void adminValidationTestBothValid() { 
		String employeeId = "Ling2657";
		String password =  "@Password123";
		boolean inValidCredentials = UserService.adminValidation(employeeId, password);
		assertTrue(inValidCredentials);	
	}
	
	/**
	 * valid employeeId and invalid password
	 */
	@Test
	public void adminValidationTestValidEmployeeId() { 
		String employeeId = "Ling2657";
		String password =  "@Password1";
		boolean inValidCredentials = UserService.adminValidation(employeeId, password);
		assertFalse(inValidCredentials);
	}	
	
	/**
	 * valid employeeId and Invalid password
	 */
	@Test
	public void adminValidationTestValidPassword() { 
		String employeeId = "Ling2657";
		String password =  "@Password123";
		boolean inValidCredentials = UserService.adminValidation(employeeId, password);
		assertTrue(inValidCredentials);	
	}	
	
	/**
	 * Invalid employeeId and Invalid password
	 */
	@Test
	public void adminValidationTestBothInvalid() { 
		String employeeId = "Ling265";
		String password =  "@Passss1123";
		boolean inValidCredentials = UserService.adminValidation(employeeId, password);
		assertFalse(inValidCredentials);	
	}	

	/**
	 *Null employee
	 */
	@Test
	public void adminValidationTestBothNull() { 
		String employeeId = null;
		String password =  null;
		boolean inValidCredentials = UserService.adminValidation(employeeId, password);
		assertFalse(inValidCredentials);	
	}	

}
