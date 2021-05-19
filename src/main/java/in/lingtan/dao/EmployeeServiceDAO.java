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
	 * 
	 * @param employee
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */

	public void addEmployee(Employee employee) throws ClassNotFoundException, SQLException {

		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();

			String sql = "insert into employee_data (firstname,lastname,name,role ,mobilenumber,emailid,employeeid,dob,joineddate,password,gender) values (?,?,?,?,?,?,?,?,?,?,?)";

			pst = connection.prepareStatement(sql);

			pst.setString(1, employee.getFirstName());
			pst.setString(2, employee.getLastName());
			pst.setString(3, employee.getName());
			pst.setString(4, employee.getRole());
			pst.setLong(5, employee.getMobileNumber());
			pst.setString(6, employee.getEmail());
			pst.setString(7, employee.getEmployeeID());
			pst.setObject(8, employee.getDob());
			pst.setObject(9, employee.getJoiningDate());
			pst.setString(10, employee.getPassword());
			pst.setString(11, employee.getGender());

			pst.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.getMessage();
		} finally {
			ConnectionUtil.close(pst, connection);
		}
	}

	/**
	 * This Method calculates the number of rows in the table
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */

	public int tableSize() throws ClassNotFoundException, SQLException {

		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		int count = 0;
		try {
			connection = ConnectionUtil.getConnection();

			String str = "select count(*) from employee_data";

			pst = connection.prepareStatement(str);
			rs = pst.executeQuery();

			rs.next();
			count = rs.getInt(1);
		} catch (ClassNotFoundException | SQLException e) {

			e.getMessage();
		} finally {
			ConnectionUtil.close(rs, pst, connection);
		}

		return count;
	}

	/**
	 * This Method returns a Map of mobile number and employee's last name of all
	 * the employees in the table. This map is used for the purpose of checking
	 * whether an employee is already registered or not
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */

	public Map<Long, String> isEmployeeNotAvailableInDAO() throws ClassNotFoundException, SQLException {

		Connection connection = null;
		Map<Long, String> existingEmployeeCheck = new HashMap<>();
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			connection = ConnectionUtil.getConnection();
			existingEmployeeCheck = new HashMap<>();

			String str = "select * from employee_data";
			pst = connection.prepareStatement(str);
			rs = pst.executeQuery();

			while (rs.next()) {
				String lastname = rs.getString("lastname");
				long mobilenumber = rs.getLong("mobilenumber");

				existingEmployeeCheck.put(mobilenumber, lastname);
			}
		} catch (ClassNotFoundException | SQLException e) {

			e.getMessage();
		}

		finally {
			ConnectionUtil.close(rs, pst, connection);
		}
		return existingEmployeeCheck;

	}

	/**
	 * This Method returns a HashMap of employeeId and their corressponding employee
	 * Name for the purpose of displaying to the admin.
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Map<String, String> displayAllEmployees() throws ClassNotFoundException, SQLException {

		Map<String, String> allEmployeeDataToDisplay = new HashMap<>();
		Connection connection = null;
		PreparedStatement pst1 = null;
		ResultSet rs = null;
		try {
			connection = ConnectionUtil.getConnection();

			String str = "select * from employee_data";
			pst1 = connection.prepareStatement(str);
			rs = pst1.executeQuery();

			while (rs.next()) {
				String employeeName = rs.getString("firstname");
				String employeeId = rs.getString("employeeid");
				allEmployeeDataToDisplay.put(employeeId, employeeName);
			}
		} catch (ClassNotFoundException | SQLException e) {

			e.getMessage();
		} finally {
			ConnectionUtil.close(rs, pst1, connection);
		}
		return allEmployeeDataToDisplay;
	}
	
	/**
	 * This method gives a map of individual employee data of a particular employee in the database.
	 * @param employeeId
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Map<String, Employee> displayDetailOfAnIndividualEmployee(String employeeId) throws ClassNotFoundException, SQLException {
		Map<String, Employee> allEmployeeDataToDisplay = new HashMap<>(); 
		
		Employee employee = new Employee();
		Connection connection = ConnectionUtil.getConnection();
		
		String str = "select * from employee_data where employeeid=?";
		PreparedStatement pst = connection.prepareStatement(str);	
		pst.setString(1, employeeId);
		ResultSet rs =  pst.executeQuery();
		while(rs.next()) {
			employee.setFirstName(rs.getString("firstname"));
			employee.setName(rs.getString("name"));
			employee.setEmployeeID(rs.getString("employeeid"));
			employee.setMobileNumber(rs.getLong("mobilenumber"));
			employee.setEmail(rs.getString("emailid"));
			employee.setGender(rs.getString("gender"));
			employee.setRole(rs.getString("role"));
			employee.setDob(LocalDate.parse(rs.getString("dob")));
			employee.setJoiningDate(LocalDate.parse(rs.getString("joineddate")));
			
			allEmployeeDataToDisplay.put(employee.getEmployeeID(),employee);
		}
		
		return allEmployeeDataToDisplay;
	}	


}
