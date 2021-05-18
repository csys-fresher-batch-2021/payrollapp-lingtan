package in.lingtan.validator;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import in.lingtan.exceptions.ExistingEmployeeException;
import in.lingtan.model.Employee;

public class EmployeeValidatorTestCase {

	@Test
	public void theEmployeeInDataBaseIsAddedAgainAndTested() {
		Employee employee = new Employee();
		employee.setFirstName("Lingtan");
		employee.setLastName("navis anthoni samy");
		employee.setName("Lingtan navis anthoni samy");
		employee.setMobileNumber(9600923846l);
		
		boolean isAvailable;
		try {
			isAvailable = EmployeeValidator.isEmployeeNotAvailable(employee);
			assertTrue(isAvailable);
		} catch (ClassNotFoundException | ExistingEmployeeException | SQLException e) {
		
			e.printStackTrace();
		}
		
	
		
	}
	
	/**
	 * This method returns true if an employee is not already enrolled into the database
	 * @throws SQLException 
	 * @throws ExistingEmployeeException 
	 * @throws ClassNotFoundException 
	 */
	@Test
	public void aNewEmployeeIsAddedAndTested()  {
		Employee employee = new Employee();
		employee.setEmployeeID("venkatesh");
		employee.setLastName("ganesh");
		employee.setMobileNumber(9600923846l);
	
		boolean isAvailable;
		try {
			isAvailable = EmployeeValidator.isEmployeeNotAvailable(employee);
			assertTrue(isAvailable);
		} catch (ClassNotFoundException | ExistingEmployeeException | SQLException e) {
			
			e.printStackTrace();
		}
		
	}	

}
