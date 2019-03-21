<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>修改页面</title>
</head>
<body>
	<form action="/Bank/modifyServlet" method="post">
		<table>
			<tr>
				<td>存单id</td>
				<td><input type="text" name="bill_id" readonly="readonly" value="${requestScope.bill.getBill_id() }"></td>
			</tr>
			<tr>
				<td>储户账户</td>
				<td><input type="text" name="user_account" readonly="readonly" value="${requestScope.bill.getUser_account() }"> </td>
			</tr>
			<tr>
				<td>存单密码</td>
				<td><input type="text" name="bill_password" value="${requestScope.bill.getBill_password() }"> </td>
			</tr>
			<tr>
				<td>存单余额</td>
				<td><input type="text" name="bill_money" value="${requestScope.bill.getBill_money() }"> </td>
			</tr>
			<tr>
				<td>存单记录</td>
				<td><input type="text" name="bill_record" value="${requestScope.bill.getBill_record() }"> </td>
			</tr>
			<tr>
				<td><input type="submit" value="确定"></td>
				<td><a href="/Bank/managerServlet?type=bill">返回</a></td>
			</tr>
		</table>
	</form>
</body>
</html>