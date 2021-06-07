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

import in.lingtan.dto.PayRollDTO;
import in.lingtan.service.PayRollService;

/**
 * Servlet implementation class GetPayDataForRoleServlet
 */
@WebServlet("/GetPayDataForRoleServlet")
public class GetPayDataForRoleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetPayDataForRoleServlet() {
        super();

    }

    @Override
   	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   	
   		PayRollService payRollService = new PayRollService();
   		String roleToDisplay = request.getParameter("roleToDisplay");
   		
   		List<PayRollDTO> payrollData;
   		try {
   			payrollData = payRollService.getPayRoleData(roleToDisplay);
   			
   			Gson gson = new Gson();
   			String json = gson.toJson(payrollData);
   			PrintWriter out = response.getWriter();
   			out.println(json);
   			out.flush();
   		} catch (ClassNotFoundException | SQLException e) {

   			e.printStackTrace();
   		}
   		
    }
}

