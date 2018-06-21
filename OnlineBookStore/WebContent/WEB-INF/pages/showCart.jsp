<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="jlc" uri="http://jlcindia.com/tags" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>showCart</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/jlcindis.css">
</head>
<body>

<center>
<form action="removefromcart.jlc" method="post">
<table width="100%" cellspacing="2" cellpadding="3" style="font-family:arial">
<tr bgcolor="orange">
<td align="center" colspan="8">
<font size="5"><b>Displaying book from Cart</b></font>
</td>
</tr>

<tr bgcolor="lightyellow">
<td align="center" colspan="7">
<font color="red" size="4"><jlc:error property="bookId"/></font>
</td>
</tr>
<core:if test="${REMOVED_BOOK ne null }">
<tr bgcolor="lightyellow">
<td align="center" colspan="8">
<b><font size="4">${REMOVED_BOOK.bookName}</font><font color="red" size = "4"> is removed successfully. Quantity was</font><font  color="green" size="4"> ${REMOVED_BOOK.selectedNumberOfBook }</font></b>
</td>
</tr>
</core:if>

<tr bgcolor="black">
<td align="center"><font color="yellow" size="5"><b>Book Name</b></font></td>
<td align="center"><font color="yellow" size="5"><b>Author</b></font></td>
<td align="center"><font color="yellow" size="5"><b>Publication</b></font></td>
<td align="center"><font color="yellow" size="5"><b>Edition</b></font></td>
<td align="center"><font color="yellow" size="5"><b>Cost</b></font></td>
<td align="center"><font color="yellow" size="5"><b>Quantity</b></font></td>
<td align="center"><font color="yellow" size="5"><b>Total</b></font></td>
</tr>

<%
int i=0;	int x=-1;	String color="fdeaff";
%>

<core:forEach var="bto" items="${SELECTED_BOOK_LIST }">
<% ++i;	x++; 
if(x==3) x=0;
if(x==0) color="#fdeaff";
else if(x==1) color="dee1fe";
else if(x==2) color="e1ffde";
%>

<tr bgcolor="<%=color %>">
<td>
<input type="radio" value="${bto.bookId }" name="bookId"/>
<font size="4">${bto.bookName}</font>
</td>

<td align="center"><font size="4">${bto.author}</font></td>
<td align="center"><font size="4">${bto.publication}</font></td>
<td align="center"><font size="4">${bto.edition}</font></td>
<td align="right"><font size="4" face="Rupee Foradian">`</font><font size="4">${bto.cost}/-</font></td>
<td align="center"><font size="4">${bto.selectedNumberOfBook}</font></td>
<td align="right"><font size="4" face="Rupee Foradian">`</font><font size="4"><jlc:displayBookTotalAmount value="${bto.cost*bto.selectedNumberOfBook }" quantity="${bto.selectedNumberOfBook }"/>/-</font></td>
</tr>
</core:forEach>

<tr bgcolor="#ff8080">
<td colspan="5" align="right">
<font color="" size="4"><b>Total</b></font>
</td>

<td align="center">
<font color="" size="4"><b>${TOTAL_BOOK_QUANTITY}</b></font>
</td>

<td align="right">
<font size="4" face="Rupee Foradian">`<jlc:displayTotalAmount/>/-</font>
</td>
</tr>

<tr bgcolor="maroon">
<td colspan="2" align="center"><a href="searchBookDef.jsp"><font size="3">Add More Book</font></a>
</td>

<td colspan="3" align="center"><a href="placeOrderDef.jsp"><font size="3">Place Order</font></a>
</td>

<td colspan="2" align="center">
<input type="submit" value="Remove" class="signoutButton">
</td>
</tr>

</table>
</form>
</center>

</body>
</html>