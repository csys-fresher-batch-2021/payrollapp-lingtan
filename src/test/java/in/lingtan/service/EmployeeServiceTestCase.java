package in.lingtan.service;

import static org.junit.Assert.assertEquals;


import java.sql.SQLException;
import java.time.LocalDate;

import java.util.Map;

import org.junit.After;
import org.junit.Test;


import in.lingtan.model.Employee;

public class EmployeeServiceTestCase {
	static Employee employee = new Employee();
	static EmployeeService employeeService = new EmployeeService(); 
	
	@After
	public void resetData() throws ClassNotFoundException, SQLException{
		
		Map<String, String> employeeMap = employeeService.displayAllEmployees();
		employeeMap.clear();
	}
		
	@Test
	public void employeeIdGeneratorTestCase() {
		employee.setFirstName("Lingtan");
		employee.setDob(LocalDate.parse("2000-12-12"));
		String generatedEmployeeId = employeeService.generateEmployeeId(employee, 0);
		assertEquals("Ling12007", generatedEmployeeId);
	}
	
	@Test
	public void emailGeneratorTestCase() {
		employee.setFirstName("Andrew");
		employee.setLastName("Navis Anthoni samy");
		employee.setEmployeeID("Andr12006");
		String inValidCredentials = employeeService.generateEmail(employee);
		assertEquals("andrew.navisanthonisamy12006@companyname.com",inValidCredentials);
	}
}
