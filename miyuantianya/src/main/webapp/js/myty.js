// // layUI获取元素值：var pvalue = $("input[name='password']").val(); name属性为password的input的值
// layui.use(['form'], function(){
//     var form = layui.form;
//     //自定义验证规则，元素使用lay-verify绑定校验规则，不同的校验规则 用逗号间隔，可以使用自定义方法
//     form.verify({
//         pass: [/(.+){6,12}$/, '密码必须6到12位']
//     });
//     //监听提交,也就是在点击按钮，提交到后台之前的操作
//     form.on('submit(login)', function(data){
//         console.log(data);
//     });
// });
//
// function show() {
//     //创建内置Date对象
//     var date = new Date();
//     //获取当前年份
//     var year = date.getFullYear();
//     //获取当前的月份,范围是0-11
//     var month = date.getMonth() + 1;
//     if(month < 10){
//         month = "0" + month;
//     }
//     //获取该月的第几天
//     var day = date.getDate();
//     if(day < 10){
//         day = "0" + day;
//     }
//     //getDay方法获取当前是这个星期的第几天范围是0-6
//     //周日对应0，123456分别是对应的星期几
//     var week = "日一二三四五六".charAt(date.getDay());
//     //获取当前小时分钟和秒
//     var hour = date.getHours();
//     if(hour < 10){
//         hour = "0"+hour;
//     }
//     var minute = date.getMinutes();
//     if(minute < 10){
//         minute = "0"+minute;
//     }
//     var second = date.getSeconds();
//     if(second < 10){
//         second = "0"+second;
//     }
//     //选择id为time的标签
//     var element = document.getElementById("showTime");
//     element.innerHTML = year+"-"+month+"-"+day+" "+"星期"+week+"	"+hour+":"+minute+":"+second;
// }
// show();
// //每间隔1000毫秒执行一次程序，保证时间动态显示
// setInterval("show()",1000);
