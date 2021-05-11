<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Admin Portal</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">


<h2>Welcome</h2>
<h3><strong>Admin Login portal</strong></h3>
<form action="adminCredentialValidation.jsp" method="get">

<input type="text" name="adminUsername" id="adminUsername" placeholder="Employee ID" required autofocus><br/><br/>
<input type ="password" name="adminPassword" id="adminPassword" placeholder="password" required ><br/>
<%

final String errorMessage = request.getParameter("errorMessage");
if(errorMessage!=null){
	out.println("<font color='red'>"+errorMessage+"</font>");
}
%>
<br/>

<button class="btn btn-primary">Login</button><br>


</form>
<br>
<a href="index.jsp">Employee Login</a>
</main>
</body>
</html>