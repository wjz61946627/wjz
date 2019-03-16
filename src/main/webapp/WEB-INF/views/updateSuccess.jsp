<%--
  Created by IntelliJ IDEA.
  User: 61946
  Date: 2019/3/10
  Time: 13:52
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
    <br>
    <b>id：</b><span id="id">${stu.id}</span><br>
    <b>姓名：</b><span id="name">${stu.name}</span><br>
    <b>性别：</b><span id="sex">${stu.sex}</span><br>
</body>
</html>
