<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	language="java"%>
<html>
<head>
<title>User Profile</title>
</head>
<body>
	<h1>Profile Page</h1>
	<a href="/home">Return to Main page</a>
	<p>계정을 확인합니다.</p>
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
			<label for="email">Email</label>
		</div>
		<div>
			<input type="email" value="${res.email}" placeholder="email@email"
				name="email" readonly="readonly">
		</div>
		<div>
			<label for="createAt">Create At</label>
		</div>
		<div>
			<input type="datetime" value="${res.createAt}" placeholder="createAt"
				name="createAt" readonly="readonly">
		</div>
		<div>
			<label for="updateAt">Update At</label>
		</div>
		<div>
			<input type="datetime" value="${res.updateAt}" placeholder="updateAt"
				name="updateAt" readonly="readonly">
		</div>
	<form action="/user/edit" method="get">
		<div>
			<button type="submit">Edit Mode</button>
		</div>
	</form>
	<form action="/user/delete" method="get">
		<div>
			<button type="submit">Delete User</button>
		</div>
	</form>
</body>
</html>
