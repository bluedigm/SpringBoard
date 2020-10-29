<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	language="java"%>
<html>
<head>
<title>User Login</title>
</head>
<body>
	<h1>Login Page</h1>
	<a href="/home">Return to Main page</a>
	<p>계정을 로그인합니다.</p>
	<form id="form" action="/user/login" method="post">
		<div>
			<label for="name">Username</label>
		</div>
		<div>
			<input type="text" value="${res.name}" placeholder="username"
				name="name">
		</div>
		<div>
			<label for="pw">Password</label>
		</div>
		<div>
			<input type="password" placeholder="password" name="pw">
		</div>
		<div>
			<button type="submit">Login User</button>
		</div>
	</form>
</body>
</html>
