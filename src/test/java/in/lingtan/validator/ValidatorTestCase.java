package in.lingtan.validator;

import static org.junit.Assert.*;

import org.junit.Test;

import in.lingtan.util.StringValidator;

public class ValidatorTestCase {
	
	/**
	 *Null employee id is validated
	 */
	@Test
	public void isEmployeeIdNull() { 
		String employeeName = null;
		boolean isValidEmployeeId = StringValidator.isEmployeeIdEmptyAndNull(employeeName);
		assertFalse(isValidEmployeeId);
	}
	
	/**
	 * valid string is passed
	 */
	@Test
	public void isEmployeeIdValidCase() { 
		String employeeName = "Ling";
		boolean isValidEmployeeId = StringValidator.isEmployeeIdEmptyAndNull(employeeName);
		assertTrue(isValidEmployeeId);
	}
	
	/**
	 * employeeId is empty
	 */
	@Test
	public void isEmployeeIdEmpty() { 
		String employeeName = "";
		boolean isValidEmployeeId = StringValidator.isEmployeeIdEmptyAndNull(employeeName);
		assertFalse(isValidEmployeeId);
	}
	
	/**
	 *Valid employeeId length  is validated 
	 */
	@Test
	public void isValidEmployeeIdValidLengthTest() { 
		String employeeName = "Ling2657";
		boolean isValidEmployeeId = StringValidator.isValidEmployeeIdLength(employeeName);
		assertTrue(isValidEmployeeId);
	}
	
	/**
	 * Invalid employee Id is validated
	 */
	@Test
	public void isValidEmployeeIdInvalidLengthTest() { 
		String employeeName = "Ling267";
		boolean isValidEmployeeId = StringValidator.isValidEmployeeIdLength(employeeName);
		assertFalse(isValidEmployeeId);
	}
	
	/**
	 * username is wrong password is correct
	 */
	@Test
	public void isValidPasswordFormatValidTest() { 
		String password =  "Lingtan123@";
		boolean isValidPasswordLength = UserValidator.isValidPasswordFormat(password);
		assertTrue(isValidPasswordLength);
	}
	
	/**
	 * Valid employeeId format is validated
	 */
	@Test
		public void isValidFormatEmployyeeIdValidTest() { 
		String employeeName = "Lin2657";
			boolean isValidEmployeeId = UserValidator.isValidEmployyeeIdFormat(employeeName);
	assertFalse(isValidEmployeeId);
	}
	
	
	/**
	 * username is wrong password is correct
	 */
	@Test
	public void isValidPasswordFormatInvalidTest() { 
		String password =  "raja123";
		boolean isValidPasswordLength = UserValidator.isValidPasswordFormat(password);
		assertFalse(isValidPasswordLength);
	}
	

}
