package in.lingtan.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.lingtan.service.EmployeeService;

/**
 * Servlet implementation class ActivateEmployeeServlet
 */
@WebServlet("/ActivateEmployeeServlet")
public class ActivateEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActivateEmployeeServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String employeeIdToActivate = request.getParameter("employeeIdToValidate");
		
			EmployeeService employeeService = new EmployeeService();
			if(employeeService.activateDeletedEmployee(employeeIdToActivate)) {
				response.sendRedirect("registerEmployee.jsp?activationSuccessMessage=Successfully activated &employeeId="+employeeIdToActivate +"&activationStatus=yes");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			response.sendRedirect("registerEmployee.jsp?activationFailureMessage=Cannot activate");
			e.printStackTrace();
		}
	}

	

}
