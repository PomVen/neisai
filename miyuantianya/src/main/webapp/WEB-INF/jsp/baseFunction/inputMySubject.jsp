<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: YowYouth
  Date: 2019/11/8
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>谜苑天涯-输入谜题</title>
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
            <table class="layui-table" lay-filter="inputSubject">
                <tr>
                    <th><span>谜面</span></th>
                    <th><span>谜目</span></th>
                    <th><span>谜底</span></th>
                    <th><span>谜面注解</span></th>
                    <th><span>谜底注解</span></th>
                </tr>
                <c:forEach items="${list}" var="item" varStatus="status">
                    <tr>
                        <td><input type="text" class="layui-input" name="mimian" value="${item.dmMimian}"/></td>
                        <td><input type="text" class="layui-input" name="mimu" value="${item.dmMimu}"/></td>
                        <td><input type="text" class="layui-input" name="midi" value="${item.dmMidi}"/></td>
                        <td><input type="text" class="layui-input" name="mimianzhu" value="${item.dmMimianzhu}"/></td>
                        <td><input type="text" class="layui-input" name="midizhu" value="${item.dmMidizhu}"/></td>
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

        //监听单元格编辑
        table.on('edit(inputSubject)', function(obj){
            var value = obj.value //得到修改后的值
                ,data = obj.data //得到所在行所有键值
                ,field = obj.field; //得到字段
            layer.msg('[ID: '+ data.id +'] ' + field + ' 字段更改为：'+ value);
        });
    });
</script>
</html>
