package in.lingtan.validator;

import java.util.HashMap;

import in.lingtan.model.Employee;
import in.lingtan.service.EmployeeService;

public class EmployeeValidator {

	private EmployeeValidator() {
		// Default Constructor.
	}

	public static boolean isEmployeeNotAvailable(Employee employee) {
		boolean isAvailable = true;
		HashMap<String, Employee> employeeMap = EmployeeService.getAllEmployees();
		for (Employee employeeId : employeeMap.values()) {
			if (employeeId.getMobileNumber() == employee.getMobileNumber()
					&& employeeId.getLastName().toLowerCase().replaceAll("\\s", "")
							.equalsIgnoreCase(employee.getLastName().toLowerCase().replaceAll("\\s", ""))) {
				throw new RuntimeException(employeeId.getFirstName() + " - Already registered");
			}

		}
		return isAvailable;

	}
}
