<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Employee Portal</title>
</head>
<script> 
const [entry] = performance.getEntriesByType("navigation");
if (entry["type"] === "back_forward")
location.reload();
</script>
<body>
	<jsp:include page="headerForEmployee.jsp"></jsp:include>
	<main class="container-fluid">
	<br/>
		<div class="d-flex justify-content-center">
			<div class="md=5 row">
				
			<%
			String employeeLoginId = (String)session.getAttribute("EMPLOYEE_LOGIN_USERNAME");
			if(employeeLoginId==null){
				response.sendRedirect("employeeLogin.jsp");
			}%>
			<%
			out.println("<h4>" + " Welcome - " + employeeLoginId + "</h4>");
			%>
			</div>
		</div>
		<div class="d-flex justify-content-center">
			<div class="md=5 row">
				<a href="changePassword.jsp" >Change Password</a>
			</div>
		</div>
</main>
</body>
</html>