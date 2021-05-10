package in.lingtan.validator;

import static org.junit.Assert.*;

import org.junit.Test;




public class ValidatorTestCase {

	@Test
	public void isEmployeeIdNullTest1() {
		String employeeName = null;
		boolean isValidEmployeeId = UserValidator.isEmployeeIdEmptyAndNull(employeeName);
		assertFalse(isValidEmployeeId);
	}
	
	@Test
	public void isEmployeeIdNullTest2() {
		String employeeName = "";
		boolean isValidEmployeeId = UserValidator.isEmployeeIdEmptyAndNull(employeeName);
		assertFalse(isValidEmployeeId);
	}
	
	@Test
	public void isEmployeeIdNullTest3() {
		String employeeName = "Ling";
		boolean isValidEmployeeId = UserValidator.isEmployeeIdEmptyAndNull(employeeName);
		assertTrue(isValidEmployeeId);
	}
	
//////////////////////////////////////////////////////////////////////////////////	
	

	@Test
	public void isValidEmployeeIdLengthTest() {
		String employeeName = "Ling2657";
		boolean isValidEmployeeId = UserValidator.isValidEmployeeIdLength(employeeName);
		assertTrue(isValidEmployeeId);
	}
	
	@Test
	public void isValidEmployeeIdLengthTest1() {
	String employeeName = "Ling2657";
	boolean isValidEmployeeId = UserValidator.isValidEmployeeIdLength(employeeName);
	assertTrue(isValidEmployeeId);
}

	@Test
	public void isValidFormatEmployyeeIdTest1() {
	String employeeName = "Lin2657";
	boolean isValidEmployeeId = UserValidator.isValidEmployyeeIdFormat(employeeName);
	assertFalse(isValidEmployeeId);
	}
	
	@Test
	public void isValidFormatEmployyeeIdTest2() {
	String employeeName = "Ling257";
	boolean isValidEmployeeId =UserValidator.isValidEmployyeeIdFormat(employeeName);
	assertFalse(isValidEmployeeId);
	}
	
	@Test
	public void isValidPasswordFormatTest1() { //username is wrong password is correct
		String password =  "raja123";
		boolean isValidPasswordLength = UserValidator.isValidPasswordFormat(password);
		assertFalse(isValidPasswordLength);
	}
	
	@Test
	public void isValidPasswordFormatTest2() { //username is wrong password is correct
		String password =  "Lingtan123@";
		boolean isValidPasswordLength = UserValidator.isValidPasswordFormat(password);
		assertTrue(isValidPasswordLength);
	}
	
	

}
