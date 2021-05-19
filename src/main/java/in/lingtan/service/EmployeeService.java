package in.lingtan.service;

import java.sql.SQLException;
import java.util.Map;

import in.lingtan.dao.EmployeeServiceDAO;
import in.lingtan.exceptions.CannotRegisterEmployeeException;
import in.lingtan.exceptions.ExistingEmployeeException;
import in.lingtan.exceptions.InValidEmailIDException;
import in.lingtan.exceptions.InvalidEmployeeIdException;
import in.lingtan.model.Employee;
import in.lingtan.util.EmailValidator;
import in.lingtan.validator.EmployeeValidator;
import in.lingtan.validator.UserValidator;

public class EmployeeService {



	public EmployeeService() {
		// Default constructor.
	}
	
	private final EmployeeServiceDAO employeeServiceDAO = new EmployeeServiceDAO();
	


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
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public boolean addEmployee(Employee employee) throws CannotRegisterEmployeeException, InvalidEmployeeIdException, InValidEmailIDException, ExistingEmployeeException, ClassNotFoundException, SQLException {

		int employeeTableSize = employeeServiceDAO.tableSize();
		System.out.println("size"+employeeTableSize);
		String generatedEmployeeId = generateEmployeeId(employee, employeeTableSize);
		UserValidator.isValidEmployeeId(generatedEmployeeId, "Invalid Employee ID");
		employee.setEmployeeID(generatedEmployeeId);

		String generatedEmailId = generateEmail(employee);
		EmailValidator.isValidEmailId(generatedEmailId, "Invalid Email-ID");
		employee.setEmail(generatedEmailId);
		employee.setPassword("@Password123");
		
		boolean isEmployeeAvailable = EmployeeValidator.isEmployeeNotAvailable(employee);
		System.out.println(isEmployeeAvailable);
		if (isEmployeeAvailable) {
			employeeServiceDAO.addEmployee(employee);
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
	 * @param employeeTableSize 
	 * 
	 * @param name
	 * @param dob
	 * @return
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public String generateEmployeeId(Employee employee, int employeeTableSize) {

		String employeeIdCharacters;
		String generatedEmployeeId;
		String employeeIdDigits;
		String firstName = employee.getFirstName().trim();
		

		if (firstName.length() <= 3) {
			employeeIdCharacters = firstName.substring(0, 1).toUpperCase()
					+ firstName.substring(1, 3) + employee.getLastName().trim().substring(0, 1)
					+ employee.getDob().toString().substring(8, 10);
		}else {
			employeeIdCharacters = firstName.substring(0, 1).toUpperCase()
					+ firstName.substring(1, 4) + employee.getDob().toString().substring(8, 10);
		} 
		if ((employeeTableSize == 0)) {
			employeeIdDigits = "00" + Integer.toString(firstName.length());
		} else if ((employeeTableSize < 10) && (employeeTableSize > 0)) {
			employeeIdDigits = "0" + Integer.toString(employeeTableSize)
					+ Integer.toString(firstName.length());
		} else {
			employeeIdDigits = Integer.toString(employeeTableSize)
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

	public String generateEmail(Employee employee) {
		String firstName = employee.getFirstName().trim();
		String lastName = employee.getLastName().trim();
		return firstName.toLowerCase() + "." + lastName.toLowerCase().replaceAll("\\s", "")
				+ employee.getEmployeeID().substring(4, 9) + ("@companyname.com");
	
	}
	
	/**
	 * This method returns a hashmap of allt the employee names and their employee ID available in the database.
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	
	public Map<String, String> displayAllEmployees() throws ClassNotFoundException, SQLException{
		return employeeServiceDAO.displayAllEmployees();
		
	}
	
	
	


}
