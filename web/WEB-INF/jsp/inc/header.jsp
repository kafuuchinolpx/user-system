<%--
  Created by IntelliJ IDEA.
  User: 19070
  Date: 6/29/2020
  Time: 3:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>


<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="${pageContext.request.contextPath}/index">chino员工管理系统</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <ul class="nav navbar-nav">
                    <c:forEach items="${loginRole.resources}" var="r">
                        <c:if test="${ r.pid == 0}">
                            <li class="${pageContext.request.requestURI.endsWith(r.url.concat(".jsp"))?'active':''}">
                                <a href="${pageContext.request.contextPath}${r.url}">${r.name}</a>
                            </li>
                        </c:if>
                    </c:forEach>
                </ul>
<%--                <li><a href="${pageContext.request.contextPath}/user">用户管理</a></li>--%>
<%--                <li><a href="${pageContext.request.contextPath}/role">角色管理</a></li>--%>
<%--                <li><a href="${pageContext.request.contextPath}/setting">设置</a></li>--%>
<%--                <li><a href="${pageContext.request.contextPath}/help">帮助</a></li>--%>
<%--                <li><a href="${pageContext.request.contextPath}/login">登录</a></li>--%>
                <li><a>${loginUser.name}</a></li>
                <li><a href="${pageContext.request.contextPath}/logout">注销</a></li>
            </ul>
            <form class="navbar-form navbar-right">
                <input type="text" class="form-control" placeholder="搜索">
            </form>
        </div>
    </div>
</nav>

</nav>
</body>
</html>
