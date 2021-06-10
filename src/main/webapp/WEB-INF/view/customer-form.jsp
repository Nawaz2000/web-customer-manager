<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer form</title>

	<link rel="stylesheet" 
		  type="text/css" 
		  href="${pageContext.request.contextPath}/resources/css/style.css"/>
		  
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-customer-style.css"/>
		  
	<style type="text/css">
		.error{color: red;}
	</style>
		  
</head>
<body>

	<div id="wrapper">
		<div id="header">			
			<h3>Save Customer</h3>			
		</div>
	</div>
	
	<div id = "container">
		<h3>Customer details</h3>
		<form:form action="saveCustomer" method="POST" modelAttribute="customer">
				
			<form:hidden path="id"/>
				
			<table>
				<tbody>
					<tr>
						<td><label>First Name:</label></td><td><form:input path="firstName"/></td>
						<td><form:errors cssClass="error" path="firstName"></form:errors></td>							
					</tr>
					<tr>
						<td><label>Last Name:</label></td><td><form:input path="lastName"/></td>
						<td><form:errors cssClass="error" path="lastName"></form:errors></td>
					</tr>
					<tr>
						<td><label>Email:</label></td><td><form:input path="email"/></td>
						<td><form:errors cssClass="error" path="email"></form:errors></td>
					</tr>
					<tr>
						<td><label></label></td><td><input type="submit" value="Save" class="save"/></td>
						<td><label></label></td>
					</tr>
				</tbody>
			</table>
				
		</form:form>
		
		<p>
			<a href="${pageContext.request.contextPath}/customer/list">Back to list</a>
		</p>
		
	</div>

</body>
</html>