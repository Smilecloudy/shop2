<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title></title>
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css"/>
    <script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
    <script src="js/bootstrap.min.js" type="text/javascript"></script>
</head>

<body>
<div class="container-fluid">

    <!-- 引入header.jsp -->
    <jsp:include page="/header.jsp"></jsp:include>

    <!-- 轮播图 -->
    <div class="container-fluid">
        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
            <!-- 轮播图的中的小点 -->
            <ol class="carousel-indicators">
                <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                <li data-target="#carousel-example-generic" data-slide-to="2"></li>
            </ol>
            <!-- 轮播图的轮播图片 -->
            <div class="carousel-inner" role="listbox">
                <div class="item active">
                    <img src="img/1.jpg">
                    <div class="carousel-caption">
                        <!-- 轮播图上的文字 -->
                    </div>
                </div>
                <div class="item">
                    <img src="img/2.jpg">
                    <div class="carousel-caption">
                        <!-- 轮播图上的文字 -->
                    </div>
                </div>
                <div class="item">
                    <img src="img/3.jpg">
                    <div class="carousel-caption">
                        <!-- 轮播图上的文字 -->
                    </div>
                </div>
            </div>

            <!-- 上一张 下一张按钮 -->
            <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
    </div>

    <!-- 热门商品 -->
    <div class="container-fluid">
        <div class="col-md-12">
            <h2>热门商品&nbsp;&nbsp;<img src="img/title2.jpg"/></h2>
        </div>
        <div class="col-md-2" style="border:1px solid #E7E7E7;border-right:0;padding:0;">
            <img src="products/hao/big01.jpg" width="205" height="404" style="display: inline-block;"/>
        </div>
        <div class="col-md-10" id="hotProduct">
            <%--<div class="col-md-6" style="text-align:center;height:200px;padding:0px;">
                <a href="product_info.htm">
                    <img src="products/hao/middle01.jpg" width="516px" height="200px" style="display: inline-block;">
                </a>
            </div>--%>
            <script>
                $(function () {
                    $.ajax({
                        type: "get",
                        url: "${pageContext.request.contextPath}/findHotProduct",
                        dataType: "json",
                        error: function () {
                            alert("出错了");
                        }, success: function (hotProductList) {
                            $(hotProductList).each(function (index, hotProduct) {
                                var pid = hotProduct.pid;
                                var pname = hotProduct.pname;
                                var pimage = hotProduct.pimage;
                                var shop_price = hotProduct.shop_price;

                                var div = '<div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">\n' +
                                    '\t\t\t\t\t\t\t\t\t\t\t<a href="${pageContext.request.contextPath}/findProductByPid?pid='+pid+'">\n' +
                                    '\t\t\t\t\t\t\t\t\t\t\t<img src="' + pimage + '" width="130" height="130" style="display: inline-block;">\n' +
                                    '\t\t\t\t\t\t\t\t\t\t\t</a>\n' +
                                    '\t\t\t\t\t\t\t\t\t\t\t<p><a href="${pageContext.request.contextPath}/findProductByPid?pid='+pid+'" style=\'color:#666\'>' + pname + '</a></p>\n' +
                                    '\t\t\t\t\t\t\t\t\t<p><font color="#E4393C" style="font-size:16px">&yen;' + shop_price + '</font></p>\n' +
                                    '\t\t\t\t\t\t\t\t\t</div>';
                                $("#hotProduct").append(div);
                            });

                        }
                    });
                })
            </script>

        </div>
    </div>

    <!-- 广告条 -->
    <div class="container-fluid">
        <img src="products/hao/ad.jpg" width="100%"/>
    </div>

    <!-- 最新商品 -->
    <div class="container-fluid">
        <div class="col-md-12">
            <h2>最新商品&nbsp;&nbsp;<img src="img/title2.jpg"/></h2>
        </div>
        <div class="col-md-2" style="border:1px solid #E7E7E7;border-right:0;padding:0;">
            <img src="products/hao/big01.jpg" width="205" height="404" style="display: inline-block;"/>
        </div>
        <div class="col-md-10" id="newProduct">
        <script>
            $(function () {
                $.ajax({
                    type: "get",
                    url: "${pageContext.request.contextPath}/findNewProduct",
                    dataType: "json",
                    error: function () {
                        alert("出错了");
                    }, success: function (newProductList) {
                        $(newProductList).each(function (index, product) {
                            var pid = product.pid;
                            var pimage = product.pimage;
                            var pname = product.pname;
                            var shop_price = product.shop_price;

                            var div = '<div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">\n' +
                                '            <a href="${pageContext.request.contextPath}/findProductByPid?pid='+pid+'">\n' +
                                '                <img src="'+pimage+'" width="130" height="130" style="display: inline-block;">\n' +
                                '            </a>\n' +
                                '            <p><a href="${pageContext.request.contextPath}/findProductByPid?pid='+pid+'" style=\'color:#666\'>'+pname+'</a></p>\n' +
                                '            <p><font color="#E4393C" style="font-size:16px">&yen;'+shop_price+'</font></p>\n' +
                                '        </div>';
                            $("#newProduct").append(div);
                        });
                    }
                });
            })
        </script>

    </div>
</div>

<!-- 引入footer.jsp -->
<jsp:include page="/footer.jsp"></jsp:include>

</div>
</body>

</html>