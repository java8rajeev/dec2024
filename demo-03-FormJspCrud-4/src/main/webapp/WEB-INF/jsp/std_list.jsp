<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.rajeev.model.Student" %>
    <%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>list page</h2>
<table border="1">
    <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Dob</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
    </thead>
    <tbody>
          <%      List<Student>  students=  (List<Student> ) request.getAttribute("students");
          if(students!=null){
        for(Student std:students){
        %> 
        <tr>
            <td><%= std.getId() %></td>
            <td><%= std.getName() %></td>
            <td><%= std.getDob() %></td>
            <td>
                <a href="<%= request.getContextPath()+"/edit/" +std.getId() %>">edit</a>
            </td>
            <td>
                <a href="<%=  request.getContextPath()+"/delete/"+ std.getId() %>">delete</a>
            </td>
        </tr>
        <%}} %>
    </tbody>
</table>

<a href="/std">back to register page</a>
</body>
</html>