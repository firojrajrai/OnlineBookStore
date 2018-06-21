  <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
  
    <%@taglib prefix="jlc" uri="http://jlcindia.com/tags" %>
    <%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/jlcindia.css"> 
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/indexstyle.css">
</head>
<body>
<form action="changePassword.jlc" method="post">
<center>
<table class="textStyle">
<tr bgcolor="orange">
<td align="center" colspan="7">
<font size="5"><b>Change User Password</b></font>
</td>
</tr>

<tr bgcolor="lightyellow">
<td align="center" colspan="3">
<font size="4" color="red"><b><jlc:error property="changePasswordError"/></b></font>
</td>
</tr>
<tr><td><br/></td></tr>

<core:if test="${CHANGED_PASSWORD ne 'OK'}">
<tr>
<td align="center" height="">
<font size="5"><b>Current Password</b></font>
</td>
<td>
<input type="password" size="35" style="color: black; background-color: #b4e0d2; font-size:20" name="currpass">
</td>
<td>
<font size="4" color="red"><b><jlc:error property="currpass"/></b></font>
</td>
</tr>

<tr>
<td>
<font size="5"><b>New Password</b></font>
</td>
<td>
<input type="password" size="35" style="color: black; background-color: #b4e0d2; font-size:20" name="newpass">
</td>
<td>
<font size="4" color="red"><b><jlc:error property="newpass"/></b></font>
</td>
</tr>

<tr><td align>
<font size="5"><b>Confirm Password</b></font>
</td>
<td>
<input type="password" size="35" style="color: black; background-color: #b4e0d2; font-size:"20" name="confpass">
</td>
<td>
<font size="4" color="red"><b><jlc:error property="confpass"/></b></font>
</td>
</tr>

<tr>
<td align="center" colspan="3">
<br/>
<input type="submit" value="Change Password" style="color: white; background-color: maroon; font-size: 17">
</td>
</tr>
</core:if>
</table>
</center>
</form>
</body>
</html>