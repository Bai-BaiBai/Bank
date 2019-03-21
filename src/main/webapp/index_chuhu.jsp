<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<h1>欢迎使用，${sessionScope.user.user_name}</h1>
	<hr>
	<ul>
		<li><a href="">主页</a></li><!-- 指向一个servlet -->
		<li><a href="/Bank/viewbillServlet">查看存单信息</a></li>
		<li><a href="/Bank/money_save.jsp">存钱</a></li>
		<li><a href="/Bank/money_pay.jsp">缴费</a></li>
		<li><a href="/Bank/updateBillPasswd.jsp">修改存单密码</a></li>
		<li><a href="/Bank/updateUserPasswd.jsp">修改用户密码</a></li>
		<li><a href="/Bank/printServlet">打印收支记录</a></li>
	</ul>
	
</body>
</html>