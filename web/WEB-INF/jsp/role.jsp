<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="inc/header.jsp" %>

<html>
<head>
    <link href="../../css/bootstrap.min.css" rel="stylesheet">
    <title>角色管理</title>
</head>
<body>

<h2 class="sub-header">Section title</h2>
<div class="container">
    <div class="row">
        <a href="roleEdit" type="button" class="btn btn-success">
            添加
        </a>
        <a href="resource" type="button" class="btn btn-success">
            资源管理
        </a>
    </div>
</div>
<table class="table table-striped">
    <thead>
    <tr>
        <th>权限名字</th>
        <th>备注</th>
        <th>创建时间</th>
        <th>修改时间</th>
        <th>编辑</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${role}" var="r">
    <tr>
        <td>${r.name}</td>
        <td>${r.remark}</td>
        <td>${r.createTime}</td>
        <td>${r.updateTime}</td>
        <td>
            <a href="editRoleOfResource?id=${r.id}" type="button" class="btn btn-success btn-sm">权限</a>
            <a href="roleEdit?id=${r.id}" type="button" class="btn btn-info btn-sm">修改</a>
            <a href="role?id=${r.id}" type="button" class="btn btn-danger btn-sm">删除</a>
        </td>
    </tr>
    </c:forEach>
    <%@ include file="inc/footer.jsp" %>
</body>
</html>
