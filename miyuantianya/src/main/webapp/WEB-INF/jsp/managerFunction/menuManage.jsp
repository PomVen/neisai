<%--
  Created by IntelliJ IDEA.
  User: YowYouth
  Date: 2019/11/20
  Time: 10:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>谜苑天涯-菜单管理</title>
    <link rel="stylesheet" href="/layui/css/layui.css" />
    <link rel="stylesheet" href="/css/myty.css" />
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/jquery.pure.tooltips.js"></script>
    <script type="text/javascript" src="/js/myty.js"></script>
    <script type="text/javascript" src="/layui/layui.js"></script>
</head>
<body>
<div style="padding: 15px;">
    <table id="menuManage" lay-filter="test"></table>
</div>
</body>
<script>
    layui.use('table', function(){
        var table = layui.table;

        //第一个实例
        table.render({
            elem: '#menuManage'
            ,url: '/menu/getAllMenu' //数据接口
            ,page: true //开启分页
            ,limits: [5,10,20,50]
            ,limit: 10
            ,cols: [[ //表头
                {field: 'menuName', title: '菜单名',fixed: 'left'}
                ,{field: 'menuPath', title: '菜单路径'}
                ,{field: 'menuRole', title: '菜单权限'}
            ]]
        });
    });
</script>
</html>
