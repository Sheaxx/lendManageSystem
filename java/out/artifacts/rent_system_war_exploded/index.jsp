<%--
  Created by IntelliJ IDEA.
  User: L
  Date: 2020/5/18
  Time: 21:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>rental_system</title>
    <link href="index.css" type="text/css" rel="stylesheet">
</head>
<body>

<div>
    <div class="heading">
        <div class="hav">
            <div class="heading_a">rental_system</div>
            <ul>

                <li>
                    <form action="showAllClientServlet" method="post">
                        <button type="submit">客户信息</button>
                    </form>
                </li>
                <li>
                    <form action="showAllProjectServlet" method="post">
                        <button type="submit">项目信息</button>
                    </form>
                </li>
                <li>
                    <form action="showAllFreelanceServlet" method="post">
                        <button type="submit">自由职业者信息</button>
                    </form>
                </li>
                <li>
                    <form action="showAllTimetableServlet" method="post">
                        <button type="submit">时间表信息</button>
                    </form>
                </li>

            </ul>
            <!--                 <form>
                                <button onclick="" type="submit">搜索</button>
                            </form> -->
        </div>
    </div>
</div>
<div class="body"></div>

<%--<a href="showAllSupplierServlet">查看所有供应商信息</a>--%>
<%--<a href="showAllPartServlet">查看所有零件信息</a>--%>
<%--<a href="showAllDinghuoServlet">查看所有订货信息</a>--%>
<%--<a href="showAllShiwuServlet">查看所有事务信息</a>--%>
</body>
</html>
