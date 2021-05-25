<!DOCTYPE html>
<%@page import="java.util.Map"%>
<%@page import="in.lingtan.service.EmployeeService"%>
<%@page import="in.lingtan.model.Employee"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.security.KeyStore.Entry"%>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Employee Data</title>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>
	<br />
	<main class="container-fluid">
	<a href="addSalary.jsp" type="button" class="btn btn-primary btn-color btn-bg-color btn-sm col-xs-2 margin-left">Pay slip</a>
	
	<br/>
	<table class="table" border="1">
	
	
	
		<caption>Employee Data</caption>
		<tbody>


			<%
			String employeeId = request.getParameter("employeeId");
			EmployeeService employeeService = new EmployeeService();
			Map<String, Employee> individualEmployeeData = employeeService.displayIndividualEmployeeData(employeeId);
			Employee employee = individualEmployeeData.get(employeeId);
			%>
			<tr>
			<th scope="col"><h3 style = "color:green"><%= employee.getFirstName()%></h3></th>
			</tr>
			<tr>
				<th scope="row">Employee Name</th>
				<td><%= employee.getName()%></td>
			</tr>
			<tr>
				<th scope="row">Employee-ID</th>
				<td><%= employee.getEmployeeID()%></td>
			</tr>
			<tr>
			<tr>
				<th scope="row">Role</th>
				<td><%= employee.getRole()%></td>
			<tr>
				<th scope="row">Gender</th>
				<td><%= employee.getGender()%></td>
			</tr>
			<tr>
				<th scope="row">Mobile Number</th>
				<td><%= employee.getMobileNumber()%></td>
			</tr>
			<tr>
				<th scope="row">Date of Birth</th>
				<td><%= employee.getDob()%></td>
			</tr>
			<tr>
				<th scope="row">Joined Date</th>
				<td><%=employee.getJoiningDate()%></td>
			</tr>
			
			
		

		</tbody>
	</table>
	</main>
</body>
<a href="displayAllEmployees.jsp">Previous page</a>

</html>