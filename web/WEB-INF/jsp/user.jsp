<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户管理</title>
    <link href="../../css/bootstrap.min.css" rel="stylesheet">
    <%@ include file="inc/header.jsp" %>
</head>
<body>

<h2 class="sub-header">Section title</h2>
<div class="container">
    <div class="row">
        <a href="userEdit" type="button" class="btn btn-success">
            添加
        </a>
        <div class="input-group" style="float: right;width: 30%">
            <input type="text" class="form-control" placeholder="姓名" id="search" oninput="searchName()">
            <span class="input-group-btn">
                </span>
        </div>
    </div>
</div>
<table class="table table-striped">
    <thead>
    <tr>
        <th>ID</th>
        <th>姓名</th>
        <th>登录名</th>
        <th>密码</th>
        <th>角色</th>
        <th>创建时间</th>
        <th>修改时间</th>
        <th>编辑</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${users.list}" var="r">
        <tr>
            <td>${r.id}</td>
            <td>${r.name}</td>
            <td>${r.loginName}</td>
            <td>${r.loginPassword}</td>
            <td>${r.role.name}</td>
            <td>${r.createTime}</td>
            <td>${r.updateTime}</td>
            <td>
                <a href="userEdit?id=${r.id}" type="button" class="btn btn-info btn-sm">修改</a>
                <a href="user?id=${r.id}" type="button" class="btn btn-danger btn-sm">删除</a>
            </td>
        </tr>
    </c:forEach>

    </tbody>
</table>
<nav aria-label="...">
    <ul class="pagination">
        <li class=""><a href="user?page=1" aria-label="Previous"><span aria-hidden="true">首页</span></a></li>
        <c:forEach begin="1" end="${users.pageCount}" step="1" var="index">
            <li class="${users.page==index?'active':''}"><a href="user?page=${index}&name=${name}">${index}<span
                    class="sr-only">(current)</span></a>
            </li>
        </c:forEach>
        <li><a href="user?page=${users.pageCount}" aria-label="Next"><span aria-hidden="true">末尾</span></a></li>
    </ul>
</nav>
</div>

<%@ include file="inc/footer.jsp" %>
<script>
    function searchName() {
        location.href = "user?name=" + $("#search").val()
    }
</script>
</body>
</html>
</div>