<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Admin portal</title>
</head>
<body>


	<jsp:include page="header.jsp"></jsp:include>
	<h4><%String employeeId = (String)session.getAttribute("ADMIN_ID");
		out.println("<h4>"+" Welcome "+employeeId+"</h4>");
		%></h4>
	<main class="container-fluid">

		<a href="employeeOperations.jsp">Employee Modifications</a><br> <a
			href="adminOperations.jsp">Admin Modifications</a><br> <a
			href="index.jsp">Main page</a><br>
	</main>
</body>
</html>