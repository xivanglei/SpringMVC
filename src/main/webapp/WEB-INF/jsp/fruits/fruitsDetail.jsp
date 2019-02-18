<%--
  Created by IntelliJ IDEA.
  User: xianglei
  Date: 2019-02-16
  Time: 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>查询水果</title>
</head>
<body>
<h3>新鲜水果</h3>
<table width="300px;" border="1">
    <tr>
        <th>名称</th>
        <th>价格</th>
        <th>产地</th>
    </tr>
    <tr>
        <td>${fruit.name }</td>
        <td>${fruit.price }</td>
        <td>${fruit.producing_area }</td>
    </tr>
</table>
</body>
</html>
