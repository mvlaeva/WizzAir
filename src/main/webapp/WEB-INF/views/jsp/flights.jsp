<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>AirLines | Flights</title>
<meta charset="utf-8">
<link href="<c:url value="/css/reset.css" />" rel="stylesheet">
<link href="<c:url value="/css/layout.css" />" rel="stylesheet">
<link href="<c:url value="/css/style.css" />" rel="stylesheet">
<!--[if lt IE 9]>
<script type="text/javascript" src="js/html5.js"></script>
<style type="text/css">.main, .tabs ul.nav a, .content, .button1, .box1, .top { behavior:url("../js/PIE.htc")}</style>
<![endif]-->
</head>
<body id="page3">
	<div class="main">
		<!--header -->
		<header>
			<div class="wrapper">
				<h1>
					<a href="./Home" id="logo">AirLines</a>
				</h1>
				<span id="slogan">Fast, Frequent &amp; Safe Flights</span>
				<nav id="top_nav">
					<ul>
						<c:if test="${ empty user  }">
							<li><a href="./Login" class="nav2">Login</a></li>
						</c:if>
						<c:if test="${ not empty user }">
							<li><a href="./Logout" class="nav2">Logout</a></li>
						</c:if>
						<li><a href="./Contacts" class="nav3">Contact</a></li>
					</ul>
				</nav>
			</div>
			<nav>
				<ul id="menu">
					<li><a href="./Home"><span><span>About</span></span></a></li>
					<li><a href="./Offers"><span><span>Offers</span></span></a></li>
					<li id="menu_active"><a href="./Book"><span><span>Book</span></span></a></li>
					<li><a href="./Safety"><span><span>Safety</span></span></a></li>
					<li class="end"><a href="./Contacts"><span><span>Contacts</span></span></a></li>
					<c:if test="${not empty user }">
						<li><a href="./Profile"><span><span>Profile</span></span></a></li>
					</c:if>
				</ul>
			</nav>
		</header>
		<!-- / header -->
		<!--content -->
		<section id="content">
			<div class="wrapper pad1">
				<article class="col1">
					<div class="box1">
						<h2 class="top">Hot Offers of the Week</h2>
						<div class="pad">
							<strong>Birmingham</strong><br>
							<ul class="pad_bot1 list1">
								<li><span class="right color1">from GBP 143.-</span><a
									href="book2.html">Zurich</a></li>
							</ul>
							<strong>London (LCY)</strong><br>
							<ul class="pad_bot1 list1">
								<li><span class="right color1">from GBP 176.-</span><a
									href="book2.html">Geneva</a></li>
								<li><span class="right color1">from GBP 109.-</span><a
									href="book2.html">Zurich</a></li>
							</ul>
							<strong>London (LHR)</strong><br>
							<ul class="pad_bot2 list1">
								<li><span class="right color1">from GBP 100.-</span><a
									href="book2.html">Geneva</a></li>
								<li><span class="right color1">from GBP 112.-</span><a
									href="book2.html">Zurich</a></li>
								<li><span class="right color1">from GBP 88.-</span><a
									href="book2.html">Basel</a></li>
							</ul>
							<strong>Manchester</strong><br>
							<ul class="pad_bot2 list1">
								<li><span class="right color1">from GBP 97.-</span><a
									href="book2.html">Basel</a></li>
								<li><span class="right color1">from GBP 103.-</span><a
									href="book2.html">Zurich</a></li>
							</ul>
							<strong>Edinburgh</strong><br>
							<ul class="pad_bot2 list1">
								<li><span class="right color1">from GBP 165.-</span><a
									href="book2.html">Zurich</a></li>
							</ul>
							<strong>Birmingham</strong><br>
							<ul class="pad_bot1 list1">
								<li><span class="right color1">from GBP 143.-</span><a
									href="book2.html">Zurich</a></li>
							</ul>
							<strong>London (LCY)</strong><br>
							<ul class="pad_bot1 list1">
								<li><span class="right color1">from GBP 176.-</span><a
									href="book2.html">Geneva</a></li>
								<li><span class="right color1">from GBP 109.-</span><a
									href="book2.html">Zurich</a></li>
							</ul>
							<strong>London (LHR)</strong><br>
							<ul class="pad_bot2 list1">
								<li><span class="right color1">from GBP 100.-</span><a
									href="book2.html">Geneva</a></li>
								<li><span class="right color1">from GBP 112.-</span><a
									href="book2.html">Zurich</a></li>
								<li><span class="right color1">from GBP 88.-</span><a
									href="book2.html">Basel</a></li>
							</ul>
						</div>
					</div>
				</article>
				<article class="col2">
					<div class="tabs2">
						<article>
							<div>
								<div class="content">
									<div class="tab-content" id="Flight">
										<form action="./Luggage" method="post">
											<div class="wrapper pad1">
												<div class="flight_info"
													style="background: white; border: 1px solid #63aeca;">
													<c:if test="${ not empty allFlights }">
														<c:forEach items="${allFlights}" var="flight">
															<div class="padding_flight" style="width: 500px">
																<br>
															</div>
															<div class="flight">
																<br>
																<p class="flight">
																	Id :
																	<c:out value="${flight.id}" />
																</p>
																<!--	<p>
																	<c:out value="${flight.stops}" />
																</p>
																-->
																<p class="flight">
																	Origin Station :
																	<c:out value="${flight.originStation}" />
																</p>
																<p class="flight">
																	Destination Station :
																	<c:out value="${flight.destinationStation}" />
																</p>
																<p class="flight">
																	Departure :
																	<c:out value="${flight.departure}" />
																</p>
																<p class="flight">
																	Arrival :
																	<c:out value="${flight.arrival}" />
																</p>
																<p class="flight">
																	Duration :
																	<c:out value="${flight.duration} minutes" />
																</p>
																<p class="flight">
																	Carrier :
																	<c:out value="WizzAir" />
																</p>
																<p class="flight">
																	Price :
																	<fmt:formatNumber type="number" maxFractionDigits="2"
																		value="${flight.price}" />
																</p>
																<div class="buy_now">				
																		<p>
																		Choose
																<input type="radio" name="outgoingFlightId" value="${flight.id}">
																	
															</p>
																</div>
																<br>
															</div>
														</c:forEach>
													</c:if>
												</div>
											</div>
											<c:if test="${ not empty allFlights }">
												<input type="submit" value="Continue" />
											</c:if>
										</form>
										<c:if test="${empty allFlights }">
											<div class="flight_info" style="padding: 0">
												<p>
													<c:out
														value="No flights were found matching your criteria." />
												</p>
												<br>
												<form action="./index" method="get">
													<p>
														<input type="submit" value="Search new flights">
													</p>
												</form>
											</div>
										</c:if>
									</div>
								</div>
							</div>
						</article>
					</div>
				</article>
			</div>
		</section>
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
	</div>
	<script type="text/javascript">
		Cufon.now();
	</script>
	<script type="text/javascript">
		jQuery(document).ready(function($) {
			$('.form_5').jqTransform({
				imgPath : 'jqtransformplugin/img/'
			});
		});
		$(document).ready(function() {
			tabs2.init();
		});
	</script>
</body>
</html>