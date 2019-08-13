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



		
<table id="t01">
  <tr>
  
    <th>Movie Id</th>
    <th>Audi id</th> 
    <th>Theater</th>
  <th>Showtime</th>
  <th>Price</th>
  <th>View</th>
  </tr>
<c:forEach items="${schedule }" var="schedule" ><tr>
 
		<td> <c:out value="${schedule.movieId}"/>  </td>
		<td><c:out value="${schedule.auditoriumId}"/> </td>
		<td><c:out value="${schedule.theaterId}"/> </td>
		<td><c:out value="${schedule.showtime}"/> </td>
		<td><c:out value="${schedule.price}"/> </td>
		
		<td colspan="2">
		<a href="${contextPath}/removeMovieId?scheduleId=${schedule.scheduleId} ">
			View</a></td>
		
</tr>
</c:forEach>
    
</table>

</body>
</html>