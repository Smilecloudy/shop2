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
    <!-- 引入自定义css文件 style.css -->
    <link rel="stylesheet" href="css/style.css" type="text/css"/>

    <style>
        body {
            margin-top: 20px;
            margin: 0 auto;
        }

        .carousel-inner .item img {
            width: 100%;
            height: 300px;
        }

        font {
            color: #3164af;
            font-size: 18px;
            font-weight: normal;
            padding: 0 10px;
        }
    </style>
</head>
<body>

<!-- 引入header.jsp -->
<jsp:include page="/header.jsp"></jsp:include>

<div class="container"
     style="width: 100%; background: url('image/regist_bg.jpg');">
    <div class="row">
        <div class="col-md-2"></div>
        <div class="col-md-8"
             style="background: #fff; padding: 40px 80px; margin: 30px; border: 7px solid #ccc;">
            <font>会员注册</font>USER REGISTER
            <form
                    class="form-horizontal"
                    style="margin-top: 5px;"
                    action="${pageContext.request.contextPath}/user/register"
                    method="POST">
                <div class="form-group">
                    <label for="username" class="col-sm-2 control-label">用户名</label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" id="username"
                               placeholder="请输入用户名" name="username" onblur="checkUserName()">
                        <span id="usernameMsg"></span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="password" class="col-sm-2 control-label">密码</label>
                    <div class="col-sm-6">
                        <input type="password" class="form-control" id="password"
                               placeholder="请输入密码" name="password" value="" onblur="checkPassword()">
                    </div>
                </div>
                <div class="form-group">
                    <label for="confirmpwd" class="col-sm-2 control-label">确认密码</label>
                    <div class="col-sm-6">
                        <input type="password" class="form-control" id="confirmpwd"
                               placeholder="请输入确认密码" value="123456">
                    </div>
                </div>
                <div class="form-group">
                    <label for="email" class="col-sm-2 control-label">Email</label>
                    <div class="col-sm-6">
                        <input type="email" class="form-control" id="email"
                               placeholder="Email" name="email" value="caoyunbo@it.com" onblur="checkEmail()">
                    </div>
                </div>
                <div class="form-group">
                    <label for="telephone" class="col-sm-2 control-label">手机号</label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" id="telephone"
                               placeholder="请输入手机号" name="telephone" value="13512345678" onblur="checkPhone()">
                    </div>
                </div>
                <div class="form-group">
                    <label for="name" class="col-sm-2 control-label">姓名</label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" id="name"
                               placeholder="请输入姓名" name="name" value="小娃" onblur="checkName()">
                    </div>
                </div>
                <div class="form-group opt">
                    <label for="male" class="col-sm-2 control-label">性别</label>
                    <div class="col-sm-6">
                        <label class="radio-inline"> <input type="radio"
                                                            name="sex" id="male" value="男" checked="checked">
                            男
                        </label> <label class="radio-inline"> <input type="radio"
                                                                     name="sex" id="female" value="女">
                        女
                    </label>
                    </div>
                </div>
                <div class="form-group">
                    <label for="birthday" class="col-sm-2 control-label">出生日期</label>
                    <div class="col-sm-6">
                        <input type="date" class="form-control"
                               id="birthday" name="birthday" value="" onblur="checkBirthday()">
                    </div>
                </div>


                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <input type="submit" width="100" value="注册" name="submit"
                               style="background: url('./images/register.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0); height: 35px; width: 100px; color: white;">
                    </div>
                </div>
            </form>
        </div>

        <div class="col-md-2"></div>

    </div>
</div>

<!-- 引入footer.jsp -->
<jsp:include page="/footer.jsp"></jsp:include>
<script type="text/javascript">
    function checkUserName() {
        var username = $("#username").val();
        var regExp = /^[a-zA-Z0-9]{4,10}$/;
        var flag = false;
        /*
        First determine whether username is null, and then determine whether it meets regExp.
         */
        if (username == "" || username == null) {
            $("#usernameMsg").html("用户名不能为空")  ;
            $("#usernameMsg").css("color", "red");
            flag = false;
        } else if (!regExp.test(username)) {
            $("#usernameMsg").html("用户名不符合规范")  ;
            $("#usernameMsg").css("color", "red");
            flag = false;
        } else {
            var data = $("#username").val();
            $.ajax({
                type: "post",
                url: "${pageContext.request.contextPath}/user/checkUserName",
				data:data,
				contentType:"text/html",
                dataType:"json",
				success:function (map) {
					var flag = map.flag;
					var msg = map.msg;
                    $("#usernameMsg").html(msg) ;
                    $("#usernameMsg").css("color","green");
                    flag = true;
				},
				error:function () {
					alert("error");
                    flag = false;
				}
            });
        }
        return flag;
    }

    function checkPassword() {
        var flag = false;
        var regExp = /^\w\d{6,12}$/;
    }

    function checkEmail() {

    }

    function checkPhone() {

    }

    function checkName() {

    }

    function checkBirthday() {

    }
</script>

</body>
</html>




