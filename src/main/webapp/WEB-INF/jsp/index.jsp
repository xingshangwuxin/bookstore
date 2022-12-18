<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${applicationScope.globalParameter.webName}</title>

    <base href="<%=basePath%>">
    <script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <%--    为网页标题加图标--%>
    <link rel="shortcut icon" href="img/tubiao.jpg" type="image/x-icon"/>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/bs.css"/>

</head>

<body>
<jsp:include page="header.jsp"/>
<div class="container" style="margin-top:10px ;">
    <div class="row" style="height: 850px;">
        <div class="col-lg-3 col-md-4 col-sm-6 col-xs-12 sort" style="width: 10%;height: 100%;padding: 0;">
            <div id="sort_header">
                <span>图书分类</span>
            </div>
<%--            首页左侧展示书的分类--%>
            <ul id="sort_ul">
<%--                bookCategories是取得的列表，bookCat是列表中的每一项--%>
                <c:forEach items="${bookCategories}" var="bookCat">
                    <li class="sort_li">
                        <a href="book/list?cateId=${bookCat.cateId}">${bookCat.name}</a>
                        <span class="sort_span">></span>
                    </li>
                </c:forEach>
            </ul>
        </div>
        <div class="col-lg-6 col-md-4 col-sm-6 col-xs-12" style="width: 65%;height: 100%;">

            <div id="myCarousel" class="carousel slide">
                <!-- 轮播（Carousel）指标 data-target="#myCarousel"-->
                <ol class="carousel-indicators">
                    <li   data-slide-to="0"
                        class="active"></li>
                    <li  data-slide-to="1"></li>
                    <li  data-slide-to="2"></li>
                    <li  data-slide-to="3"></li>
                    <li  data-slide-to="4"></li>
                </ol>
                <!-- 轮播（Carousel）项目 -->
                <div class="carousel-inner">
                    <div class="item active">
                        <img src="img/lunbo1.jpg" alt="First slide">
                    </div>
                    <div class="item">
                        <img src="img/lunbo2.jpg" alt="Second slide">
                    </div>
                    <div class="item">
                        <img src="img/lunbo3.jpg" alt="Third slide">
                    </div>
                    <div class="item">
                        <img src="img/lunbo4.jpg" alt="Fourth slide">
                    </div>
                    <div class="item">
                        <img src="img/lunbo5.jpg" alt="Fifth slide">
                    </div>
                </div>
                <!-- 轮播（Carousel）导航 -->
<%--                左边的轮播导航--%>
                <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
                    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <%--                右边的轮播导航--%>
                <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
                    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>
            <div class="index_product_top">
                <span class="title">好书推荐</span>
                <div class="div_hr"></div>
            </div>
            <div class="product_div">
                <ul class="product_ul">
<%--                    //首页取bookinfo--%>
                    <c:forEach items="${bookInfos}" begin="0" end="11" var="bookInfo">

                        <li class="product_li">
                            <a href="book/info/${bookInfo.bookId}" class="img" target="_blank">
                                <img src="${bookInfo.imageUrl}"/>
                            </a>
                            <p class="name">
                                <a href="book/info/${bookInfo.bookId}">${bookInfo.name}</a>
                            </p>
                            <p class="author">${bookInfo.author}</p>
                            <p class="price">
                                <span class="rob">￥${bookInfo.price}</span>
                                <span class="oprice">￥${bookInfo.marketPrice}</span>
                            </p>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>

        <div class="col-lg-3 col-md-4 col-sm-6 col-xs-12" style="width: 25%;height: 100%; padding: 0;">
            <div class="news">
                <p class="title">每日一学</p>
                <ul>
                    <li>《观书有感》</li>
                    <li>宋·朱熹</li>
                    <li>半亩方塘一鉴开，天光月影共徘徊。</li>
                    <li>问渠那得清如许，为有源头活水来。</li>
                </ul>
            </div>
            <div class="quotes">
                <p class="title"></p>
                <ul>
                    <li>吾日三省吾身</li>
                    <li>为人谋而不忠乎？</li>
                    <li>与朋友交而不信乎？</li>
                    <li>传不习乎？</li>
                </ul>
                <br />
                <br />
                <p class="title"></p>
                <ul>
                    <li>读书有三到，谓心到，眼到，口到。</li>
                    <li>心不在此，则眼看不仔细，</li>
                    <li>心眼既不专一，却只漫浪诵读；</li>
                    <li>决不能记，久也不能久也。</li>
                    <li>三到之中，心到最急；</li>
                    <li>心既到矣，眼口岂不到乎？</li>
                </ul>
            </div>
        </div>
    </div>
    <div class="row" style="margin-top: 30px;height: 500px;">
        <div class="col-lg-10 col-md-12 col-sm-12 col-xs-12" style="width: 82.5%;padding-left: 0;">
</div>
</div>

<div style="height: 3px; background-color: #ff2832;"></div>

<jsp:include page="footer.jsp"/>
</body>

</html>