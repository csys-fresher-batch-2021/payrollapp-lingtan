package in.lingtan.validator;

import static org.junit.Assert.*;

import org.junit.Test;

public class ValidatorTestCase {

	@Test
	public void isEmployeeIdNull() { //Null employee id is validated
		String employeeName = null;
		boolean isValidEmployeeId = UserValidator.isEmployeeIdEmptyAndNull(employeeName);
		assertFalse(isValidEmployeeId);
	}
	
	@Test
	public void isEmployeeIdEmpty() { //employeeId is empty
		String employeeName = "";
		boolean isValidEmployeeId = UserValidator.isEmployeeIdEmptyAndNull(employeeName);
		assertFalse(isValidEmployeeId);
	}
	
	@Test
	public void isEmployeeIdValidCase() { //valid string is passed
		String employeeName = "Ling";
		boolean isValidEmployeeId = UserValidator.isEmployeeIdEmptyAndNull(employeeName);
		assertTrue(isValidEmployeeId);
	}
	
//////////////////////////////////////////////////////////////////////////////////	
	

	@Test
	public void isValidEmployeeIdValidLengthTest() { //Valid employeeId length  is validated
		String employeeName = "Ling2657";
		boolean isValidEmployeeId = UserValidator.isValidEmployeeIdLength(employeeName);
		assertTrue(isValidEmployeeId);
	}
	
	@Test
	public void isValidEmployeeIdInvalidLengthTest() { //Invalid employee Id is validated
	String employeeName = "Ling267";
	boolean isValidEmployeeId = UserValidator.isValidEmployeeIdLength(employeeName);
	assertFalse(isValidEmployeeId);
}

	@Test
	public void isValidFormatEmployyeeIdValidTest() { //Valid employeeId format is validated
	String employeeName = "Lin2657";
	boolean isValidEmployeeId = UserValidator.isValidEmployyeeIdFormat(employeeName);
	assertFalse(isValidEmployeeId);
	}
	
	@Test
	public void isValidFormatEmployyeeIdInvalidNumberTest() { //Invalid employeeId with only 4 numerals is validated
	String employeeName = "Ling257";
	boolean isValidEmployeeId =UserValidator.isValidEmployyeeIdFormat(employeeName);
	assertFalse(isValidEmployeeId);
	}
	
	@Test
	public void isValidFormatEmployyeeIdInvalidAlphabetTest() { // Invalid employeeId with only 3 alphabets is validated
	String employeeName = "Lin2657";
	boolean isValidEmployeeId =UserValidator.isValidEmployyeeIdFormat(employeeName);
	assertFalse(isValidEmployeeId);
	}
	
	@Test
	public void isValidPasswordFormatInvalidTest() { //username is wrong password is correct
		String password =  "raja123";
		boolean isValidPasswordLength = UserValidator.isValidPasswordFormat(password);
		assertFalse(isValidPasswordLength);
	}
	
	@Test
	public void isValidPasswordFormatValidTest() { //username is wrong password is correct
		String password =  "Lingtan123@";
		boolean isValidPasswordLength = UserValidator.isValidPasswordFormat(password);
		assertTrue(isValidPasswordLength);
	}
	
	

}
