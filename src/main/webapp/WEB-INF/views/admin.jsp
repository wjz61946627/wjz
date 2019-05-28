<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href='<c:url value="/resource/css/bootstrap.min.css" />' rel="stylesheet">
    <link href='<c:url value="/resource/css/font-awesome.min.css" />' rel="stylesheet">
    <link href='<c:url value="/resource/css/bootstrap-table.min.css" />' rel="stylesheet">
    <link href='<c:url value="/resource/css/admin.css" />' rel="stylesheet">

    <script src='<c:url value="/resource/js/jquery-3.3.1.min.js" />'></script>


    <script src='<c:url value="/resource/js/bootstrap.4.min.js" />'></script>
    <script src='<c:url value="/resource/js/xlsx.core.min.js" />'></script>
    <script src='<c:url value="/resource/js/jspdf.min.js" />'></script>
    <script src='<c:url value="/resource/js/jspdf.plugin.autotable.js" />'></script>
    <script src='<c:url value="/resource/js/tableExport.min.js" />'></script>
    <script src='<c:url value="/resource/js/bootstrap-table.min.js" />'></script>
    <%--<script src='<c:url value="/resource/js/bootstrap-table-zh-CN.js" />'></script>--%>
    <script src='<c:url value="/resource/js/bootstrap-table-export.min.js" />'></script>
    <script src='<c:url value="/resource/js/admin.js" />'></script>

    <title>Welcome</title>
</head>
<body>
<jsp:include page="head.jsp" flush="true">
    <jsp:param name="pageTitle" value="newInstance.com"/>
    <jsp:param name="pageSlogan" value=" "/>
</jsp:include>

<div class="content">

    <%--导航条--%>
    <div class="leftNav">
        <ul class="nav flex-column" id="">

            <li class="nav-item">
                <a class="nav-link" href="#" id="nav-account" onclick="initAccount()">账号管理</a>
            </li>

            <li class="nav-item">
                <a class="nav-link" href="#" id="nav-group" onclick="initGroup()">组管理</a>
            </li>

            <li class="nav-item">
                <a class="nav-link" href="#" id="nav-project" onclick="initProject()">项目管理</a>
            </li>

            <%--<li class="nav-item dropdown">--%>
            <%--<a class="nav-link nav-header collapsed active" data-toggle="collapse" role="button"--%>
            <%--aria-haspopup="true" aria-expanded="false" href="#api">项目管理</a>--%>

            <%--&lt;%&ndash;<div class="collapse" id="api">&ndash;%&gt;--%>
            <%--&lt;%&ndash;<a class="dropdown-item" href="#">项目预览</a>&ndash;%&gt;--%>
            <%--&lt;%&ndash;<a class="dropdown-item" href="#">Another action</a>&ndash;%&gt;--%>
            <%--&lt;%&ndash;<a class="dropdown-item" href="#">Something else here</a>&ndash;%&gt;--%>
            <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
            <%--</li>--%>
        </ul>
    </div>

    <%--右侧侧边栏--%>
    <div class="rightContent">

        <div class="rightContainer" id="user">
            <div class="panel panel-default">
                <!-- Table -->
                <table id="userTab" class="table table-hover"></table>

            </div>

        </div>

        <div class="rightContainer" id="group">
            <div class="panel panel-default">
                <table id="gTable" class="table table-hover"></table>
            </div>

        </div>

        <div class="rightContainer" id="project">

            <div class="panel panel-default">
                <table id="pTable" class="table table-hover"></table>
            </div>

        </div>


    </div>


</div>

<!-- Modal -->
<div class="modal fade" id="userModal" tabindex="-1" role="dialog" aria-labelledby="userModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title text-center" id="updateUserModalLabel">修改账号信息</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>

            <div class="modal-body">

                <div class="input-group mb-3">
                    <label class="col-sm-2 control-label">ID</label>

                    <div class="col-sm-9">
                        <input type="text" class="form-control" readonly="readonly" id="uid" name="uid" value=""
                               placeholder="自动生成">
                    </div>
                </div>

                <form class="form-horizontal" role="form" id="userInfo">
                    <div class="input-group mb-3">
                        <label class="col-sm-2 control-label">名称</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="name" value="" id="name"
                                   placeholder="用户名">
                        </div>
                    </div>

                    <div class="input-group mb-3">
                        <label class="col-sm-2 control-label">密码</label>
                        <div class="col-sm-9">
                            <input type="password" class="form-control" name="password" value="" id="password"
                                   placeholder="6~20位大小写字母和数字">
                        </div>
                    </div>

                    <div class="input-group mb-3">
                        <label class="col-sm-2 control-label">密码</label>
                        <div class="col-sm-9">
                            <input type="password" class="form-control" name="password-repreat" value=""
                                   id="password-repreat"
                                   placeholder="二次确认">
                        </div>
                    </div>

                    <div class="input-group mb-3">
                        <label class="col-sm-2 control-label">邮箱</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="email" value="" id="email"
                                   placeholder="example@example.com">
                        </div>
                    </div>
                </form>
            </div>

            <div class="modal-footer">
                <button type="button" class="btn btn-primary" id="userModelSubmit">提交</button>
            </div>
        </div>
    </div>
