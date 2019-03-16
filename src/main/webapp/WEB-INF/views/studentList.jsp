<%--
  Created by IntelliJ IDEA.
  User: 61946
  Date: 2019/3/9
  Time: 20:43
  To change this template use File | Settings | File Templates.
--%>
<%@page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<html>
<head>
    <title>index</title>
</head>
<body>
<input type="button" value="insert">
<c:forEach items="${list}" var="Teacher">
    ------------------------------------
    <br>
    <b>id：</b><span id="id">${Student.id}</span><br>
    <b>姓名：</b><span id="name">${Student.name}</span><br>
    <b>性别：</b><span id="sex">${Student.sex}</span><br>
    <form action="http://localhost:8080/learn/delete">
        <input type="hidden" name="id" value="${Student.id}" />
        <input type="submit" value="删除"/>
    </form>
    <form action="http://localhost:8080/learn/requestUpdate">
        <input type="hidden" name="id" value="${Student.id}" />
        <input type="hidden" name="name" value="${Student.name}" />
        <input type="hidden" name="sex" value="${Student.sex}" />
        <input type="submit" value="更新"/>
    </form>

</c:forEach>

    <form action="http://localhost:8080/learn/requestFindByName">
        <input type="text" name="name"/>
        <input type="submit" value="名字查询"/>
    </form>

    <form action="http://localhost:8080/learn/requestFindById">
        <input type="text" name="id"/>
        <input type="submit" value="id查询"/>
    </form>
</body>
</html>
