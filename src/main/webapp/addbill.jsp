<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>新建存单</title>
</head>
<body>
	<form action="addBillServlet" method="post">
		<table>
			<tr>
				<td>存单id：</td>
				<td><input type="text" name="bill_id" required="required"></td>
			</tr>
			<tr>
				<td>用户账户：</td>
				<td>
					<select name="user_account">
						<c:forEach var="account" items="${requestScope.user_accounts }">
							<option value="${account }">${account }</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>存单密码：</td>
				<td><input type="text" name="bill_password"></td>
			</tr>
			<tr>
				<td>存单金额：</td>
				<td><input type="number" name="bill_money"></td>
			</tr>
			<tr>
				<td>存单记录：</td>
				<td><input type="text" name="bill_record"></td>
			</tr>
			<tr>
				<td><input type="submit" value="添加"></td>
				<td><a href="index_manager.jsp">返回</a></td>
			</tr>
		</table>
	</form>
</body>
</html>