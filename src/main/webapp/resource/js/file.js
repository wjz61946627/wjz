$(function () {
    initFileTable($("#pid").attr("data-pid"));
});

var fOptionEvents = {
    'click .removeF': function (e, value, row, index) {
        var param = [
            'pid=' + $("#pid").attr("data-pid"),
            'fname=' + row.fname,
            'fid=' + row.fid
        ].join('&');

        $.ajax({
            url: '/file/deleteByPidFid',
            type: "Post",
            data: param,
            error: function (msg) {
                console.log(msg);
            },
            success: function (msg, stat, xhr) {
                $('#fileTable').bootstrapTable('remove', {
                    field: 'fid',
                    values: [row.fid]
                })
            }
        });
    }
}

function fOpetionDIV(value, row, index) {
    return [
        '<a class="removeF" href="javascript:void(0)" title="删除">',
        '<i class="fa fa-trash"></i>',
        '</a>  '
    ].join('');
}

function fToolDIV() {
    return [
        '<button class="btn btn-secondary" type="button" name="refresh" aria-label="Refresh" title="刷新" onclick="refreshFTable()">',
        '<i class="fa fa-refresh" aria-hidden="true"></i>',
        '</button>',
        '<button class="btn btn-secondary" type="button" name="add" aria-label="add" title="新增" data-toggle="modal" onclick="showUpload()">',
        '<i class="fa fa-plus-square"></i>',
        '</button>'
    ].join('');
}

function showUpload() {

    var pid = $("#pid").attr("data-pid");
    var uid = $("#uid").attr("data-uid");

    var option = {
        language: 'zh', //设置语言
        uploadUrl: '/file/upload', //上传的地址
        allowedFileExtensions: ['xlsx', 'xls', 'doc', 'docx', 'zip'],
        showUpload: true, //是否显示上传按钮
        showCaption: true,//是否显示标题
        browseClass: "btn btn-primary", //按钮样式
        maxFileCount: 6, //表示允许同时上传的最大文件个数
        maxFileSize: 4194304,
        enctype: 'multipart/form-data',
        validateInitialCount: true,
        theme: 'fa',
        uploadAsync: false,
        uploadExtraData: {'pid': pid, 'uid': uid},
    };

    var modal = $('#fUploadModal');
    modal.on('show.bs.modal', function (e) {
        var pid = $("#pid").attr("data-pid");
        $("#upload").fileinput(option);

        $("#upload").on('filebatchselected', function (event, files) {
            console.log(files);
            for (var key in files) {
                checkFileName(pid, files[key].name);
            }
        });
    });

    modal.modal('show');
}

function checkFileName(pid, fileName) {
    var param = [
        'pid=' + pid,
        'fname=' + fileName
    ].join('&');

    $.ajax({
        url: '/file/checkFileName',
        type: "GET",
        data: param,
        contentType: '',
        error: function (msg) {
            console.log(msg);
        },
        success: function (msg, stat, xhr) {
            console.log(msg);
        }
    });
}

var fNameEvents = {
    'click .fname': function (e, value, row, index) {
        // var param = [
        //     'pid=' + $("#pid").attr("data-pid"),
        //     'fid=' + row.fname,
        //     'fid=' + row.fid
        // ].join('&');
        //
        // $.ajax({
        //     url: '/file/readByFidPid',
        //     type: "GET",
        //     data: param,
        //     error: function (msg) {
        //         console.log(msg);
        //     },
        //     success: function (msg, stat, xhr) {
        //         console.log(msg);
        //     }
        // });
    }
}


function fNameDIV(value, row, index) {
    var param = [
        'pid=' + $("#pid").attr("data-pid"),
        'fid=' + row.fid
    ].join('&');

    return [
        '<a class="fname fa fa-download" href="/file/download?',
        param,
        '" title="下载">',
        '</a>  ',
        '<a class="read" href="/file/show?fid=',
        row.fid,
        '" title="浏览">',
        '</a>  ',
    ].join('');
}

function refreshFTable() {
    $('#fileTable').bootstrapTable('refresh', null);
}

function initFileTable(pid) {

    var option = {
        url: '/file/findByPid?pid=' + pid,
        striped: true, // 是否显示行间隔色
        showExport: true,
        exportDataType: "all",
        exportTypes: ['excel', 'pdf'],
        pagination: false,
        columns: [
            {
                field: 'fid',
                title: '文件编号',
                align: 'center',
                sortable: true
            },
            {
                field: 'fname',
                title: '文件名',
                align: 'center',
                events: fNameEvents,
                formatter: fNameDIV
            },
            {
                field: 'uploadTime',
                title: '上传时间',
                align: 'center',
            },
            {
                field: 'uploadId',
                title: '上传者id',
                align: 'center',

            },
            {
                field: 'option',
                title: '操作',
                align: 'center',
                events: fOptionEvents,
                formatter: fOpetionDIV
            }
        ]
    };

    var filetable = $('#fileTable');
    filetable.bootstrapTable('destroy');
    filetable.bootstrapTable(option);

    var exportTool = $('.fixed-table-toolbar').find('.export');
    exportTool.before(fToolDIV());
    exportTool.find('.dropdown-toggle').attr('title', "导出数据");
}


