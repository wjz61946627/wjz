<%--
  Created by IntelliJ IDEA.
  User: 61946
  Date: 2019/3/10
  Time: 19:26
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
<c:forEach items="${teacherList}" var="teacher">
    <b>id：</b><span id="id">${teacher.id}</span><br>
    <b>姓名：</b><span id="name">${teacher.name}</span><br>
    <b>年龄：</b><span id="age">${teacher.age}</span><br>
    <b>性别：</b><span id="sex">${teacher.sex}</span><br>
</c:forEach>
</body>
</html>
