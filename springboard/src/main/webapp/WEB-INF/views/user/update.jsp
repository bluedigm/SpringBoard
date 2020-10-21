<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	language="java"%>
<html>
<head>
<title>User Update</title>
</head>
<body>
	<h1>Update Page</h1>
	<a href="/user/portal">Return to Main page</a>
	<p>계정을 수정합니다.</p>
	<form action="/user/update" method="post">
		<div>
			<label for="username">Username</label>
		</div>
		<div>
			<input type="text" value="${res.username}" placeholder="username"
				name="username">
		</div>
		<div>
			<label for="nickname">Nickname</label>
		</div>
		<div>
			<input type="text" value="${res.nickname}" placeholder="nickname"
				name="nickname">
		</div>
		<div>
			<label for="email">Email</label>
		</div>
		<div>
			<input type="email" value="${res.email}" placeholder="email@email"
				name="email">
		</div>
		<div>
			<label for="passwordOld">Old Password</label>
		</div>
		<div>
			<input type="password" placeholder="password" name="passwordOld">
		</div>
		<div>
			<label for="passwordNew1">New Password</label>
		</div>
		<div>
			<input type="password" placeholder="password" name="passwordNew1">
		</div>
		<div>
			<label for="passwordNew2">One More New Password</label>
		</div>
		<div>
			<input type="password" placeholder="password" name="passwordNew2">
		</div>
		<div>
			<button type="submit">Update User</button>
		</div>
	</form>
</body>
</html>
