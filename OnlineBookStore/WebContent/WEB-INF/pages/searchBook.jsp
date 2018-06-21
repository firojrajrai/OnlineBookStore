<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="jlc" uri="http://jlcindia.com/tags"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.jlc.book.shop.to.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>searchBook</title>
</head>
<body>
<form action="searchBook.jlc" method="post">
<center>

<table class="textStyle" height="95%">

<tr bgcolor="orange">
<td align="center" colspan="7">
<font size="5"><b>Search Book</b></font>
</td>
</tr>
<core:if test="${searchingBookError ne null }">
<tr bgcolor="lightyellow">
<td align="center" colspan="6">
<font size="4" color="red"><b><jlc:error property="searchingBookError"/></b>
</font>
</td>
</tr>
</core:if>

<tr valign = "top">
<td align="center"><b>Book Name</b>
<input type="text" name="bname" value="${BOOK_NAME }" style="color:black; background-color:#b4e0d2;">
</td>

<td align="center"><b>Cost</b>
<input type="text" name="cost" value="${COST }" style="color:black; background-color:#b4e0d2;">
</td>

<td align="center"><b>Author</b>
<input type="text" name="author" value="${AUTHOR }" style="color:black; background-color:#b4e0d2;">
</td>

<td align="center"><b>Publication</b>
<input type="text" name="publication" value="${PUBLICATION }" style="color:black; background-color:#b4e0d2;">
</td>

<td align="center"><b>EDITION</b>
<input type="text" name="edition" value="${EDITION }" style="color:black; background-color:#b4e0d2;">
</td>

<td align="center" colspan="5">
<input type="submit" value="Search"  style="color:black; background-color:maroon;font-size:17 ">
</td>
</tr>
</table>
</center>
</form>

<core:if test="${BOOK_LIST ne null }">
<form action="sortInfo.jlc" method="post">
<table width="90%">
<tr>
<td align="left">
<jlc:showSortField/>
</td>

<td align="left">
<jlc:showSortOrder/>
</td>

<td align="left">
<input type="submit" value="Sort Information" style="color: white; background-color: maroon; font-size: 17"/>
</td>

<td>
<font color="red" size="4"><jlc:error property="sortingError"/></font>
</td>

<td colspan="7" align="right">
<font color="maroon" size="4"><b>${START+1} to ${END} of ${TOTAL}</b></font>
</td>

</tr>
</table>
</form>

<table width="90%" cellspacing="0" cellpadding="3" style="font-family:arial">
<core:if test="${DELETE_MESSAGE ne null}">
<tr>
<td colspan="7" align="center" bgcolor="lightyellow">
<font color="red" size="3"><b>${DELETE_MESSAGE}</b></font>
</td>
</tr>
</core:if>

<core:if test="${ADDED_TO_CART_MESSAGE ne null }">
<tr>
<td colspan="7" align = "center" bgcolor="lightyellow"><b><font color="black" size="4">${ADDED_BOOK.bookName}</font>
<font color="red" size="4"> added to Cart. Quantity of<font color="black" size="4">${ADDED_BOOK.bookName }</font> is<font color="green" size="4">${ADDED_BOOK.selectedNumberOfBook}</font></font></b>
</td>
</tr>
</core:if>

<core:if test="${REMOVED_TOTAL ne null }">
<tr>
<td colspan="7" align="center" bgcolor="lightyellow">
<font color="red" size="4"><b>${REMOVED_TOTAL }</b></font>
</td>
</tr>
</core:if>

<tr bgcolor="black">
<td align="center">
<font color="yellow" size="5"><b>Sr.No</b></font>
</td>

<td align="center">
<font color="yellow" size="5"><b>BookName</b></font>
</td>

<td align="center">
<font color="yellow" size="5"><b>Author</b></font>
</td>

<td align="center">
<font color="yellow" size="5"><b>Publication</b></font>
</td>

<td align="center">
<font color="yellow" size="5"><b>Edition</b></font>
</td>

<core:if test="${SELECTED_BOOK_LIST eq null }">
<td colspan="2" align = "center"><font color="yellow" size="5"><b>Cost</b></font>
</td>
</core:if>


<core:if test="${SELECTED_BOOK_LIST ne null }">
<td  align = "center"><font color="yellow" size="5"><b>Cost</b></font>
</td>
</core:if>

<core:if test="${SELECTED_BOOK_LIST ne null }">
<td  bgcolor="maroon" align="center">
<a href="showCartDef.jsp"><font size="5"><b>Show My Cart</b></font></a>
</td>
</core:if>
</tr>

<%
int i = Integer.parseInt(session.getAttribute("START").toString());
int x=-1;	String color="#fdeaff";
%>

<core:forEach var="bto" items="${BOOK_LIST}">
<%
++i;	x++;
if(x==3) x=0;
if(x==0) color="#fdeaff";
else if(x==1) color="#dee1fe";
else if(x==2) color="#e1ffde";
%>

<tr bgcolor="<%=color %>">
<td align="center"><b><%=i %></b></td>
<td align="center"><font size="4">${bto.bookName }</font></td>
<td align="center"><font size="4">${bto.author }</font></td>
<td align="center"><font size="4">${bto.publication }</font></td>
<td align="center"><font size="4">${bto.edition}</font></td>
<td align="center"><font size="4" face="Rupee Foradian">`</font><font size="4">${bto.cost}/-</font></td>

<td align="center">
<core:if test="${USER_TO.role eq 'Admin'}">
<form action="delete.jlc" method="post">
<input type="hidden" name="bookId" value="${bto.bookId }">
<input type="submit" value="Delete">
</form>
</core:if>

<core:if test="${USER_TO.role eq 'User' }">
<form action="addtocart.jlc" method="post">
<input type="hidden" name="bookId" value="${bto.bookId }">
<input type="submit" value="Add to Cart">
</form>
</core:if>
</td>
</tr>
</core:forEach>

<core:if test="${TOTAL gt 5 }">
<tr bgcolor="maroon">
<td colspan="4" align="left">
<core:if test="${START gt 0 }">
<a href="previous.jlc"><font size="4"><b>Previous</b></font></a>
</core:if>
</td>
<td align="right" colspan="3">
<core:if test="${END lt TOTAL }">
<a href="next.jlc"><font size="4"><b>Next</b></font></a>
</core:if>
</td>
</tr>
</core:if>
</table>
</core:if>
</body>
</html>