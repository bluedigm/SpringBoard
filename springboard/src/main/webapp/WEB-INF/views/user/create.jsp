<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	language="java"%>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<title>User Create</title>
</head>
<body>
	<div class="container">
		<h1>Create Page</h1>
	</div>
	<div class="container">
		<a href="../home">Return to Main page</a>
		<p>계정을 생성합니다.</p>
	</div>
	<div class="container">
		<form id="form" name="form" action="create" method="post">
			<p></p>
			<div>
				<label for="user">Username : <input id="check" name="check"
					type="checkbox"></label>
			</div>
			<div>
				<input id="name" name="name" type="text" placeholder="username"
					onchange="fn_check()">
			</div>
			<p></p>
			<div>
				<label for="nick">Nickname</label>
			</div>
			<div>
				<input id="nick" name="nick" type="text" placeholder="nickname">
			</div>
			<p></p>
			<div>
				<label for="email">Email</label>
			</div>
			<div>
				<input id="email" name="email" type="email"
					placeholder="email@email">
			</div>
			<p></p>
			<div>
				<label for="pw">Password</label>
			</div>
			<div>
				<input type="password" placeholder="password" name="pw">
			</div>
			<div>
				<label for="pwNew">One More Password</label>
			</div>
			<div>
				<input type="password" placeholder="password" name="pwNew">
			</div>
			<p></p>
			<div>
				<button type="button" onclick="fn_submit()">Create User</button>
			</div>
		</form>
	</div>
</body>
<script>
	function fn_check() {
		var name = $("#name").val();
		$.post('create_check', "name=" + name, function(data) {
			if (data['result'] == "ok") {
				window.location.assign('login');
				//document.getElementById('form').submit();
			} else {
				alert(data['result']);
			}
			$('#check').attr('checked', data == "ok");
		});
	}
	function fn_submit() {
		var query = $("#form").serialize();
		$.post('create_submit', query, function(data) {
			if (data['result'] == "ok") {
				window.location.assign('login');
			} else {
				alert(data['result']);
			}
		});
	}
</script>
</html>
