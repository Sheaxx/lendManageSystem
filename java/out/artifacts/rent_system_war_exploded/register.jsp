<%--
  Created by IntelliJ IDEA.
  User: L
  Date: 2020/5/25
  Time: 22:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
    <title>注册界面</title>
</head>
<body>

<form action="registerServlet"method="post" style="padding-top:-700px;">
    输入用户名:<input name="user_name" type="text"><br><br>
    输入用户密码:<input name="user_password" type="password"><br><br>


    <input type="reset"value="重置"><input type="submit"value="注册">
</form>

</body>
</html>
