<%--
  Created by IntelliJ IDEA.
  User: L
  Date: 2020/6/12
  Time: 14:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录注册界面</title>
</head>
<body>
<form action="loginServlet"  method="post"  style="padding-top:-700px;">
    用户名：<input type="text" name="user_name"value=""><br><br>
    密码：  <input type="password" name="user_password"value=""><br><br>
    <input type="submit"value="登录"name="login"><input type="reset"value="重置"><br>
</form>

<form action="register.jsp">
    <input type="submit"value="新用户注册">
</form>
</body>
</html>
