<%--
  Created by IntelliJ IDEA.
  User: YowYouth
  Date: 2019/11/7
  Time: 17:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/layui/css/layui.css"/>
    <link rel="stylesheet" href="/css/myty.css" />
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/jquery.pure.tooltips.js"></script>
    <script type="text/javascript" src="/layui/layui.js"></script>
</head>
<body>
<div class="layui-row">
    <div class="topDiv">
        <div class="layui-row topWord bottom">
            <div class="layui-col-md4 left">
                【第${roundNo}轮】
            </div>
            <div class="layui-col-md4 center">
                <a href="/login/loginOut">退出登录</a>
            </div>
            <div class="layui-col-md4 right">
                <span id="showTime"></span>
            </div>
        </div>
    </div>
</div>
</body>
</html>
