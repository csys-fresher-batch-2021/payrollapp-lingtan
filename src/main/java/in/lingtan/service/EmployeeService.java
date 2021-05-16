package in.lingtan.service;

import java.util.HashMap;
import java.util.Map;

import in.lingtan.employeeExceptions.CannotRegisterEmployeeException;
import in.lingtan.employeeExceptions.ExistingEmployeeException;
import in.lingtan.employeeExceptions.InValidEmailIDException;
import in.lingtan.employeeExceptions.InvalidEmployeeIdException;
import in.lingtan.model.Employee;
import in.lingtan.util.EmailValidator;
import in.lingtan.validator.EmployeeValidator;
import in.lingtan.validator.UserValidator;

public class EmployeeService {

	private static final HashMap<String, Employee> employeeMap = new HashMap<>();
	private static final HashMap<String, String> masterCredentialStorage = new HashMap<>();

	private EmployeeService() {
		// Default constructor.
	}

	/**
	 * This Method displays the hashMap that stores the employee data
	 * 
	 * @return
	 */
	public static Map<String, Employee> getAllEmployees() {
		return employeeMap;
	}

	/**
	 * To add the details of an Employee into a hashmap where the employeeId is the
	 * key for the employee
	 * 
	 * @param employee
	 * @return
	 * @throws CannotRegisterEmployeeException 
	 * @throws InvalidEmployeeIdException 
	 * @throws InValidEmailIDException 
	 * @throws ExistingEmployeeException 
	 */
	public static boolean addEmployee(Employee employee) throws CannotRegisterEmployeeException, InvalidEmployeeIdException, InValidEmailIDException, ExistingEmployeeException {

	

		String generatedEmployeeId = EmployeeService.generateEmployeeId(employee);
		UserValidator.isValidEmployeeId(generatedEmployeeId, "Invalid Employee ID");
		employee.setEmployeeID(generatedEmployeeId);

		String generatedEmailId = EmployeeService.generateEmail(employee);
		EmailValidator.isValidEmailId(generatedEmailId, "Invalid Email-ID");
		employee.setEmail(generatedEmailId);
		boolean isEmployeeAvailable = EmployeeValidator.isEmployeeNotAvailable(employee);
		
		if (isEmployeeAvailable) {
			employeeMap.put(employee.getEmployeeID(), employee);
			masterCredentialStorage.put(employee.getEmployeeID(), "@password123");
			return true;
		} else {
			throw new CannotRegisterEmployeeException("Cannot add employee");
		}
	}

	/**
	 * this will create an unique employeeId with a combo of 4 letters of name and 4
	 * numbers of unique pattern
	 * 
	 * employeeIdCharacters - creates a string of length 4, which has the employee
	 * Name with the first character capitalized.
	 * 
	 * employeeIdDigits - The employee digits creates a unique pattern of number of
	 * length four where the first 2 digits are their date of birth the -next two
	 * numbers are the order of their joining list of employees and the last number
	 * is the employee name's length.
	 * 
	 * @param name
	 * @param dob
	 * @return
	 */
	public static String generateEmployeeId(Employee employee) {

		String employeeIdCharacters;
		String generatedEmployeeId;
		String employeeIdDigits;
		String firstName = employee.getFirstName();

		if (firstName.length() <= 3) {
			employeeIdCharacters = firstName.substring(0, 1).toUpperCase()
					+ firstName.substring(1, 4) + employee.getLastName().substring(0, 1)
					+ employee.getDob().toString().substring(8, 10);
		}else {
			employeeIdCharacters = firstName.substring(0, 1).toUpperCase()
					+ firstName.substring(1, 4) + employee.getDob().toString().substring(8, 10);
		} 
		
		if ((employeeMap.size() == 0)) {
			employeeIdDigits = "00" + Integer.toString(firstName.length());
		} else if ((employeeMap.size() < 10) && (employeeMap.size() > 0)) {
			employeeIdDigits = "0" + Integer.toString(employeeMap.size())
					+ Integer.toString(firstName.length());
		} else {
			employeeIdDigits = Integer.toString(employeeMap.size())
					+ Integer.toString(firstName.length());
		}
		generatedEmployeeId = employeeIdCharacters + employeeIdDigits;
		return generatedEmployeeId;
	}

	/**
	 * This method generates a unique mail id for the employee using the employee
	 * name and their employeeID.
	 * 
	 * This method uses the employee's first name and last name where the last name
	 * is free from inbetween spaces and all the string is made to lowercase
	 * 
	 * @param firstName
	 * @param employeeId
	 * @param lastName
	 * @param dob
	 * @return
	 */

	public static String generateEmail(Employee employee) {
		String firstName = employee.getFirstName();
		String lastName = employee.getLastName();
		return firstName.toLowerCase() + "." + lastName.toLowerCase().replaceAll("\\s", "")
				+ employee.getEmployeeID().substring(4, 9) + ("@companyname.com");
	
	}

}
