package in.lingtan.servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.lingtan.exceptions.CannotRegisterEmployeeException;
import in.lingtan.model.Employee;
import in.lingtan.service.EmployeeService;
import in.lingtan.util.DateValidator;
import in.lingtan.util.NumberValidator;
import in.lingtan.util.StringValidator;

/**
 * Servlet implementation class GenerateEmployeeID
 */
@WebServlet("/RegisterEmployeeServlet")
public class RegisterEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * This method validates the datas entered in the input field and registers the
	 * user only when all the datas are valid else it throws an exception which is
	 * catched and displayed to the admin.
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			Employee employee = new Employee();
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String dob = request.getParameter("dob");
			String role = request.getParameter("Role");
			String mobileNumber = request.getParameter("Mobile-Number");
			String joinedDate = request.getParameter("Joined-Date");
			String gender = request.getParameter("Gender");

			StringValidator.isStringNotNullOrEmpty(firstName, "FirstName field Cannot be Empty");

			StringValidator.isStringNotNullOrEmpty(lastName, "Last Name Cannot be Empty");

			LocalDate parsedDob = DateValidator.isDateFormatOrNot(dob, "Invalid DOB Date Format");
			DateValidator.isNotAFutureDate((parsedDob), "DOB cannot be a future date");

			Long validatedMobileNumber = NumberValidator.isValidNumberOnly(mobileNumber,
					"Mobile Number cannot contain alphabets");
			NumberValidator.isValidMobileNumber(validatedMobileNumber);

			LocalDate parsedJoinedDate = DateValidator.isDateFormatOrNot(joinedDate, "Invalid Joining Date Format");
			DateValidator.isNotAFutureDate(parsedJoinedDate, "Joining Date cannot be a future date");

			employee.setFirstName(firstName);
			employee.setLastName(lastName);
			employee.setName(employee.getFirstName() + " " + employee.getLastName());
			employee.setDob(parsedDob);
			employee.setRole(role);
			employee.setMobileNumber(validatedMobileNumber);
			employee.setJoiningData(parsedJoinedDate);
			employee.setGender(gender);
			
			EmployeeService employeeService = new EmployeeService();
		
			boolean isAddedEmployee = employeeService.addEmployee(employee);


			if (isAddedEmployee) {
				String successMessage = "Successfully Registered";
				response.sendRedirect("registerEmployee.jsp?infoMessage=" + successMessage + "&registeredEmployeeId="
						+ employee.getFirstName());
			} else {
				throw new CannotRegisterEmployeeException("Cannot Register user");
			}
		} catch (Exception e) {
			response.sendRedirect("registerEmployee.jsp?errorMessage=" + e.getMessage());
		}

	}

}
