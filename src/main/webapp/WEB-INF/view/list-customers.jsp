<%@ page import="com.nawaz2000.spring.util.SortUtils" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
			
			<!-- adding search feature -->
			<form:form action="search" method="GET">
				Search customer: <input type="text" name="searchName"/>
				<input type="submit" value="search" class="add-button">
			</form:form>
			
			<!-- default sort -->
			<c:url var="defaultSort" value="list"></c:url>
			<a href="${defaultSort}">default sort</a>
			
			<br><br>
			
			
			<!-- add, delete, update table -->
			<table>
			
				<!-- construct a sort key for the first name -->
				
				<c:url var="sortFirstNameLink" value="list">
					<c:param name="sort" value="<%= Integer.toString(SortUtils.FIRST_NAME) %>"/>
				</c:url>
				
				<!-- constructing sort key for last name -->
				
				<c:url var="sortLastNameLink" value="list">
					<c:param name="sort" value="<%= Integer.toString(SortUtils.LAST_NAME) %>"/>
				</c:url>
				
				<!-- constructing sort key using email -->
				
				<c:url var="sortEmailLink" value="list">
					<c:param name="sort" value="<%= Integer.toString(SortUtils.EMAIL) %>"/>
				</c:url>
			
				<tr>
					<th><a href="${sortFirstNameLink}">First name</a></th>				
					<th><a href="${sortLastNameLink}">Last name</a></th>					
					<th><a href="${sortEmailLink}">Email</a></th>					
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
			
			
		</div>
	</div>

</body>
</html>