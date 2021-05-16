package in.lingtan.util;

public class NumberValidator {
	
	/**
	 * This Method validates if the mobile number contains only Long integer.
	 * @param number
	 * @param errorMessage
	 * @return
	 */

	public static Long isValidNumberOnly(String number, String errorMessage) {

		try {
			Long mobileNumber = Long.parseLong(number);
			return mobileNumber;
		} catch (Exception e) {
			throw new RuntimeException(errorMessage);
		}

	}

	/**
	 * This method checks whether the length of mobile number is 10 digits
	 * 
	 * @param number
	 * @return
	 */
	public static boolean isNumberValidLength(Long number) {
		boolean isValidNumber = false;
		if (number != null) {
			long numberString = (long) number.toString().trim().length();
			if ((numberString == 10) && number != 0) {
				isValidNumber = true;
			} else {
				throw new RuntimeException("Invalid Mobile Number Length");
			}
		}
		return isValidNumber;
	}

	public static boolean isNumberPositive(Long number) {
		boolean isValidNumber = false;
		if (number != null) {
			if (number > 0) {
				isValidNumber = true;
			} else {
				throw new RuntimeException("Mobile Cannot be Negative");
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
	 */
	public static boolean isValidMobileNumber(long mobileNumber, String errorMessage) {
		try {
			boolean isValidMobileNumber = false;
			boolean isValidMobileNumberLength = NumberValidator.isNumberValidLength(mobileNumber);
			boolean isMobileNumberPositive = NumberValidator.isNumberPositive(mobileNumber);

			if (isMobileNumberPositive && isValidMobileNumberLength) {
				isValidMobileNumber = true;

			}
			return isValidMobileNumber;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}

	}
}
