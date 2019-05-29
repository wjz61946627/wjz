<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java"
         import="java.util.*,com.zhuozhengsoft.pageoffice.*"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <link href='<c:url value="/resource/css/pobstyle.css" />' rel="stylesheet">

    <script src='<c:url value="/resource/js/jquery-3.3.1.min.js" />'></script>
    <script src='<c:url value="/resource/js/pageoffice.js" />'></script>


    <title>在线打开文件</title>
</head>
<body>
<label src="/pageoffice.js" id="po_js_main"></label>
<div style="width:1000px;height:700px;">
    ${pageoffice}
</div>
</body>
</html>