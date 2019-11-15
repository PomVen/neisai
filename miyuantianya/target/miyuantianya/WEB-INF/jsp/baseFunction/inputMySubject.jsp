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
    <link rel="stylesheet" href="/layui/css/layui.css"/>
    <link rel="stylesheet" href="/css/myty.css"/>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/jquery.pure.tooltips.js"></script>
    <script type="text/javascript" src="/js/myty.js"></script>
    <script type="text/javascript" src="/layui/layui.js"></script>
</head>
<body>
<div style="padding: 15px;background-color: #996600; color: #fff;">
    tips:
</div>
<div style="padding-left: 15px; border-left: 1px solid #996600; border-right: 1px solid #996600">
    1.集锦谜谜底用/隔开，注意用半角符号，而不是全角符号“／”。
</div>
<div style="padding-left: 15px; border-left: 1px solid #996600; border-right: 1px solid #996600">
    2.探骊、隐目等带目的谜底或谜目为“某某冠某”、“某某带某”之类者，谜底连写，不加分隔符号。
</div>
<div style="padding-left: 15px; border-left: 1px solid #996600; border-right: 1px solid #996600">
    3.谜目与谜格之间用/或者·隔开，不必用括号将谜目括起来。
</div>
<div style="padding-left: 15px; border-left: 1px solid #996600; border-right: 1px solid #996600">
    4.注释栏用于对谜面出处等作一简单注释，猜射和评谜时将显示出来。
</div>
<div style="padding-left: 15px; border-left: 1px solid #996600; border-right: 1px solid #996600; border-bottom: 1px solid #996600">
    5.扣合备注栏用于对谜面和谜底扣合的可能引起误会之处作一注解，评分时将显示出来，以免出现误评。此项和注释项都可填可不填。
</div>
<div style="padding: 15px;">
    <form id="mySubjectForm" class="layui-form layui-form-pane">
        <div class="layui-form-item">
            <table name="list" id="demo" lay-filter="test"></table>
        </div>
        <div class="layui-form-item">
            <input class="layui-btn layui-btn-fluid" type="button" value="保存" onclick="submitMySubject()">
        </div>
    </form>
</div>
</body>
<script>

    layui.use(['form', 'layer'], function () {
        var form = layui.form;
    });

    layui.use('table', function () {
        var table = layui.table;

        //第一个实例
        table.render({
            elem: '#demo'
            , url: '/dengmiTemp/inputMySubject' //数据接口
            , page: false //开启分页
            , cols: [[ //表头
                {field: 'dmMimian', edit: 'text', title: '谜面', fixed: 'left'}
                , {field: 'dmMimu', edit: 'text', title: '谜目/谜格'}
                , {field: 'dmMidi', edit: 'text', title: '谜底'}
                , {field: 'dmMimianzhu', edit: 'text', title: '谜面注解'}
                , {field: 'dmMidizhu', edit: 'text', title: '谜底注解'}
            ]]
        });

    });

    function submitMySubject() {
        console.log($('#mySubjectForm').serializeArray());
        $.ajax({
            //几个参数需要注意一下
            type: "POST",//方法类型
            dataType: "json",//预期服务器返回的数据类型
            url: "/dengmiTemp/submitMySubject",//url
            data: $('#mySubjectForm').serializeArray(),
            success: function (result) {
                layer.open({
                    title: '用户新增结果'
                    , content: result.msg
                });
            },
            error: function () {
                alert("异常！");
            }
        });
    }
</script>
</html>
