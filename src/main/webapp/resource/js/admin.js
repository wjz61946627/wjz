$(function () {
    initAccount();
});

// 账号管理
function initAccount() {
    $(".rightContainer").hide();
    $('#user').show();
    initTable();
}

// 组管理
function initGroup() {
    $(".rightContainer").hide();
    $('#group').show();

    initGroupTable();
}

// 项目管理
function initProject() {
    $(".rightContainer").hide();
    $('#project').show();

    initPTable();
}

// 弹一个警告框
function showWarning(msg) {
    $(".alert").val(msg);
    $(".alert").alert()
}

//====账号

function addUserModal(modal) {
    $('#userModal').on('show.bs.modal', function (event) {
        $('#userModal').find('.modal-title').text("新增账号");

        var submit = $('#userModelSubmit');
        submit.text("新增");
        submit.on('click', null, modal, addUser);
    })

    $('#userModal').modal('show');
}

function addUser(param) {

    $.ajax({
        url: '/user/addUser',
        type: "POST",
        data: $("#userInfo").serialize(),
        error: function (msg) {
            console.log(msg);
            $("#error").html(msg);
        },
        success: function (msg, stat, xhr) {

            if (msg["result"] == "false") {
                $("#errorInfo").html(msg["msg"]);
                $("#errorInfo").show();
            } else {
                $("#loginForm").submit();
            }
        }
    });

    var modal = $('#userModal');
    modal.modal('hide');
    refreshTable();
}

function operateFormatter(value, row, index) {
    return [
        '<a class="update" href="javascript:void(0)" title="修改" data-target="#userModal">',
        '<i class="fa fa-cog"></i>',
        '</a>  ',
        '<a class="remove" href="javascript:void(0)" title="删除">',
        '<i class="fa fa-trash"></i>',
        '</a>'
    ].join('')
}

window.operateEvents = {
    'click .update': function (e, value, row, index) {
        $('#userModal').on('show.bs.modal', function (e) {
            $('#userModal').find('.modal-title').text("更新账号");
            var submit = $('#userModelSubmit');
            submit.text("修改");

            submit.on('click', null, row, updateUser);

            $('#userModal').find('#uid').val(row["uid"]);
            $('#userModal').find('#name').val(row["name"]);
            $('#userModal').find('#email').val(row["email"]);
        });

        $('#userModal').modal('show');
    },
    'click .remove': function (e, value, row, index) {

        $.ajax({
            url: '/user/deleteByUid',
            type: "POST",
            data: "uid=" + row["uid"],
            error: function (msg) {
                alert(msg);
            },
            success: function (msg, stat, xhr) {
                if (msg["result"] == "false") {
                    alert(msg["msg"]);
                } else {
                    $('#userTab').bootstrapTable('remove', {
                        field: 'uid',
                        values: [row.uid]
                    })
                }
            }
        });
    }
}


function updateUser() {
    $.ajax({
        url: '/user/updateByUid',
        type: "POST",
        data: $("#userInfo").serialize(),
        error: function (msg) {
            alert(msg);
        },
        success: function (msg, stat, xhr) {
            if (msg["result"] == "false") {
                alert(msg["msg"]);
            } else {
                var modal = $('#userModal');
                modal.modal('hide');
                refreshTable();
            }
        }
    });
}

function addTool() {
    return [
        '<button class="btn btn-secondary" type="button" name="refresh" aria-label="Refresh" title="刷新" onclick="refreshTable()">',
        '<i class="fa fa-refresh" aria-hidden="true"></i>',
        '</button>',
        '<button class="btn btn-secondary" type="button" name="add" aria-label="add" title="新增" data-toggle="modal" onclick="addUserModal()">',
        '<i class="fa fa-plus-square"></i>',
        '</button>'
    ].join('');
}

function initTable() {
    $('#userTab').bootstrapTable('destroy');
    $('#userTab').bootstrapTable({
        method: 'get',
        url: '/user/findAll',
        striped: true, // 是否显示行间隔色
        pagination: false,
        toolbar: "#toolbarU",
        columns: [
            {
                field: 'uid',
                title: '工号',
                align: 'center',
                sortable: true
            },
            {
                field: 'name',
                title: '名称',
                align: 'center'
            },
            {
                field: 'timecreate',
                title: '创建时间',
                align: 'center',
                sortable: true
            },
            {
                field: 'email',
                title: '邮箱',
                align: 'center'
            },
            {
                field: 'operate',
                title: '操作',
                align: 'center',
                events: window.operateEvents,
                formatter: operateFormatter
            }
        ]
    });

    $('.bs-bars').removeClass("float-left");
}

function refreshTable() {
    $('#userTab').bootstrapTable('refresh', null);
}

