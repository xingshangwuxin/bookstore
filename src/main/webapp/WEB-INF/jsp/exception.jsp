<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/"; %>

<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>出错了！</title>
    <base href="<%=basePath%>">
    <script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/bs.css"/>
</head>
<body>
<jsp:include page="top.jsp"/>
<div class="container" align="center">
    <h2 class="h2">${url}</h2>
    <h2 class="h2">${exception}</h2>
</div>
</body>
</html>
