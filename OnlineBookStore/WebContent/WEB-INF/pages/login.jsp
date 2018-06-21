<%@taglib prefix="jlc" uri="/WEB-INF/tlds/jlcindia.tld" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css"
href="<%=request.getContextPath() %>/css/jlcindia.css">
<link rel="stylesheet" type="text/css"
href="<%=request.getContextPath() %>/css/main.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>login</title>
</head>
<body>
<form action ="login.jlc" method="post">
<center>
<table class="textStyle">
<tr>
<td align = "center" colspan="3">
<font size="7"><b> Account Login </b></font>
</td>
</tr>

<tr>
<td align = "center" colspan="3">
<font size="4" color="red"><b><jlc:error property="loginError"/></b></font>
</td>
</tr>
<tr><td><br></td></tr>
<tr>
<td align="center" height="">
<font size="5"><b>Username</b></font></td>
<td>
<input type="text" size="30" style="color:black; background-color:#b4e0d2; font-size:large;" name="uname"></td>
<td>
<font size="4" color ="red"><b><jlc:error property="uname"/></b></font></td>
</tr>

<tr>
<td align="center">
<font size="5"><b>Password</b></font></td>
<td>
<input type="password" size="30" style="color:black; background-color:#b4e0d2; font-size:large;" name="pass"></td>
<td>
<font size="4" color ="red"><b><jlc:error property="pass"/></b></font></td>
</tr>

<tr>
<td align="center" colspan="3">
<br/>
<input type="submit" value="Login Me" style="color:white; background-color:maroon; font-size:35"></td>
</tr>
<tr>
<td align="center" colspan="3">
<b><font size="5">New User</font>&nbsp;<a href="registerDef.jsp">
<font size="5">Signup Here</font></a></b></td>
</tr>

<tr>
<td align="center" colspan="3">
<b><font size="5">Forgot Password..</font>&nbsp;<a href="forgetPasswordDef.jsp">
<font size="5">Click Here</font></a></b></td>
</tr>
</table>
</center>
</form>

</body>
</html>