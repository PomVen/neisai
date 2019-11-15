<%--
  Created by IntelliJ IDEA.
  User: YowYouth
  Date: 2019/11/12
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>谜苑天涯内赛系统</title>
    <script src="/js/jquery.min.js"></script>
    <script src="/easyui/jquery.easyui.min.js"></script>
    <link href="/easyui/themes/gray/easyui.css" rel="stylesheet" />
    <link href="/easyui/themes/icon.css" rel="stylesheet" />
</head>
<body>
<div id="loginWin" class="easyui-window" title="登录" style="width:350px;height:188px;padding:5px;"
     minimizable="false" maximizable="false" resizable="false" collapsible="false">
    <div class="easyui-layout" fit="true">
        <div region="center" border="false" style="padding:5px;background:#fff;border:1px solid #ccc;">
            <form id="loginForm" method="post">
                <div style="padding:5px 0;">
                    <label for="userName">用户名:</label>
                    <input type="text" name="userName" id="userName" style="width:260px;" />
                </div>
                <div style="padding:5px 0;">
                    <label for="userPassword">密码:</label>
                    <input type="password" name="userPassword" id="userPassword" style="width:260px;" />
                </div>
                <div style="padding:5px 0;text-align: center;color: red;" id="showMsg"></div>
            </form>
        </div>
        <div region="south" border="false" style="text-align:right;padding:5px 0;">
            <a class="easyui-linkbutton" iconcls="icon-ok" href="javascript:void(0)" onclick="login()">登录</a>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
    document.onkeydown = function (e) {
        var event = e || window.event;
        var code = event.keyCode || event.which || event.charCode;
        if (code == 13) {
            login();
        }
    }
    $(function () {
        $("input[name='login']").focus();
    });
    function cleardata() {
        $('#loginForm').form('clear');
    }
    function login() {
        if ($("input[name='userName']").val() == "" || $("input[name='userPassword']").val() == "") {
            $("#showMsg").html("用户名或密码为空，请输入");
            $("input[name='userName']").focus();
        } else {
            //ajax异步提交
            $.ajax({
                type: "POST",   //post提交方式默认是get
                url: "/login/loginCheck",
                data: $("#loginForm").serialize(),   //序列化
                error: function (request) {      // 设置表单提交出错
                    $("#showMsg").html(request);  //登录错误提示信息
                },
                success: function (data) {
                    document.location = "../baseFunction/home.jsp";
                }
            });
        }
    }
</script>
</html>
