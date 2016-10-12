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
		<form action="./Luggage" method="post">
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
									<input type="checkbox" name="${flight.id}" id="input-filter-height[1]">
        							<label for="input-filter-height[1]">Tralala</label>
									</div>
								<br>
							</div>
						</c:forEach>
					</c:if>
				</div>
			</div>
			<input type="submit" value="Continue" />
			</form>
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
		<script type="text/javascript">
			$(document).ready(function() {
				tabs.init();
			});
			jQuery(document).ready(function($) {
				$('#form_1, #form_2, #form_3').jqTransform({
					imgPath : 'jqtransformplugin/img/'
				});
			});
			$(window).load(function() {
				$('#slider').nivoSlider({
					effect : 'fade', //Specify sets like: 'fold,fade,sliceDown, sliceDownLeft, sliceUp, sliceUpLeft, sliceUpDown, sliceUpDownLeft' 
					slices : 15,
					animSpeed : 500,
					pauseTime : 6000,
					startSlide : 0, //Set starting Slide (0 index)
					directionNav : false, //Next & Prev
					directionNavHide : false, //Only show on hover
					controlNav : false, //1,2,3...
					controlNavThumbs : false, //Use thumbnails for Control Nav
					controlNavThumbsFromRel : false, //Use image rel for thumbs
					controlNavThumbsSearch : '.jpg', //Replace this with...
					controlNavThumbsReplace : '_thumb.jpg', //...this in thumb Image src
					keyboardNav : true, //Use left & right arrows
					pauseOnHover : true, //Stop animation while hovering
					manualAdvance : false, //Force manual transitions
					captionOpacity : 1, //Universal caption opacity
					beforeChange : function() {
					},
					afterChange : function() {
					},
					slideshowEnd : function() {
					} //Triggers after all slides have been shown
				});
			});
		</script>
</body>
</html>