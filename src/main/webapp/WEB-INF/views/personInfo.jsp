<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href='<c:url value="/resource/css/bootstrap.css" />' rel="stylesheet">
    <link href='<c:url value="/resource/css/welcome.css" />' rel="stylesheet">

    <script src='<c:url value="/resource/js/jquery-3.3.1.min.js" />'></script>

    <title>个人信息</title>
</head>
<body>
<jsp:include page="head.jsp" flush="true">
    <jsp:param name="pageTitle" value="newInstance.com"/>
    <jsp:param name="pageSlogan" value=" "/>
</jsp:include>

<%--正文--%>

<div class="album py-5 bg-light">
    <div class="container">

        <form class="form-text">
            <div class="row">

                <div class="card w-75 box-shadow project">
                    <div class="card-body">
                        <h5 class="card-title">个人信息</h5>

                        <div class="input-group mb-3">
                            <div class="input-group-prepend">
                                <span class="input-group-text" id="loginName">登陆名</span>
                            </div>
                            <input type="text" class="form-control" aria-label="Default"
                                   aria-describedby="loginName" value="wangtong">
                        </div>

                        <div class="input-group mb-3">
                            <div class="input-group-prepend">
                                <span class="input-group-text" id="username">用户名</span>
                            </div>
                            <input type="text" class="form-control" aria-label="Default"
                                   aria-describedby="username" value="王彤">
                        </div>

                        <div class="input-group mb-3">
                            <div class="input-group-prepend">
                                <span class="input-group-text" id="sex">性别</span>
                            </div>
                            <input type="radio" aria-label="Radio button for following text input"/>男
                            <input type="radio" aria-label="Radio button for following text input"/>女
                        </div>

                        <div class="card-footer text-sm-right">
                            <button type="button" class="btn btn-danger" data-toggle="modal"
                                    data-target="#warn">保存
                            </button>
                        </div>
                    </div>
                </div>

            </div>
        </form>

    </div>
</div>

<div class="modal fade" id="warn" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
     aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLongTitle">警告</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="alert alert-danger" role="alert">
                    这将会修改你的个人信息
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Save changes</button>
            </div>
        </div>
    </div>
</div>

<jsp:include page="foot.jsp" flush="true"/>

</body>
</html>
