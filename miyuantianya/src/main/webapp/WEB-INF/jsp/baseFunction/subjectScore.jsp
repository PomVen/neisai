<%--
  Created by IntelliJ IDEA.
  User: YowYouth
  Date: 2019/11/20
  Time: 10:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>谜苑天涯-制谜积分榜</title>
    <link rel="stylesheet" href="/layui/css/layui.css"/>
    <link rel="stylesheet" href="/css/myty.css"/>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/jquery.pure.tooltips.js"></script>
    <script type="text/javascript" src="/js/myty.js"></script>
    <script type="text/javascript" src="/layui/layui.js"></script>
</head>
<body>
<form class="layui-form" action="">
    <div class="layui-form-item" style="margin-left:350px;">
        <div class="layui-inline">
            <input type="text" id="roundNo" name="roundNo" required lay-verify="required" placeholder="轮次" autocomplete="off" class="layui-input">
        </div>
        <button class="layui-btn layui-btn-normal" onclick="return false;" data-type="reload" id="selectbyCondition" >搜索</button>
    </div>
</form>
<div style="padding: 15px;">
    <table id="subjectScore" lay-filter="test"></table>
</div>
</body>
<script>
    layui.use('table', function(){
        var table = layui.table;
        //第一个实例
        table.render({
            elem: '#subjectScore'
            ,url: '/answer/getSubjectScoreInfo' //数据接口
            ,page: true //开启分页
            ,id: 'dengmiTableReload'
            ,cols: [[ //表头
                {field: 'dm_author_name', title: '用户名',fixed: 'left'}
                ,{field: 'user_subject_score', title: '制谜得分'}
            ]]
        });

        //根据条件查询表格数据重新加载
        var $ = layui.$, active = {
            reload: function(){
                //获取用户名
                var demoReload = $('#roundNo');
                //执行重载
                table.reload('dengmiTableReload', {
                    page: {
                        curr: 1 //重新从第 1 页开始
                    }
                    //根据条件查询
                    ,where: {
                        roundNo:demoReload.val()
                    }
                });
            }
        };
        //点击搜索按钮根据用户名称查询
        $('#selectbyCondition').on('click',
            function(){
                var type = $(this).data('type');
                active[type] ? active[type].call(this) : '';
            });
    });
</script>
</html>
