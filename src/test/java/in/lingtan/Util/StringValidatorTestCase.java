package in.lingtan.Util;

import static org.junit.Assert.*;

import org.junit.Test;

import in.lingtan.util.StringValidator;

public class StringValidatorTestCase {

	@Test
	public void emptyStringInputIsChecked() {
		try {
			StringValidator.isStringNotNullOrEmpty(" ", "Field cannot be Empty");
		} catch (Exception e) {
			assertEquals("Field cannot be Empty", e.getMessage());
		}

	}

	@Test
	public void validStringInputIsChecked() {
		try {
			boolean isValidString = StringValidator.isStringNotNullOrEmpty("Lingtan", "Field cannot be Empty");
			assertTrue(isValidString);
		} catch (Exception e) {
			assertEquals("Field cannot be Empty", e.getMessage());
		}

	}

	@Test
	public void nullStringInputIsChecked() {
		try {
			StringValidator.isStringNotNullOrEmpty(null, "Field cannot be Empty");
		} catch (Exception e) {
			assertEquals("Field cannot be Empty", e.getMessage());
		}

	}

}
