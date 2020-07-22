<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>资源编辑</title>
</head>
<body>
<%@ include file="inc/header.jsp" %>
<h2>resourceEdit</h2>

<div class="container">
    <form class="form-horizontal" action="" method="post">
        <input name="id" value="${resource.id}" hidden>

        <div class="form-group">
            <label for="name" class="col-sm-2 control-label">角色名</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="name" placeholder="角色名" name="name"
                       value="${resource.name}">
            </div>
        </div>
        <div class="form-group">
            <label for="url" class="col-sm-2 control-label">地址</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="url" placeholder="url" name="url"
                       value="${resource.url}">
            </div>
        </div>
        <div class="form-group">
            <label for="url" class="col-sm-2 control-label">地址</label>
            <div class="col-sm-10">
                <select name="pid" class="form-control">
                    <option value="0">根节点</option>
                    <c:forEach items="${resourceList}" var="r">
                        <option value="${r.id}">${r.name}</option>
                    </c:forEach>

                </select>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">保存</button>
            </div>
        </div>
    </form>
</div>


<%@ include file="inc/footer.jsp" %>

</body>
</html>
