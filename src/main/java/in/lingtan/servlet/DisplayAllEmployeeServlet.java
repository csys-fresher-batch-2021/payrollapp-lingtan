package in.lingtan.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import in.lingtan.model.Employee;
import in.lingtan.service.EmployeeService;

/**
 * Servlet implementation class DisplayAllEmployeeServlet
 */
@WebServlet("/DisplayAllEmployeeServlet")
public class DisplayAllEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayAllEmployeeServlet() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeService employeeService = new EmployeeService();
		System.out.println("hello");
	
		try {
			List<Employee> employeeList = employeeService.displayAllEmployees();
			PrintWriter out = response.getWriter();
			Gson gson = new Gson();
			String object = gson.toJson(employeeList);
			out.println(object);
			out.flush();
			
		} catch (ClassNotFoundException | SQLException e) {
			PrintWriter out = response.getWriter();
			JsonObject obj = new JsonObject();
			obj.addProperty("ERROR",e.getMessage() );
			out.println(obj);
			out.flush();
			e.printStackTrace();
		}
		
	
	}

	

}
