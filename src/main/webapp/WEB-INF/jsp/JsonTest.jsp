<%--
  Created by IntelliJ IDEA.
  User: xianglei
  Date: 2019-02-21
  Time: 10:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Json Test</title>
</head>
<body>
    <textarea id="jsonMsg" cols="30" rows="5" placeholder="请输入json格式信息"></textarea>
    <br><button onclick="submitJsonMsg()">发送Json数据</button>
    <button onclick="submitKeyValueMsg()">发送键值对数据</button>
</body>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript">

        function submitJsonMsg() {
            var message = $('#jsonMsg').val();
            $.ajax({
                type:'post',
                url:'${pageContext.request.contextPath}/JsonTest.action',
                contentType:'application/json;charset=utf-8',
                data:message,
                success:function (data) {
                    alert("username=" + data["username"] + ",password=" + data["password"]);
                }
            });
        }

        function submitKeyValueMsg() {
            var message = $('#jsonMsg').val();
            $.ajax({
                type:'post',
                url:'${pageContext.request.contextPath}/KeyValueTest.action',
                data:message,
                success:function (data) {
                    alert("username=" + data["username"] + ",password=" + data["password"]);
                }
            });
        }

    </script>
</html>
