package in.lingtan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import in.lingtan.model.Employee;
import in.lingtan.util.ConnectionUtil;

public class EmployeeServiceDAO {
	
	/**
	 * This Method Registers a new employee into a Database with their data.
	 * @param employee
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */

	public void addEmployee(Employee employee) throws ClassNotFoundException, SQLException {
		Connection connection = ConnectionUtil.getConnection();
		System.out.println(connection);
		String sql = "insert into employee_data (firstname,lastname,name,role ,mobilenumber,emailid,employeeid,dob,joineddate,password,gender) values (?,?,?,?,?,?,?,?,?,?,?)";
		System.out.println(sql);

		PreparedStatement pst = connection.prepareStatement(sql);
		pst.setString(1, employee.getFirstName());
		pst.setString(2, employee.getLastName());
		pst.setString(3, employee.getName());
		pst.setString(4, employee.getRole());
		pst.setLong(5, employee.getMobileNumber());
		pst.setString(6, employee.getEmail());
		pst.setString(7, employee.getEmployeeID());
		pst.setObject(8, employee.getDob());
		pst.setObject(9, employee.getJoiningData());
		pst.setString(10, employee.getPassword());
		pst.setString(11, employee.getGender());
		
		System.out.println("inserted note");

		int rows = pst.executeUpdate();

		System.out.println("No of rows inserted :" + rows);

		ConnectionUtil.close(connection);

	}
	
	/**
	 * This Method calculates the number of rows in the table 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */

	public int tableSize() throws ClassNotFoundException, SQLException {
		
		Connection connection = ConnectionUtil.getConnection();
		System.out.println(connection);

		String str1 = "select count(*) from employee_data";
		PreparedStatement pst1 = connection.prepareStatement(str1);
		ResultSet rs = pst1.executeQuery();
		rs.next();
		int count = rs.getInt(1);

		ConnectionUtil.close(connection);
		return count;
	}

	/**
	 * This Method returns a Map of mobile number and employee's 
	 * last name of all the employees in the table. This map is used for the purpose of 
	 * checking whether an employee is already registered or not
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	
	public Map<Long, String> isEmployeeNotAvailableInDAO() throws ClassNotFoundException, SQLException {
		Connection connection = ConnectionUtil.getConnection();
		System.out.println(connection);

		Map<Long, String> existingEmployeeCheck = new HashMap<>();

		String str1 = "select lastname from employee_data";
		PreparedStatement pst1 = connection.prepareStatement(str1);

		String str2 = "select mobilenumber from employee_data";
		PreparedStatement pst2 = connection.prepareStatement(str2);

		ResultSet rs1 = pst1.executeQuery();
		ResultSet rs2 = pst2.executeQuery();

		while (rs1.next() && rs2.next()) {

			String lastname = rs1.getString("lastname");
			long mobilenumber = rs2.getLong("mobilenumber");

			existingEmployeeCheck.put(mobilenumber, lastname);
		}
		return existingEmployeeCheck;

	}
	
	/**
	 * This Method returns a HashMap of employeeId and their corressponding employee Name for the purpose of displaying to the admin.
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Map<String, String> displayAllEmployees() throws ClassNotFoundException, SQLException {
		Map<String, String> allEmployeeDataToDisplay = new HashMap<>(); 
		
		Connection connection = ConnectionUtil.getConnection();
		
		String str = "select * from employee_data";
		PreparedStatement pst1 = connection.prepareStatement(str);	
		ResultSet rs =  pst1.executeQuery();
		while(rs.next()) {
			String employeeName = rs.getString("firstname");
			String employeeId = rs.getString("employeeid");
			allEmployeeDataToDisplay.put(employeeId, employeeName);
		}
		return allEmployeeDataToDisplay;
	}
	
		
		
}
