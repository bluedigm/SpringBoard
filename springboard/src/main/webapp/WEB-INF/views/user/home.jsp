<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	language="java"%>
<html>
<head>
<title>User Profile</title>
</head>
<body>
	<form action="/board/search" method="post">
		<p>
			Page : <input type="number" value="${res.page}" placeholder="page"
				name="page"> / <input type="number" value="${res.pageMax}"
				placeholder="page" name="pageMax" readonly="readonly">
		</p>
		<p>
			Size : <input type="number" value="${res.size}" placeholder="size"
				name="size">
		</p>
		<button type="submit">Search</button>
	</form>
	<form action="/board/create" method="get">
		<button type="submit">Create</button>
	</form>
	<table>
		<tr>
			<th>Title</th>
			<th>Text</th>
			<th>Update At</th>
		</tr>
		<c:forEach var="join" items="${res.joinList}">
			<tr>
				<td><a href="/board/${join.board.link}">${join.board.title}</a></td>
				<td>${join.board.text}</td>
				<td>${join.board.updateAt}</td>
			</tr>

		</c:forEach>
	</table>
	<p>
		<a href="/user/logout">Go to Logout User</a>
	</p>
	<p>
		<a href="/user/profile">Go to Profile User</a>
	</p>
	<p>
		<a href="/user/search">Go to Search User</a>
	</p>
	<p>
		<a href="/board/search">Go to Search Board</a>
	</p>
</body>
</html>
