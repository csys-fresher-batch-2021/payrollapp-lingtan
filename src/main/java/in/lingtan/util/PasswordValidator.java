package in.lingtan.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator {

	/**
	 * This method verifies whether the password is in valid format or not
	 * 
	 * @param password
	 * @return
	 */
	public static boolean isValidPasswordFormat(String password, String errorMessage) {
		boolean isValidFormat = false;
		if (password != null) {
			String regex = "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])" + "(?=\\S+$).{8,15}$";
			Pattern regexPattern = Pattern.compile(regex);
			Matcher matchCheck = regexPattern.matcher(password);
			isValidFormat = matchCheck.matches();
			if (isValidFormat) {
				return isValidFormat;
			}
			throw new RuntimeException(errorMessage);
		}
		return isValidFormat;

	}
}
