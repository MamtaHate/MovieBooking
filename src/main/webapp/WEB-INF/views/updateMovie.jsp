<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
table {
  width:100%;
}
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}
th, td {
  padding: 15px;
  text-align: left;
}
table#t01 tr:nth-child(even) {
  background-color: #eee;
}
table#t01 tr:nth-child(odd) {
 background-color: #fff;
}
table#t01 th {
  background-color: black;
  color: white;
}
</style>
</head>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="movieId" scope="session" value="${movieId}"/> 
<c:set var="movieName" scope="session" value="${movieName}"/>


		
<table id="t01">
  <tr>
    <th>Movie Name</th>
    <th>Genre</th> 
    <th>Description</th>
  <th>Update</th>
  </tr>
 
		<c:forEach items="${movies }" var="movies" > 
				
   <tr>
				<td> 
		<c:out value="${movies.movieName}"/>  </td>
		<td><c:out value="${movies.genre}"/> </td>
		<td><c:out value="${movies.description}"/> </td>
		
		<td colspan="2">
<a href="${contextPath}/updateMovie?movieId=${movies.movieId}&movieName=${movieName} ">
			Book
			
		</a>
		</td>

			</tr>	
				</c:forEach>


    
</table>

</body>
</html>