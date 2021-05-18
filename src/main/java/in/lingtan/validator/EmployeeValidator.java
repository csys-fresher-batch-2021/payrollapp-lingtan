package in.lingtan.validator;

import java.sql.SQLException;
import java.util.Map;

import in.lingtan.dao.EmployeeServiceDAO;
import in.lingtan.exceptions.ExistingEmployeeException;
import in.lingtan.model.Employee;

public class EmployeeValidator {

	private EmployeeValidator() {
		// Default Constructor.
	}

	
	/**
	 * This method verifies whether an employee is already registered or not.
	 * @param employee
	 * @return
	 * @throws ExistingEmployeeException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static boolean isEmployeeNotAvailable(Employee employee)
			throws ExistingEmployeeException, ClassNotFoundException, SQLException {

		boolean isAvailable = true;
		EmployeeServiceDAO employeeServiceDAO = new EmployeeServiceDAO();
		Map<Long, String> employeeMap = employeeServiceDAO.isEmployeeNotAvailableInDAO();
		for (Map.Entry<Long, String> employeeMapSet : employeeMap.entrySet()) {

			if (employeeMapSet.getKey() == (employee.getMobileNumber())
					&& (employeeMapSet.getValue().toLowerCase().replaceAll("\\s", "")
							.equalsIgnoreCase(employee.getLastName().toLowerCase().replaceAll("\\s", "")))) {
				throw new ExistingEmployeeException(employee.getName() + " - Already registered");

			} else {
				isAvailable = true;
			}
		}
		return isAvailable;
	}
}
