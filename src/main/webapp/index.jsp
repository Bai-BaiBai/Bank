<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<title>login</title>
</head>
<body>
 <form action="/Bank/logincheck" method = "post">
  <table align="center" width="800px" height="400"><tr bgcolor="#CCCCCC" ><td colspan="2" align="center"><font size="+2" ><b>用户登录</b></font></td></tr>
  <tr>
  <td width="260"><img src="img/pic1.bmp"/> </td>
  <td width="540">
  <table align = "center">
  <tr>
  <td  colspan="2">请输入用户名和密码：</td>
  </tr>
  <tr>
  <td>用户名：</td>
  <td><input name = "user_account" type = "text" style="width:180px"></td>
  </tr>
  <tr>
  <td>密码：</td>
  <td><input name = "user_password" type = "password" style="width:180px"></td>
  </tr>
  <tr>
  <td><input name = "ok" type = "submit" value = "确定"></td>
  <td><input name = "cancel" type = "reset" value = "取消"></td>
  </tr>
  </table>
  </td>
  </tr>
  </table>
  </form>
  <hr>

</body>
</html>