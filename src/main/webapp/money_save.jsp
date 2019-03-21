<%@page import="bean.User"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/Bank/modifybillServlet?action=save" method="post">
		<table>
			<tr>
				<td>用户账户：</td>
				<td><input type="text" name="user_account" readonly="readonly" value="${sessionScope.user.user_account }"></td>
			</tr>
			<tr>
				<td>存款金额：</td>
				<td><input type="number" name="money"></td>
			</tr>
			<tr>
				<td>请输入存单密码：</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr align="center">
				<td colspan="2"><input type="submit" value="提交"></td>
			</tr>
		</table>
	</form>
	
</body>
</html>