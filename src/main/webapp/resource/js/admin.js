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

    var modal = $(param.data[0]);
    modal.find('.close').click();
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

            $('#userModal').find('#name').val(row["name"]);
            $('#userModal').find('#email').val(row["email"]);
        });

        $('#userModal').modal('show');
    },
    'click .remove': function (e, value, row, index) {
        $('#mytab').bootstrapTable('remove', {
            field: 'id',
            values: [row.id]
        })
    }
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
        showExport: true,
        exportDataType: "all",
        exportTypes: ['excel', 'pdf'],
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

    var exportTool = $('.fixed-table-toolbar').find('.export');
    exportTool.before(addTool());
    exportTool.find('.dropdown-toggle').attr('title', "导出数据");


}

function refreshTable() {
    $('#userTab').bootstrapTable('refresh', null);
}

//=====组
var gTableID = '#gTable';
var memberTable = '#memberTable';

function gOperateDIV(value, row, index) {
    return [
        '<a class="add" href="javascript:void(0)" title="新增成员">',
        '<i class="fa fa-user-circle"></i>',
        '</a>  ',
        '<a class="update" href="javascript:void(0)" title="修改">',
        '<i class="fa fa-cog"></i>',
        '</a>  ',
        '<a class="remove" href="javascript:void(0)" title="删除">',
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
    'click .add': function (e, value, row, index) {
        var modal = $('#gModal');
        modal.on('show.bs.modal', function (e) {
            modal.find('.modal-title').text("新增组");
            var submit = $('#userModelSubmit');
            submit.text("修改");
            submit.on('click', null, modal, addUser);

            modal.find('#gname').val(row["gname"]);
        });

        modal.modal('show');
    },
    'click .update': function (e, value, row, index) {
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
    'click .remove': function (e, value, row, index) {
        $('#gTable').bootstrapTable('remove', {
            field: 'gid',
            values: [row.id]
        })
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
        $.ajax({
            method: 'GET',
            url: '/admin/group/delMemberByUid',
            data: 'uid=' + row[uid],
            error: function () {
                showWarning("请求失败");
            },
            success: function (msg) {
                if (msg["result"] === "false") {
                    showWarning(msg["msg"]);
                } else {
                    $(memberTable).bootstrapTable('remove', {
                        field: 'uid',
                        values: [row.id]
                    })
                }
            }
        });
    }
}

// 显示组成员
var gEventMember = {
    'click .group': function (e, value, row, index) {
        var optionMemberTable = {
            url: '/group/members',
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
        showExport: true,
        exportDataType: "all",
        exportTypes: ['excel', 'pdf'],
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


    var exportTool = $('.fixed-table-toolbar').find('.export');
    exportTool.before(gTabTool());
    exportTool.find('.dropdown-toggle').attr('title', "导出数据");
}