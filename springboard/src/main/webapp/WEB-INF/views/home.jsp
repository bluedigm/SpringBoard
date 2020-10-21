<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	language="java"%>
<html xmlns:th="http://thymeleaf.org">
<head>
<title>Home</title>
</head>
<body>
	<p>${time}</p>
	<p>
		<a href="/user/create">Go to Create User</a>
	</p>
	<p>
		<a href="/user/login">Go to Login User</a>
	</p>
	<p>
		<a href="/user/search">Go to Search User</a>
	</p>
</body>
</html>
