<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<!-- 登录 注册 购物车... -->
<div class="container-fluid">
    <div class="col-md-4">
        <img src="img/logo2.png"/>
    </div>
    <div class="col-md-5">
        <img src="img/header.png"/>
    </div>
    <div class="col-md-3" style="padding-top:20px">
        欢迎[${!empty user ? user.username : "游客"}]光临<br/>
        <ol class="list-inline">
            <c:choose>
                <c:when test="${!empty user}">
                    <li><a href="cart.jsp">购物车</a></li>
                    <li><a href="order_list.jsp">我的订单</a></li>
                    <li><a href="${pageContext.request.contextPath}/user/logout">退出</a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="login.jsp">登录</a></li>
                    <li><a href="register.jsp">注册</a></li>
                </c:otherwise>
            </c:choose>


        </ol>
    </div>
</div>

<!-- 导航条 -->
<div class="container-fluid">
    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                        data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="default.jsp">首页</a>
            </div>

            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav" id="categoryid">

                    <script>
                        $(function () {
                            $.ajax({
                                type: "get",
                                url: "${pageContext.request.contextPath}/findAllCategory",
                                dataType: "json",
                                error: function () {
                                    alert("出错了");
                                }, success: function (categories) {
                                    $(categories).each(function (index, category) {
                                        var cid = category.cid;
                                        var cname = category.cname;
                                        var li = '<li><a href="${pageContext.request.contextPath}/findProductByCid?cid='+cid+'">' + cname + '</a></li>'
										$("#categoryid").append(li);
                                    });
                                }
                            });

                        });
                    </script>

                    <%--<li class="active"><a href="product_list.jsp">手机数码<span class="sr-only">(current)</span></a></li>
                    <li><a href="#">电脑办公</a></li>
                    <li><a href="#">电脑办公</a></li>
                    <li><a href="#">电脑办公</a></li>--%>
                </ul>
                <form class="navbar-form navbar-right" role="search">
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="Search">
                    </div>
                    <button type="submit" class="btn btn-default">Submit</button>
                </form>
            </div>
        </div>
    </nav>
</div>