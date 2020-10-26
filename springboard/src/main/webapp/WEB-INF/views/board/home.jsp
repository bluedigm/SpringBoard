<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	language="java"%>
<html>
<head>
<title>${res.title}</title>
</head>
<body>
	<h1>${res.title}</h1>
	<p>${res.text}</p>
	<p>
		<a href="/home">Return to Main page</a>
	</p>
	<p>
		<a href="/board/create">Go to Create Board</a>
	</p>
	<p>
		<a href="/board/search">Go to Search Board</a>
	</p>
	<form action="/note/create" method="get">
		<div>
			<button type="submit">New Post</button>
		</div>
	</form>
	<table>
		<tr>
			<th>Note Title</th>
			<th>Author</th>
			<th>Update At</th>
		</tr>
		<c:forEach var="list" items="${res.noteList}">
			<tr>
				<td><a href="/note/${list.note.id}">${list.note.title}</a></td>
				<td>${list.user.name}</td>
				<td>${list.note.updateAt}</td>
			</tr>

		</c:forEach>
	</table>
</body>
</html>
