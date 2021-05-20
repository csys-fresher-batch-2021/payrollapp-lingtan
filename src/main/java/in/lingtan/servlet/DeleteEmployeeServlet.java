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
 * Servlet implementation class DeleteEmployeeServlet
 */
@WebServlet("/DeleteEmployeeServlet")
public class DeleteEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteEmployeeServlet() {
        super();

    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeService employeeService = new EmployeeService();
		
		String employeeId = request.getParameter("employeeId");
		try {
			boolean isRemoved = employeeService.deleteEmployeeFromTheDataBase(employeeId);
			if(isRemoved) {
				RequestDispatcher rd=request.getRequestDispatcher("displayAllEmployees.jsp?infoMessage=SuccessFully Deleted Employee-"+employeeId);  
				rd.forward(request, response);
			}
			else {
				RequestDispatcher rd=request.getRequestDispatcher("displayAllEmployees.jsp?errorMessage=Cannot Delete Employee-"+employeeId);  
				rd.forward(request, response);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
