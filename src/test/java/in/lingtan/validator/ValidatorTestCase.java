package in.lingtan.validator;

import static org.junit.Assert.*;

import org.junit.Test;

public class ValidatorTestCase {

	@Test
	public void isEmployeeIdNull() {
		String employeeName = null;
		boolean isValidEmployeeId = UserValidator.isEmployeeIdEmptyAndNull(employeeName);
		assertFalse(isValidEmployeeId);
	}
	
	@Test
	public void isEmployeeIdEmpty() {
		String employeeName = "";
		boolean isValidEmployeeId = UserValidator.isEmployeeIdEmptyAndNull(employeeName);
		assertFalse(isValidEmployeeId);
	}
	
	@Test
	public void isEmployeeIdValidCase() {
		String employeeName = "Ling";
		boolean isValidEmployeeId = UserValidator.isEmployeeIdEmptyAndNull(employeeName);
		assertTrue(isValidEmployeeId);
	}
	
//////////////////////////////////////////////////////////////////////////////////	
	

	@Test
	public void isValidEmployeeIdValidLengthTest() {
		String employeeName = "Ling2657";
		boolean isValidEmployeeId = UserValidator.isValidEmployeeIdLength(employeeName);
		assertTrue(isValidEmployeeId);
	}
	
	@Test
	public void isValidEmployeeIdInvalidLengthTest() {
	String employeeName = "Ling267";
	boolean isValidEmployeeId = UserValidator.isValidEmployeeIdLength(employeeName);
	assertTrue(isValidEmployeeId);
}

	@Test
	public void isValidFormatEmployyeeIdValidTest() {
	String employeeName = "Lin2657";
	boolean isValidEmployeeId = UserValidator.isValidEmployyeeIdFormat(employeeName);
	assertFalse(isValidEmployeeId);
	}
	
	@Test
	public void isValidFormatEmployyeeIdInvalidNumberTest() {
	String employeeName = "Ling257";
	boolean isValidEmployeeId =UserValidator.isValidEmployyeeIdFormat(employeeName);
	assertFalse(isValidEmployeeId);
	}
	
	@Test
	public void isValidFormatEmployyeeIdInvalidAlphabetTest() {
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
