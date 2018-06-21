<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="jlc" uri="http://jlcindia.com/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>JLC Online Book Shop</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/indexstyle.css">
</head>
<body bgcolor="lightgray">
<jlc:validateSession/>
<jlc:removeSearchInfoFromSessionTag/>
<table width="90%" align="center" height="97%">
<tr height="5px" valign="top">
<td align = "center">
<jsp:include page="/WEB-INF/pages/header.jsp"/>
</td>
</tr>

<tr height="3px" bgcolor="maroon" valign="top">
<td align = "center">
<jsp:include page="/WEB-INF/pages/userMenu.jsp"/>
</td>
</tr>

<tr valign="top">
<td align = "center">
<jsp:include page="/WEB-INF/pages/changePassword.jsp"/>
</td>
</tr>

<tr height="2px" valign="bottom">
<td align = "center">
<jsp:include page="/WEB-INF/pages/footer.html"/>
</td>
</tr>
</table>
</body>
</html>