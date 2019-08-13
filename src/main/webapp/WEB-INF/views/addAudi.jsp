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
<c:set var="theaterid" scope="session" value="${theaterid}"/> 
<c:set var="NumOfAudi" scope="session" value="${NumOfAudi}"/> 
	<form action="${contextPath}/addAudi" method="POST">
		<table>	  

	<c:forEach var="status" begin="1" end="${NumOfAudi}">
		
		<tr>
		<td>Auditorium Name:</td>
			<td align="center"></td>
			<td><input type="text" name="audiName" required="true" /></td>
			
		
		<td>Auditorium capacity:</td>
			<td align="center"></td>
			<td><input type="number" name="audiCap" required="true" /></td>
			
		</tr>
		
	</c:forEach>
			
			<tr>
				<td colspan="2"><input type="submit" value="Add Auditorium" /></td>
			</tr>
		</table>
	</form>
	
</body>
</html>