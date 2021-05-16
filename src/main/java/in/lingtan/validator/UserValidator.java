package in.lingtan.validator;

import in.lingtan.util.StringValidator;

public class UserValidator {

	private UserValidator() {
		// Default constructor
	}

	/**
	 * This method validates whether the employeeId is in valid Format.
	 * i.e) valid id : Ling12007.
	 * @param employeeId
	 * @return
	 */

	public static boolean isValidEmployeeIdFormat(String employeeId) {
		boolean isValidFormat = false;
		String digitsOfId = employeeId.replaceAll("\\D", "");
		String stringOfId = employeeId.replaceAll("\\d", "");
		if ((stringOfId.length() == 4) && (digitsOfId.length() == 5)) {
			isValidFormat = true;
			return isValidFormat;
		}
		throw new RuntimeException("Invalid EmployeeID Format");
	}

	/**
	 * This method verifies whether the length of the employeeID is valid or not.
	 * @param employeeId
	 * @return
	 */
	public static boolean isValidEmployeeIdLength(String employeeId) {
		boolean isValidEmployeeId = false;
		if (employeeId.length() == 9 || employeeId == null ) {
			isValidEmployeeId = true;
			return isValidEmployeeId;
		}
		throw new RuntimeException("Invalid Length");
	}

	/**
	 * This method is a combined validation method where all the validations are
	 * combined to give one result for employeeID
	 * @param employeeId
	 * @return
	 */

	public static boolean isValidEmployeeId(String employeeId, String errorMessage) {
		try {
			boolean isStringNullOrEmpty = StringValidator.isStringNotNullOrEmpty(employeeId, errorMessage);
			boolean isValidEmployeeIdFormat = isValidEmployeeIdFormat(employeeId);
			boolean isValidEmployeeIdLength = isValidEmployeeIdLength(employeeId);

			if (isStringNullOrEmpty && isValidEmployeeIdFormat && isValidEmployeeIdLength) {
				return true;
			} else {
				throw new RuntimeException(errorMessage);
			}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

}
