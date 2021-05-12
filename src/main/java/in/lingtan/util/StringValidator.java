package in.lingtan.util;

public class StringValidator {
	
	/**
	 * This method verifies whether an employeeId field is null or empty
	 * @param employeeId
	 * @return
	 */
	public static boolean isEmployeeIdEmptyAndNull(String employeeId) {  
		boolean isEmployeeNull = true;
			if((employeeId == null)  || (employeeId.trim().length()==0) ){
				isEmployeeNull = false;	
			}
		return isEmployeeNull;
	}
	
	/**
	 * This method verifies whether the length of the employeeID is valid or not
	 * @param employeeId
	 * @return
	 */
	
	public static boolean isValidEmployeeIdLength(String employeeId) {
		boolean isValidEmployeeId = false;
		if(employeeId!=null && employeeId.length() == 8) {
			isValidEmployeeId = true;
		}
		return isValidEmployeeId;
	}
	
}
