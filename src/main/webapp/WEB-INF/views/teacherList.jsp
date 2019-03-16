<%--
  Created by IntelliJ IDEA.
  User: 61946
  Date: 2019/3/10
  Time: 18:19
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
    <form action="http://localhost:8080/practice/requestTeacherInsert">
        <input type="submit" value="insert"/><br>
    </form>
    <form action="http://localhost:8080/practice/find">
        <input type="submit" value="find"/>
    </form>

    <c:forEach items="${teacherList}" var="teacher">
        ------------------------------------
        <br>
        <b>id：</b><span id="id">${teacher.id}</span><br>
        <b>姓名：</b><span id="name">${teacher.name}</span><br>
        <b>年龄：</b><span id="age">${teacher.age}</span><br>
        <b>性别：</b><span id="sex">${teacher.sex}</span><br>
        <form action="http://localhost:8080/practice/teacherDelete">
            <input type="hidden" name="id" value="${teacher.id}" />
            <input type="submit" value="删除"/>
        </form>
        <form action="http://localhost:8080/practice/requestTeacherUpdate">
            <input type="hidden" name="id" value="${teacher.id}" />
            <input type="hidden" name="name" value="${teacher.name}" />
            <input type="hidden" name="age" value="${teacher.age}" />
            <input type="hidden" name="sex" value="${teacher.sex}" />
            <input type="submit" value="更新"/>
        </form>

    </c:forEach>
</body>
</html>
