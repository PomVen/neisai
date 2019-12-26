<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%--<html>--%>
<%--<head>--%>
<%--<title>谜苑天涯-首页</title>--%>
<%--<link rel="stylesheet" href="/layui/css/layui.css"/>--%>
<%--<link rel="stylesheet" href="/css/myty.css" />--%>
<%--<script type="text/javascript" src="/js/jquery.min.js"></script>--%>
<%--<script type="text/javascript" src="/js/jquery.pure.tooltips.js"></script>--%>
<%--<script type="text/javascript" src="/layui/layui.js"></script>--%>
<%--</head>--%>
<%--<body>--%>
<%--<jsp:include page="../frame/topLogin.jsp"></jsp:include>--%>
<%--<div class="layui-row">--%>
<%--<div class="loginDiv">--%>
<%--<div class="layui-tab layui-tab-brief">--%>
<%--<ul class="layui-tab-title">--%>
<%--<c:forEach items="${menu}" var="item" varStatus="status">--%>
<%--<c:if test="${status.index == actived}">--%>
<%--<li class="layui-this">${item.menuName}</li>--%>
<%--</c:if>--%>
<%--<c:if test="${status.index != actived}">--%>
<%--<li>${item.menuName}</li>--%>
<%--</c:if>--%>
<%--</c:forEach>--%>
<%--</ul>--%>
<%--<div class="layui-tab-content" style="height: 100px;">--%>
<%--<c:forEach items="${menu}" var="item" varStatus="status">--%>
<%--<c:if test="${status.index == actived}">--%>
<%--<div class="layui-tab-item layui-show">--%>
<%--<jsp:include page="${item.menuPath}"></jsp:include>--%>
<%--</div>--%>
<%--</c:if>--%>
<%--<c:if test="${status.index != actived}">--%>
<%--<div class="layui-tab-item">--%>
<%--<jsp:include page="${item.menuPath}"></jsp:include>--%>
<%--</div>--%>
<%--</c:if>--%>
<%--</c:forEach>--%>
<%--</div>--%>
<%--</div>--%>
<%--</div>--%>
<%--</div>--%>
<%--</body>--%>
<%--<script>--%>
<%--layui.use('element', function(){--%>
<%--// var $ = layui.jquery--%>
<%--//     ,element = layui.element; //Tab的切换功能，切换事件监听等，需要依赖element模块--%>
<%--});--%>

<%--function show() {--%>
<%--//创建内置Date对象--%>
<%--var date = new Date();--%>
<%--//获取当前年份--%>
<%--var year = date.getFullYear();--%>
<%--//获取当前的月份,范围是0-11--%>
<%--var month = date.getMonth() + 1;--%>
<%--if(month < 10){--%>
<%--month = "0" + month;--%>
<%--}--%>
<%--//获取该月的第几天--%>
<%--var day = date.getDate();--%>
<%--if(day < 10){--%>
<%--day = "0" + day;--%>
<%--}--%>
<%--//getDay方法获取当前是这个星期的第几天范围是0-6--%>
<%--//周日对应0，123456分别是对应的星期几--%>
<%--var week = "日一二三四五六".charAt(date.getDay());--%>
<%--//获取当前小时分钟和秒--%>
<%--var hour = date.getHours();--%>
<%--if(hour < 10){--%>
<%--hour = "0"+hour;--%>
<%--}--%>
<%--var minute = date.getMinutes();--%>
<%--if(minute < 10){--%>
<%--minute = "0"+minute;--%>
<%--}--%>
<%--var second = date.getSeconds();--%>
<%--if(second < 10){--%>
<%--second = "0"+second;--%>
<%--}--%>
<%--//选择id为time的标签--%>
<%--var element = document.getElementById("showTime");--%>
<%--element.innerHTML = year+"-"+month+"-"+day+" "+"星期"+week+"	"+hour+":"+minute+":"+second;--%>
<%--}--%>
<%--show();--%>
<%--//每间隔1000毫秒执行一次程序，保证时间动态显示--%>
<%--setInterval("show()",1000);--%>
<%--</script>--%>
<%--</html>--%>
<html>

<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>谜苑天涯内赛系统</title>
    <link rel="stylesheet" href="/layui/css/layui.css"/>
    <link rel="stylesheet" href="/css/myty.css"/>
</head>

