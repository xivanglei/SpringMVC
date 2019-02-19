<%--
  Created by IntelliJ IDEA.
  User: xianglei
  Date: 2019-02-19
  Time: 08:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>提示</title>
</head>
<body>
    <img src="${pageContext.request.contextPath}/image/error.jpg" width="50px;" height="50px;"/>
        <br>
        抱歉，访问异常，具体信息如下:<br>
    <h2><font color="red">${message}</font> </h2><br>
</body>
</html>
