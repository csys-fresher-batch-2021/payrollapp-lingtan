package in.lingtan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import in.lingtan.model.Employee;
import in.lingtan.model.PayRoll;
import in.lingtan.util.ConnectionUtil;

public class PayRollServiceDAO {
	
	private static final String BASIC_PAY ="basic_pay";
	private static final String HRA ="hra";
	private static final String FOOD_ALLOWANCE ="food_allowance";
	private static final String TRAVEL_ALLOWANCE ="travel_allowance";
	private static final String MEDICAL_ALLOWANCE ="medical_allowance";
	private static final String PF ="pf";
	private static final String ROLE ="role";
	private static final String PF_PERCENTAGE ="pf_percentage";
	private static final String SALARY ="salary";
	private static final String CTC ="ctc";
	private static final String ANNUAL_BASIC_PAY ="annual_basic_pay";
	private static final String ANNUAL_HRA ="annual_hra";
	private static final String ANNUAL_FOOD_ALLOWANCE ="annual_food_allowance";
	private static final String ANNUAL_MEDICAL_ALLOWANCE ="annual_medical_allowance";
	private static final String ANNUAL_PF ="annual_pf";
	private static final String ANNUAL_TRAVEL_ALLOWANCE ="annual_travel_allowance";
	private static final String ANNUAL_SALARY ="annual_salary";
	private static final String ANNUAL_CTC ="annual_ctc";
	


	
	/**
	 * This method updates the database with the payroll data recieved  from the payroll service class
	 * @param payRoll
	 * @return 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public boolean update(PayRoll payRoll) throws ClassNotFoundException, SQLException {
		
	
		
		boolean isAdded = false;
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			
			String sql = "update payroll_data set (basic_pay, hra, pf, medical_allowance, travel_allowance , food_allowance, pf_percentage, salary, ctc) = (?,?,?,?,?,?,?,?,?) where role=?";
			pst = connection.prepareStatement(sql);
			pst.setDouble(1,payRoll.getBasicPay());
			pst.setInt(2,payRoll.getHraAllowance());
			pst.setDouble(3,payRoll.getPfAllowance());
			pst.setDouble(4,payRoll.getMedicalAllowance());
			pst.setDouble(5,payRoll.getTravelAllowance());
			pst.setDouble(6,payRoll.getFoodAllowance());
			pst.setDouble(7, payRoll.getPfPercentage());
			pst.setDouble(8, payRoll.getSalary());
			pst.setDouble(9, payRoll.getCtc());
			
			pst.setString(10, payRoll.getRole());
			
			pst.executeUpdate();
			isAdded = true;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
		
			ConnectionUtil.close(pst, connection);
			
		}
		return isAdded;
	}
	
	/**
	 * This method returns an array of payrolldata for a specified job role.
	 * @param role
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<PayRoll> get(String role) throws ClassNotFoundException, SQLException {
		
		List<PayRoll> payRollDataForARole = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {	
			connection = ConnectionUtil.getConnection();
			
			String sql = "select basic_pay, hra, food_allowance, pf, medical_allowance, travel_allowance, role, pf_percentage,salary, ctc from payroll_data where role=?";
			
			pst = connection.prepareStatement(sql);
			pst.setString(1, role);
			rs = pst.executeQuery();
			while(rs.next()) {
				PayRoll payRoll = new PayRoll();
				payRoll.setBasicPay(rs.getInt(BASIC_PAY));
				payRoll.setHraAllowance(rs.getInt(HRA));
				payRoll.setFoodAllowance(rs.getInt(FOOD_ALLOWANCE));
				payRoll.setMedicalAllowance(rs.getInt(MEDICAL_ALLOWANCE));
				payRoll.setPfAllowance(rs.getInt(PF));
				payRoll.setTravelAllowance(rs.getInt(TRAVEL_ALLOWANCE));
				payRoll.setRole(rs.getString(ROLE));
				payRoll.setPfPercentage(rs.getInt(PF_PERCENTAGE));
				payRoll.setSalary(rs.getInt(SALARY));
				payRoll.setCtc(rs.getInt(CTC));
				
				payRollDataForARole.add(payRoll);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
	
			e.printStackTrace();
		}
		 finally {
			ConnectionUtil.close(rs, pst, connection);
		}
		
		return payRollDataForARole;
	}
	
	
	/**
	 * This methof gets the payroll data for a selected individual employee from the database.
	 * @param role
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public 	List<PayRoll> getPayForEmployee(String role) throws ClassNotFoundException, SQLException {
		
		List<PayRoll> payRollDataForAnEmployee = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			connection = ConnectionUtil.getConnection();
		//	String sql = "select e.name,mobile_number,employee_id,e.role, p.basic_pay,hra,pf,medical_allowance, food_allowance, travel_allowance,salary,ctc from employee_data e, payroll_data p where (e.role = p.role) and employee_id=?";
			String sql = "select e.name,mobile_number,employee_id,e.role, \r\n"
					+ "p.basic_pay,p.basic_pay*12 as annual_basic_pay,\r\n"
					+ "hra,hra*12 as annual_hra,\r\n"
					+ "pf ,pf*12 as annual_pf,\r\n"
					+ "medical_allowance, medical_allowance*12 as annual_medical_allowance,\r\n"
					+ "food_allowance, food_allowance*12 as annual_food_allowance,\r\n"
					+ "travel_allowance, travel_allowance*12 as annual_travel_allowance ,\r\n"
					+ "salary, salary*12 as annual_salary ,\r\n"
					+ "ctc, ctc*12 as annual_ctc\r\n"
					+ "from employee_data e, payroll_data p \r\n"
					+ "where (e.role = p.role) and employee_id=?";
			
			pst = connection.prepareStatement(sql);
			pst.setString(1, role);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				PayRoll payRoll = new PayRoll();
				Employee employee = new Employee();
				employee.setName(rs.getString("name"));
				employee.setMobileNumber(rs.getLong("mobile_number"));
				employee.setEmployeeID(rs.getString("employee_id"));
				employee.setRole(rs.getString("role"));
				
				payRoll.setEmployee(employee);
				payRoll.setBasicPay(rs.getInt(BASIC_PAY));
				payRoll.setHraAllowance(rs.getInt(HRA));
				payRoll.setFoodAllowance(rs.getInt(FOOD_ALLOWANCE));
				payRoll.setMedicalAllowance(rs.getInt(MEDICAL_ALLOWANCE));
				payRoll.setPfAllowance(rs.getInt(PF));
				payRoll.setTravelAllowance(rs.getInt(TRAVEL_ALLOWANCE));
				payRoll.setAnnualBasicPay(rs.getInt(ANNUAL_BASIC_PAY));
				payRoll.setAnnualHraAllowance(rs.getInt(ANNUAL_HRA));
				payRoll.setAnnualFoodAllowance(rs.getInt(ANNUAL_FOOD_ALLOWANCE));
				payRoll.setAnnualMedicalAllowance(rs.getInt(ANNUAL_MEDICAL_ALLOWANCE));
				payRoll.setAnnualPfAllowance(rs.getInt(ANNUAL_PF));
				payRoll.setAnnualTravelAllowance(rs.getInt(ANNUAL_TRAVEL_ALLOWANCE));
				payRoll.setAnnualSalary(rs.getInt(ANNUAL_SALARY));
				payRoll.setAnnualCtc(rs.getInt(ANNUAL_CTC));
	
				payRoll.setSalary(rs.getInt(SALARY));
				payRoll.setCtc(rs.getInt(CTC));
				
				payRollDataForAnEmployee.add(payRoll);
			}
		
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			ConnectionUtil.close(rs, pst, connection);
		}
		System.out.println("In dao----"+payRollDataForAnEmployee);
		return payRollDataForAnEmployee;
	}

	

}