//=====组
var gTableID = '#gTable';
var memberTable = '#memberTable';

function gOperateDIV(value, row, index) {
    return [
        '<a class="addG" href="javascript:void(0)" title="新增成员">',
        '<i class="fa fa-user-circle"></i>',
        '</a>  ',
        '<a class="updateG" href="javascript:void(0)" title="修改">',
        '<i class="fa fa-cog"></i>',
        '</a>  ',
        '<a class="removeG" href="javascript:void(0)" title="删除">',
        '<i class="fa fa-trash"></i>',
        '</a>'
    ].join('')
}

// 更新组信息
function updateG() {
    $.ajax({
        url: '/group/update',
        type: "POST",
        data: $("#gInfo").serialize(),
        error: function (msg) {
            console.log(msg);
        },
        success: function (msg, stat, xhr) {
            console.log(msg);
        }
    });
}

var gOperateEvents = {
    'click .addG': function (e, value, row, index) {
        initUnselectUserTable(row.gid);
    },
    'click .updateG': function (e, value, row, index) {
        var modal = $('#gModal');
        modal.on('show.bs.modal', function (e) {
            modal.find('.modal-title').text("更新组");
            var submit = $('#gModelSubmit');
            submit.text("修改");
            submit.on('click', null, modal, updateG);

            modal.find('#gid').val(row["gid"]);
            modal.find('#gname').val(row["gname"]);
        });

        modal.modal('show');
    },
    'click .removeG': function (e, value, row, index) {

        $.ajax({
            method: 'GET',
            url: '/group/deleteByGid',
            data: 'gid=' + row.gid,
            error: function () {
                showWarning("请求失败");
            },
            success: function (msg) {
                if (msg["result"] === "false") {
                    showWarning(msg["msg"]);
                } else {
                    $('#gTable').bootstrapTable('remove', {
                        field: 'gid',
                        values: [row.gid]
                    })
                }
            }
        });
    }
}

function gMemberDIV(value, row, index) {
    return [
        '<a class="group" href="javascript:void(0)" title="组员列表">',
        '<i class="fa fa-group"></i>',
        '</a>'
    ].join('')
}

function gOperateMemberTab() {
    return [
        '<a class="removeMember" href="javascript:void(0)" title="删除">',
        '<i class="fa fa-trash"></i>',
        '</a>'
    ].join('')
}

var eventDelMember = {
    'click .removeMember': function (e, value, row, index) {
        var param = [
            'gid=' + $('#memberModal').find('.saveGid').attr('data-gid'),
            'uid=' + row.uid
        ].join('&');
        $.ajax({
            url: '/group/delMember',
            data: param,
            error: function () {
                showWarning("请求失败");
            },
            success: function (msg) {
                if (msg["result"] === "false") {
                    showWarning(msg["msg"]);
                } else {
                    $(memberTable).bootstrapTable('remove', {
                        field: 'uid',
                        values: [row.uid]
                    })
                }
            }
        });
    }
}

// 显示组成员
var gEventMember = {
    'click .group': function (e, value, row, index) {
        $('#memberModal').find('.saveGid').attr('data-gid', row.gid);

        var optionMemberTable = {
            url: '/group/members?gid=' + row.gid,
            pagination: false,
            columns: [
                {
                    field: 'uid',
                    title: '工号',
                    align: 'center',
                    sortable: true
                },
                {
                    field: 'name',
                    title: '名称',
                    align: 'center'
                },
                {
                    field: 'email',
                    title: '邮箱',
                    align: 'center'
                },
                {
                    field: 'operate',
                    title: '操作',
                    align: 'center',
                    events: eventDelMember,
                    formatter: gOperateMemberTab
                }
            ]

        }

        $('#memberModal').on('show.bs.modal', function (e) {
                $(memberTable).bootstrapTable('destroy');
                $(memberTable).bootstrapTable(optionMemberTable);
            }
        );

        $('#memberModal').modal('show');
    }
}

function addGroupModal() {
    $('#gModelSubmit').on('click', null, null, function () {
        $.ajax({
            url: '/group/create',
            type: "POST",
            data: $("#gInfo").serialize(),
            error: function (msg) {
                $('#gModal').modal('hide');
            },
            success: function (msg, stat, xhr) {
                $('#gModal').modal('hide');
                refreshGTable();
            }
        });
    });

    var modal = $('#gModal');
    modal.on('show.bs.modal', function (e) {
        modal.find('.modal-title').text("新增组");
        var submit = $('#gModelSubmit');
        submit.text("增加");
    });

    modal.modal('show');
}

function refreshGTable() {
    $('#gTable').bootstrapTable('refresh', null);
}

