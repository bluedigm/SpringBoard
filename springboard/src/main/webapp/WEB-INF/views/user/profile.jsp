<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	language="java"%>
<html xmlns:th="http://thymeleaf.org">
<head>
<title>User Profile</title>
</head>
<body>
	<h1>Profile Page</h1>
	<a href="/home">Return to Main page</a>
	<p>계정을 확인합니다.</p>
	<form action="/user/update" method="get">
		<div>
			<label for="username">Username</label>
		</div>
		<div>
			<input type="text" th:value="${res.username}" placeholder="username"
				name="username" readonly="readonly">
		</div>
		<div>
			<label for="nickname">Nickname</label>
		</div>
		<div>
			<input type="text" th:value="${res.nickname}" placeholder="nickname"
				name="nickname" readonly="readonly">
		</div>
		<div>
			<label for="email">Email</label>
		</div>
		<div>
			<input type="email" th:value="${res.email}" placeholder="email"
				name="email@email" readonly="readonly">
		</div>
		<div>
			<label for="createAt">Create At</label>
		</div>
		<div>
			<input type="datetime-local" th:value="${res.createAt}"
				placeholder="createAt" name="createAt">
		</div>
		<div>
			<label for="updateAt">Update At</label>
		</div>
		<div>
			<input type="password" th:value="${res.updateAt}"
				placeholder="updateAt" name="updateAt">
		</div>
		<div>
			<button type="submit">Update Mode</button>
		</div>
	</form>
</body>
</html>
