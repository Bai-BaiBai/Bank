<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>修改页面</title>
</head>
<body>
	<form action="/Bank/modifyUserServlet" method="post">
		<table>
		
			<tr>
				<td>储户账户</td>
				<td><input type="text" name="user_account" readonly="readonly" value="${requestScope.user.getUser_account() }"> </td>
			</tr>
			<tr>
				<td>储户姓名</td>
				<td><input type="text" name="user_name" value="${requestScope.user.getUser_name() }"> </td>
			</tr>
			<tr>
				<td>储户密码</td>
				<td><input type="text" name="user_password" value="${requestScope.user.getUser_password() }"> </td>
			</tr>
			
			<tr>
				<td><input type="submit" value="确定"></td>
				<td><a href="/Bank/managerServlet?type=user">返回</a></td>
			</tr>
		</table>
	</form>
</body>
</html>