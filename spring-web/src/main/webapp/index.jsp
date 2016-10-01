<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Spring Web App</title>
</head>
<body>
	<h3>Create User</h3>
	<form method="POST" action="create">
		<input type="text" name="firstName" placeholder="First Name">
		<input type="text" name="lastName" placeholder="Last Name"> 
		<input type="email" name="email" placeholder="example@domain.com"> 
		<input type="text" name="company" placeholder="Company Name">
		<button type="submit">Create User</button>
	</form>
</body>
</html>