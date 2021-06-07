package in.lingtan.servlet;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import in.lingtan.dto.PayRollDTO;
import in.lingtan.service.PayRollService;
import in.lingtan.util.NumberValidator;


/**
 * Servlet implementation class AddPayServlet
 */
@WebServlet("/AddPayServlet")
public class AddPayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPayServlet() {
        super();
     }

	

									
	/**
	 * This method recieves the form values and stores it into the database after validation. 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	PayRollDTO payRollDTO = new PayRollDTO();
		
		try {
			
			String role = request.getParameter("Role");
			String basicPay = request.getParameter("basicPay");
			String hra = request.getParameter("hra");
			String medicalAllowance = request.getParameter("medicalAllowance");
			String travelAllowance = request.getParameter("travelAllowance");
			String foodAllowance = request.getParameter("foodAllowance");
			String pfPercentage = request.getParameter("pfPercentage");
			

			payRollDTO.setRole(role);
			
			payRollDTO.setBasicPay(NumberValidator.isValidInteger(basicPay, "Invalid Basic Pay"));
			payRollDTO.setHraAllowance(NumberValidator.isValidInteger(hra, "Invalid HRA"));
			payRollDTO.setFoodAllowance(NumberValidator.isValidInteger(foodAllowance, "Invalid Food Allowance"));
			payRollDTO.setTravelAllowance(NumberValidator.isValidInteger(travelAllowance, "Invalid Travel Allowance"));
			payRollDTO.setMedicalAllowance(NumberValidator.isValidInteger(medicalAllowance, "Invalid Medical Allowance"));
			payRollDTO.setPfPercentage(NumberValidator.isValidInteger(pfPercentage, "Invalid PF percentage"));
			
			NumberValidator.isValidPayData(payRollDTO.getBasicPay(),"Basic pay cannot be Negative");
			NumberValidator.isValidPayData(payRollDTO.getHraAllowance(),"HRA cannot be negative");
			NumberValidator.isValidPayData(payRollDTO.getFoodAllowance(),"FoodAllowance cannot be negative");
			NumberValidator.isValidPayData(payRollDTO.getPfPercentage(),"Pf percentage cannot be negative");
			NumberValidator.isValidPayData(payRollDTO.getMedicalAllowance(),"Medical Allowance cannot be negative");
			NumberValidator.isValidPayData(payRollDTO.getTravelAllowance(),"Travel Allowance cannot be negative");
			
			
			PayRollService payRollService = new PayRollService();
			payRollService.updatePayRollData(payRollDTO);
			
			
			RequestDispatcher rd = request.getRequestDispatcher("addSalary.jsp?infoMessage=Successfully Updated Payroll Data for "+ role+ "&roleToPassIntoJavaMethod="+role);
			rd.forward(request, response);
	
		} catch (Exception e) {
			RequestDispatcher rd = request.getRequestDispatcher("addSalary.jsp?errorMessage="+e.getMessage());
			rd.forward(request, response);
		}
		
	}
	
}
