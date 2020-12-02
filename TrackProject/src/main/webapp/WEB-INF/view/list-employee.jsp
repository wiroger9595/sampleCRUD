<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />


</head>
<body>
	
	
	<div id="wrapper">
		<div id="header">
			<h2> CRM- customer relationship manager</h2>
		</div>
	</div>
	
	<div id="container">
		
		<div id="content">
			
			<!--  put new button: Add employee -->
			
			<input type="button" value="Add Employee" onclick="window.location.href='FormForAdd'; return false;" class="add-button">
			
						
			<!--  add html table here -->
			
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				
				
				</tr>
				
				<!--  loop over and print our employee -->
				<c:forEach var="fieldEmployee" items="${employees}">
				
					<c:url var="updateHere" value="/employee/FormForUpdate">
						<c:param name="employeeId" value="${fieldEmployee.id}" />
					</c:url>
					
					
					<!--  construct an "delete" link with employee id -->
					<c:url var="deleteHere" value="/employee/FormForDelete">
						<c:param name="employeeId" value="${fieldEmployee.id}" />
					</c:url>
					<tr>
						<td>${fieldEmployee.firstName}</td>
						<td>${fieldEmployee.lastName}</td>
						<td>${fieldEmployee.email}</td>
						
						
						<td>
							<!--  display the update link -->
							<a href="${updateHere}">update</a>
							
							|
							
							<!--  display the delete date link -->
							<a href="${deleteHere}" onclick="if (!(confirm('delete for sure'))) return false">delete</a>
						</td>
				
					</tr>
				
				</c:forEach>
				
				
				
			</table>
		</div>
	
	</div>
	
	
	
</body>
</html>






