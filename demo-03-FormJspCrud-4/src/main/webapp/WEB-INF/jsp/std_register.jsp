<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>register</h2>
<form action="/save" method="post">
<label for="name">Name</label>
<input type="text" name="name"><br><br>

<label for="dob">Dob</label>
<input type="date" name="dob"><br><br>

<button type="submit">Submit</button>
</form>
</body>
</html>