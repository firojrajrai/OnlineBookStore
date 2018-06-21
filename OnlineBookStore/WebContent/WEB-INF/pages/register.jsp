<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="jlc" uri="/WEB-INF/tlds/jlcindia.tld" %>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/jlcindia.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/main.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>register</title>
</head>
<body>
<center>
<form action="register.jlc" method="post">
<table class="textStyle">
<tr>
<td align="center" colspan="3">
<font size="7"><b>Register New User</b></font>
</td>
</tr>

<tr>
<td align="center" colspan="3">
<font size="4" color= "red"><b><jlc:error property="registrationError"/></b></font>
</td>
</tr>

<jstl:if test="${REGISTERED ne 'OK'}">
<tr><td><font size="5"><b>First Name</b></font></td>
<td> 
<input type="text" name="fname" id="fname" style="color:black; background-color:#b4e0d2; font-size:large"/></td>
<td>
<b><font color ="red" size="4"><jlc:error property="fname"/></font></b></td>
</tr>

<tr><td><font size="5"><b>Middle Name</b></font></td>
<td> 
<input type="text" name="mname" id="mname" style="color:black; background-color:#b4e0d2; font-size:large;"/></td>
<td>
<b><font color ="red" size="4"><jlc:error property="mname"/></font></b></td>
</tr>

<tr><td><font size="5"><b>Last Name</b></font></td>
<td> 
<input type="text" name="lname" id="lname" style="color:black; background-color:#b4e0d2; font-size:large;"/></td>
<td>
<b><font color ="red" size="4"><jlc:error property="lname"/></font></b></td>
</tr>

<tr><td><font size="5"><b>Email</b></font></td>
<td> 
<input type="text" name="email" id="email" style="color:black; background-color:#b4e0d2; font-size:large;"/></td>
<td>
<b><font color ="red" size="4"><jlc:error property="email"/></font></b></td>
</tr>

<tr><td><font size="5"><b>Phone</b></font></td>
<td> 
<input type="text" name="phone" id="phone" style="color:black; background-color:#b4e0d2; font-size:large;"/></td>
<td>
<b><font color ="red" size="4"><jlc:error property="phone"/></font></b></td>
</tr>

<tr><td><font size="5"><b>Gender</b></font></td>
<td> 
<input type="radio" name="gender" value="Male"><font size="5"><b>Male</b></font>
<input type="radio" name="gender" value="Female"><font size="5"><b>Female</b></font>
</td>
<td>
<b><font color ="red" size="4"><jlc:error property="gender"/></font></b></td>
</tr>

<tr><td><font size="5"><b>Username</b></font></td>
<td> 
<input type="text" name="uname" id="uname" style="color:black; background-color:#b4e0d2; font-size:large;"/></td>
<td>
<b><font color ="red" size="4"><jlc:error property="uname"/></font></b></td>
</tr>

<tr><td><font size="5"><b>Password</b></font></td>
<td> 
<input type="password" name="pass" id="pass" style="color:black; background-color:#b4e0d2; font-size:large;"/></td>
<td>
<b><font color ="red" size="4"><jlc:error property="pass"/></font></b></td>
</tr>

<tr>
<td colspan="2" align="center">
<br>
<input type="submit" value ="REGISTER ME" style="color:white; background-color:maroon; font-size:17;"/>
</td>
</tr>
</jstl:if>
<tr>
<td align="center" colspan="3">
<b><font size="5">Login</font>&nbsp;<a href="index.jsp">
<font size="5">CLICK HERE</font></a></b></td></tr>

<tr>
<td align="center" colspan="3">
<b><font size="5">FORGOT PASSWORD??</font>&nbsp;<a href="forgetPasswordDeg.jsp"><font size="5">Click Here</font></a></b></td>
</tr>
</table>
</form>
</center>
</body>
</html>