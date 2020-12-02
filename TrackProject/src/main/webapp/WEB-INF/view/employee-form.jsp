<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/style.css">
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/add-employee-style.css">

</head>
<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Relationship Manager</h2>
		
		</div>
	</div>
	
	<div id="container">
		<h3>Save Employee</h3>
	
	
		<form:form action="saveEmployee" modelAttribute="employee" method="POST">
		
			<!--  need t o associate this data with employee if-->
			<form:hidden path="id" />
			
			
			<table>
				<tbody>
					<tr>
						<td><label>First name:</label></td>
						<td><form:input path="firstName" /></td>
					</tr>
					<tr>
						<td><label>Last name:</label></td>
						<td><form:input path="lastName" /></td>
					</tr>				
					<tr>
						<td><label>Email:</label></td>
						<td><form:input path="Email" /></td>
					</tr>			
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Delete" class="Delete" /></td>
					</tr>		
				</tbody>
			
			
			</table>
		
		
		
		</form:form>
		
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pabeContext.request.contextPath}/TrackProject/employee/list">Back to List</a>
		</p>
			
	</div>
	
	
</body>
</html>