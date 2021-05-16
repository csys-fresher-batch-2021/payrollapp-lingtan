package in.lingtan.util;

import java.time.LocalDate;

public class DateValidator {

	/**
	 * This method checks whether the date is not a future date or not This method
	 * 
	 * @param date
	 * @return
	 */
	public static boolean isNotAFutureDate(LocalDate date, String errorMessage) {
		boolean isValidDate = true;
		if (date.isAfter(LocalDate.now())) {
			throw new RuntimeException(errorMessage);
		}
		return isValidDate;
	}

	public static LocalDate isDateFormatOrNot(String dateToCheck, String errorMessage) {
		try {
			LocalDate isValidDateFormat = LocalDate.parse(dateToCheck);
			return isValidDateFormat;
		} catch (Exception e) {
			throw new RuntimeException(errorMessage);
		}
	}

}
