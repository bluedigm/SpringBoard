<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	language="java"%>
<html>
<head>
<title>User Delete</title>
</head>
<body>
	<h1>Delete Page</h1>
	<a href="/home">Return to Main page</a>
	<p>계정을 제거합니다.</p>
	<form action="/user/delete" method="post">
		<div>
			<label for="name">Username</label>
		</div>
		<div>
			<input type="text" value="${res.name}" placeholder="username"
				name="name" readonly="readonly">
		</div>
		<div>
			<label for="nick">Nickname</label>
		</div>
		<div>
			<input type="text" value="${res.nick}" placeholder="nickname"
				name="nick" readonly="readonly">
		</div>
		<div>
			<label for="pw1">Password</label>
		</div>
		<div>
			<input type="password" placeholder="password" name="pw1">
		</div>
		<div>
			<label for="pw2">One More Password</label>
		</div>
		<div>
			<input type="password" placeholder="password" name="pw2">
		</div>
		<div>
			<button type="submit">Delete User</button>
		</div>
	</form>
</body>
</html>
