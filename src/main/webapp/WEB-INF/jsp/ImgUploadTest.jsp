<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/20/0020
  Time: 下午 21:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8"/>
    <title>上传图片测试</title>
</head>
<body>
    <form action="uploadImg.action" method="post" enctype="multipart/form-data">
        <c:if test="${image != null}">
            <img src="/pic/${image}" width=100 height=100/><br>
        </c:if>
        <input type="file" name="file"><br>
        <input type="submit" value="上传">
    </form>
</body>
</html>
