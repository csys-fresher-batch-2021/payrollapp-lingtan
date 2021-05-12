package in.lingtan.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.lingtan.service.UserService;

/**
 * Servlet implementation class AdminValidationService
 */
@WebServlet("/AdminValidationServlet")
public class AdminValidationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String adminUsername = request.getParameter("adminUsername");
		String adminPassword = request.getParameter("adminPassword");
		boolean isValidAdmin = UserService.adminValidation(adminUsername, adminPassword);
		if(isValidAdmin){
			response.sendRedirect("adminPortal.jsp");
		}
		else{
	
			String message = "Invalid Credentials";
			response.sendRedirect("adminLogin.jsp?errorMessage="+message);
		}
	}

}
