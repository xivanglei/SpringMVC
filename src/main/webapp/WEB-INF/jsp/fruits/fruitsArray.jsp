<%--
  Created by IntelliJ IDEA.
  User: xianglei
  Date: 2019-02-17
  Time: 10:50
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
    <form action="fruitsArrayTest.action" method="post">
        <table width="300px;" border="1">
            <tr>
                <td>选择</td>
                <td>名称</td>
                <td>价格</td>
                <td>产地</td>
            </tr>
            <c:forEach items="${fruitsList}" var="fruit">
                <tr>
                    <td><input type="checkbox" name="fids" value="${fruit.id}"></td>
                    <td>${fruit.name}</td>
                    <td>${fruit.price}</td>
                    <td>${fruit.producing_area}</td>
                </tr>
            </c:forEach>
        </table>
        <br>
        <input type="submit" value="批量测试提交">
    </form>
</body>
</html>
