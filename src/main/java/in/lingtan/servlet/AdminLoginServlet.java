package in.lingtan.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.lingtan.exceptions.InvalidCredentialsException;
import in.lingtan.service.UserService;
import in.lingtan.util.StringValidator;
import in.lingtan.validator.UserServiceValidator;

/**
 * Servlet implementation class AdminValidationService
 */
@WebServlet("/AdminLogin")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * This method validates the admin credentials and checks whether the admin is a
	 * valid user or not.
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
	
			String adminUsername = request.getParameter("adminUsername");
			String adminPassword = request.getParameter("adminPassword");			
			UserServiceValidator.isValidEmployeeId(adminUsername, "Invalid Employee ID");
			StringValidator.isStringNotNullOrEmpty(adminPassword, "Password field Cannot be empty");

			boolean isValidAdmin = UserService.adminValidation(adminUsername, adminPassword);
			if (isValidAdmin) {
				HttpSession session = request.getSession();
				session.setAttribute("ADMIN_ID", adminUsername);
				response.sendRedirect("adminPortal.jsp?username="+adminUsername);
				
			}else {
				throw new InvalidCredentialsException("Invalid Admin Credentials");
			
			}
		} catch (Exception e) {
			RequestDispatcher rd=request.getRequestDispatcher("adminLogin.jsp?errorMessage=" + e.getMessage());  
			rd.forward(request, response);
			
		}
	}
}
