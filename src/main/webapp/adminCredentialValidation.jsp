<!DOCTYPE html>
<%@page import="in.lingtan.service.UserService"%>


<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>admin Validation</title>
</head>
<body>



<%
String adminUsername = request.getParameter("adminUsername");
String adminPassword = request.getParameter("adminPassword");
boolean isValidAdmin = UserService.adminValidation(adminUsername, adminPassword);
if(isValidAdmin){
	response.sendRedirect("adminPortal.jsp");
}
else{
	out.println("Invalid Credentials");
	String message = "Invalid Credentials";
	response.sendRedirect("adminLogin.jsp?errorMessage="+message);
}
%>

<br><a href="adminLogin.jsp">click to retry again</a>
</body>
</html>