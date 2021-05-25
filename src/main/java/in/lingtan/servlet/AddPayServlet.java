package in.lingtan.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

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
     * This method gets the payroll data from the database for a specific employee role.
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PayRollService payRollService = new PayRollService();
		String roleToDisplay = request.getParameter("roleToDisplay");
		
		List<PayRollDTO> payrollData;
		try {
			payrollData = payRollService.getPayRoleData(roleToDisplay);
			
			Gson gson = new Gson();
			String json = gson.toJson(payrollData);
			PrintWriter out = response.getWriter();
			out.println(json);
			out.flush();
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
		
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
			
			
			PayRollService payRollService = new PayRollService();
			payRollService.updatePayRollData(payRollDTO);
			
			
			RequestDispatcher rd = request.getRequestDispatcher("addSalary.jsp?infoMessage=Successfully Updated Payroll Data for "+ role+ "&roleToPassIntoJavaMethod="+role);
			rd.forward(request, response);
	
		} catch (Exception e) {
			JsonObject object = new JsonObject();
			object.addProperty("ERROR_MESSAGE", "Unable to Display Data");
		}
		
	}
	
}
