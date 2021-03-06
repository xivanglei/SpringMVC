<%--
  Created by IntelliJ IDEA.
  User: xianglei
  Date: 2019-02-16
  Time: 14:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>水果列表</title>
</head>
<body>
<h3>新鲜水果</h3>
<table width="300px;" border="1">
    <form action="queryFruitsByCondition.action" method="post">
            名称: <input type="text" name="name"/>&nbsp;&nbsp;
            产地: <input type="text" name="producing_area"/>
        <input type="submit" value="搜索">
    </form>
    <hr/>
    <c:if test="${allErrors != null}">
        <c:forEach items="${allErrors}" var="error">
            <font color="red">${error.defaultMessage}</font>
            <br>
        </c:forEach>
    </c:if>
    <h3>搜索结果</h3>
    <tr>
        <th>名称</th>
        <th>价格</th>
        <th>产地</th>
    </tr>
    <c:forEach items="${fruitsList }" var="fruit">
        <tr>
            <td>${fruit.name }</td>
            <td>${fruit.price }</td>
            <td>${fruit.producing_area }</td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
