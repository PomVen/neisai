<%--
  Created by IntelliJ IDEA.
  User: YowYouth
  Date: 2019/11/15
  Time: 9:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>谜苑天涯-列中</title>
</head>
<body>
<div style="padding: 15px;">
    <table id="pingfen" lay-filter="test"></table>
</div>
</body>
<script>
    layui.use('table', function(){
        var table = layui.table;

        //第一个实例
        table.render({
            elem: '#pingfen'
            ,url: '/dengmiTemp/pingfen' //数据接口
            ,page: true //开启分页
            ,limits: [5,10,20,50]
            ,limit: 10
            ,cols: [[ //表头
                {field: 'dmMimian', title: '谜面',fixed: 'left'}
                ,{field: 'dmMimu', title: '谜目'}
                ,{field: 'dmMidi', title: '谜底'}
                ,{field: 'dmYidi', title: '异底'}
                ,{field: 'liezhong',edit: 'text', title: '列中'}
            ]]
        });
    });
</script>
</html>
