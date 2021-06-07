<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/fontawesome.min.css">
<link rel="stylesheet" href="assets/css/style.css">

<%
String employeeId = (String)session.getAttribute("ADMIN_ID");
String employeeLoginId = (String)session.getAttribute("EMPLOYEE_LOGIN_USERNAME");
%>
<style>
#userId{
font-size:16px;
color:black;
font-weight:bold;
border:1px solid white;
background-color:white;
border-radius:10%;
margin-top:10px;
margin-left:10px;
opacity:0.8;
padding:5px;
}
</style>
<link rel="icon" type="image/png" href="/assets/images/logo-l10.png"/>
<header>

<nav class="navbar navbar-expand-sm navbar-dark bg-dark">

<%if(employeeId == null){ %>

  <a class="navbar-brand" href="index.jsp">L10-PayRoll</a>
  <button class="navbar-toggler d-lg-none" type="button" data-toggle="collapse" data-target="#collapsibleNavId" aria-controls="collapsibleNavId"
      aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="collapsibleNavId">
    
    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
      <li class="nav-item active">
        <a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
      </li>
    </ul>
    
   
   <%}else if(employeeId!=null){ %>
    <a class="navbar-brand" href="adminPortal.jsp">PayRoll-App</a>
    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
      <li class="nav-item active">
        <a class="nav-link" href="adminPortal.jsp">Home <span class="sr-only">(current)</span></a>
      </li>
    </ul>
   <%} %>

     <ul class="navbar-nav ml-auto mt-2 mt-lg-0">
    <%if(employeeId == null){ %>
      <li class="nav-item active">
        <a class="nav-link" href="adminLogin.jsp">Login</a>
      </li>
    
  	<%}else if(employeeId!=null){ %>
      <li class="nav-item">
        <a class="nav-link" href="LogoutServlet" onclick="confirmLogout()">Logout</a>
       </li>
       <li>
       	<a class="nav-link" href="registerEmployee.jsp">Register Employee</a>
      </li>
      </ul>
       <label id="userId"><%=employeeId %></label>
   <%} %>
  
<script>
function confirmLogout(){
	if(confirm("Are you sure want to Logout")){
		window.localStorage.clear();
	}else{
		event.preventDefault();
	} 	
}
</script>
   
 </div>
 
</nav>
</header>
