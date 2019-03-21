<%@page import="bean.User"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>存单ID</th>
			<th>存单账户</th>
			<th>剩余金额</th>
			<th>收支记录</th>
		</tr>
		<c:forEach var="bill" items="${requestScope.bills}">
			<tr>
				<td><c:out value="${bill.getBill_id() }"></c:out></td>
				<td><c:out value="${bill.getUser_account() }"></c:out></td>
				<td><c:out value="${bill.getBill_money() }"></c:out></td>
				<td><c:out value="${bill.getBill_record() }"></c:out></td>
			</tr>
		</c:forEach>
	</table>
	<a href="index_chuhu.jsp">返回主页</a>
</body>
</html>