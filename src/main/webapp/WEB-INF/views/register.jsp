<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
${loginError}

<form:form action="${contextPath}/register" method="post" modelAttribute="user">
<form:errors path="*"/><br/>

		<table>
			<tr>
				<td>Name:</td>
				<td><form:input type="text" path="name" /></td><form:errors path="name"/>
			</tr>
			<tr>
				<td>Username:</td>
				<td><form:input type="text " path="username"  /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><form:input type="text" path="password" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Register" /></td>
			</tr>
		</table>
	</form:form>
        
</body>
</html>