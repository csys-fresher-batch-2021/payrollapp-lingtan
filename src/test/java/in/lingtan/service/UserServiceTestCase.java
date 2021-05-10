package in.lingtan.service;

import static org.junit.Assert.*;

import org.junit.Test;



public class UserServiceTestCase {

	@Test
	public void adminValidationTest1() { // Valid employeeID and Password
		String employeeId = "Ling2657";
		String password =  "@Password123";
		boolean inValidCredentials = UserService.adminValidation(employeeId, password);
		assertTrue(inValidCredentials);	
	}
	@Test
	public void adminValidationTest2() { //Invalid employeeId and password
		String employeeId = "Ling2657";
		String password =  "@Password1";
		boolean inValidCredentials = UserService.adminValidation(employeeId, password);
		assertFalse(inValidCredentials);
	}	
	
	@Test
	public void adminValidationTest3() { //valid employeeId and Invalid password
		String employeeId = "Ling2657";
		String password =  "@Passssss1123";
		boolean inValidCredentials = UserService.adminValidation(employeeId, password);
		assertFalse(inValidCredentials);	
	}	
	
	@Test
	public void adminValidationTest4() { //Invalid employeeId and Invalid password
		String employeeId = "Ling265";
		String password =  "@Passss1123";
		boolean inValidCredentials = UserService.adminValidation(employeeId, password);
		assertFalse(inValidCredentials);	
	}	


	@Test
	public void adminValidationTest5() { //Null empl
		String employeeId = null;
		String password =  null;
		boolean inValidCredentials = UserService.adminValidation(employeeId, password);
		assertFalse(inValidCredentials);	
	}	

}
