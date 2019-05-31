<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>


    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>

    <link href='<c:url value="/resource/css/bootstrap.min.css" />' rel="stylesheet">
    <link href='<c:url value="/resource/css/font-awesome.min.css" />' rel="stylesheet">
    <link href='<c:url value="/resource/css/bootstrap-table.min.css" />' rel="stylesheet">
    <link href='<c:url value="/resource/css/fileinput.css" />' rel="stylesheet">

    <link href='<c:url value="/resource/css/file.css" />' rel="stylesheet">

    <script src='<c:url value="/resource/js/jquery-3.3.1.min.js" />'></script>
    <script src='<c:url value="/resource/js/bootstrap.min.js" />'></script>
    <script src='<c:url value="/resource/js/bootstrap-table.min.js" />'></script>

    <script src='<c:url value="/resource/js/fileinput.js" />'></script>
    <script src='<c:url value="/resource/js/fa-file-theme.js" />'></script>
    <script src='<c:url value="/resource/js/fileinput-zh.js" />'></script>

    <script src='<c:url value="/resource/js/file.js" />'></script>

    <title>Welcome</title>
</head>
<body>
<jsp:include page="head.jsp" flush="true">
    <jsp:param name="pageTitle" value="newInstance.com"/>
    <jsp:param name="pageSlogan" value=" "/>
</jsp:include>

<%--正文--%>
<label id="pid" class="hidden" data-pid="${pid}"></label>
<label id="uid" class="hidden" data-uid="${sessionScope.user.uid}"></label>

<div class="content">
    <table id="fileTable" class="table table-hover"></table>
</div>


<!-- Modal -->
<div class="modal fade" id="fUploadModal" tabindex="-1" role="dialog" aria-labelledby="fUploadModalLabel"
     aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content" style="width: 822px;">
            <div class="modal-header">
                <h5 class="modal-title" id="fUploadModalLabel">选择文件</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="file-loading">
                    <input type="file" id="upload" name="fileinput[]" multiple class="file-loading"/>
                </div>
                <div id="kartik-file-errors"></div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="foot.jsp" flush="true"/>

</body>
</html>
