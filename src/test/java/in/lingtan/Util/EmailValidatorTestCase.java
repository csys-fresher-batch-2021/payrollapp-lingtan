package in.lingtan.Util;

import static org.junit.Assert.*;

import org.junit.Test;

import in.lingtan.util.EmailValidator;

public class EmailValidatorTestCase {

	@Test
	public void validEmailIdIsTested() {
		String emailId = "lingtan.navisanthonisamy@gmail.com";
		boolean isValidMail = EmailValidator.isValidEmailId(emailId, "Invalid EmailId");
		assertTrue(isValidMail);
	}
	
	@Test
	public void inValidEmailIdIsTested() {
		try {
			String emailId = "lingtan.navisanthonisamygmail.com";
			boolean isValidMail = EmailValidator.isValidEmailId(emailId, "Invalid Email-ID format");
			assertFalse(isValidMail);
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Invalid Email-ID format");
			e.printStackTrace();
		}
	}
	


}
