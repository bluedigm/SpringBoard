<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	language="java"%>
<html xmlns:th="http://thymeleaf.org">
<head>
<title>User Profile</title>
</head>
<body>
	<p>#{time}</p>
	<a href="/user/delete">Go to Delete User</a>
	<a href="/user/profile">Go to Profile User</a>
	<a href="/user/search">Go to Search User</a>
</body>
</html>
