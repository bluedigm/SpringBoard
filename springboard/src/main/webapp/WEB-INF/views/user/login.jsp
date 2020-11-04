<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	language="java"%>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<title>User Login</title>
</head>
<body>
	<div class="container">
		<h1>Login Page</h1>
	</div>
	<div class="container">
		<a href="../home">Return to Main page</a>
		<p>계정으로 접속합니다.</p>
	</div>
	<div class="container">
		<form id="form" name="form" onsubmit="fn_submit()">
			<p></p>
			<div>
				<label for="name">Username</label>
			</div>
			<div>
				<input id="name" name="name" type="text" placeholder="username">
			</div>
			<p></p>
			<div>
				<label for="pw">Password</label>
			</div>
			<div>
				<input id="pw" name="pw" type="password" placeholder="password">
			</div>
			<p></p>
			<div>
				<button type="button" onclick="fn_submit()">Login User</button>
			</div>
		</form>
	</div>
</body>
<script>
	function fn_submit() {
		var query = $("#form").serialize();
		$.post('login_submit', query, function(data) {
			if (data['result'] == "ok") {
				window.location.assign('home');
			} else {
				alert(data['result']);
			}
		});
	}
</script>
</html>
