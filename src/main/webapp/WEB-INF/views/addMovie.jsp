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
	<form:form action="${contextPath}/addMovie" method="post"
		modelAttribute="movie" enctype="multipart/form-data">
		<table>
			<tr>
				<td>Movie Name:</td>
				<td><form:input type="text" path="movieName" required="true" /></td>
			</tr>
			<tr>
				<td>Description:</td>
				<td><form:input type="text " path="description" required="true" /></td>
			</tr>
			<tr>
				<td>Genre:</td>
				<td><form:input type="text" path="genre" required="true"/></td>
			</tr>
			
			<tr>
				<td>Image:</td>
				<td><input type="file" name="fileUpload" required="true"/></td>
			</tr>
				<td colspan="2"><input type="submit" value="Add Movie" /></td>
			</tr>
		</table>
	</form:form>
	
</body>
</html>