<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns:th="http://thymeleaf.org">
<head>
<title>User Create</title>
</head>
<body>
	<h1>Create Page</h1>
	<a href="/home">Return to Main page</a>
	<p>계정을 생성합니다.</p>
	<div id="body">
		<form action="/user/create" method="post">
			<div class="control-group mb-3">
				<div>
					<label class="control-label" for="email">Email <input
						th:if="${res.usable}" type="checkbox" checked="checked"
						disabled="disabled"></label>
				</div>
				<div>
					<input type="email" class="form-control" th:value="${res.email}"
						placeholder="email@email" name="email">
				</div>
			</div>
			<div class="control-group mb-3">
				<div>
					<label class="control-label" for="nickname">Nickname</label>
				</div>
				<div>
					<input type="text" class="form-control" th:value="${res.nickname}"
						placeholder="nickname" name="nickname">
				</div>
			</div>
			<div class="control-group mb-3">
				<div>
					<label class="control-label" for="password1">Password</label>
				</div>
				<div>
					<input type="password" class="form-control" placeholder="password"
						name="password1">
				</div>
			</div>
			<div class="control-group mb-3">
				<div>
					<label class="control-label" for="password2">One More
						Password</label>
				</div>
				<div>
					<input type="password" class="form-control" placeholder="password"
						name="password2">
				</div>
			</div>
			<div class="control-group mb-3">
				<div>
					<label class="control-label" for="acceptCode">Link Access <input
						type="checkbox" name="acceptCode" th:checked="${res.acceptCode}">
					</label>
				</div>
				<div>
					<label class="control-label" for="acceptOpen">Open Access <input
						type="checkbox" name="acceptOpen" th:checked="${res.acceptOpen}">
					</label>
				</div>
			</div>
			<div>
				<button type="submit" class="btn btn-primary">Create User</button>
			</div>
		</form>
	</div>
</body>
</html>
