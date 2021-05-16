package in.lingtan.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {

	public static boolean isValidEmailId(String emailId, String errorMessage) {
		boolean isValidEmailId = false;
		if (emailId == null || emailId.isEmpty()) {
			throw new RuntimeException(errorMessage);
		}

		else {
			String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
			Pattern regexEmailFormat = Pattern.compile(regex);
			Matcher matchEmailPattern = regexEmailFormat.matcher(emailId);
			if (matchEmailPattern.matches()) {
				isValidEmailId = matchEmailPattern.matches();
				return isValidEmailId;
			}
			throw new RuntimeException(errorMessage);

		}

	}
}