<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">
            <img src="/img/logo3.png"/>
        </div>
        <div class="myty-top">
            谜苑天涯灯谜联赛${saiji}赛季
        </div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    欢迎您， ${loginUserName}
                </a>
            </li>
            <li class="layui-nav-item">
                <a href="/login/loginOut">退出登录</a>
            </li>
        </ul>
    </div>

    <div class="layui-side layui-bg-orange">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree" lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">基本功能</a>
                    <dl class="layui-nav-child">
                        <c:forEach items="${menu}" var="item" varStatus="status">
                            <c:if test="${item.menuType == 1}">
                                <c:choose>
                                    <c:when test="${item.hasChildren == 0}">
                                        <c:if test="${item.parentMenu == '0'}">
                                            <dd>
                                                <a data-url="${item.menuPath}" data-id="${item.menuId}"
                                                   data-title="${item.menuName}" href="#" class="site-demo-active"
                                                   data-type="tabAdd">${item.menuName}</a>
                                            </dd>
                                        </c:if>
                                    </c:when>
                                    <c:otherwise>
                                        <li class="layui-nav-item layui-nav-itemed">
                                            <a class="" href="javascript:;">${item.menuName}</a>
                                            <dl class="layui-nav-child">
                                                <c:forEach items="${menu}" var="item2" varStatus="status">
                                                    <c:if test="${item2.parentMenu == item.menuId}">
                                                        <dd>
                                                            <a data-url="${item2.menuPath}" data-id="${item2.menuId}"
                                                               data-title="${item2.menuName}" href="#" class="site-demo-active"
                                                               data-type="tabAdd">${item2.menuName}</a>
                                                        </dd>
                                                    </c:if>
                                                </c:forEach>
                                            </dl>
                                        </li>
                                    </c:otherwise>
                                </c:choose>
                            </c:if>
                        </c:forEach>
                    </dl>
                </li>
                <c:if test="${loginUser.userRole == 0}">
                    <li class="layui-nav-item">
                        <a href="javascript:;">友情链接</a>
                        <dl class="layui-nav-child">
                            <c:forEach items="${menu}" var="item" varStatus="status">
                                <c:if test="${item.menuType == 2}">
                                    <dd>
                                        <a href="${item.menuPath}" target="_blank">${item.menuName}</a>
                                    </dd>
                                </c:if>
                            </c:forEach>
                        </dl>
                    </li>
                </c:if>
                <c:if test="${loginUser.isDeveloper == 1}">
                    <li class="layui-nav-item">
                        <a href="javascript:;">系统说明</a>
                        <dl class="layui-nav-child">
                            <c:forEach items="${menu}" var="item" varStatus="status">
                                <c:if test="${item.menuType == 3}">
                                    <dd>
                                        <a data-url="${item.menuPath}" data-id="${item.menuId}"
                                           data-title="${item.menuName}" href="#" class="site-demo-active"
                                           data-type="tabAdd">${item.menuName}</a>
                                    </dd>
                                </c:if>
                            </c:forEach>
                        </dl>
                    </li>
                </c:if>
            </ul>
        </div>
    </div>
    <div class="layui-tab" lay-filter="demo" lay-allowclose="true" style="margin-left: 200px;">
        <ul class="layui-tab-title">
        </ul>
        <ul class="rightmenu" style="display: none;position: absolute;">
            <li data-type="closethis">关闭当前</li>
            <li data-type="closeall">关闭所有</li>
        </ul>
        <div class="layui-tab-content">
        </div>
    </div>
    <div class="layui-footer">
        谜苑天涯灯谜联赛 Ver 1.0.0
        Copyright 2008-${saiji}谜苑天涯
    </div>
