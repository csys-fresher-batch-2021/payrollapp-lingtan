<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">

<title>Admin portal</title>
</head>
<body>


	<jsp:include page="header.jsp"></jsp:include>
	<div class="d-flex justify-content-center">
		<h4>
			<%
			String employeeId = (String) session.getAttribute("ADMIN_ID");
			out.println("<h4>" + " Welcome " + employeeId + "</h4>");
			%>
		</h4>
	</div>

	<main class="container-fluid">
	
	

		<div class="d-flex justify-content-center">
			<a href="displayAllEmployees.jsp">Display Employees</a><br>
		</div>
		<div class="d-flex justify-content-center">
			<a href="adminOperations.jsp">Admin Modifications</a><br>
		</div>
		<div class="d-flex justify-content-center">
			<a href="index.jsp">Main page</a><br>
		</div>

	</main>


</body>
</html>