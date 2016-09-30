<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Profile Page</title>
</head>
<body>
This is the profile page.
<p><strong>Name</strong>: ${u.firstName} ${u.lastName}</p>
<p><strong>Email</strong>: <a href="mailto:${u.email}">${u.email}</a></p>
</body>
</html>