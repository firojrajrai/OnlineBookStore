<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="jlc" uri="/WEB-INF/tlds/jlcindia.tld" %>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>userMenu</title>
</head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/jlcindia.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/indexstyle.css">
<body>
<center>
<table class="textStyle" width="95%">
<tr>

<td>
<font color="yellow"><b>Welcome&nbsp;<font color="white">${USER_TO.firstName}&nbsp;${USER_TO.middleName}&nbsp;${USER_TO.lastName}
<font>[${USER_TO.role}]</b></font>
</td>

<td>
<a href="userHomeDef.jsp">Home</a>
</td>
<jstl:if test="${USER_TO.role eq 'Admin'}">
<td><a href="addBookDef.jsp">Add Book</a></td>
</jstl:if>

<td>
<a href="searchBookDef.jsp">Search Book</a>
</td>
<jstl:if test="${USER_TO.role eq 'User'}">
<td><a href="userorderstatus.jlc">My Order Status</a></td>

</jstl:if>
<jstl:if test="${USER_TO.role eq 'Admin'}">
<td><a href="allorders.jlc">Display Orders</a></td>
</jstl:if>

<td><a href="detailsDef.jsp">View Details</a></td>

<td><a href="changePasswordDef.jsp">Change Password</a></td>

<td><a href="logout.jlc">Logout</a></td>
</tr>
</table>
</center>
</body>
</html>