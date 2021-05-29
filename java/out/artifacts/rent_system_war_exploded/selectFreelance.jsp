<%--
  Created by IntelliJ IDEA.
  User: L
  Date: 2020/5/19
  Time: 20:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查找自由职业者</title>
    <link href="https://cdn.bootcss.com/twitter-bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
    <link href="part.css" type="text/css" rel="stylesheet">
</head>
<body>

<div class="heading">
    <div class="hav">
        <div class="heading_a">自由职业者信息 rental_system</div>
        <button class="bt"><a href="index.jsp">返回</a></button>
    </div>
</div>

<div class="body">
    <div class="add"><h2><center>自由职业者信息</center></h2></div>
    <form class="form" action="selectFreelanceServlet" method="post">
        职业者编号：<input id="f_id" name="f_id" type="text" required>
        <button class="bt1" type="submit">查询</button>
        <button class="bt1" type="reset">重置</button>

    </form>
</div>


</body>
</html>
