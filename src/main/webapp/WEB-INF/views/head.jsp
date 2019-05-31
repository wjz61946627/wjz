<%@ page import="nwsuaf.model.User" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<nav class="navbar navbar-expand-sm bg-light navbar-light fixed-top">

    <ul class="navbar-nav">
        <li class="nav-item" style="float: right">
            <a class="navbar-brand fa fa-home" href="/user/welcome"></a>
        </li>

        <%
            User a = (User) request.getSession().getAttribute("user");
            String hurl = "#";
            if (a.getAdmin()) {
                hurl = "/user/admin";
            }
        %>

        <li class="nav-item" style="float: right">

            <a class="navbar-brand fa fa-user" href="<% out.println(hurl);%>">
                ${sessionScope.user.name}
            </a>
        </li>
    </ul>
</nav>
<br>