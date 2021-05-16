package in.lingtan.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.lingtan.service.UserService;
import in.lingtan.util.StringValidator;
import in.lingtan.validator.UserValidator;

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

		String adminUsername = request.getParameter("adminUsername");
		String adminPassword = request.getParameter("adminPassword");

		try {
			
			UserValidator.isValidEmployeeId(adminUsername, "Invalid Employee ID");
			StringValidator.isStringNotNullOrEmpty(adminPassword, "Password field Cannot be empty");

			boolean isValidAdmin = UserService.adminValidation(adminUsername, adminPassword);
			if (isValidAdmin) {
				HttpSession session = request.getSession();
				session.setAttribute("ADMIN_ID", adminUsername);
				session.setMaxInactiveInterval(1000);
				response.sendRedirect("adminPortal.jsp");
			}
		} catch (Exception e) {
			response.sendRedirect("adminLogin.jsp?errorMessage=" + e.getMessage());
		}
	}
}
