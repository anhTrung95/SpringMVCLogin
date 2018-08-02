<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s" %>

<html>
<head>
<title>Welcome</title>
</head>

<body>
	<h1></h1>
	<div>
		<div align="right">
			<a href="${pageContext.request.contextPath}/">
				<b>Home</b>
			</a>
			<a href="${pageContext.request.contextPath}/customer/logout">
				<b>Log out</b>
			</a>
		</div>
		<div align="left">
			Welcome <b style="color:red;">${customer.c_name}</b>
			</div>
	</div>
	<div align="center">
		<table>
			<tr>
				<td>Customer name:</td>
				<td>${customer.c_name}</td>
			</tr>
			<tr>
				<td>Customer moblie:</td>
				<td>${customer.c_mobile}</td>
			</tr>
			<tr>
				<td>Customer gender:</td>
				<td>${customer.c_gender}</td>
			</tr>
			<tr>
				<td>Customer email:</td>
				<td>${customer.c_email}</td>
			</tr>
		</table>
	</div>
</body>
</html>