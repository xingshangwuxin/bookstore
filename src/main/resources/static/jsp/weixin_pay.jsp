<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/"; %>


<html>
<head>
    <title> 二维码 </title>
    <meta http-equiv="Content-Type"
          content="text/html;charset=UTF-8"/>


    <script src="../../js/qrious.min.js"></script>
</head>
<body>

<h1>总金额：${genPayCode.get("totalFee")}</h1>
<h1>交易订单号：${genPayCode.get("outTradeNo")}</h1>
<h1>商品详情：${genPayCode.get("description")}</h1>
<h1>打开微信扫一扫</h1>
<img id="qrious"/>
<script type="text/javascript">
    var qr = new QRious({
        element : document.getElementById("qrious"),
        size : 200,
        level : 'H',
        value : '${genPayCode.get("codeUrl")}'
    });
</script>
</body>
</html>