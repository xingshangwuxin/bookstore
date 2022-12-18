<%--suppress ALL --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/"; %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>无涯书城后台管理系统</title>
    <base href="<%=basePath%>">
    <link rel="stylesheet" href="css/bs.css"/>
    <style>
        body {
            /*加载背景图：图片地址 不平铺 */
            background: url(img/centerbackground.jpg) no-repeat center center;
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
<body style="height: 1000px" >
<iframe src="admin/home" style="width: 100%;height: 100%;margin: 0;padding: 0"></iframe>
</body>
</html>
