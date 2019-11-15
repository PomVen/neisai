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
    <link rel="stylesheet" href="/layui/css/layui.css" />
    <link rel="stylesheet" href="/css/myty.css" />
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/jquery.pure.tooltips.js"></script>
    <script type="text/javascript" src="/js/myty.js"></script>
    <script type="text/javascript" src="/layui/layui.js"></script>
</head>
<body>
<div style="padding: 15px;">
    <table id="liezhong" lay-filter="test"></table>
</div>
</body>
<script>
    layui.use('table', function(){
        var table = layui.table;
        //第一个实例
        table.render({
            elem: '#liezhong'
            ,url: '/dengmiTemp/liezhong' //数据接口
            ,page: true //开启分页
            ,limits: [5,10,20,50]
            ,limit: 10
            ,cols: [[ //表头
                {field: 'dm_mimian', title: '谜面',fixed: 'left'}
                ,{field: 'dm_mimu', title: '谜目'}
                ,{field: 'dm_midi', title: '谜底'}
                ,{field: 'user_answer', title: '异底'}
                ,{field: 'is_right',edit: 'text', title: '列中'}
            ]]
        });
    });
</script>
</html>
