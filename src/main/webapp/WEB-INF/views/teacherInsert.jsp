<%--
  Created by IntelliJ IDEA.
  User: 61946
  Date: 2019/3/10
  Time: 18:45
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
    <form action="http://localhost:8080/practice/teacherInsert">
        <p>姓名:<input type="text" name="name"/></p>
        <p>年龄:<input type="text" name="age"/></p>
        <p>
            男<input type="radio" name="sex" value="true"/>
            女<input type="radio" name="sex" value="false"/>
        </p>
        <input type="submit"/>
</form>
</body>
</html>
