package in.lingtan.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import in.lingtan.dto.PayRollDTO;
import in.lingtan.service.PayRollService;

/**
 * Servlet implementation class PaySlipGenerationForEmployeeId
 */
@WebServlet("/PaySlipGenerationForEmployeeId")
public class PaySlipGenerationForEmployeeIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaySlipGenerationForEmployeeIdServlet() {
        super();
    }

	/**
	 * This method gets the payroll data from the service class to get displayed in the screen
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	PayRollService payRollService = new PayRollService();
		String employeeId = request.getParameter("employeeId");
		
		
		try {
			List<PayRollDTO> paySlipForAnEmployee = payRollService.getPayRollDataForEmployee(employeeId);
			
			Gson gson = new Gson();
			String object = gson.toJson(paySlipForAnEmployee);
			PrintWriter out = response.getWriter();
			out.println(object);
			out.flush();
			
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
    	
		
	}

  
}
