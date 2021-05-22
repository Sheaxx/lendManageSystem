<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="entity.Timetable" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dao.TimetableDao" %>
<%@ page import="dao.TimetableDaoImpl" %>
<%@ page import="java.lang.ref.ReferenceQueue" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>显示所有时间表页面</title>

    <meta name="renderer" content="webkit">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link href="supplier.css" type="text/css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/twitter-bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>


<!--以下两段代码放在body中不要放在<html>之外-->
<%
    String path=request.getContextPath();
    String basepath=request.getScheme()+"://"+ request.getServerName()+":"+request.getServerPort()+"/";
%>


<div class="heading">
    <div class="hav">
        <div class="heading_a">时间表信息  rental_system</div>
        <button class="bt" ><a href="index.jsp">返回</a></button>
    </div>
</div>
<div class="body">
    <div class="add"><h2><center>项目信息</center> </h2></div>
    <form class="form" action="addTimetableServlet" method="post">
        自由职业者编号：<input id="t_fid" name="t_fid" type="text" list="list1" required>
        时间表内容：<input id="t_content" class="sale" type="text" name="t_content" required>

        <button class="bt1" type="submit" >增加</button>
    </form>
    <%--    <div class="messege">--%>
    <%--        {{ messege }}--%>
    <%--    </div>--%>
    <table class="table table-bordered text-center">

        <tr>

            <td>时间表编号</td>

            <td>自由职业者编号</td>

            <td>时间表内容</td>

            <td>操作</td>

        </tr>

        <c:forEach var="T" items="${requestScope.all}"  >
            <form action="updateTimetableServlet" method="post">
                <tr>

                    <td><input type="text" name="t_id" value="${T.t_id}"></td>

                    <td><input type="text" name="t_fid" value="${T.t_fid}"></td>

                    <td><input type="text" name="t_content" value="${T.t_content}"></td>


                    <td>
                        <button type="submit" title="请先修改再点击按钮">更新</button>
                        <button type="submit" formaction="deleteTimetableServlet?p_id=${T.t_id}">删除</button>
                        <button type="submit" formaction="selectTimetable.jsp">查询</button>
                    </td>

                </tr>
            </form>
        </c:forEach>

    </table>
    <!-- 	</div>
     --><!-- 弹窗 -->
    <!-- 	<div id="myModal" class="modal">
     -->
    <!-- 弹窗内容 -->
    <!--  		<div class="modal-content">
                <span class="close">&times;</span>
                    <p>弹窗中的文本...</p>
              </div> -->

</div>

<%--<!-- 使用from提交数据，不能在不刷新页面的情况下直接在当前页面显示处理过的后台数据-->--%>
<%--<c:forEach var="S" items="${requestScope.all}"  >--%>
<%--      <form action="updateSupplierServlet" method="post">--%>

<%--<tr>--%>

<%--                <td><input type="text" value="${S.supplierId}" name="supplierId" ></td>--%>
<%--                <td><input type="text" value="${S.supplierName}" name="supplierName"></td>--%>
<%--                <td><input type="text" value="${S.supplierPhone}" name="supplierPhone"></td>--%>

<%--                <td><a href="deleteSupplierServlet?supplierId=${S.supplierId}">删除</a> <input type="submit" value="更新"/><a href="addSupplier.jsp">添加</a><a href="selectSupplier.jsp">查询</a></td>--%>
<%--            </tr>--%>
<%--        </form>--%>

<%--</c:forEach>--%>






</body>
</html>