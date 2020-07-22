<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="inc/header.jsp" %>
<html>
<head>
    <title>角色编辑</title>
    <link href="../../css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<h2>RoleEdit</h2>
<div class="container">
    <form class="form-horizontal" action="" method="post">
<%--        <input name="id" value="${role.id}" hidden>--%>
        <div class="form-group">
            <label for="name" class="col-sm-2 control-label">权限名字</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="name" placeholder="姓名" name="name" value="${role.name}">
            </div>
        </div>
        <div class="form-group">
            <label for="remark" class="col-sm-2 control-label">备注</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="remark" placeholder="备注" name="remark"
                       value="${role.remark}">
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