function gTabTool() {
    return [
        '<button class="btn btn-secondary" type="button" name="refresh" aria-label="Refresh" title="刷新" onclick="refreshGTable()">',
        '<i class="fa fa-refresh" aria-hidden="true"></i>',
        '</button>',
        '<button class="btn btn-secondary" type="button" name="add" aria-label="add" title="新增" data-toggle="modal" onclick="addGroupModal()">',
        '<i class="fa fa-plus-square"></i>',
        '</button>'
    ].join('');
}

// 初始化组表
function initGroupTable() {
    $('#gTable').bootstrapTable('destroy');
    $('#gTable').bootstrapTable({
        url: '/group/findAll',
        striped: true, // 是否显示行间隔色
        pagination: false,
        toolbar: "#toolbarG",
        columns: [
            {
                field: 'gid',
                title: '组号',
                align: 'center',
                sortable: true
            },
            {
                field: 'gname',
                title: '组名',
                align: 'center'
            },
            {
                field: 'member',
                title: '组员',
                align: 'center',
                events: gEventMember,
                formatter: gMemberDIV
            },
            {
                field: 'operate',
                title: '操作',
                align: 'center',
                events: gOperateEvents,
                formatter: gOperateDIV
            }
        ]
    });

    $('.bs-bars').removeClass("float-left");
}

var gUnselectEvents = {
    'click .addGU': function (e, value, row, index) {
        var param = [
            'uid=' + row.uid,
            'gid=' + $('#userMemberGM').find('#saveGid').attr('data-gid')
        ].join('&');

        $.ajax({
            url: '/group/addMember',
            type: "GET",
            data: param,
            error: function (msg) {
                console.log(msg);
            },
            success: function (msg, stat, xhr) {
                $('#unSelectUserTable').bootstrapTable('refresh', null);
            }
        });
    }
}

function gUnselectDIV(value, row, index) {
    return [
        '<a class="addGU" href="javascript:void(0)" title="新增成员">',
        '<i class="fa fa-plus-square-o"></i>',
        '</a>  ',
    ].join('');
}

// 初始化不是本组成员的列表
function initUnselectUserTable(gid) {
    var option = {
        url: '/group/findUnselectByGid?gid=' + gid,
        striped: true, // 是否显示行间隔色
        pagination: false,
        columns: [
            {
                field: 'uid',
                title: '工号',
                align: 'center',
                sortable: true
            },
            {
                field: 'name',
                title: '名称',
                align: 'center'
            },
            {
                field: 'operate',
                title: '操作',
                align: 'center',
                events: gUnselectEvents,
                formatter: gUnselectDIV
            }
        ]
    }

    $('#userMemberGM').find('#saveGid').attr('data-gid', gid);

    $('#userMemberGM').on('show.bs.modal', function (e) {
            $('#unSelectUserTable').bootstrapTable('destroy');
            $('#unSelectUserTable').bootstrapTable(option);
        }
    );

    $('#userMemberGM').modal('show');
}


//====================项目

var pOptionEvents = {
    'click .accessP': function (e, value, row, index) {
        showPAccessModal(row);
    },
    'click .updateP': function (e, value, row, index) {
        updateP(row);
    },
    'click .removeP': function (e, value, row, index) {
        $.ajax({
            url: '/project/deleteByPid?pid=' + row.pid,
            error: function () {
                showWarning("请求失败");
            },
            success: function (msg) {
                $('#pTable').bootstrapTable('remove', {
                    field: 'pid',
                    values: [row.pid]
                })
            }
        });
    }
};

function pOptionDIV(value, row, index) {
    return [
        '<a class="accessP" href="javascript:void(0)" title="权限">',
        '<i class="fa fa-lock"></i>',
        '</a>  ',
        '<a class="updateP" href="javascript:void(0)" title="修改">',
        '<i class="fa fa-cog"></i>',
        '</a>  ',
        '<a class="removeP" href="javascript:void(0)" title="删除">',
        '<i class="fa fa-trash"></i>',
        '</a>  '
    ].join('');
}

function refreshPTable() {
    $('#pTable').bootstrapTable('refresh', null);
}

function showPAccessModal(row) {
    var modal = $('#pAccessModal');
    modal.on('show.bs.modal', function (e) {
        modal.find('.savePid').attr('data-pid', row.pid);
        if (row.visited == 1) {
            modal.find('#visitedPublic').attr('checked', false);
            modal.find('#visitedPrivate').attr('checked', true);
        }

        initPAccessTable(row);
    });

    modal.modal('show');
}

