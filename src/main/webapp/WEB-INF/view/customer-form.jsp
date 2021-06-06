<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

	<link rel="stylesheet" 
		  type="text/css" 
		  href="${pageContext.request.contextPath}/resources/css/style.css"/>
		  
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-customer-style.css"/>
		  
</head>
<body>

	<div id="wrapper">
		<div id="header">			
			<h3>Save Customer</h3>			
		</div>
	</div>
	
	<div id = "container">
		<h3>Save Customer</h3>
		<form:form action="saveCustomer" method="POST" modelAttribute="customer">
				
			<form:hidden path="id"/>
				
			<table>
				<tbody>
					<tr>
						<td><label>First Name:</label></td><td><form:input path="firstName"/></td>							
					</tr>
					<tr>
						<td><label>Last Name:</label></td><td><form:input path="lastName"/></td>
					</tr>
					<tr>
						<td><label>Email:</label></td><td><form:input path="email"/></td>
					</tr>
					<tr>
						<td><label></label></td><td><input type="submit" value="Save" class="save"/></td>
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