package in.lingtan.Util;

import static org.junit.Assert.*;

import org.junit.Test;

import in.lingtan.exceptions.InvalidPasswordFormatException;
import in.lingtan.util.PasswordValidator;

public class PasswordValidatorTestCase {

	@Test
	public void validPasswordFormatIsTested() throws InvalidPasswordFormatException {
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
			assertEquals("Invalid password format", e.getMessage());
		}
	}

}
