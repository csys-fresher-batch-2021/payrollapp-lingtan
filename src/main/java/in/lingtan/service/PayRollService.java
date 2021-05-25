package in.lingtan.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.lingtan.dao.PayRollServiceDAO;
import in.lingtan.dto.PayRollDTO;
import in.lingtan.model.PayRoll;


public class PayRollService {
	
	private PayRoll payRoll = new PayRoll();
	private PayRollServiceDAO payRollServiceDAO = new PayRollServiceDAO();
	
	/**
	 * This method gets the form values from the servlet and send those values to the DAO class to update in the database.
	 * @param payRollDTO
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void updatePayRollData(PayRollDTO payRollDTO) throws ClassNotFoundException, SQLException {
		
		PayRollService payRollService = new PayRollService();
		int calculatedPf = payRollService.caluculatePf(payRollDTO);
		int calculatedSalary = payRollService.calculateSalary(payRollDTO);
		int calculatedCtc = payRollService.calculateCtc(payRollDTO);
		System.out.println(calculatedCtc);
		
		
		payRoll.setRole(payRollDTO.getRole());
		payRoll.setBasicPay(payRollDTO.getBasicPay());
		payRoll.setHraAllowance(payRollDTO.getHraAllowance());
		payRoll.setFoodAllowance(payRollDTO.getFoodAllowance());
		payRoll.setPfAllowance(calculatedPf);
		payRoll.setPfPercentage(payRollDTO.getPfPercentage());
		payRoll.setTravelAllowance(payRollDTO.getTravelAllowance());
		payRoll.setMedicalAllowance(payRollDTO.getMedicalAllowance());
		payRoll.setSalary(calculatedSalary);
		payRoll.setCtc(calculatedCtc);
		
		
		payRollServiceDAO.update(payRoll);
		
		
	}
	
	
	/**
	 * This Method gets an array of individual role's payroll data from the dao class.
	 * @param role
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<PayRollDTO> getPayRoleData(String role) throws ClassNotFoundException, SQLException {
		PayRollDTO payRollDTO = new PayRollDTO();
		
		
		
		List<PayRollDTO> payRollDataArrayForServlet = new ArrayList<>();
		List<PayRoll> payRollDataFromDAO = payRollServiceDAO.get(role);
		
		for(PayRoll payRollData : payRollDataFromDAO) {
			payRollDTO.setBasicPay(payRollData.getBasicPay());
			payRollDTO.setHraAllowance(payRollData.getHraAllowance());
			payRollDTO.setPfAllowance(payRollData.getPfAllowance());
			payRollDTO.setMedicalAllowance(payRollData.getMedicalAllowance());
			payRollDTO.setTravelAllowance(payRollData.getTravelAllowance());
			payRollDTO.setFoodAllowance(payRollData.getFoodAllowance());
			payRollDTO.setPfPercentage(payRollData.getPfPercentage());
			payRollDTO.setRole(payRollData.getRole());
			payRollDTO.setSalary(payRollData.getSalary());
			payRollDTO.setCtc(payRollData.getCtc());
			payRollDataArrayForServlet.add(payRollDTO);
			
		}
		return payRollDataArrayForServlet;	
	}
	
	/**
	 * This method calculates the pf amount from the basic pay using the alloted pf percentage.
	 * @param payRollDTO
	 * @return
	 */
	public int caluculatePf(PayRollDTO payRollDTO) {
		
		payRollDTO.setPfAllowance((payRollDTO.getBasicPay() * payRollDTO.getPfPercentage())/100);
		
		return payRollDTO.getPfAllowance();
		}
	
	/**
	 * This method calculates the estimated gross compensation for a specified role. 
	 * @param payRollDTO
	 * @return
	 */
	private int calculateSalary(PayRollDTO payRollDTO) {
		payRollDTO.setSalary((payRollDTO.getBasicPay()+payRollDTO.getHraAllowance()+payRollDTO.getMedicalAllowance()+payRollDTO.getFoodAllowance()+payRollDTO.getTravelAllowance())-payRollDTO.getPfAllowance());
		return payRollDTO.getSalary();
	}
	
	/**
	 * This method calculates the cost to company for a specified role.
	 * @param payRollDTO
	 * @return
	 */
	private int calculateCtc(PayRollDTO payRollDTO) {
		payRollDTO.setCtc((payRollDTO.getBasicPay()+payRollDTO.getHraAllowance()+payRollDTO.getMedicalAllowance()+payRollDTO.getFoodAllowance()+payRollDTO.getTravelAllowance()));
		return payRollDTO.getCtc();
	}
	
	
}

