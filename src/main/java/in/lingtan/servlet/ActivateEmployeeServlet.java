package in.lingtan.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
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
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String employeeIdToActivate = request.getParameter("employeeIdToValidate");
		
			EmployeeService employeeService = new EmployeeService();
			if(employeeService.activateDeletedEmployee(employeeIdToActivate)) {
				RequestDispatcher rd = request.getRequestDispatcher("registerEmployee.jsp?activationSuccessMessage=Successfully activated &employeeId="+employeeIdToActivate +"&activationStatus=yes");  
				rd.forward(request, response);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			RequestDispatcher rd = request.getRequestDispatcher("registerEmployee.jsp?activationFailureMessage=Cannot activate");  
			rd.forward(request, response);
			e.printStackTrace();
		}
	}

	

}
