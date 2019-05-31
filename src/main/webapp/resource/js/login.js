function initLogin() {
    $("#login").click(function () {
        $.ajax({
            url: "/user/sign",
            timeout: 500,
            type: "POST",
            dataType: "json",
            data: $("#loginForm").serialize(),
            error: function (msg) {
                $("#error").html(msg);
            },
            success: function (msg, stat, xhr) {
                if (msg["result"] == "false") {
                    $("#errorInfo").html(msg["msg"]);
                    $("#errorInfo").show();
                } else {
                    window.open("/user/welcome");
                }
            }
        })
    });
}

$(function () {
    $("#errorInfo").hide();
    initLogin();
})