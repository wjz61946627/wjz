<%--
  Created by IntelliJ IDEA.
  User: 61946
  Date: 2019/3/10
  Time: 19:02
  To change this template use File | Settings | File Templates.
--%>
<%@page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="http://localhost:8080/practice/teacherUpdate">
        <b>id：</b><input type="text" name="id" readonly="true" value="${teacher.id}"><br>
        <b>姓名：</b><input type="text" name="name" value="${teacher.name}"><br>
        <b>年龄：</b><input type="text" name="age" value="${teacher.age}"><br>
        <b>性别：</b><input type="text" name="sex" value="${teacher.sex}"><br>
        <input type="submit"/>
    </form>
</body>
</html>