<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>

<body>
	用戶信息：
	<shiro:hasPermission name="USER_CREATE">
	 <a href="user/init">添加</a>
	 </shiro:hasPermission>
	<br>
	<form action="user/query" method="post">
	  关键字查询：
	  <input type="text" name="keywords" value="${vo.keywords }" placeholder="请输入用户名或电话号码">
	  <input type="submit" value="查询">
	</form>
	<table border="1" cellpadding="0" cellspacing="0" >
		<tr>
			<th>ID</th>
			<th>用户名</th>
			<th>电话号码</th>
			<th>真实姓名</th>
			<th>操作</th>
		</tr>

		<c:forEach var='user' items="${pageModel.list}">
			<tr>
				<td>${user.id}</td>
				<td>${user.username}</td>
				<td>${user.phone}</td>
				<td>${user.realname}</td>
				<td>
				<shiro:hasPermission name="USER_UPDATE">
				<a href="user/queryById/${user.id}">修改</a>
				</shiro:hasPermission>
				 &nbsp 
				 <shiro:hasPermission name="USER_DELETE">
				<a href="user/delete/${user.id}">删除</a> 
				</shiro:hasPermission>
				 </td>
			</tr>
		</c:forEach>
	</table>
	<%@include file="pageBar.jsp"%>
	<form action="user/query" method="post" id="pager">
		<input type="hidden" name="pageNum" id="pageNum"
			value="${pageModel.pageNum }"> 
		<input type="hidden"
			name="pageSize" id="pageSize" value="${pageModel.pageSize }">


	</form>
</body>
</html>
