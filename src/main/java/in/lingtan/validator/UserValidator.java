package in.lingtan.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidator {
	
	private UserValidator() {
		//Default constructor
	}
	
	public static boolean isEmployeeIdEmptyAndNull(String employeeId) {   //null, "" 
		boolean isEmployeeNull = true;
			if((employeeId == null)  || (employeeId.trim().length()==0) ){
				isEmployeeNull = false;	
			}
		return isEmployeeNull;
	}
	
	
	//This method verifies whether the length of the employeeID is valid or not
	public static boolean isValidEmployeeIdLength(String employeeId) {
		boolean isValidEmployeeId = false;
		if(employeeId!=null && employeeId.length() == 8) {
			isValidEmployeeId = true;
		}
		return isValidEmployeeId;
	}
	
	//This method validates whether the employeeId is in valid Format or not i.e) valid id : Ling2657
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
	
	//This method is a combined validation method where all the validations are combined to give one result for employeeID
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
	
	//This method verifies whether the password is in valid format or not
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
