<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: YowYouth
  Date: 2019/11/7
  Time: 17:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>谜苑天涯-评分</title>
    <link rel="stylesheet" href="/layui/css/layui.css" />
    <link rel="stylesheet" href="/css/myty.css" />
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/jquery.pure.tooltips.js"></script>
    <script type="text/javascript" src="/js/myty.js"></script>
    <script type="text/javascript" src="/layui/layui.js"></script>
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
                ,{field: 'dmMimianzhu', title: '谜面注解'}
                ,{field: 'dmMidizhu', title: '谜底注解'}
                ,{field: 'dmMidi', title: '谜底'}
                ,{field: 'userAnswer', title: '我的谜底'}
                ,{field: 'userJudge',edit: 'text', title: '评分'}
            ]]
        });
    });
</script>
</html>
