<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="jlc" uri="http://jlcindia.com/tags" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.jlc.book.shop.to.*" %>
<html>
<head>
<link rel="stylesheet" trpe="text/css" href="<%=request.getContextPath() %>/css/jlcindia.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>userOrderStatus</title>
</head>
<body>
<center>
<br/>
<table align="center" width="80%" class="textStyle" cellspacing="0">
<core:if test="${ORDER_FOUND eq null}">
<tr bgcolor="orange">
<td align="center">
<font color="black" size="5"><b>Order Information not found</b></font>
</td>
</tr>
</core:if>

<core:if test="${ORDER_FOUND ne null}">
<tr bgcolor="orange">
<td align="center" colspan="6">
<font color="black" size="5"><b>Order Information</b></font>
</td>
</tr>

<tr bgcolor="black">
<td align="center"><font color="yellow" size="4"><b>Sr.No.</b></font></td>
<td align="center"><font color="yellow" size="4"><b>Order Id</b></font></td>
<td align="center"><font color="yellow" size="4"><b>Order Date</b></font></td>
<td align="center"><font color="yellow" size="4"><b>Total Item</b></font></td>
<td align="center"><font color="yellow" size="4"><b>Total Amount</b></font></td>
<td align="center"><font color="yellow" size="4"><b>Status</b></font></td>
</tr>

<%int i=0; int x=-1;	String color="#fdeaff";%>

<core:forEach var="oto" items="${ORDER_FOUND}">
<%
i++;	x++;
if(x==3) x=0;
if(x==0) color="#fdeaff";
else if(x==1) color="#dee1fe";
else if(x==2) color="e1ffde";
%>
<tr bgcolor=<%=color%>>
<td align="center">
<b><%=i %></b>
</td>
<td align="center">
<form action="showorderinfo.jlc" method="post">
<input type="hidden" value="${oto.orderId}" name="orderId"/>
<input type="hidden" value="userOrderStatusDef.jsp" name="page"/>
<input type="submit" value="${oto.orderId}" class="tableButton"/>
</form>
</td>

<td align="center">
<font size="3"><b>${oto.orderDate}</b></font>
</td>
<td align="center">
<font size="3"><b>${oto.totalItem}</b></font>
</td>
<td align="center">
<font size="3" face="Rupee Foradian">`</font><font size="3"><b>${oto.totalAmount}/-</b></font>
</td>
<td align="center">
<font size="3"><b>${oto.status}</b></font>
</td>
</tr>
</core:forEach>
</core:if>
</table>
<br/>

<core:if test="${ORDER_TO ne null}">
<table width="95%" cellspacing="0" class="textStyle">
<tr bgcolor="maroon">
<td align="center" colspan="7">
<font color = "yellow" size="4"><b>Information about the order with id<font color="white">${ORDER_TO.orderId}</font>
</b></font>
</td>
</tr>

<tr bgcolor="black">
<td align="center" colspan="2"><font color="yellow" size="4"><b>Address</b></font></td>
<td align="center"><font color="yellow" size="4"><b>Street</b></font></td>
<td align="center"><font color="yellow" size="4"><b>City</b></font></td>
<td align="center"><font color="yellow" size="4"><b>State</b></font></td>
<td align="center"><font color="yellow" size="4"><b>Zip</b></font></td>
<td align="center"><font color="yellow" size="4"><b>Order Date</b></font></td>
</tr>

<tr>
<td align="center" colspan="2"><font size="3"><b>${ORDER_TO.address}</b></font></td>
<td align="center" ><font size="3"><b>${ORDER_TO.street}</b></font></td>
<td align="center" ><font size="3"><b>${ORDER_TO.city}</b></font></td>
<td align="center" ><font size="3"><b>${ORDER_TO.state}</b></font></td>
<td align="center" ><font size="3"><b>${ORDER_TO.zip}</b></font></td>
<td align="center" ><font size="3"><b>${ORDER_TO.orderDate}</b></font></td>
</tr>

<tr bgcolor="black">
<td align="center"><font color="yellow" size="4"><b>Book Name</b></font></td>
<td align="center"><font color="yellow" size="4"><b>Author</b></font></td>
<td align="center"><font color="yellow" size="4"><b>Edition</b></font></td>
<td align="center"><font color="yellow" size="4"><b>Publication</b></font></td>
<td align="center"><font color="yellow" size="4"><b>Cost</b></font></td>
<td align="center"><font color="yellow" size="4"><b>Quantity</b></font></td>
<td align="center"><font color="yellow" size="4"><b>Amount</b></font></td>
</tr>
<%int i=0; int x=-1;	String color="#fdeaff";%>

<core:forEach var="bto" items="${ORDER_TO.orderItemList}">

<%
i++;	x++;
if(x==3) x=0;
if(x==0) color="#fdeaff";
else if(x==1) color="#dee1fe";
else if(x==2) color="e1ffde";
%>
<tr bgcolor=<%=color %>>
<td align="center"><font size="3"><b>${bto.bookName}</b></font></td>
<td align="center"><font size="3"><b>${bto.author}</b></font></td>
<td align="center"><font size="3"><b>${bto.edition}</b></font></td>
<td align="center"><font size="3"><b>${bto.publication}</b></font></td>
<td align="center"><font size="3" face="Rupee Foradian">`</font><font size="3"><b>${bto.cost}/-</b></font></td>
<td align="center"><font size="3"><b>${bto.selectedNumberOfBook}</b></font></td>
<td align="right"><font size="4" face="Rupee Foradian">`</font><font size="4"><jlc:displayBookTotalAmount value="${bto.cost*bto.selectedNumberOfBook}" quantity="${bto.selectedNumberOfBook }"/>/-</font></td>
</tr>
</core:forEach>
</table>
</core:if>
</center>
</body>
</html>