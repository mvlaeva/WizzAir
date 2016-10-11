<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<!--<link type="text/css" rel="stylesheet" href="<c:url value="css/style.css" />" />-->
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/reset.css" type="text/css" media="all">
<link rel="stylesheet" href="css/layout.css" type="text/css" media="all">
<link rel="stylesheet" href="css/style.css" type="text/css" media="all">
<title>Flights</title>
</head>
<body>
	<div class="main">
		<!--header -->
		<header>
			<div class="wrapper">
				<h1>
					<a href="./index" id="logo">AirLines</a>
				</h1>
				<span id="slogan">Fast, Frequent &amp; Safe Flights</span>
				<nav id="top_nav">
					<ul>
						<li><a href="./Login" class="nav1">Login</a></li>
						<li><a href="./Contacts" class="nav3">Contact</a></li>
					</ul>
				</nav>
			</div>
			<nav>
				<ul id="menu">
					<li><a href="./index"><span><span>About</span></span></a></li>
					<li><a href="./Offers"><span><span>Offers</span></span></a></li>
					<li><a href="./Book"><span><span>Book</span></span></a></li>
					<li><a href="./Services"><span><span>Services</span></span></a></li>
					<li><a href="./Safety"><span><span>Safety</span></span></a></li>
					<li><a href="./Contacts"><span><span>Contacts</span></span></a></li>
				</ul>
			</nav>
		</header>
		<!-- / header -->
		<!--content -->
		<section id="content">
			<div class="wrapper pad1">
				<div class="flight_info">
				
					<c:if test="${ not empty allFlights }">


						<c:forEach items="${allFlights}" var="flight">
							<div class="padding_flight">
								<br>
							</div>
							<div class="flight">
								<br> 
								<p class="flight"> Id : <c:out value="${flight.id}" /></p>
									<p class="flight"> Origin Station : <c:out value="${flight.originStation}" /></p>
									<p class="flight"> Destination Station : <c:out value="${flight.destinationStation}" /></p>
									<p class="flight"> Departure : <c:out value="${flight.departure}" /></p>
									<p class="flight"> Arrival : <c:out value="${flight.arrival}" /></p>
									<p class="flight"> Duration : <c:out value="${flight.duration}" /></p>
									<p class="flight"> Carrier : <c:out value="${flight.carriers}" /></p>
									<p class="flight"> Price : <c:out value="${flight.price}" /></p>
									
									<div class="buy_now" >
									 <form action="./buy">
									  <button style="background: #63aeca;">
									   <img src="images/buy.png">
									  </button>
									 </form>
									</div>
								<br>
							</div>
						</c:forEach>

					</c:if>

				</div>
			</div>
		</section>
	</div>
	<!--content end-->
	<!--footer -->
	<footer>
		<div class="wrapper">
			<ul id="icons">
				<li><a href="https://www.facebook.com/wizzaircom"
					class="normaltip"><img src="images/icon1.jpg" height="30"
						width="30" alt=""></a></li>
				<li><a href="https://twitter.com/wizzair" class="normaltip"><img
						src="images/icon2.jpg" height="30" width="30" alt=""></a></li>
				<li><a href="https://www.youtube.com/user/WizzAirCorporate"
					class="normaltip"><img src="images/icon3.jpg" height="30"
						width="30" alt=""></a></li>
			</ul>
		</div>
	</footer>
	<!--footer end-->
	<script type="text/javascript">
		Cufon.now();
	</script>
</body>
</html>