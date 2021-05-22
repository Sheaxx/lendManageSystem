<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="entity.Timetable" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dao.TimetableDao" %>
<%@ page import="dao.TimetableDaoImpl" %>
<%@ page import="java.lang.ref.ReferenceQueue" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>查询时间表信息</title>
    <link href="part.css" type="text/css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/twitter-bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="heading">
    <div class="hav">
        <div class="heading_a">时间表信息 rental_system</div>
        <button class="bt"><a href="index.jsp">返回</a></button>
    </div>
</div>
<!--以下两段代码放在body中不要放在<html>之外-->
<%
    String path=request.getContextPath();
    String basepath=request.getScheme()+"://"+ request.getServerName()+":"+request.getServerPort()+"/";
%>
<!-- 使用from提交数据，不能在不刷新页面的情况下直接在当前页面显示处理过的后台数据-->

<div class="body">
    <div class="add"><h2><center>时间表信息</center></h2></div>
    <table class="table table-bordered text-center">
        <tr>
            <td>时间表编号</td>
            <td>自由职业者编号</td>
            <td>时间表内容</td>
            <td>操作</td>
        </tr>
        <c:forEach var="T" items="${requestScope.select}"  >
            <form action="" method="post">
                <tr>
                    <td><input type="text" value="${T.t_id}" name="t_id" ></td>
                    <td><input type="text" value="${T.t_fid}" name="t_fid" ></td>
                    <td><input type="text" value="${T.t_content}" name="t_content" ></td>
                        <%--                    <a href="addUpdateDeleteSuccess.jsp">返回首页</a>--%>
                </tr>
            </form>
        </c:forEach>
    </table>
</div>

<%--<c:forEach var="P" items="${requestScope.select}"  >--%>
<%--    <form action="" method="post">--%>
<%--        <tr>--%>
<%--            <td><input type="text" value="${P.partId}" name="partId" ></td>--%>
<%--            <td><input type="text" value="${P.partName}" name="partName"></td>--%>
<%--            <td><input type="text" value="${P.partPrice}" name="partPrice"></td>--%>
<%--            <td><input type="text" value="${P.partNum}" name="partNum" ></td>--%>
<%--            <td><input type="text" value="${P.mainSupplierId}" name="mainSupplierId"></td>--%>
<%--            <td><input type="text" value="${P.secSupplierId}" name="secSupplierId"></td>--%>
<%--            <td><input type="text" value="${P.partCriticalNum}" name="partCriticalNum" ></td>--%>

<%--            <a href="addUpdateDeleteSuccess.jsp">返回首页</a>--%>
<%--        </tr>--%>
<%--    </form>--%>
<%--</c:forEach>--%>
</body>
</html>
