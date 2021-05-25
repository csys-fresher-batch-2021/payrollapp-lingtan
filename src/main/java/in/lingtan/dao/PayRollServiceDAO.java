package in.lingtan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
	
	
	/**
	 * This method updates the database with the payroll data recieved  from the payroll service class
	 * @param payRoll
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void update(PayRoll payRoll) throws ClassNotFoundException, SQLException {
		
	
		
		
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
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
		
		ConnectionUtil.close(pst, connection);
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
	

}
