<!DOCTYPE>


<%@page import="java.util.Map.Entry"%>
<%@page import="in.lingtan.service.EmployeeService"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<html lang="en">
<head>
<style>
#searchEmployee {
width: 250px;
background:lightgreen;
opacity:90%;
}
</style>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>

<title>Employee Payroll</title>
</head>
<body onload="search()">
	<jsp:include page="header.jsp"></jsp:include>
	<br />
	<main class="container-fluid">

		<h3>Employees in the Company</h3>
		<label>Search Employee</label><input type="text" id="searchEmployee" oninput="search()" class="form-control form-control-sm"  placeholder="Enter Employee Name"> <br>
		<table id="employeeTable" class="table" border="1">

			<caption>List of Employees in a company</caption>
			<thead class="thead-dark">
				<tr>
					<th scope="col"></th>
				
				</tr>
			</thead>
			<tbody>

			</tbody>
		</table>

		<a href="adminPortal.jsp">Main menu</a> <br>
	</main>
<script>

/**
 * This function fetches the data from the servlet and stores it in a variable and does the filteration and sends the data to display function.
 */
function search(){
	event.preventDefault();
	let value = document.getElementById("searchEmployee").value;
	let url = "DisplayAllEmployeeServlet";
	fetch(url).then(res=>res.json()).then(res=>{

	let filteredData = [];
	
	if(value!=null){
		filteredData = res.filter(res => res.name.toLowerCase().includes(value.toLowerCase()));
	}else{
		filteredData = res;
	}
	displayEmployee(filteredData);
	});
	}
	
/**
 * This Function gets the filtered data as parameter and aligns it in the table.
 */
function displayEmployee(filteredData){
	
		var tableData = '<thead class="thead-dark"><th>Name</th><th>EmployeeID</th><th>Details</th><th>Delete</th></thead>'
			tableData+= '<tbody>'
		    for(i = 0;i < filteredData.length; i++){
		    	tableData+= '<tr>';
		    	tableData+= '<td>' + filteredData[i].name + '</td>';
		    	tableData+= '<td>' + filteredData[i].employeeID + '</td>';
		    	tableData+= '<td><a href="displayIndividualEmployeeData.jsp?employeeId='+filteredData[i].employeeID+'"">Profile</a></td>';
		    	tableData+= '<td><a href="DeleteEmployeeServlet?employeeId='+filteredData[i].employeeID+'"" onclick="confirmDelete()" >Delete</a></td>';		        
		    	tableData+= '</tr>';
		    }
			tableData+='</tbody>';
		    document.getElementById("employeeTable").innerHTML = tableData;
	}	


	/**
	*This function confirms whether to delete the employee or not.
	*/
	function confirmDelete(employeeId){
		
		if(confirm("Are You sure want to delete")){
		}else{
			event.preventDefault();
		}
	}
	
</script>
</body>
</html>