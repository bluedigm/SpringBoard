<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	language="java"%>
<html>
<head>
<title>User Update</title>
</head>
<body>
	<h1>Update Page</h1>
	<a href="/home">Return to Main page</a>
	<p>계정을 수정합니다.</p>
	<form action="/user/edit" method="post">
		<div>
			<label for="username">Username</label>
		</div>
		<div>
			<input type="text" value="${res.name}" placeholder="username"
				name="name">
		</div>
		<div>
			<label for="nickname">Nickname</label>
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
			<label for="pwOld">Old Password</label>
		</div>
		<div>
			<input type="password" placeholder="password" name="pwOld">
		</div>
		<div>
			<label for="pwNew1">New Password</label>
		</div>
		<div>
			<input type="password" placeholder="password" name="pwNew1">
		</div>
		<div>
			<label for="pwNew2">One More New Password</label>
		</div>
		<div>
			<input type="password" placeholder="password" name="pwNew2">
		</div>
		<div>
			<button type="submit">Update User</button>
		</div>
	</form>
	<form action="user/delete" method="post">
		<script>
			function dialog() {
				var password = prompt('Input Password', 'password');
				document.getElementById("input").value = password;
				//			document.write(jbResult);
			}
		</script>
		<input id="password" type="password" placeholder="password"
			name="password" hidden="true">
		<button type="submit" onclick="dialog()">Delete User</button>
	</form>
</body>
</html>
