<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: YowYouth
  Date: 2019/11/7
  Time: 17:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>谜苑天涯-我的谜题</title>
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
        <div class="borderColor loginDiv height-230">
            <table class="layui-table">
                <tr>
                    <th lay-data="{align:'center'}" colspan="5">本轮我输入的谜题</th>
                </tr>
                <tr>
                    <th><span>谜面</span></th>
                    <th><span>谜目</span></th>
                    <th><span>谜底</span></th>
                    <th><span>谜面注解</span></th>
                    <th><span>谜底注解</span></th>
                </tr>
                <c:forEach items="${list}" var="item" varStatus="status">
                    <tr class="${status.index%2 == 0 ? 'cell-background-color-0' : 'cell-background-color-1'}">
                        <td>${item.dmMimian}</td>
                        <td>${item.dmMimu}</td>
                        <td>${item.dmMidi}</td>
                        <td>${item.dmMimianzhu}</td>
                        <td>${item.dmMidizhu}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
<jsp:include page="../frame/bottom.jsp"></jsp:include>
</body>
<script>
    layui.use('table', function(){
        var table = layui.table;
    });
</script>
</html>
