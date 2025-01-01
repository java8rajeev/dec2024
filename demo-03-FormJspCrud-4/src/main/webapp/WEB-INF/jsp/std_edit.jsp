<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>edit page</h2>
<form action="/update" method="post">
    <input type="hidden" name="id" value="${std.id}">
<label for="name">Name</label>
<input type="text" name="name" value="${std.name}"><br><br>

<label for="dob">Dob</label>
<input type="date" name="dob" value="${std.dob}"><br><br>

<button type="submit">update</button>
</form>
<a href="/all">back to list page</a>
</body>
</html>