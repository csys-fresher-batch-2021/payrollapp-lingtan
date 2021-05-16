package in.lingtan.Util;

import static org.junit.Assert.*;

import org.junit.Test;

import in.lingtan.util.NumberValidator;

public class NumberValidatorTestCase {

	@Test
	public void validNumberIsTestedWithoutAnyAlphabets() {
		String number = "9600923846";
		Long isValidNumber = NumberValidator.isValidNumberOnly(number, "Mobile number cannot contain alphabets");
		assertEquals(Long.valueOf(9600923846L), isValidNumber);
	}

	@Test
	public void invalidNumberIsTestedWithAlphabet() {
		try {
			String number = "960092384s";
			Long isValidNumber = NumberValidator.isValidNumberOnly(number, "Mobile Number cannot contain alphabets");
			assertEquals(Long.valueOf(9600923846L), isValidNumber);
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Mobile Number cannot contain alphabets");
		}
	}

}
