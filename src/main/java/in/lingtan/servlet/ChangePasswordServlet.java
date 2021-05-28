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
import in.lingtan.util.PasswordValidator;

/**
 * Servlet implementation class ChangePasswordServlet
 */
@WebServlet("/ChangePasswordServlet")
public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChangePasswordServlet() {
		super();

	}


	/**
	 * This method gets the acknowledgement whether the password is changed or not from the service class.
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			String employeeId = request.getParameter("employeeId");
			String newPassword = request.getParameter("newPassword");
			String oldPassword = request.getParameter("oldPassword");
			
			
			PasswordValidator.isValidPasswordFormat(newPassword, "Invalid Password Format");
	
			boolean isChanged =  UserService.changePassword(employeeId, newPassword, oldPassword);
		
			
			PrintWriter out = response.getWriter();
			JsonObject obj = new JsonObject();
			obj.addProperty("IS_CHANGED", isChanged);
			out.println(obj);
			out.flush();
			
		} catch (Exception e) {
			PrintWriter out = response.getWriter();
			JsonObject obj = new JsonObject();
			obj.addProperty("IS_CHANGED", e.getMessage());
			out.println(obj);
			out.flush();
		}
		
	}
}
