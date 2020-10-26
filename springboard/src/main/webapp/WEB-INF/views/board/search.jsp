<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	language="java"%>
<html>
<head>
<title>Board Search</title>
</head>
<body>
	<h1>Search Page</h1>
	<a href="/home">Return to Main page</a>
	<p>게시판을 검색합니다.</p>
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
	<table>
		<tr>
			<th>Title</th>
			<th>Text</th>
			<th>Create At</th>
			<th>Update At</th>
		</tr>
		<c:forEach var="board" items="${res.boardList}">
			<tr>
				<td><a href="/board/${board.link}">${board.title}</a></td>
				<td>${board.text}</td>
				<td>${board.createAt}</td>
				<td>${board.updateAt}</td>
			</tr>

		</c:forEach>
	</table>
</body>
</html>
