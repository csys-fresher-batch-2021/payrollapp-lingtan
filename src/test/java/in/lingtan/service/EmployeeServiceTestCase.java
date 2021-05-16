package in.lingtan.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.time.LocalDate;

import java.util.Map;

import org.junit.After;
import org.junit.Test;

import in.lingtan.employee.CannotRegisterEmployeeException;
import in.lingtan.employee.ExistingEmployeeException;
import in.lingtan.employee.InValidEmailIDException;
import in.lingtan.employee.InvalidEmployeeIdException;
import in.lingtan.model.Employee;

public class EmployeeServiceTestCase {
	static Employee employee = new Employee();
	
	@After
	public void resetData(){
		Map<String, Employee> employeeMap = EmployeeService.getAllEmployees();
		employeeMap.clear();
	}
	
	@Test
	public void addRegisterTestCase() throws InvalidEmployeeIdException, InValidEmailIDException, ExistingEmployeeException  {
		employee.setFirstName("Lingtan");
		employee.setLastName("Navis Anthoni samy");
		employee.setDob(LocalDate.parse("2000-02-12"));
		employee.setMobileNumber(9600923846l);
		employee.setJoiningData(LocalDate.parse("2021-05-15"));
		boolean isAdded;
		try {
			isAdded = EmployeeService.addEmployee(employee);
			assertTrue(isAdded);
		} catch (CannotRegisterEmployeeException e) {
			e.printStackTrace();
		}
		assertEquals("lingtan.navisanthonisamy12007@companyname.com",employee.getEmail());
		assertEquals("Ling12007",employee.getEmployeeID());
		
	}
		
	@Test
	public void employeeIdGeneratorTestCase() {
		employee.setFirstName("Lingtan");
		employee.setDob(LocalDate.parse("2000-12-12"));
		String generatedEmployeeId = EmployeeService.generateEmployeeId(employee);
		assertEquals("Ling12007", generatedEmployeeId);
	}
	
	@Test
	public void emailGeneratorTestCase() {
		employee.setFirstName("Andrew");
		employee.setLastName("Navis Anthoni samy");
		employee.setEmployeeID("Andr12006");
		String inValidCredentials = EmployeeService.generateEmail(employee);
		assertEquals("andrew.navisanthonisamy12006@companyname.com",inValidCredentials);
	}
}
