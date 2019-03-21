<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>添加用户</title>
</head>
<body>
	<form action="addUserServlet" method="post">
		<table>
			<tr>
				<td>用户账户：</td>
				<td><input type="text" name="user_account" required="required"></td>
			</tr>
			<tr>
				<td>用户姓名：</td>
				<td><input type="text" name="user_name"></td>
			</tr>
			<tr>
				<td>用户密码：</td>
				<td><input type="text" name="user_password"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="添加"></td>
			</tr>
		</table>
	</form>
</body>
</html>