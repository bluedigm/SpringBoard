<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	language="java"%>
<html>
<head>
<title>${res.title}</title>
</head>
<body>
	<p>
		<a href="/board">Return to Main page</a>
	</p>
	<p>${res.createAt}</p>
	<p>${res.updateAt}</p>
	<h1>${res.title}</h1>
	<p>${res.text}</p>
</body>
</html>
