<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<!--<link type="text/css" rel="stylesheet" href="<c:url value="css/style.css" />" />-->
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Flights</title>
</head>
<body>

<c:if test="${ not empty allFlights }">

	<c:forEach items="${allFlights}" var="flight">
				<p> Id : <c:out value="${flight.id}" /></p>
				<p> originStation : <c:out value="${flight.originStation}" /></p>
				<p> destinationStation : <c:out value="${flight.destinationStation}" /></p>
				<p> departure : <c:out value="${flight.departure}" /></p>
				<p> arrival : <c:out value="${flight.arrival}" /></p>
				<p> duration : <c:out value="${flight.duration}" /></p>
				<p> carrier : <c:out value="${flight.carrier}" /></p>
				<p> price : <c:out value="${flight.price}" /></p>
				<br>
	</c:forEach>

</c:if>

</body>
</html>