</div>
<script src="/layui/layui.all.js"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function () {
        var $ = layui.jquery;
        var element = layui.element; //Tab的切换功能，切换事件监听等，需要依赖element模块

        //触发事件
        var active = {
            //在这里给active绑定几项事件，后面可通过active调用这些事件
            tabAdd: function (url, id, name) {
                //新增一个Tab项 传入三个参数，分别对应其标题，tab页面的地址，还有一个规定的id，是标签中data-id的属性值
                //关于tabAdd的方法所传入的参数可看layui的开发文档中基础方法部分
                element.tabAdd('demo', {
                    title: name,
                    content: '<iframe data-frameid="' + id + '" scrolling="auto" frameborder="0" src="' + url + '" style="width:100%;height:99%;"></iframe>',
                    id: id //规定好的id
                });
                // CustomRightClick(id); //给tab绑定右击事件
                FrameWH();  //计算ifram层的大小
            },
            tabChange: function (id) {
                //切换到指定Tab项
                element.tabChange('demo', id); //根据传入的id传入到指定的tab项
            },
            tabDelete: function (id) {
                element.tabDelete("demo", id);//删除
            },
            tabDeleteAll: function (ids) {//删除所有
                $.each(ids, function (i, item) {
                    element.tabDelete("demo", item); //ids是一个数组，里面存放了多个id，调用tabDelete方法分别删除
                })
            }
        };


        //当点击有site-demo-active属性的标签时，即左侧菜单栏中内容 ，触发点击事件
        $('.site-demo-active').on('click', function () {
            var dataid = $(this);

            //这时会判断右侧.layui-tab-title属性下的有lay-id属性的li的数目，即已经打开的tab项数目
            if ($(".layui-tab-title li[lay-id]").length <= 0) {
                //如果比零小，则直接打开新的tab项
                active.tabAdd(dataid.attr("data-url"), dataid.attr("data-id"), dataid.attr("data-title"));
            } else {
                //否则判断该tab项是否以及存在

                var isData = false; //初始化一个标志，为false说明未打开该tab项 为true则说明已有
                $.each($(".layui-tab-title li[lay-id]"), function () {
                    //如果点击左侧菜单栏所传入的id 在右侧tab项中的lay-id属性可以找到，则说明该tab项已经打开
                    if ($(this).attr("lay-id") == dataid.attr("data-id")) {
                        isData = true;
                    }
                })
                if (isData == false) {
                    //标志为false 新增一个tab项
                    active.tabAdd(dataid.attr("data-url"), dataid.attr("data-id"), dataid.attr("data-title"));
                }
            }
            //最后不管是否新增tab，最后都转到要打开的选项页面上
            active.tabChange(dataid.attr("data-id"));
        });

        function CustomRightClick(id) {
            //取消右键  rightmenu属性开始是隐藏的 ，当右击的时候显示，左击的时候隐藏
            $('.layui-tab-title li').on('contextmenu', function () {
                return false;
            })
            $('.layui-tab-title,.layui-tab-title li').click(function () {
                $('.rightmenu').hide();
            });
            //桌面点击右击
            $('.layui-tab-title li').on('contextmenu', function (e) {
                var popupmenu = $(".rightmenu");
                popupmenu.find("li").attr("data-id", id); //在右键菜单中的标签绑定id属性

                //判断右侧菜单的位置
                l = ($(document).width() - e.clientX) < popupmenu.width() ? (e.clientX - popupmenu.width()) : e.clientX;
                t = ($(document).height() - e.clientY) < popupmenu.height() ? (e.clientY - popupmenu.height()) : e.clientY;
                popupmenu.css({left: l, top: t}).show(); //进行绝对定位
                //alert("右键菜单")
                return false;
            });
        }

        $(".rightmenu li").click(function () {

            //右键菜单中的选项被点击之后，判断type的类型，决定关闭所有还是关闭当前。
            if ($(this).attr("data-type") == "closethis") {
                //如果关闭当前，即根据显示右键菜单时所绑定的id，执行tabDelete
                active.tabDelete($(this).attr("data-id"))
            } else if ($(this).attr("data-type") == "closeall") {
                var tabtitle = $(".layui-tab-title li");
                var ids = new Array();
                $.each(tabtitle, function (i) {
                    ids[i] = $(this).attr("lay-id");
                })
                //如果关闭所有 ，即将所有的lay-id放进数组，执行tabDeleteAll
                active.tabDeleteAll(ids);
            }

            $('.rightmenu').hide(); //最后再隐藏右键菜单
        })

        function FrameWH() {
            var h = $(window).height() - 41 - 10 - 60 - 10 - 44 - 10;
            $("iframe").css("height", h + "px");
        }

        $(window).resize(function () {
            FrameWH();
        })
    });

    layui.use('table', function () {
        var table = layui.table;

        //第一个实例
        table.render({
            elem: '#demo'
            , height: 800
            , url: '/dengmiTemp/toMySubject' //数据接口
            , page: true //开启分页
            , limits: [5, 10, 20, 50]
            , limit: 10
            , cols: [[ //表头
                {field: 'dmMimian', title: '谜面', sort: true, fixed: 'left'}
                , {field: 'dmMimu', title: '谜目'}
                , {field: 'dmMidi', title: '谜底', sort: true}
                , {field: 'dmMimianzhu', title: '谜面注解'}
                , {field: 'dmMidizhu', title: '谜底注解'}
            ]]
        });
    });

    $(function () {
        $(".layui-nav-child dd").on("click", function () {
            var address = $(this).attr("data-src");
            $("iframe").attr("src", address);
        });
    });

</script>
</body>

</html>