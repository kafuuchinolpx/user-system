<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>资源管理</title>
</head>
<body>
<%@ include file="inc/header.jsp" %>
<h2 class="sub-header">Section title</h2>
<div class="container">
    <div class="row">
        <div class="col-sm-12">
            <h1>资源管理</h1>
            <a href="resourceEdit" type="button" class="btn btn-success">添加</a>
        </div>
    </div>

    <div class="row">
        <div class="col-sm-12" style="margin-top: 20px">
            <ul class="media-list">
                <c:forEach items="${resourceList}" var="r">
                <li class="media">
                    <div class="media-left">

                        <a href="resourceEdit?id=${r.id}" class="btn btn-info btn-sm">
                            修改
                        </a>
                        <a href="resource?id=${r.id}" class="btn btn-danger btn-sm">
                            删除
                        </a>

                    </div>
                    <div class="media-body">
                        <h4 class="media-heading">${r.name}</h4>
                        <p>${r.url}</p>
                        <c:forEach items="${r.son}" var="s">
                            <div class="media">
                                <div class="media-left">
                                    <a href="resourceEdit?id=${s.id}" class="btn btn-info btn-sm">
                                        修改
                                    </a>
                                    <a href="resource?id=${s.id}" class="btn btn-danger btn-sm">
                                        删除
                                    </a>
                                </div>
                                <div class="media-body">
                                    <h4 class="media-heading">${s.name}</h4>
                                    <p>${s.url}</p>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </li>
                </c:forEach>
        </div>
    </div>
</div>

<%@ include file="inc/footer.jsp" %>
</body>
</html>
