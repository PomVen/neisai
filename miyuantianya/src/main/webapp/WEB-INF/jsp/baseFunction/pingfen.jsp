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
                {field: 'dm_mimian', title: '谜面', width: 500, fixed: 'left'}
                ,{field: 'dm_mimu', title: '谜目'}
                ,{field: 'dm_mimianzhu', title: '谜面注解'}
                ,{field: 'dm_midizhu', title: '谜底注解'}
                ,{field: 'dm_midi', title: '谜底'}
                ,{field: 'user_answer', title: '我的谜底'}
                ,{field: 'user_judge',edit: 'text', title: '评分'}
            ]]
        });

        table.on('edit(test)', function (obj) { //注：edit是固定事件名，test是table原始容器的属性 lay-filter="对应的值"
            var value = obj.value //得到修改后的值
                , data = obj.data //得到所在行所有键值
                , field = obj.field; //得到字段
            if(value > 10 || value < 0){
                layer.msg('请输入0-10的评分', {
                    time: 2000, //2s后自动关闭
                    btn: ['明白了']
                });
            } else {
                $.post("/answer/saveMyJudge", {dmTempId: data.dm_temp_id, judge: value}, function (data) {
                    if (!data.result) {
                        layer.msg(data.msg);
                    }
                });
            }
        });
    });
</script>
</html>
