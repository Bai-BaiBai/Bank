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
	<form action="/Bank/updatePasswdServlet?type=bill" method="post">
		<table>
			<tr>
				<td>用户账户：</td>
				<td><input type="text" name="user_account" readonly="readonly" value="${sessionScope.user.user_account }"></td>
			</tr>
			<tr>
				<td>存单原密码：</td>
				<td><input type="password" name="old_password"></td>
			</tr>
			<tr>
				<td>存单新密码：</td>
				<td>
					<input type="password" name="new_password"></td>
				</td>
			</tr>
			<tr align="center">
				<td colspan="2"><input type="submit" value="提交"></td>
			</tr>
		</table>
	</form>
	
</body>
</html>