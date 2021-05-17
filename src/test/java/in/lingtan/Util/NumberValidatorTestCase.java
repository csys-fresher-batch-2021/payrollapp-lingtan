package in.lingtan.Util;

import static org.junit.Assert.*;

import org.apache.taglibs.standard.lang.jstl.parser.ParseException;
import org.junit.Test;

import in.lingtan.exceptions.InvalidLongNumberTypeException;
import in.lingtan.util.NumberValidator;

public class NumberValidatorTestCase {

	@Test
	public void validNumberIsTestedWithoutAnyAlphabets() throws ParseException, InvalidLongNumberTypeException {
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
			assertEquals("Mobile Number cannot contain alphabets", e.getMessage());
		}
	}

}
