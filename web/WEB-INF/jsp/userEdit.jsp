
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户修改</title>
</head>
<body>
<%@ include file="inc/header.jsp" %>
<h2>UserEdit</h2>
<div class="container">
    <form class="form-horizontal" action="" method="post">
        <input name="id" value="${user.id}" hidden>
        <div class="form-group">
            <label for="name" class="col-sm-2 control-label">姓名</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="name" placeholder="姓名" name="name" value="${user.name}">
            </div>
        </div>
        <div class="form-group">
            <label for="loginName" class="col-sm-2 control-label">账号</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="loginName" placeholder="账号" name="loginName"
                       value="${user.loginName}">
            </div>
        </div>
        <div class="form-group">
            <label for="loginPassword" class="col-sm-2 control-label">密码</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="loginPassword" placeholder="密码" name="loginPassword"
                       value="${user.loginPassword}">
            </div>
        </div>
        <div class="form-group">
            <label for="role" class="col-sm-2 control-label">权限</label>
            <div class="col-sm-10">
                <select id="role" name="roleId" class="form-control">
                    <c:forEach items="${userList}" var="r">
                        <option ${user.role.id==r.id?'selected':''} value="${r.id}">${r.name}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">添加(修改)</button>
            </div>
        </div>
    </form>
</div>


<%@ include file="inc/footer.jsp" %>
</body>
</html>
