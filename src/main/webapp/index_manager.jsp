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
		<li><a href="/Bank/managerServlet?type=bill">查看存单信息</a></li>
		<li><a href="/Bank/managerServlet?type=user">查看用户信息</a></li>
		<li><a href="/Bank/adduser.jsp">增加用户</a></li>
		<li><a href="/Bank/addBillServlet">新建存单</a></li>
	</ul>
	
</body>
</html>