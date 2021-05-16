package in.lingtan.Util;

import static org.junit.Assert.*;

import org.junit.Test;

import in.lingtan.util.PasswordValidator;

public class PasswordValidatorTestCase {

	@Test
	public void validPasswordFormatIsTested() {
		String password = "@Password123";
		boolean isValidPassword = PasswordValidator.isValidPasswordFormat(password, "Invalid password format");
		assertTrue(isValidPassword);
	}

	@Test
	public void inValidPasswordFormatIsTested() {
		try {
			String password = "password12";
			boolean isValidPassword = PasswordValidator.isValidPasswordFormat(password, "Invalid password format");
			assertFalse(isValidPassword);
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Invalid password format");
		}
	}

}
