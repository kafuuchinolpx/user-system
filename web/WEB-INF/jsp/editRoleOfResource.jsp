<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>授权</title>
</head>
<body>
<%@ include file="inc/header.jsp" %>
<div class="container">
    <div class="row">
        <h2>RoleOfResource</h2>
        <h1>资源授权</h1>
    </div>
    <div class="row">
        <table class="table table-hover">
            <thead>
            <tr>
                <th>ID</th>
                <th>名字</th>
                <th>状态</th>
                <th>编辑</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${role.resources}" var="u">
                <tr>
                    <td>${u.id}</td>
                    <td>${u.name}</td>
                    <td>已授权</td>
                    <td>
                        <button class="btn btn-warning btn-sm" onclick="authorize(${u.id},${role.id})">
                            取消授权
                        </button>
                    </td>
                </tr>
            </c:forEach>
            <c:forEach items="${notHaveResources}" var="u">
                <tr>
                    <td>${u.id}</td>
                    <td>${u.name}</td>
                    <td>未授权</td>
                    <td>
                        <button  class="btn btn-primary btn-sm" onclick="authorize(${u.id},${role.id})">
                            授权
                        </button>
                    </td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
    </div>
</div>
<%@ include file="inc/footer.jsp" %>


<script>
    function authorize(resourceId,roleId) {
        $.post("authorize", {resourceId: resourceId,roleId:roleId}, function (response) {
            var obj = JSON.parse(response)
            if (obj.code == 200) {
                location.reload();
            }else {
                alert(obj.msg);
            }
        })
    }
</script>
</body>
</html>
