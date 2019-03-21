<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>管理人员表单操作</title>
</head>
<body>
	<h1>欢迎使用，${sessionScope.user.user_name }</h1>
	<table border="1">
		<tr>
			<th>储户账户</th>
			<th>储户姓名</th>
			<th>储户密码</th>
		</tr>
		<c:forEach var="user" items="${requestScope.users }">
			<tr>
				<td><c:out value="${user.getUser_account() }"></c:out></td>
				<td><c:out value="${user.getUser_name() }"></c:out></td>
				<td><c:out value="${user.getUser_password() }"></c:out></td>
				<td><a href="/Bank/modifyUserServlet?user_account=${user.getUser_account() }">修改</a></td>
				<td><a href="/Bank/deleteUserServlet?user_account=${user.getUser_account() }">删除</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="index_manager.jsp">返回主页</a>
</body>
</html>