package in.lingtan.Util;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import in.lingtan.exceptions.InvalidDateException;
import in.lingtan.util.DateValidator;

public class DateValidatorTestCase {
	
	@Test
	public void futureDateIsTested() {
		try{
			LocalDate testDate = LocalDate.now().plusDays(1);
			DateValidator.isNotAFutureDate(testDate, "Invalid Date");
		}
		catch(Exception e) {
			assertEquals("Invalid Date",e.getMessage());
		}
		
	}
	
	@Test
	public void presentDateIsTested() throws InvalidDateException {
		LocalDate testDate = LocalDate.now();
		boolean isValidEmployeeId = DateValidator.isNotAFutureDate(testDate, "Invalid Date");
		assertTrue(isValidEmployeeId);
	}
	
	@Test
	public void pastDateIsChecked() throws InvalidDateException {
		LocalDate testDate = LocalDate.now().minusDays(1);
		boolean isValidEmployeeId = DateValidator.isNotAFutureDate(testDate, "Invalid Date");
		assertTrue(isValidEmployeeId);
	}
	
	@Test
	public void validDateFormatOrNotIsChecked() throws InvalidDateException {
		String testDate = "2000-12-12";
		LocalDate ValidDate = DateValidator.isDateFormatOrNot(testDate, "Invalid Date format");
		assertEquals(ValidDate,LocalDate.parse("2000-12-12"));
	}
	
	@Test
	public void inValidDateFormatIsChecked() {
		try{
			String testDate = "2000-12-1";
			DateValidator.isDateFormatOrNot(testDate, "Invalid Date format");
		}
		catch(Exception e) {
			assertEquals("Invalid Date format",e.getMessage());
		}
		
	}
}