function addProject() {
    var modal = $('#pInfoModal');

    $('#pInfoModalSubmit').on('click', null, null, function () {
        $.ajax({
            url: '/project/create',
            type: "POST",
            data: $("#pInfo").serialize(),
            error: function (msg) {

            },
            success: function (msg, stat, xhr) {
                modal.modal('hide');
                refreshPTable();
            }
        });
    });


    modal.on('show.bs.modal', function (e) {
        modal.find('.modal-title').text("新增项目");
        var submit = $('#pInfoModalSubmit');
        submit.text("增加");
    });

    modal.modal('show');
}

function updateP(row) {
    $('#pInfoModalSubmit').on('click', null, null, function () {
        $.ajax({
            url: '/project/updateByPid',
            type: "POST",
            data: $("#pInfo").serialize(),
            error: function (msg) {

            },
            success: function (msg, stat, xhr) {

                refreshPTable();
            }
        });
    });

    var modal = $('#pInfoModal');
    modal.on('show.bs.modal', function (e) {
        modal.find('.modal-title').text("更新项目");
        modal.find('#pid').val(row.pid);
        modal.find('#pname').val(row.pname);
        modal.find('#desc').val(row.desc);

        var submit = $('#pInfoModalSubmit');
        submit.text("增加");
    });

    modal.modal('show');
}

function initPTable() {
    var option = {
        url: '/project/findAll',
        striped: true, // 是否显示行间隔色
        toolbar: "#toolbarP",
        pagination: false,
        columns: [
            {
                field: 'pid',
                title: '编号',
                align: 'center',
                sortable: true
            },
            {
                field: 'pname',
                title: '名称',
                align: 'center'
            },
            {
                field: 'date',
                title: '创建时间',
                align: 'center'
            },
            {
                field: 'desc',
                title: '备注',
                align: 'left',
                width: '500px'
            },
            {
                field: 'operate',
                title: '操作',
                align: 'center',
                events: pOptionEvents,
                formatter: pOptionDIV
            }
        ]
    }

    $('#pTable').bootstrapTable('destroy');
    $('#pTable').bootstrapTable(option);

    $('.bs-bars').removeClass("float-left");
}

var pAccessEvent = {
    'click .accessP': function (e, value, row, index) {
        var checked = e.currentTarget.checked;
        var index = $(e.currentTarget).attr('data-index');
        var access = 0;
        index = Math.pow(2, index);
        if (checked) {
            access = row.access | index;
        } else {
            access = row.access - index;
        }

        row.access = access;

        var param = [
            'pid=' + $('#pAccessModal').find('.savePid').attr('data-pid'),
            'gid=' + row.gid,
            'access=' + access
        ].join('&');

        $.ajax({
            url: '/project/updateAccess',
            type: "GET",
            data: param,
            error: function (msg) {
                console.log(msg);
            },
            success: function (msg, stat, xhr) {
                $('#unSelectUserTable').bootstrapTable('refresh', null);
            }
        });
    }
}

function pAccessDIV(value, row, index, i) {
    // 第i位为1则为true
    var check = (row.access >> i & 1) > 0 ? 'checked' : '';
    return [
        '<input class="accessP" type="checkbox" ',
        check,
        ' data-index="',
        i,
        '"/>',
    ].join('');
}

function initPAccessTable(row) {
    var option = {
        url: '/project/accessList?pid=' + row.pid,
        striped: true, // 是否显示行间隔色
        pagination: false,
        columns: [
            {
                field: 'gid',
                title: '组号',
                align: 'center',
                sortable: true
            },
            {
                field: 'gname',
                title: '组名',
                align: 'center'
            },
            {
                field: 'fread',
                title: '文件-读取',
                align: 'center',
                events: pAccessEvent,
                formatter: function (value, row, index) {
                    return pAccessDIV(value, row, index, 0);
                }
            },
            {
                field: 'fupload',
                title: '文件-上传',
                align: 'center',
                events: pAccessEvent,
                formatter: function (value, row, index) {
                    return pAccessDIV(value, row, index, 1);
                }
            },
            {
                field: 'fdelete',
                title: '文件-下载',
                align: 'center',
                events: pAccessEvent,
                formatter: function (value, row, index) {
                    return pAccessDIV(value, row, index, 2);
                }
            }
        ]
    }

    $('#pAccessTable').bootstrapTable('destroy');
    $('#pAccessTable').bootstrapTable(option);
}

function pAccess(visited) {
    var param = [
        'pid=' + $('#pAccessModal').find('.savePid').attr('data-pid'),
        'visited=' + visited
    ].join('&');

    $.ajax({
        url: '/project/updateVisited',
        type: "GET",
        data: param,
        error: function (msg) {
            console.log(msg);
        },
        success: function (msg, stat, xhr) {

        }
    });
}