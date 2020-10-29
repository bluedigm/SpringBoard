<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	language="java"%>
<html>
<head>
<title>User Create</title>
</head>
<body>
	<h1>Create Page</h1>
	<a href="../home">Return to Main page</a>
	<p>계정을 생성합니다.</p>
	<form action="create" method="post">
		<div>
			<label for="user">Username</label>
		</div>
		<div>
			<input type="text" value="${res.name}" placeholder="username"
				name="name">
		</div>
		<div>
			<label for="nick">Nickname</label>
		</div>
		<div>
			<input type="text" value="${res.nick}" placeholder="nickname"
				name="nick">
		</div>
		<div>
			<label for="email">Email</label>
		</div>
		<div>
			<input type="email" value="${res.email}" placeholder="email@email"
				name="email">
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
			<button type="submit">Create User</button>
		</div>
	</form>
</body>
</html>
