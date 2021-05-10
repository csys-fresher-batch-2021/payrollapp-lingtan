package in.lingtan.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidator {
	
	public static boolean isEmployeeIdEmptyAndNull(String employeeId) {   //null, "" 
		boolean isEmployeeNull = true;
			if(employeeId == null){
				isEmployeeNull = false;	
				
			}
			else if(employeeId.trim().length()==0) {
				 
				isEmployeeNull = false;
			}
		return isEmployeeNull;
	}
	
	public static boolean isValidEmployeeIdLength(String employeeId) {
		boolean isValidEmployeeId = false;
		if(employeeId!=null) {
		if(employeeId.length() == 8) {
			isValidEmployeeId = true;
		}
		}
		
		return isValidEmployeeId;
	}
	
	
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
	
	public static boolean employeeIdValidation(String employeeId) {
		boolean isValidAllParameters = false;
		boolean isEmptyAndNull = isEmployeeIdEmptyAndNull(employeeId);
		boolean isValidEmployeeIdLength = isValidEmployeeIdLength(employeeId);
		boolean isValidEmployeeIdFormat = isValidEmployyeeIdFormat(employeeId);
		
		if(isEmptyAndNull && isValidEmployeeIdFormat && isValidEmployeeIdLength) {
			isValidAllParameters = true;
		}
		return isValidAllParameters;
	}
	
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
