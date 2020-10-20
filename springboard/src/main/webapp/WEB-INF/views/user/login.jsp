<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	language="java"%>
<html xmlns:th="http://thymeleaf.org">
<head>
<title>User Login</title>
</head>
<body>
	<h1>Login Page</h1>
	<a href="/home">Return to Main page</a>
	<p>계정을 로그인합니다.</p>
	<form action="/user/login" method="post">
		<div>
			<label for="username">Username</label>
		</div>
		<div>
			<input type="text" th:value="${res.username}" placeholder="username"
				name="username">
		</div>
		<div>
			<label for="password">Password</label>
		</div>
		<div>
			<input type="password" placeholder="password" name="password">
		</div>
		<div>
			<button type="submit">Login User</button>
		</div>
	</form>
</body>
</html>
