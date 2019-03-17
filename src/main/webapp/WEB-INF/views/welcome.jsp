<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href='<c:url value="/resource/css/bootstrap.css" />' rel="stylesheet">
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

            <div class="card w-100 box-shadow project">
                <div class="card-body">
                    <h5 class="card-title">八号楼拆除项目</h5>
                    <img class="mr-2" src="<c:url value="/resource/png/paperclip-3x.png" />" alt="项目组长" style="display: flow;"/>
                    <h6>
                        <span class="badge badge-dark">组长</span> 刘东辉
                        <span class="badge badge-dark">人数</span> 8
                        <span class="badge badge-dark">文件总数</span> 20
                    </h6>
                    <p class="card-text">
                        本项目主要是关于八号楼整体拆除
                    </p>
                    <footer class="blockquote-footer text-right">二狗:我提交了xx文件 2019-01-20 20:00:10</footer>
                </div>
            </div>

            <div class="card w-100 box-shadow project">
                <div class="card-body">
                    <h5 class="card-title">八号楼拆除项目</h5>
                    <img src="resource/fon/" alt="项目组长"/>
                    <h6>
                        <span class="badge badge-dark">组长</span> 刘东辉
                        <span class="badge badge-dark">人数</span> 8
                        <span class="badge badge-dark">文件总数</span> 20
                    </h6>
                    <p class="card-text">
                        本项目主要是关于八号楼整体拆除
                    </p>
                    <footer class="blockquote-footer text-right">二狗:我提交了xx文件 2019-01-20 20:00:10</footer>
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="foot.jsp" flush="true"/>

</body>
</html>
