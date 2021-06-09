<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search list</title>
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
			
			<h3>Search Result: </h3> Matches found: ${fn:length(customers)} <br><br>	
			
			<!-- add, delete, update table -->
			<table>
				<tr>
					<th>First name</th>
					<th>Last name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				
				<!-- loop over each customer in the model attribute -->
				
				<c:forEach var="tempCustomer" items="${customers}">
				
				<c:url var="update" value="showCustomerUpdateForm">
					<c:param name="customerId" value="${tempCustomer.id}"></c:param>
				</c:url>
				
				<c:url var="delete" value="deleteCustomer">
					<c:param name="customerId" value="${tempCustomer.id}"></c:param>
				</c:url>
					
					<tr>
						<td>${tempCustomer.firstName}</td>
						<td>${tempCustomer.lastName}</td>
						<td>${tempCustomer.email}</td>
						<td><a href="${update}">Update</a>
							|
							<a href="${delete}" onclick="if(!(confirm('Do you really want to delete?'))) return false">Delete</a>
						</td>
					</tr>
					
				</c:forEach>
				
			</table>
			
			<br><br>
			<a href="${pageContext.request.contextPath}/customer/list">Back to list</a>
			
		</div>
	</div>

</body>
</html>