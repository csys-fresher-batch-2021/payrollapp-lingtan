package in.lingtan.util;

public class StringValidator {

	private StringValidator() {
		// Default Constructor
	}

	/**
	 * This verifies whether the role field is filled or not
	 * 
	 * @param role
	 * @return
	 */
	public static boolean isStringNotNullOrEmpty(String stringToValidate, String errorMessage) {
		boolean isValidRole = true;
		if (stringToValidate == null || stringToValidate.trim().isEmpty()) {
			throw new RuntimeException(errorMessage);
		}
		return isValidRole;
	}

}
