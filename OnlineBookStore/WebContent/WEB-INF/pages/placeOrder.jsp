<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="jlc" uri="http://jlcindia.com/tags" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Place Order</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/jlcindia.css">
</head>
<body>
<form action="placeorder.jlc" method="post">
<table width="95%" height="95%" align="center">
<tr valign="middle">
<td align="center" colspan="3">
<font color = "black" size="6">Place Your Order</font>
</td>
</tr>

<tr bgcolor="lightyellow">
<td colspan="3" align="center">
<b><font color="red" size="5"><jlc:error property="errorInOrder"/></font></b>
</td>
</tr>

<core:if test="${ORDER_PLACED ne null }">
<%
session.removeAttribute("SELECTED_BOOK_LIST");
%>
<tr bgcolor="lightyellow">
<td align="center">
<br/>
<br/>
<font color="red" size="5"><b>Order is placed successfully. Your OrderId is <font color="green">${ORDER_PLACED}</font>. You canuse for further reference.</b></font>
</td>
</tr>
</core:if>

<core:if test="${ORDER_PLACED eq null }">
<tr bgcolor="maroon">
<td colospan="3" align="center">
<font color="white" size="5"><b>Address Information</b></font>
</td>
</tr>

<tr><td><font size="5"><b>Address</b></font></td>
<td>
<input type="text" name="address" id="address" style="color:black; background-color:#b4e0d2; font-size:large"/>
</td>
<td>
<b><font color="red" size="4"><jlc:error property="address"/></font></b>
</td>
</tr>

<tr><td><font size="5"><b>Street</b></font></td>
<td>
<input type="text" name="street" id="street" style="color:black; background-color:#b4e0d2; font-size:large"/>
</td>
<td>
<b><font color="red" size="4"><jlc:error property="street"/></font></b>
</td>
</tr>

<tr><td><font size="5"><b>City</b></font></td>
<td>
<input type="text" name="city" id="city" style="color:black; background-color:#b4e0d2; font-size:large"/>
</td>
<td>
<b><font color="red" size="4"><jlc:error property="city"/></font></b>
</td>
</tr>

<tr><td><font size="5"><b>State</b></font></td>
<td>
<input type="text" name="state" id="state" style="color:black; background-color:#b4e0d2; font-size:large"/>
</td>
<td>
<b><font color="red" size="4"><jlc:error property="state"/></font></b>
</td>
</tr>

<tr><td><font size="5"><b>Country</b></font></td>
<td>
<input type="text" name="country" id="country" style="color:black; background-color:#b4e0d2; font-size:large"/>
</td>
<td>
<b><font color="red" size="4"><jlc:error property="country"/></font></b>
</td>
</tr>

<tr><td><font size="5"><b>Zip-Code</b></font></td>
<td>
<input type="text" name="zip" id="zip" style="color:black; background-color:#b4e0d2; font-size:large"/>
</td>
<td>
<b><font color="red" size="4"><jlc:error property="zip"/></font></b>
</td>
</tr>

<tr bgcolor="maroon">
<td colspan="3" align="center">
<font color="white" size="5"><b>Card Information</b></font>
</td>
</tr>

<tr><td><font size="5"><b>Card Number</b></font></td>
<td>
<input type="text" name="cardNo" id="cardNo" style="color:black; background-color:#b4e0d2; font-size:large"/>
</td>
<td>
<b><font color="red" size="4"><jlc:error property="cardNo"/></font></b>
</td>
</tr>

<tr><td><font size="5"><b>Secret Pin</b></font></td>
<td>
<input type="password" name="pin" id="pin" style="color:black; background-color:#b4e0d2; font-size:large"/>
</td>
<td>
<b><font color="red" size="4"><jlc:error property="pin"/></font></b>
</td>
</tr>

<tr><td><font size="5"><b>Card Expiration Date[MM/YYYY]</b></font></td>
<td>
<input type="text" name="cardExp" id="cardExp" style="color:black; background-color:#b4e0d2; font-size:large"/>
</td>
<td>
<b><font color="red" size="4"><jlc:error property="cardExp"/></font></b>
</td>
</tr>

<tr>
<td colspan="3" align="center">
<br>
<input type="submit" value="Place Order" style="color:white; background-color:maroon; font-size:medium;">
</td>
</tr>
</core:if>
</table>
</form>
</body>
</html>