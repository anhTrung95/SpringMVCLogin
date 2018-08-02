<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<table>
</table>
	<tr><td><a href="${pageContext.request.contextPath}/customer/register">Register Customer</a></td></tr>
	<tr><td><a href="${pageContext.request.contextPath}/customer/login">Login Customer</a></td></tr>
</body>
</html>
