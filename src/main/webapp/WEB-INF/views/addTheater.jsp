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
	<form:form action="${contextPath}/addTheater" method="post"
		modelAttribute="theater">
		<table>
			<tr>
				<td>Theater Name:</td>
				<td><form:input type="text" path="theaterName" required="true" /></td>
			</tr>
			<tr>
				<td>Number of auditorium:</td>
				<td><form:input type="number" path="NumOfAudi" required="true" /></td>
			</tr>
			<tr>
				<td>Location:</td>
				<td><form:input type="text" path="location" required="true"/></td>
			</tr>		
			<tr>
				<td colspan="2"><input type="submit" value="Add Theater" /></td>
			</tr>
			
		</table>
	</form:form>
	
	
</body>
</html>