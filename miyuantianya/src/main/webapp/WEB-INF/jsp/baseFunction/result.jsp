<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>谜苑天涯-比赛结果</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/layui/css/layui.css"/>
    <link rel="stylesheet" href="/css/myty.css"/>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/jquery.pure.tooltips.js"></script>
    <script type="text/javascript" src="/js/myty.js"></script>
    <script type="text/javascript" src="/layui/layui.js"></script>
</head>
<body>
<div class="layui-header">
    <div class="layui-row">
        <div class="layui-col-md4"
             style="border: 1px solid #996600; text-align: center; font-size: medium; padding-top: 5px; padding-bottom: 5px;">
            <div class="grid-demo grid-demo-bg1">
                <a href="#" style="color: #000000;">本轮得分榜</a>
            </div>
        </div>
        <div class="layui-col-md4"
             style="border: 1px solid #996600; text-align: center; font-size: medium; padding-top: 5px; padding-bottom: 5px;">
            <div class="grid-demo">总积分榜</div>
        </div>
        <div class="layui-col-md4"
             style="border: 1px solid #996600; text-align: center; font-size: medium; padding-top: 5px; padding-bottom: 5px;">
            <div class="grid-demo grid-demo-bg1">猜射成绩榜</div>
        </div>
    </div>
    <div class="layui-row">
        <div class="layui-col-md4"
             style="border: 1px solid #996600; text-align: center; font-size: medium; padding-top: 5px; padding-bottom: 5px;">
            <div class="grid-demo grid-demo-bg1">制谜成绩榜</div>
        </div>
        <div class="layui-col-md4"
             style="border: 1px solid #996600; text-align: center; font-size: medium; padding-top: 5px; padding-bottom: 5px;">
            <div class="grid-demo">全部谜题</div>
        </div>
        <div class="layui-col-md4"
             style="border: 1px solid #996600; text-align: center; font-size: medium; padding-top: 5px; padding-bottom: 5px;">
            <div class="grid-demo grid-demo-bg1">佳谜榜</div>
        </div>
    </div>
    <form class="layui-form" action="">
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">往期成绩</label>
                <div class="layui-input-inline">
                    <select name="quiz">
                        <option value="">请选择</option>
                        <optgroup>
                            <option value="第4轮">第4轮</option>
                            <option value="第3轮">第3轮</option>
                            <option value="第2轮">第2轮</option>
                            <option value="第1轮">第1轮</option>
                        </optgroup>
                    </select>
                </div>
            </div>
        </div>
    </form>
</div>

</body>
<script>
    layui.use(['form', 'layedit', 'laydate'], function () {
        var form = layui.form
            , layer = layui.layer
            , layedit = layui.layedit
            , laydate = layui.laydate;
    });
</script>
</html>