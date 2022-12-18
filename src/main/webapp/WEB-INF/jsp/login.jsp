<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <base href="<%=basePath%>">
    <title>登录</title>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
    <link rel="stylesheet" type="text/css" href="css/bs.css"/>
    <script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="js/jquery.validate.js"></script>
    <script type="text/javascript" src="js/messages_zh.js"></script>

    <script>
        $(function () {
            $("#loginForm").validate({
                rules: {
                    username: "required",
                    password: {
                        rangelength: [3, 15],
                        required: true
                    }
                },
                errorPlacement: function (error, element) {	//错误信息位置设置方法
                    error.appendTo(element.parent().next());//这里的element是录入数据的对象,parent父元素，next()下一个
                },
                success: function (label) {
                    label.addClass("error");
                },
                messages: {
                    username: "用户名不能为空",
                    password: {
                        rangelength: "密码长度在{0}~{1}之间",
                        required: "密码不能为空"
                    }
                }
            });
        })
    </script>
    <style>
        body {
            /*加载背景图：图片地址 不平铺 */
            background: url(img/loginbackground.jpg) no-repeat center center;
            /* 让背景图基于容器大小伸缩 */
            background-size: cover;
            /* background-attachment设置背景图像是否固定或者随着页面的其余部分滚动。
                scroll 背景图片随着页面的滚动而滚动，这是默认的。
                 fixed 背景图片不会随着页面的滚动而滚动。
                  local 背景图片会随着元素内容的滚动而滚动。*/
            background-attachment: fixed;
        }
    </style>
</head>
<body background="img/loginbackground.jpg">
<jsp:include page="loginRegister_above.jsp"/>

<div  >
    <shiro:notAuthenticated>

    <form action="<%=basePath%>user/login" method="post" id="loginForm">
        <div id="register" style="color: white">密码登录</div>
        <div id="username_div">
            <span id="row1"></span>
            <input type="text" name="username" id="username" placeholder="用户名" style="color: white"/>
        </div>
        <p class="tips">
        </p>
        <div id="password_div">
            <span id="row2"></span>
            <input type="password" name="password" id="password" placeholder="密码" style="color: white"/>
        </div>
        <p class="tips">
        </p>

        <input type="submit" id="loginButton" value="登录"/>
        <div class="margin">
            <span style="color: white">记住我</span>
            <input type="checkbox" name="rememberMe" value="rememberMe"/>
            <span class="error">${loginMsg}</span>
        </div>
        <div class="margin">
            <span class="a"><a href="page/register" title="注册" target="_blank" style="color: white">注册</a></span>
            <span class="a"><a href="" title="忘记密码?" style="color: white">找回密码</a></span>
        </div>
    </form>
    </shiro:notAuthenticated>
    <shiro:user>
        <div id="loginForm">
            <div>
                <div style="font-size: 20px">您已经登录,<a href="user/info"><shiro:principal property="username"/></a></div>
                <div style="font-size: 18px"><a href="user/logout" >注销</a></div>
            </div>
        </div>

    </shiro:user>
</div>

<hr size="2" color="#E6E6E6"/>
</body>
</html>
