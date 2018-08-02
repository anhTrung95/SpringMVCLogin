<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s" %>

<html>
<head>
<title>Register</title>
</head>

<body>
	<div align="center">
		<h1>Register</h1>
		<table>
			<s:form commandName="customerData"
			  action="${pageContext.request.contextPath}/customer/register" 
			  method="post">
				<tr>
					<td>Customer name:</td>
					<td><s:input path="c_name"/></td>
					<td><s:errors path="c_name" cssStyle="color:red;"/></td>
				</tr>
				<tr>
					<td>Customer mobile:</td>
					<td><s:input path="c_mobile"/></td>
					<td><s:errors path="c_mobile" cssStyle="color:red;"/></td>
				</tr>
				<tr>
					<td>Customer gender:</td>
					<td><s:radiobutton path="c_gender" value="Male" name="gender"/>Male</td>
					<td><s:radiobutton path="c_gender" value="Female" name="gender"/>Female</td>
					<td><s:errors path="c_gender" cssStyle="color:red;"/></td>
				</tr>
				<tr>
					<td>Customer email:</td>
					<td><s:input path="c_email"/></td>
					<td><s:errors path="c_email" cssStyle="color:red;"/></td>
				</tr>
				<tr>
					<td>Customer password:</td>
					<td><s:input type="password" path="c_password"/></td>
					<td><s:errors path="c_password" cssStyle="color:red;"/></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Register"/></td>
				</tr>
			</s:form>
		</table>
		<p style="color:red;">${duplicate }</p>
		<p><a href="${pageContext.request.contextPath}/customer/login">Login</a></p>
	</div>
</body>
</html>