<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	language="java"%>
<html xmlns:th="http://thymeleaf.org">
<head>
<title>User Profile</title>
</head>
<body>
	<p>${time}</p>
	<p>
		<a href="/user/delete">Go to Delete User</a>
	</p>
	<p>
		<a href="/user/logout">Go to Logout User</a>
	</p>
	<p>
		<a href="/user/profile">Go to Profile User</a>
	</p>
	<p>
		<a href="/user/search">Go to Search User</a>
	</p>
</body>
</html>
