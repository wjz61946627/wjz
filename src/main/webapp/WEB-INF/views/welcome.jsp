<%@ page import="nwsuaf.model.Project" %>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href='<c:url value="/resource/css/bootstrap.min.css" />' rel="stylesheet">
    <link href='<c:url value="/resource/css/font-awesome.min.css" />' rel="stylesheet">
    <link href='<c:url value="/resource/css/welcome.css" />' rel="stylesheet">

    <script src='<c:url value="/resource/js/jquery-3.3.1.min.js" />'></script>

    <title>Welcome</title>
</head>
<body>
<jsp:include page="head.jsp" flush="true">
    <jsp:param name="pageTitle" value="newInstance.com"/>
    <jsp:param name="pageSlogan" value=" "/>
</jsp:include>

<%--正文--%>
<div class="album py-5 bg-light">
    <div class="container">
        <div class="row">
            <%
                List<Project> projects = (List<Project>) request.getAttribute("projects");
                for (Project project : projects) {
                    String access = project.getVisited() == 0 ? "公开" : "私有";
            %>

            <div class="card w-100 box-shadow project">
                <div class="card-body">
                    <h6 class="card-title">
                        <a class="fa fa-paperclip font-weight-bold fa-lg"
                           href="/file/index?pid=<% out.println(project.getPid());%>"><%
                            out.println(project.getPname());%></a>
                    </h6>
                    <h6 class="">
                        <span class="badge badge-dark">权限</span><span style="font-size:80%;">&nbsp;<% out.println(access);%></span>
                        <span class="badge badge-dark">文件总数</span> <% out.println(project.getFileNum());%>
                    </h6>
                    <p class="card-text">
                        &nbsp;&nbsp;&nbsp;&nbsp;<% out.println(project.getDesc());%>
                    </p>
                    <footer class="blockquote-footer text-right">二狗:我提交了xx文件 2019-01-20 20:00:10</footer>
                </div>
            </div>

            <%
                }
            %>

        </div>
    </div>
</div>

<jsp:include page="foot.jsp" flush="true"/>

</body>
</html>
