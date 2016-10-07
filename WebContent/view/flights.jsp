<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Flights</title>
</head>
<body>

<c:if test="${ not empty allFlights }">

	<c:forEach items="${allFlights.flight}" var="flight">
				<p><c:out value="${flight}" /></p>
	</c:forEach>

</c:if>

</body>
</html>