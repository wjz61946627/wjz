$(function () {
    initAccount();

    initTable();
});

// 账号管理
function initAccount() {
    $(".rightContainer").hide();
    $('#user').show();
}

// 组管理
function initGroup() {
    $(".rightContainer").hide();
    $('#group').show();
}

// 项目管理
function initProject() {
    $(".rightContainer").hide();
    $('#project').show();
}

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
        url: '/admin/addUser',
        type: "POST",
        data: $("#userInfo").serialize(),
        error: function (msg) {
            console.log(msg);
            $("#error").html(msg);
        },
        success: function (msg, stat, xhr) {
            console.log(msg);
            if (msg["result"] == "false") {
                $("#errorInfo").html(msg["msg"]);
                $("#errorInfo").show();
            } else {
                $("#loginForm").submit();
            }
        }
    });

    console.log("成功添加一个用户");

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
    $('#userTab').bootstrapTable({
        method: 'post',
        url: '/admin/findAll',
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