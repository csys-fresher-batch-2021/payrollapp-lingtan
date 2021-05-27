package in.lingtan.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.JsonObject;


import in.lingtan.service.UserService;
import in.lingtan.util.StringValidator;
import in.lingtan.validator.UserServiceValidator;

/**
 * Servlet implementation class EmployeeLogin
 */
@WebServlet("/EmployeeLogin")
public class EmployeeLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeLoginServlet() {
		super();

	}

	
	/**
	 * This method gets the username and password and validates and gives the result whether the 
	 * credentials are valid or not and if any exceptions occurs it is sent as a json object.
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String employeeId = request.getParameter("employeeLoginId");
			String password = request.getParameter("employeePassword");
			UserServiceValidator.isValidEmployeeId(employeeId, "Invalid Employee ID");
			StringValidator.isStringNotNullOrEmpty(password, "Password field Cannot be empty");

			PrintWriter out = response.getWriter();
			
			boolean isValid = UserService.employeeLoginValidation(employeeId, password);
			
			JsonObject obj = new JsonObject(); 
			obj.addProperty("IS_VALID", isValid);
			out.println(obj);
			out.flush();
			
		} catch (Exception e) {
			PrintWriter out = response.getWriter();
			JsonObject obj = new JsonObject();
			obj.addProperty("IS_VALID",e.getMessage());
			out.println(obj);
			out.flush();
		
		}
			
	}

}
