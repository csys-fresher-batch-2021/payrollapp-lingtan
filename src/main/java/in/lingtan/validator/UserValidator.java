package in.lingtan.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import in.lingtan.util.StringValidator;

public class UserValidator {
	
	private UserValidator() {
		//Default constructor
	}
	
	/**
	 * This method validates whether the employeeId is in valid Format or not i.e) valid id : Ling2657
	 * @param employeeId
	 * @return
	 */
	
	public static boolean isValidEmployyeeIdFormat(String employeeId) {
		boolean isValidFormat = false;
		if(employeeId!=null) {
			String stringOfId  = employeeId.replaceAll("\\D", "");
			String digitsOfId  = employeeId.replaceAll("\\d", "");
			if((stringOfId.length()==4) && (digitsOfId.length()==4)) {
				isValidFormat=true;
			}	
		}
		
		return isValidFormat;
	}

	/**
	 * This method is a combined validation method where all the validations are combined to give one result for employeeID
	 * @param employeeId
	 * @return
	 */
	
	public static boolean employeeIdValidation(String employeeId) {
		boolean isValidAllParameters = false;
		boolean isEmptyAndNull = StringValidator.isEmployeeIdEmptyAndNull(employeeId);
		boolean isValidEmployeeIdLength = StringValidator.isValidEmployeeIdLength(employeeId);
		boolean isValidEmployeeIdFormat = isValidEmployyeeIdFormat(employeeId);
		
		if(isEmptyAndNull && isValidEmployeeIdFormat && isValidEmployeeIdLength) {
			isValidAllParameters = true;
		}
		return isValidAllParameters;
	}
	/**
	 * This method verifies whether the password is in valid format or not
	 * @param password
	 * @return
	 */
	
	public static boolean isValidPasswordFormat(String password) {
		 boolean isValidFormat = false;
		 if (password != null) {
			 String regex = "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])" + "(?=\\S+$).{8,15}$";
			 Pattern regexPattern = Pattern.compile(regex);
			 Matcher matchCheck = regexPattern.matcher(password);
			 isValidFormat = matchCheck.matches();
		 	}
 return isValidFormat;
}
}
