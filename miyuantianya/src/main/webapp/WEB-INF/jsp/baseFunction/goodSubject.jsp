<%--
  Created by IntelliJ IDEA.
  User: YowYouth
  Date: 2019/11/20
  Time: 10:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>谜苑天涯-佳谜榜</title>
    <link rel="stylesheet" href="/layui/css/layui.css"/>
    <link rel="stylesheet" href="/css/myty.css"/>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/jquery.pure.tooltips.js"></script>
    <script type="text/javascript" src="/js/myty.js"></script>
    <script type="text/javascript" src="/layui/layui.js"></script>
</head>
<body>
<form class="layui-form" action="">
    <div class="layui-form-item  layui-inline">
        <label class="layui-form-label">轮次</label>
        <div class="layui-input-block" style="width: 300px;">
            <select id="roundNo" name="roundNo" lay-verify="required" lay-filter="brickType">
                <option value=""></option>
                <option value="1">第1轮</option>
                <option value="2">第2轮</option>
                <option value="3">第3轮</option>
            </select>
        </div>
    </div>
</form>
<div style="padding: 15px;">
    <table id="goodSubject" lay-filter="test"></table>
</div>
<script type="text/html" id="mimianTemplet">
    <a lay-event="showDetail" class="layui-table-link">{{d.dm_mimian}}</a>
</script>
</body>
<script>
    layui.use(['table','form'], function(){
        var table = layui.table,
            form = layui.form;
        //第一个实例
        table.render({
            elem: '#goodSubject'
            ,url: '/dengmiTemp/goodSubject' //数据接口
            ,page: true //开启分页
            ,id: 'dengmiTableReload'
            ,toolbar: true
            ,cols: [[ //表头
                {field: 'dm_mimian', title: '谜面',fixed: 'left', templet:'#mimianTemplet'}
                ,{field: 'dm_mimu', title: '谜目'}
                ,{field: 'dm_midi', title: '谜底'}
                ,{field: 'dm_mimianzhu', title: '谜面注'}
                ,{field: 'dm_midizhu', title: '谜底注'}
                ,{field: 'user_name', title: '作者'}
                ,{field: 'user_judge', title: '评分'}
            ]]
        });

        //根据条件查询表格数据重新加载
        form.on('select(brickType)', function(data){
            console.log(data);
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
        });

        table.on('tool(test)', function(obj){
            var data = obj.data;
            console.log(data);
            //formData = data;
            if(obj.event === 'showDetail'){
                layer.open({
                    //layer提供了5种层类型。可传入的值有：0（信息框，默认）1（页面层）2（iframe层）3（加载层）4（tips层）
                    type:1,
                    title:"谜题信息",
                    area: ['90%','90%'],
                    content: '<div><table id="dengmiDetailTable"></table><table id="dengmiAnswerDetailTable"></table></div>',
                    success : function(index, layero) {
                        table.render({
                            elem: '#dengmiDetailTable'
                            ,url: '/util/dengmiDetailTable?dmId=' + data.dm_temp_id //数据接口
                            ,page: false //开启分页
                            ,cols: [[ //表头
                                {field: 'dm_mimian', title: '谜面', width:400, fixed: 'left'}
                                ,{field: 'dm_mimu', title: '谜目/谜格'}
                                ,{field: 'dm_midi', title: '谜底'}
                                ,{field: 'dm_mimianzhu', title: '谜面注解'}
                                ,{field: 'dm_midizhu', title: '谜底注解'}
                                ,{field: 'user_name', title: '作者'}
                            ]]
                        });
                        var userName = data.user_name;
                        table.render({
                            elem: '#dengmiAnswerDetailTable'
                            ,url: '/util/dengmiAnswerDetailTable?dmId='+data.dm_temp_id //数据接口
                            ,page: true //开启分页
                            ,cols: [[ //表头
                                {field: 'user_name', title: '用户', fixed: 'left'}
                                ,{field: 'user_answer', title: '猜射'}
                                ,{field: 'result', title: '列中'}
                                ,{field: 'user_answer_score', title: '用户得分'}
                                ,{field: 'user_judge', title: '用户评分'}
                            ]]
                        });

                    },
                });
            }
        });
    });
</script>
</html>
