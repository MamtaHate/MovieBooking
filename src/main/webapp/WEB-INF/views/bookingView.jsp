<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<c:forEach items="${booking}" var="booking" > 
				

			<c:out value="${booking.theaterName}"/>  
		<c:out value="${booking.audiName}"/> 
		<c:out value="${booking.showtime}"/> 
		<c:out value="${booking.movieName}"/> 
		
	
				</c:forEach>

</body>
</html>