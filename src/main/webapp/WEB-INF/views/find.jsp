<%--
  Created by IntelliJ IDEA.
  User: 61946
  Date: 2019/3/10
  Time: 17:12
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
    <form action="http://localhost:8080/practice/teacherFindById">
        <input type="text" name="id"/>
        <input type="submit" value="id查询"/><br>
    </form>
    <form action="http://localhost:8080/practice/teacherFindByName">
        <input type="text" name="name"/>
        <input type="submit" value="名字查询"/><br>
    </form>
</body>
</html>
