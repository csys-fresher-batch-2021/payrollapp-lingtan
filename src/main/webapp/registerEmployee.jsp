<!DOCTYPE html>
<%@page import="java.time.LocalDate"%>
<%@page import="java.util.HashMap"%>

<html lang="en">
<head>
<%String employeeId = (String) session.getAttribute("ADMIN_ID");
if (employeeId == null) {
	response.sendRedirect("adminLogin.jsp");
}
%>
<meta charset="ISO-8859-1">
<title>Register Employee</title>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
	<div class="d-flex justify-content-center">
		<h3>Employee Registration</h3>
	</div>
	<div class="row">
		<div class="form-group col-md-2">
			<a href="displayAllEmployees.jsp" class="btn btn-primary">Display Employees</a>
		</div>
	</div>
	
	
<form action="RegisterEmployeeServlet" method="post">
	
	
	
	

	<%
	HttpSession session1 = request.getSession();
	String errorMessage = request.getParameter("errorMessage");
	String infoMessage = request.getParameter("infoMessage");
	String registeredEmployee = request.getParameter("registeredEmployeeId");
	
	if(errorMessage != null){
		out.println("<font color='red'>"+errorMessage+"</font>");
	}
	if(infoMessage != null){
		
		out.println("<font color='green'>"+infoMessage+"-"+registeredEmployee+"</font>");
		
	}
	%>
	
	<%String inActiveEmployeeId = request.getParameter("employeeId");
	String activationStatus = request.getParameter("activationStatus");
	if(inActiveEmployeeId!=null && activationStatus==null){
	%>
	<a href=ActivateEmployeeServlet?employeeIdToValidate=<%=inActiveEmployeeId %> id = "activateButton" class="btn btn-primary btn-sm" >Activate</a>
		
	<%}
	String activationSuccessfull = request.getParameter("activationSuccessMessage");
	String activationFailed = request.getParameter("activationFailureMessage");
	if(activationSuccessfull!=null){
		out.println("<font color='green'>"+activationSuccessfull+"-"+inActiveEmployeeId+"</font>");
	}
	else if(activationSuccessfull!=null){
		out.println("<font color='red'>"+activationFailed+"-"+inActiveEmployeeId+"</font>");
	}
	
	%>
	
	<div class="row">
	  <div class="col">
			<label>First Name  </label><input type="text" name="firstName" class="form-control form-control-sm" id="firstName" pattern="[a-zA-Z]+" placeholder="First Name" required autofocus>
	  </div>
	  <div class="col">
			<label>Last Name  </label><input type="text" name="lastName" id="lastName" class="form-control form-control-sm" placeholder="Employee's Father Name" required >
	  </div>
	</div>
	<div class="row">
		<div class="col">
			<label>Role </label>
			<select name = "Role" id = "Role" class="form-control form-control-sm" required >
				<option value="Technical Consultant" >Technical Consultant </option>
				<option value="HR" >HR </option>
				<option value="System Administration" >System Administration</option>
				<option value="PL SQL" >PL SQL </option>
				<option value="Software Developer" >Software Developer </option>
				<option value="UI-Designer" >Ui-Designer</option>
			</select>
		</div>
		<div class="col">
			<label>Date of Birth</label><input type="date" min='1985-01-01' max='2004-01-01' class="form-control form-control-sm" name="dob" id="dob"  placeholder="YYYY-MM-DD" required>
		</div>
	</div>
	
	<div class="row">
		<div class=" col">
			<label>Mobile Number</label><input type="number" name="Mobile-Number" min="0000000000" max="9999999999" id="Mobile-Number" class="form-control form-control-sm" placeholder="Mobile Number" required>
		</div>
		<div class="col">
			<label>Joined Date</label><input type="date" name="Joined-Date" class="form-control form-control-sm"  value="<%=LocalDate.now()%>" id="Joined-Date" placeholder="YYYY-MM-DD" required>
		</div>
	</div>
	<div class="row">
		<div class="col">
			<label>Gender</label>
			<div class="form-check form-check-inline">
				<label>Male</label><input type="radio" id="Male" name="Gender"  value ="Male" required>
			</div>
			<div class="form-check form-check-inline">
				<label>Female</label><input type="radio" id="Female" name="Gender"   value ="Female" required>
			</div>
		</div>
	</div>
	
	<div class="row">
		<div class="form-group col-md-2">
			<button class="btn btn-success">Register</button><br>
		</div>
		<div class="form-group col-md-2">
			<a href="registerEmployee.jsp" class="btn btn-danger">Reset</a>
		</div>

		<div class="form-group col-md-2">
			<a href="adminPortal.jsp" class="btn btn-primary">Admin Portal</a>
		</div>
	
	</div>
	
	
	<br/>


</form>

<script type="text/javascript">

const [entry] = performance.getEntriesByType("navigation");
if (entry["type"] === "back_forward"){
location.reload();
}

</script>
</main>

</body>
</html>