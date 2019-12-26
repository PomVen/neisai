<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false"%>
<html>
<head>
    <title>谜苑天涯-登录</title>
    <link rel="stylesheet" href="/layui/css/layui.css" />
    <link rel="stylesheet" href="/css/myty.css" />
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/jquery.pure.tooltips.js"></script>
    <script type="text/javascript" src="/layui/layui.js"></script>
</head>
<body>
<jsp:include page="../frame/topUnlogin.jsp"></jsp:include>
<div class="layui-row">
    <div class="borderColor loginDiv height-260">
        <div class="centerDiv height-100">
            <form id="loginForm" class="layui-form layui-form-pane"  action="/login/loginCheck" method="post">
                <div class="layui-form-item">
                    <label class="layui-form-label">用户名</label>
                    <div class="layui-input-block">
                        <input type="text" name="userName" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input" />
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">密码</label>
                    <div class="layui-input-block">
                        <input type="password" name="userPassword"  lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input" />
                    </div>
                </div>
                <div class="layui-form-item">
                    <button  class="layui-btn layui-btn-fluid" lay-submit lay-filter="login">登录</button>
                </div>
                <span style="color: #FF5722">${errMsg}</span>
            </form>
        </div>
    </div>
</div>
<jsp:include page="../frame/bottom.jsp"></jsp:include>
</body>
<script>
    // layUI获取元素值：var pvalue = $("input[name='password']").val(); name属性为password的input的值
    layui.use(['form'], function(){
        var form = layui.form;
        //自定义验证规则，元素使用lay-verify绑定校验规则，不同的校验规则 用逗号间隔，可以使用自定义方法
        form.verify({
            pass: [/(.+){6,12}$/, '密码必须6到12位']
        });
        //监听提交,也就是在点击按钮，提交到后台之前的操作
        form.on('submit(login)', function(data){
            layer.msg(data);
        });
    });

    function show() {
        //创建内置Date对象
        var date = new Date();
        //获取当前年份
        var year = date.getFullYear();
        //获取当前的月份,范围是0-11
        var month = date.getMonth() + 1;
        if(month < 10){
            month = "0" + month;
        }
        //获取该月的第几天
        var day = date.getDate();
        if(day < 10){
            day = "0" + day;
        }
        //getDay方法获取当前是这个星期的第几天范围是0-6
        //周日对应0，123456分别是对应的星期几
        var week = "日一二三四五六".charAt(date.getDay());
        //获取当前小时分钟和秒
        var hour = date.getHours();
        if(hour < 10){
            hour = "0"+hour;
        }
        var minute = date.getMinutes();
        if(minute < 10){
            minute = "0"+minute;
        }
        var second = date.getSeconds();
        if(second < 10){
            second = "0"+second;
        }
        //选择id为time的标签
        var element = document.getElementById("showTime");
        element.innerHTML = year+"-"+month+"-"+day+" "+"星期"+week+"	"+hour+":"+minute+":"+second;
        var element2 = document.getElementById("copyright");
        element2.innerHTML = "Copyright 2008-" + year + "谜苑天涯";
    }
    show();
    //每间隔1000毫秒执行一次程序，保证时间动态显示
    setInterval("show()",1000);
</script>
</html>
