package in.lingtan.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;

import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import in.lingtan.model.Employee;
import in.lingtan.service.EmployeeService;
import in.lingtan.util.DateTimeAdapter;
/**
 * Servlet implementation class DispalyIndivualEmployeeDataServlet
 */
@WebServlet("/DispalyIndivualEmployeeDataServlet")
public class DispalyIndivualEmployeeDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispalyIndivualEmployeeDataServlet() {
        super();

    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String employeeId = request.getParameter("employeeId");
		EmployeeService employeeService = new EmployeeService();
		try {
			List<Employee> employeeData = employeeService.displayIndividualEmployeeData(employeeId);
			Gson gson = new GsonBuilder().setPrettyPrinting().registerTypeAdapter(LocalDate.class, new DateTimeAdapter()).registerTypeAdapter(LocalDate.class, new DateTimeAdapter()).create();
			
			String obj = gson.toJson(employeeData);
			PrintWriter out = response.getWriter();
			out.println(obj);
			out.flush();
		
		} catch (ClassNotFoundException | SQLException e) {
		
			e.printStackTrace();
		}
		
	}

}
