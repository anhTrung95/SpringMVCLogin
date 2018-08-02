<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s" %>

<html>
<head>
<title>Login</title>
</head>

<body>
	<div align="center">
		<h1>Login Customer</h1>
		<table>
			<s:form commandName="customerData"
			  action="${pageContext.request.contextPath}/customer/login" 
			  method="post">
				<tr>
					<td>Customer email:</td>
					<td><s:input path="c_email"/></td>
				</tr>
				<tr>
					<td>Customer password:</td>
					<td><s:input type="password" path="c_password"/></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Login"/></td>
				</tr>
			</s:form>
			<tr>
				<td></td>
				<td><a href="${pageContext.request.contextPath}/customer/register">Register</a></td>
				<td><a href="${pageContext.request.contextPath}/">Home</a></td>
			</tr>
		</table>
		<div>
			<p style="color:red;">${failed}</p>
		</div>
	</div>
</body>
</html>