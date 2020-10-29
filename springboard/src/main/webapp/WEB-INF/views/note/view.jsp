<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	language="java"%>
<html>
<head>
<title>${res.title}</title>
</head>
<body>
	<h1>${res.title}</h1>
	<p>작성자 : ${res.nick}</p>
	<p>작성날짜 : ${res.createAt}</p>
	<p>수정날짜 : ${res.updateAt}</p>
	<p>${res.text}</p>
	<form action="/note/edit" method="get">
		<div>
			<button type="submit">Edit Mode</button>
		</div>
	</form>
	<form action="/note/delete" method="get">
		<div>
			<button type="submit">Delete Note</button>
		</div>
	</form>
</body>
</html>
