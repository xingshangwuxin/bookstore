<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>订单详情头部</title>
</head>
<body>


<jsp:include page="top.jsp"/>
<div class="container">
    <!--
        订单详情头部
    -->
    <div class="row orderheader">
        <div class="col-lg-2 col-md-4 col-sm-6 col-xs-12 img_div">
            <a href="index" target="_blank"><img src="img/logo.jpg" width="90%" alt="scutdhl.com"
                                                      style="margin-top: 20px"/></a>
        </div>
        <div class="col-lg-2 col-md-4 col-sm-6 col-xs-12 order_text_div">
            <span class="order_text_span">填写订单</span>
        </div>
        <div class="col-lg-8 col-md-12 col-sm-12 col-xs-12 process">
            <span class="order_text">我的购物车</span>
            <span class="order_text" id="this_process">填写订单</span>
            <span class="order_text">完成订单</span>
        </div>
    </div>
    <div class="clear"></div>

</div>
<div style="height: 3px; background-color: #ff2832;"></div>
</body>
</html>
