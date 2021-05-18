<!DOCTYPE>

<%@page import="java.util.Map.Entry"%>
<%@page import="in.lingtan.service.EmployeeService"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<html lang="en">
<head>
<title>Employee Payroll</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<br />
	<main class="container-fluid">

		<h3>Employees in the Company</h3>

		<%
		EmployeeService employeeService = new EmployeeService();
		Map<String, String> allEmployeeDataToDisplay = employeeService.displayAllEmployees();
		%>


		<br>
		<table class="table" border="1">
 			
			<caption>List of Employees in a company</caption>
			 <thead class="thead-dark">
				<tr>
					<th scope="col">Employee ID</th>
					<th scope="col">Name</th>
					<th scope="col">Details</th>
					<th scope="col">Delete</th>
				</tr>
			</thead>
			<tbody>



				<%
				int i = 1;
				for (Entry<String, String> employeeId : allEmployeeDataToDisplay.entrySet()) {

					i++;
				%>
				<tr>
					<td><%=employeeId.getKey()%></td>
					<td><%=employeeId.getValue()%></td>
					<td><a
						href="DisplayEmployeeServlet?employeeId=<%=employeeId.getKey()%>">View
							Details</a></td>
					<td><a
						href="deleteEmployee.jsp?employeeId=<%=employeeId.getValue()%>">Delete
							ID</a></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
			<a href="adminPortal.jsp">Main menu</a>
			<br>
	</main>
</body>
</html>