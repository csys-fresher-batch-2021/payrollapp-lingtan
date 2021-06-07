<!DOCTYPE html>
<%@page import="java.util.Map"%>
<%@page import="in.lingtan.service.EmployeeService"%>
<%@page import="in.lingtan.model.Employee"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.security.KeyStore.Entry"%>

<html lang="en">
<head>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<link rel="stylesheet" href="assets/css/adminPortal.css">

<meta charset="ISO-8859-1">
<title>Employee Data</title>
<style>
.card{
margin-top:10px;
margin-left:-10px;
margin-bottom:10px;
height:70px;
width:130px;
}

</style>
</head>
<body onload="displayEmployeeData()">
<%String employeeIdLoggedIn = (String) session.getAttribute("ADMIN_ID");
if(employeeIdLoggedIn==null){
	response.sendRedirect("adminLogin.jsp");
}
%>


			
<jsp:include page="header.jsp"></jsp:include>
	<div class="pageTitle" class="d-flex justify-content-center">
	 	<h4 class="pageTitleText" id="employeeIdForLabel"></h4>
	 </div>
	<main class="container-fluid">
	<div class="col">
            <div class="card l-bg-green-dark">
                <div class="card-statistic-3 p-4">
                       <div class="card-icon card-icon-large"></div>
                    	<div class="mb-4">
                    	<a class="card-block stretched-link text-decoration-none" onclick="generatePaySlipForEmployee()" ></a>
                   			<h5 class="cardTitle">Pay-Slip</h5>
                   		</div>
                    </div>
                </div>
            </div>
      

	<table id="employeeDataTable" class="table" border="1">
		<caption>Employee Data</caption>
		<tbody>

		<tr>
				<th class="thead-dark" scope="col"></th>
		</tr>
	
		</tbody>
	</table>
	</main>

<script type="text/javascript">
function displayEmployeeData(){
	let params = new URLSearchParams(window.location.search);
	let employeeId = params.get("employeeId");
	let url = "DispalyIndivualEmployeeDataServlet?employeeId="+employeeId;
	
	axios.post(url).then(res=>{
		
		
		
		for(let dataField of res.data){
			document.getElementById("employeeIdForLabel").innerHTML = dataField.name;
			var tableData = '<thead class="thead-dark"><th>'+dataField.employeeID+'</th><th></th></thead>'
			tableData+= '<tbody>'	    	
	    	tableData+= '<tr><th>Name</th>';
	    	tableData+= '<td>' + dataField.name + '</td></tr>';
	    	tableData+= '<tr><th>EmployeeID</th>';
	    	tableData+= '<td>' + dataField.employeeID + '</td></tr>';
	    	tableData+= '<tr><th>Gender</th>';
	    	tableData+= '<td>' + dataField.gender + '</td></tr>';
	    	tableData+= '<tr><th>Role</th>';
	    	tableData+= '<td>' + dataField.role+ '</td></tr>';
	    	tableData+= '<tr><th>Mobile Number</th>';
	    	tableData+= '<td>' + dataField.mobileNumber + '</td></tr>';
	    	tableData+= '<tr><th>Email</th>';
	    	tableData+= '<td>' + dataField.email + '</td></tr>';
	    	tableData+= '<tr><th>DOB</th>';
	    	tableData+= '<td>' + dataField.dob + '</td></tr>';
	    	tableData+= '<tr><th>Joined Date</th>';
	    	tableData+= '<td>' + dataField.joiningDate + '</td></tr>';
	    	
	    	tableData+='</tbody>';
		    document.getElementById("employeeDataTable").innerHTML = tableData;
		}
	})
}

function generatePaySlipForEmployee(){

	let params = new URLSearchParams(window.location.search);
	let employeeId = params.get("employeeId");
	window.location.href="paySlipOfEmployee.jsp?employeeId="+employeeId;
}

/**
 * This block of code automatically makes the page to reload whenever navigated
 */
const [entry] = performance.getEntriesByType("navigation");
if (entry["type"] === "back_forward")
location.reload();

</script>


</body>
<a href="displayAllEmployees.jsp">Previous page</a>

</html>