<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List of Employees</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
</head>
<body>

<table class="table">
	<thead>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Email</th>
			<th>City</th>
			<th>State</th>
			<th>Phone</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="emp" items="${employees}">
			<tr>
				<td>${emp.id}</td>
				<td>${emp.firstName} ${emp.lastName}</td>
				<td>${emp.email}</td>
				<td>${emp.city}</td>
				<td>${emp.state}</td>
				<td>${emp.phone}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>