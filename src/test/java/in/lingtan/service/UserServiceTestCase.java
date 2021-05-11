package in.lingtan.service;

import static org.junit.Assert.*;

import org.junit.Test;



public class UserServiceTestCase {
   
	
	@Test
	public void adminValidationTestBothValid() { // Valid employeeID and Password
		String employeeId = "Ling2657";
		String password =  "@Password123";
		boolean inValidCredentials = UserService.adminValidation(employeeId, password);
		assertTrue(inValidCredentials);	
	}
	@Test
	public void adminValidationTestValidEmployeeId() { //valid employeeId and invalid password
		String employeeId = "Ling2657";
		String password =  "@Password1";
		boolean inValidCredentials = UserService.adminValidation(employeeId, password);
		assertFalse(inValidCredentials);
	}	
	
	@Test
	public void adminValidationTestValidPassword() { //valid employeeId and Invalid password
		String employeeId = "Ling2657";
		String password =  "@Password123";
		boolean inValidCredentials = UserService.adminValidation(employeeId, password);
		assertFalse(inValidCredentials);	
	}	
	
	@Test
	public void adminValidationTestBothInvalid() { //Invalid employeeId and Invalid password
		String employeeId = "Ling265";
		String password =  "@Passss1123";
		boolean inValidCredentials = UserService.adminValidation(employeeId, password);
		assertFalse(inValidCredentials);	
	}	


	@Test
	public void adminValidationTestBothNull() { //Null empl
		String employeeId = null;
		String password =  null;
		boolean inValidCredentials = UserService.adminValidation(employeeId, password);
		assertFalse(inValidCredentials);	
	}	

}
