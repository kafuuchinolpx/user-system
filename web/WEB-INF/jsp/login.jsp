<%--
  Created by IntelliJ IDEA.
  User: 19070
  Date: 7/1/2020
  Time: 5:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/header.css" rel="stylesheet">

<body>
<form class="form-horizontal form-sy" action="login" method="post">
    <h2 class="form-signin-heading">用户管理系统</h2>
    <br>
    <br>
    <div class="form-group">
        <label for="inputEmail3" class="col-sm-2 control-label">账号</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="inputEmail3" name="loginName" placeholder="登录名" required>
        </div>
    </div>
    <div class="form-group">
        <label for="inputPassword3" class="col-sm-2 control-label">密码</label>
        <div class="col-sm-10">
            <input type="password" class="form-control" id="inputPassword3" name="loginPassword" placeholder="密码"
                   required>
        </div>
    </div>

    <div class="form-group">
        <label for="inputPassword4">验证码</label>
        <div class="col-sm-6">
            <input type="text" class="form-control" id="inputPassword4" name="verify" placeholder="验证码" required>
        </div>
        <label for="inputPassword4"><img src="verify" onclick="this.src='verify?'+Math.random()"></label>
    </div>
    <br>
    <br>
    <div class="form-group">
        <div class="col-sm-12">
            <p style="color: #ff3226">${prompt}</p>
            <button type="submit" class="btn btn-primary btn-block">登录</button>
        </div>
    </div>
</form>


<%@ include file="inc/footer.jsp" %>
</body>
</html>
