<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer list</title>
	<link rel="stylesheet" 
		  type="text/css" 
		  href="${pageContext.request.contextPath}/resources/css/style.css"/>

</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relational manager</h2>
		</div>
	</div>
	
	<div id = "container">
		<div id = "content">
			
			<!-- add customer button -->
			<form action="showCustomerForm" method="GET">
				<button type="submit"
					class="add-button">Add customer
				</button>
			</form>
			
			<!-- add, delete, update table -->
			<table>
				<tr>
					<th>First name</th>
					<th>Last name</th>
					<th>Email</th>
				</tr>
				
				<!-- loop over each customer in the model attribute -->
				
				<c:forEach var="tempCustomer" items="${customers}">
					
					<tr>
						<td>${tempCustomer.firstName}</td>
						<td>${tempCustomer.lastName}</td>
						<td>${tempCustomer.email}</td>
					</tr>
					
				</c:forEach>
				
			</table>
			
			
		</div>
	</div>

</body>
</html>