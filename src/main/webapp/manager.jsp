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
			<th>存单id</th>
			<th>储户账户</th>
			<th>存单密码</th>
			<th>存单剩余金额</th>
			<th>存单记录</th>
		</tr>
		<c:forEach var="bill" items="${requestScope.bills }">
			<tr>
				<td><c:out value="${bill.getBill_id() }"></c:out></td>
				<td><c:out value="${bill.getUser_account() }"></c:out></td>
				<td><c:out value="${bill.getBill_password() }"></c:out></td>
				<td><c:out value="${bill.getBill_money() }"></c:out></td>
				<td><c:out value="${bill.getBill_record() }"></c:out></td>
				<td><a href="/Bank/modifyServlet?bill_id=${bill.getBill_id() }">修改</a></td>
				<td><a href="/Bank/deleteServlet?bill_id=${bill.getBill_id() }">删除</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="index_manager.jsp">返回主页</a>
</body>
</html>