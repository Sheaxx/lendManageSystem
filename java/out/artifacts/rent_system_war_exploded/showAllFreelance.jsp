<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="entity.Freelance" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dao.FreelanceDao" %>
<%@ page import="dao.FreelanceDaoImpl" %>
<%@ page import="java.lang.ref.ReferenceQueue" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>显示所有自由职业者信息</title>
    <link href="part.css" type="text/css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/twitter-bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
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
    <form class="form" action="addFreelanceServlet" method="post">
        职业者名称：<input id="f_name" name="f_name" type="text" list="list2" required>
        职业者类型：<input id="f_type" name="f_type" type="text" list="list3" required>
        联系方式：<input id="f_contact" name="f_contact" type="text" list="list4" required>
        <button class="bt1" type="submit">增加</button>
    </form>
    <table class="table table-bordered text-center">
        <tr>
            <td>职业者编号</td>
            <td>职业者名称</td>
            <td>职业者类型</td>
            <td>联系方式</td>
            <td>操作</td>
        </tr>
        <c:forEach var="F" items="${requestScope.all}"  >
            <form action="updateFreelanceServlet" method="post">
                <tr>
                    <td><input type="text" value="${F.f_id}" name="f_id" ></td>
                    <td><input type="text" value="${F.f_name}" name="f_name" ></td>
                    <td><input type="text" value="${F.f_type}" name="f_type" ></td>
                    <td><input type="text" value="${F.f_contact}" name="f_contact" ></td>


                    <td>
                        <button type="submit" title="请先修改再点击按钮">更新</button>
                        <button type="submit" formaction="deleteFreelanceServlet?f_id=${F.f_id}">删除</button>
                        <button type="submit" formaction="selectFreelance.jsp">查询</button>

                    </td>

                </tr>
            </form>
        </c:forEach>
    </table>
</div>


<!--以下两段代码放在body中不要放在<html>之外-->
<%
    String path=request.getContextPath();
    String basepath=request.getScheme()+"://"+ request.getServerName()+":"+request.getServerPort()+"/";
%>

<!-- 使用from提交数据，不能在不刷新页面的情况下直接在当前页面显示处理过的后台数据-->
<%--<c:forEach var="P" items="${requestScope.all}"  >--%>
<%--    <form action="updatePartServlet" method="post">--%>

<%--        <tr>--%>

<%--            <td><input type="text" value="${P.partId}" name="partId" ></td>--%>
<%--            <td><input type="text" value="${P.partName}" name="partName" ></td>--%>
<%--            <td><input type="text" value="${P.partPrice}" name="partPrice" ></td>--%>
<%--            <td><input type="text" value="${P.partNum}" name="partNum" ></td>--%>
<%--            <td><input type="text" value="${P.mainSupplierId}" name="mainSupplierId" ></td>--%>
<%--            <td><input type="text" value="${P.secSupplierId}" name="secSupplierId" ></td>--%>
<%--            <td><input type="text" value="${P.partCriticalNum}" name="partCriticalNum" ></td>--%>

<%--            <td><a href="deletePartServlet?partId=${P.partId}">删除</a> <input type="submit" value="更新"/><a href="addPart.jsp">添加</a><a href="selectPart.jsp">查询</a></td><a href="ruku.jsp">入库</a><a href="chuku.jsp">出库</a>--%>
<%--        </tr>--%>
<%--    </form>--%>
<%--</c:forEach>--%>

</body>
</html>
