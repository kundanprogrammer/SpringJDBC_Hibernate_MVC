<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>

<!DOCTYPE html>
<html>
<body>

<div align="center">
<h2 align="center">Add Student</h2>

<form:form  action="save-student" modelAttribute="student" method="POST">

    <form:hidden path="id"/>

    <label>Name :</label>
   <form:input path="name"/>
    </br>
    <label>Mobile :</label>
    <form:input path="mobile"/>
    </br>
    <label>Country :</label>
    <form:input path="country"/>
    </br>
    <input type="submit" value="Submit">
    <img alt="fake students image" src="/studentManagementCrud/src/main/javaa/images/students.jpg">
<!-- /studentManagementCrud/src/main/resources/images/students.jpg -->

</form:form>
</div>
</body>
</html>
