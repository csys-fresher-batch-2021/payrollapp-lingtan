package in.lingtan.util;

import org.apache.taglibs.standard.lang.jstl.parser.ParseException;

import in.lingtan.employee.InvalidLongNumberTypeException;
import in.lingtan.employee.InvalidMobileNumberException;
import in.lingtan.employee.InvalidNumberLengthException;
import in.lingtan.employee.NumberCannotBeNegativeException;

public class NumberValidator {

	private NumberValidator() {
		// Default constructor
	}

	/**
	 * This Method validates if the mobile number contains only Long integer.
	 * 
	 * @param number
	 * @param errorMessage
	 * @return
	 * @throws ParseException 
	 * @throws InvalidLongNumberTypeException 
	 */

	public static Long isValidNumberOnly(String number, String errorMessage) throws ParseException, InvalidLongNumberTypeException {

		try {
			return Long.parseLong(number);
		} catch (Exception e) {
			throw new InvalidLongNumberTypeException(errorMessage);
		}

	}

	/**
	 * This method checks whether the length of mobile number is 10 digits
	 * 
	 * @param number
	 * @return
	 * @throws InvalidNumberLengthException
	 */
	public static boolean isNumberValidLength(Long number) throws InvalidNumberLengthException {

		if (number != null) {
			long numberString = (long) number.toString().trim().length();
			if ((numberString == 10) && number != 0) {
				return true;
			} else {
				throw new InvalidNumberLengthException("Invalid Mobile Number Length");
			}
		}
		return false;
	}

	public static boolean isNumberPositive(Long number) throws NumberCannotBeNegativeException {
		boolean isValidNumber = false;
		if (number != null) {
			if (number > 0) {
				isValidNumber = true;
			} else {
				throw new NumberCannotBeNegativeException("Mobile Cannot be Negative");
			}
		}
		return isValidNumber;
	}

	/**
	 * This method checks whether a given mobile number is a 10 digit number and the
	 * number is not negative and the number is not zero.
	 * 
	 * @param mobileNumber
	 * @return
	 * @throws InvalidMobileNumberException
	 */
	public static boolean isValidMobileNumber(long mobileNumber) throws InvalidMobileNumberException {
		try {

			NumberValidator.isNumberValidLength(mobileNumber);
			NumberValidator.isNumberPositive(mobileNumber);
			return true;

		} catch (Exception e) {
			throw new InvalidMobileNumberException(e.getMessage());
		}

	}
}
