<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	language="java"%>
<html>
<head>
<title>Board Create</title>
</head>
<body>
	<h1>Create Page</h1>
	<a href="/board/home">Return to Main page</a>
	<p>게시판을 생성합니다.</p>
	<form action="/board/create" method="post">
		<div>
			<label for="link">Link</label>
		</div>
		<div>
			<input type="text" value="${res.link}" placeholder="link"
				name="link">
		</div>
		<div>
			<label for="title">Title</label>
		</div>
		<div>
			<input type="text" value="${res.title}" placeholder="title"
				name="title">
		</div>
		<div>
			<label for="text">Text</label>
		</div>
		<div>
			<input type="text" value="${res.text}" placeholder="text"
				name="text">
		</div>
		<div>
			<button type="submit">Create Board</button>
		</div>
	</form>
</body>
</html>
