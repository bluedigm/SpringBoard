<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	language="java"%>
<html xmlns:th="http://thymeleaf.org">
<head>
<title>User Create</title>
</head>
<body>
	<h1>Create Page</h1>
	<a href="/home">Return to Main page</a>
	<p>계정을 생성합니다.</p>
	<form action="/user/create" method="post">
		<div>
			<label for="username">Username</label>
		</div>
		<div>
			<input type="text" th:value="${res.username}" placeholder="username"
				name="username">
		</div>
		<div>
			<label for="nickname">Nickname</label>
		</div>
		<div>
			<input type="text" th:value="${res.nickname}" placeholder="nickname"
				name="nickname">
		</div>
		<div>
			<label for="email">Email</label>
		</div>
		<div>
			<input type="email" th:value="${res.email}" placeholder="email"
				name="email@email">
		</div>
		<div>
			<label for="password1">Password</label>
		</div>
		<div>
			<input type="password" placeholder="password" name="password1">
		</div>
		<div>
			<label for="password2">One More Password</label>
		</div>
		<div>
			<input type="password" placeholder="password" name="password2">
		</div>
		<div>
			<button type="submit">Create User</button>
		</div>
	</form>
</body>
</html>
