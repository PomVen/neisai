<%--
  Created by IntelliJ IDEA.
  User: YowYouth
  Date: 2019/11/8
  Time: 10:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>谜苑天涯-发起比赛</title>
    <link rel="stylesheet" href="/layui/css/layui.css" />
    <link rel="stylesheet" href="/css/myty.css" />
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/jquery.pure.tooltips.js"></script>
    <script type="text/javascript" src="/js/myty.js"></script>
    <script type="text/javascript" src="/layui/layui.js"></script>
</head>
<body>
<div class="layui-row">
    <div class="layui-row">
        <div class="borderColor loginDiv height-380">
            <div class="centerDiv height-350">
                <form enctype="multipart/form-data" id="loginForm" class="layui-form layui-form-pane"  action="/agenda/newAgenda" method="post">
                    <div class="layui-form-item">
                        <label class="layui-form-label">轮次</label>
                        <div class="layui-input-block">
                            <input type="text" name="roundNo" lay-verify="required" readonly value="${roundNo}" class="layui-input" />
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">开始时间</label>
                        <div class="layui-input-block">
                            <input type="text"  lay-verify="required" placeholder="开始时间" name="startTime" class="layui-input" id="startTime" autocomplete="off"/>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">猜射时间</label>
                        <div class="layui-input-block">
                            <input type="text" lay-verify="required" placeholder="猜射时间" name="doTime" class="layui-input" id="doTime" autocomplete="off"/>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">评分列中时间</label>
                        <div class="layui-input-block">
                            <input type="text" lay-verify="required" placeholder="评分列中时间" name="judgeTime" class="layui-input" id="judgeTime" autocomplete="off"/>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">结束时间</label>
                        <div class="layui-input-block">
                            <input type="text" lay-verify="required" placeholder="结束时间" name="endTime" class="layui-input" id="endTime" autocomplete="off"/>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">输入条数</label>
                        <div class="layui-input-block">
                            <input type="text" name="inputCount"  lay-verify="required" placeholder="输入条数" autocomplete="off" class="layui-input" />
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <button  class="layui-btn layui-btn-fluid" lay-submit>确定</button>
                    </div>
                    <span style="color: #FF5722">${errMsg}</span>
                </form>
            </div>
        </div>
    </div>
</div>
<jsp:include page="../frame/bottom.jsp"></jsp:include>
</body>
<script>
    layui.use('laydate', function() {
        var laydate = layui.laydate;
        //日期时间选择器
        laydate.render({
            elem: '#startTime'
            , type: 'datetime'
        });
        //日期时间选择器
        laydate.render({
            elem: '#doTime'
            , type: 'datetime'
        });
        //日期时间选择器
        laydate.render({
            elem: '#judgeTime'
            , type: 'datetime'
        });
        //日期时间选择器
        laydate.render({
            elem: '#endTime'
            , type: 'datetime'
        });
    });
</script>
</html>
