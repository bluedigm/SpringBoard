<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	language="java"%>
<html>
<head>
<title>User Search</title>
</head>
<body>
	<h1>Search Page</h1>
	<a href="/home">Return to Main page</a>
	<p>계정을 검색합니다.</p>
	<form action="/user/search" method="post">
		<p>
			Page : <input type="number" value="${res.page}"
				placeholder="page" name="page"> / <input type="number"
				value="${res.pageMax}" placeholder="page" name="pageMax"
				readonly="readonly">
		</p>
		<p>
			Size : <input type="number" value="${res.size}"
				placeholder="size" name="size">
		</p>
		<button type="submit">Search</button>
	</form>
	<table>
		<tr>
			<th>Username</th>
			<th>Nickname</th>
			<th>Email</th>
			<th>Create At</th>
			<th>Update At</th>
		</tr>
		<c:forEach var="user" items="${res.userList}">
			<tr>
				<td>${user.name}</td>
				<td>${user.nick}</td>
				<td>${user.email}</td>
				<td>${user.createAt}</td>
				<td>${user.updateAt}</td>
			</tr>

		</c:forEach>
	</table>
</body>
</html>
