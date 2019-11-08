<%--
  Created by IntelliJ IDEA.
  User: YowYouth
  Date: 2019/11/7
  Time: 17:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>谜苑天涯-修改密码</title>
</head>
<body>
<div class="layui-row">
    <div class="layui-row">
        <div class="borderColor loginDiv height-300">
            <div class="centerDiv height-300">
                <form id="loginForm" class="layui-form layui-form-pane"  action="/user/changePassword" method="post">
                    <div class="layui-form-item">
                        <label class="layui-form-label">用户名</label>
                        <div class="layui-input-block">
                            <input type="text" name="userName" lay-verify="required" readonly value="${loginUserName}" class="layui-input" />
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">旧密码</label>
                        <div class="layui-input-block">
                            <input type="password" name="userPassword"  lay-verify="required" placeholder="请输入旧密码" autocomplete="off" class="layui-input" />
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">新密码</label>
                        <div class="layui-input-block">
                            <input type="password" name="newPassword"  lay-verify="required" placeholder="请输入新密码" autocomplete="off" class="layui-input" />
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">确认新密码</label>
                        <div class="layui-input-block">
                            <input type="password" name="comfirmPassword"  lay-verify="required" placeholder="请输入新密码" autocomplete="off" class="layui-input" />
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <button  class="layui-btn layui-btn-fluid" lay-submit>修改密码</button>
                    </div>
                    <span style="color: #FF5722">${errMsg}</span>
                </form>
            </div>
        </div>
    </div>
</div>
<jsp:include page="../frame/bottom.jsp"></jsp:include>
</body>
</html>
