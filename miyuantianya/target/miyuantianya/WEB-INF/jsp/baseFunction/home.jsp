<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false"%>
<html>
<head>
    <title>谜苑天涯-首页</title>
    <link rel="stylesheet" href="/layui/css/layui.css"/>
    <link rel="stylesheet" href="/css/myty.css" />
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/jquery.pure.tooltips.js"></script>
    <script type="text/javascript" src="/layui/layui.js"></script>
</head>
<body>
<jsp:include page="../frame/topLogin.jsp"></jsp:include>
<div class="layui-row">
    <div class="loginDiv">
        <div class="layui-tab layui-tab-brief">
            <ul class="layui-tab-title">
                <li class="layui-this">输入猜射</li>
                <li>输入谜题</li>
                <li>评分</li>
                <li>列中</li>
                <li>当前赛况</li>
                <li>我的谜题</li>
                <li>查看日程</li>
                <li>修改密码</li>
                <li>新增用户</li>
                <li>发起比赛</li>
            </ul>
            <div class="layui-tab-content" style="height: 100px;">
                <div class="layui-tab-item layui-show">
                    <jsp:include page="/dengmiTemp/toInputAnswer"></jsp:include>
                </div>
                <div class="layui-tab-item">
                    <jsp:include page="/page/toInputMySubject"></jsp:include>
                </div>
                <div class="layui-tab-item">
                    <jsp:include page="../baseFunction/inputAnswer.jsp"></jsp:include>
                </div>
                <div class="layui-tab-item">
                    <jsp:include page="../baseFunction/inputAnswer.jsp"></jsp:include>
                </div>
                <div class="layui-tab-item">
                    <jsp:include page="../baseFunction/situationDetail.jsp"></jsp:include>
                </div>
                <div class="layui-tab-item">
                    <jsp:include page="/dengmiTemp/toMySubject"></jsp:include>
                </div>
                <div class="layui-tab-item">
                    <jsp:include page="/login/agendaDetail"></jsp:include>
                </div>
                <div class="layui-tab-item">
                    <jsp:include page="/user/toChangePassword"></jsp:include>
                </div>
                <div class="layui-tab-item">
                    <jsp:include page="/user/toAddUser"></jsp:include>
                </div>
                <div class="layui-tab-item">
                    <jsp:include page="/agenda/toNewAgenda"></jsp:include>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    layui.use('element', function(){
        // var $ = layui.jquery
        //     ,element = layui.element; //Tab的切换功能，切换事件监听等，需要依赖element模块
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
    }
    show();
    //每间隔1000毫秒执行一次程序，保证时间动态显示
    setInterval("show()",1000);
</script>

</body>
</html>