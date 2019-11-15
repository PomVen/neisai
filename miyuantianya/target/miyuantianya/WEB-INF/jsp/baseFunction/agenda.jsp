<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
 Created by IntelliJ IDEA.
 User: YowYouth
 Date: 2019/11/7
 Time: 17:42
 To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>谜苑天涯</title>
    <link rel="stylesheet" href="/layui/css/layui.css" />
    <link rel="stylesheet" href="/css/myty.css" />
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/jquery.pure.tooltips.js"></script>
    <script type="text/javascript" src="/js/myty.js"></script>
    <script type="text/javascript" src="/layui/layui.js"></script>
</head>
<body>
<div class="layui-row">
    <div class="borderColor loginDiv height-300">
        <div class="centerDiv height-120">
            <table class="layui-table">
                <colgroup>
                    <col width="150">
                    <col width="200">
                </colgroup>
                <tr>
                    <th lay-data="{align:'center'}" colspan="2">谜苑天涯灯谜联赛日程</th>
                </tr>
                <tr>
                    <td><span>开始时间</span></td>
                    <td>${startTime}</td>
                </tr>
                <tr>
                    <td><span>猜射时间</span></td>
                    <td>${doTime}</td>
                </tr>
                <tr>
                    <td><span>评分列中时间</span></td>
                    <td>${judgeTime}</td>
                </tr>
                <tr>
                    <td><span>结束时间</span></td>
                    <td>${endTime}</td>
                </tr>
                <c:if test="${!isLogined}">
                    <tr>
                        <td lay-data="{align:'center'}" colspan="2"><a href="/login/loginPage">返回首页</a></td>
                    </tr>
                </c:if>
            </table>
        </div>
    </div>
</div>
<jsp:include page="../frame/bottom.jsp"></jsp:include>
<%--<div style="padding: 15px;">--%>
    <%--<table id="demo" lay-filter="test"></table>--%>
<%--</div>--%>
</body>
<script>
    // layui.use('table', function(){
    //     var table = layui.table;
    //
    //     //第一个实例
    //     table.render({
    //         elem: '#demo'
    //         ,url: '/dengmiTemp/toMySubject' //数据接口
    //         ,page: true //开启分页
    //         ,limits: [5,10,20,50]
    //         ,limit: 10
    //         ,cols: [[ //表头
    //             {field: 'startTime', title: '开始时间', fixed: 'left'}
    //             ,{field: 'doTime', title: '猜射时间'}
    //             ,{field: 'judgeTime', title: '评分列中时间'}
    //             ,{field: 'endTime', title: '结束时间'}
    //         ]]
    //     });
    //
    // });
</script>
</html>
