package in.lingtan.validator;

import static org.junit.Assert.*;

import org.junit.Test;

public class ValidatorTestCase {

	/**
	 * Valid employeeId length is validated
	 */
	@Test
	public void ValidEmployeeIdLengthTest() {
		String employeeId = "Ling12007";
		boolean isValidEmployeeId = UserValidator.isValidEmployeeIdLength(employeeId);
		assertTrue(isValidEmployeeId);
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
			assertEquals(e.getMessage(), "Invalid Length");
		}
	}

	/**
	 * Invalid employee Id is validated
	 */
	@Test
	public void InvalidEmployeeIdTest() {
			String employeeId = "Ling12007";
			boolean isValidEmployeeId = UserValidator.isValidEmployeeId(employeeId, "Invalid EmployeeID format or length");
			assertTrue(isValidEmployeeId);
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
			assertEquals(e.getMessage(), "Invalid EmployeeID Format");
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
			assertEquals(e.getMessage(), "Invalid EmployeeID Format");
		}
	}


}
