package in.lingtan.validator;

import static org.junit.Assert.*;

import org.junit.Test;

import in.lingtan.exceptions.InvalidEmployeeIdException;
import in.lingtan.exceptions.InvalidEmployeeIdLengthException;

public class UserValidatorTestCase {

	/**
	 * Valid employeeId length is validated
	 * @throws InvalidEmployeeIdLengthException 
	 */
	@Test
	public void ValidEmployeeIdLengthTest()  {
		String employeeId = "Ling12007";
		boolean isValidEmployeeId;
		try {
			isValidEmployeeId = UserValidator.isValidEmployeeIdLength(employeeId);
			assertTrue(isValidEmployeeId);
		} catch (InvalidEmployeeIdLengthException e) {
			
			e.printStackTrace();
		}
		
	}
	
	/**
	 * invalid employeeId length is validated
	 */
	@Test
	public void invalidEmployeeIdLengthTest() {
		try {
			String employeeId = "Ling120";
			boolean isValidEmployeeId = UserValidator.isValidEmployeeIdLength(employeeId);
			assertTrue(isValidEmployeeId);
		} catch (Exception e) {
			assertEquals("Invalid Length", e.getMessage());
		}
	}

	/**
	 * Invalid employee Id is validated
	 * @throws InvalidEmployeeIdException 
	 */
	@Test
	public void InvalidEmployeeIdTest()  {
			String employeeId = "Ling12007";
			boolean isValidEmployeeId;
			try {
				isValidEmployeeId = UserValidator.isValidEmployeeId(employeeId, "Invalid EmployeeID format or length");
				assertTrue(isValidEmployeeId);
			} catch (InvalidEmployeeIdException e) {
				
				e.printStackTrace();
			}
			
	}
	
	/**
	 * Valid employeeId format is validated.
	 */
	@Test
	public void invalidEmployyeeIdFormatTest() {
		try {
			String employeeName = "Ling145";
			boolean isValidEmployeeId = UserValidator.isValidEmployeeIdFormat(employeeName);
			assertTrue(isValidEmployeeId);
		} catch (Exception e) {
			assertEquals("Invalid EmployeeID Format" ,e.getMessage());
		}
	}
	
	/**
	 * Valid employeeId format is validated.
	 */
	@Test
	public void validEmployyeeIdFormatTest() {
		try {
			String employeeName = "Ling12007";
			boolean isValidEmployeeId = UserValidator.isValidEmployeeIdFormat(employeeName);
			assertTrue(isValidEmployeeId);
		} catch (Exception e) {
			assertEquals("Invalid EmployeeID Format", e.getMessage());
		}
	}


}
