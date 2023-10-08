<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<body>
<h1 align="center">Student Management System</h1>

<div align="center">
<form action="showAdd">
<input type="submit" value="ADD">
</form>
<table border="3">
    <thread>
    <tr>
    <td>id</id>
    <td>name</td>
    <td>mobile</td>
    <td>country</td>
    </tr>
    <thread>
    <tr>
    <c:forEach var="student" items="${students}">
        <td>${student.id}</td>
        <td>${student.name}</td>
        <td>${student.mobile}</td>
        <td>${student.country}</td>
        <td><a href="/studentManagementCrud/updateStudent">Update</a></td>
       </tr>
    </c:forEach>
</table>
</div>
</body>
</html>