</div>

<!--group-member Modal -->
<div class="modal fade" id="memberModal" tabindex="-1" role="dialog" aria-labelledby="memberModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title text-center" id="memberModalLabel">成员列表</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>

            <div class="modal-body">
                <label data-gid="" class="hide saveGid"></label>
                <table id="memberTable" class="table table-hover"></table>
            </div>

        </div>
    </div>
</div>

<!--group-add-member Modal -->
<div class="modal fade" id="userMemberGM" tabindex="-1" role="dialog" aria-labelledby="userMemberGMLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title text-center" id="userMemberGMLabel">用户列表</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>

            <div class="modal-body">
                <label data-gid="" class="hide" id="saveGid"></label>
                <table id="unSelectUserTable" class="table table-hover"></table>
            </div>

        </div>
    </div>
</div>

<!-- groupModal -->
<div class="modal fade" id="gModal" tabindex="-1" role="dialog" aria-labelledby="gModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title text-center" id="gModalLabel">组信息</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>

            <div class="modal-body">

                <form class="form-horizontal" role="form" id="gInfo">
                    <div class="input-group mb-3">
                        <label class="col-sm-2 control-label">GID</label>

                        <div class="col-sm-9">
                            <input type="text" class="form-control" readonly="readonly" id="gid" name="gid" value="0"
                                   placeholder="自动生成">
                        </div>
                    </div>

                    <div class="input-group mb-3">
                        <label class="col-sm-2 control-label">名称</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="gname" value="" id="gname"
                                   placeholder="大小写英文字母和数字">
                        </div>
                    </div>
                </form>
            </div>

            <div class="modal-footer">
                <button type="button" class="btn btn-primary" id="gModelSubmit">提交</button>
            </div>
        </div>
    </div>
</div>


<!-- project-info-Modal -->
<div class="modal fade" id="pInfoModal" tabindex="-1" role="dialog" aria-labelledby="pInfoModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title text-center" id="pInfoModalLabel">项目信息</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>

            <div class="modal-body">

                <form class="form-horizontal" role="form" id="pInfo">

                    <div class="input-group mb-3">
                        <label class="col-sm-2 control-label">ID</label>

                        <div class="col-sm-9">
                            <input type="text" class="form-control" readonly="readonly" name="pid" id="pid" value="0"
                                   placeholder="自动生成">
                        </div>
                    </div>

                    <div class="input-group mb-3">
                        <label class="col-sm-2 control-label">名称</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="pname" id="pname"
                                   placeholder="项目名称">
                        </div>
                    </div>

                    <div class="input-group mb-3">
                        <label class="col-sm-2 control-label">描述</label>
                        <div class="col-sm-9">
                            <textarea cols="10" rows="6" class="form-control" name="desc" id="desc"
                                      placeholder="6~20个字符，可包含中文"></textarea>
                        </div>
                    </div>
                </form>
            </div>

            <div class="modal-footer">
                <button type="button" class="btn btn-primary" id="pInfoModalSubmit">提交</button>
            </div>
        </div>
    </div>
</div>

<!-- project-access-Modal -->
<div class="modal fade" id="pAccessModal" tabindex="-1" role="dialog" aria-labelledby="pAccessModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content" style="width: 600px">
            <div class="modal-header">
                <h5 class="modal-title text-center" id="pAccessModalLabel">权限列表</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>

            <div class="modal-body">
                <label data-pid="" class="hide savePid"></label>

                <div class="input-group mb-3">
                    <input type="radio" name="visited" id="visitedPublic" onclick="pAccess(0)" checked/>
                    <label class="col-sm-2 control-label">公开</label>
                    <input type="radio" name="visited" id="visitedPrivate" onclick="pAccess(1)" />
                    <label class="col-sm-2 control-label">私有</label>
                </div>

                <table id="pAccessTable" class="table table-hover"></table>
            </div>

        </div>
    </div>
</div>

<%--通用警告框--%>
<div class="alert alert-warning" role="alert">
    操作失败
</div>

</body>
</html>
