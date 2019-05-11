<%@ page import="nwsuaf.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<nav class="navbar navbar-expand-sm bg-light navbar-light fixed-top">
    <a class="navbar-brand" href="#"><img class="mr-2" src="<c:url value="/resource/png/basket-3x.png" />" alt="home" style="display: flow;"/></a>
    <ul class="navbar-nav">
        <%
            User user = (User) request.getSession().getAttribute("user");
            if(user.getAdmin()){
        %>
        <li class="nav-item">
            <a class="nav-link" href="/admin/index">权限</a>
        </li>
        <%
            }
        %>

        <li class="nav-item" style="float: right">
            <a class="nav-link" href="#"><img class="mr-2" src="<c:url value="/resource/png/person.png" />" alt="home" style="display: flow;"/>${sessionScope.user.name}</a>
        </li>
    </ul>
</nav>
<br>