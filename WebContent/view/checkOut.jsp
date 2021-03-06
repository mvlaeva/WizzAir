<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>AirLines | Checkout</title>
<meta charset="utf-8">
<link rel="stylesheet" href="css/reset.css" type="text/css" media="all">
<link rel="stylesheet" href="css/layout.css" type="text/css" media="all">
<link rel="stylesheet" href="css/style.css" type="text/css" media="all">
<link rel="stylesheet" href="css/regform.css" type="text/css"
	media="all">
<!--[if lt IE 9]>
<script type="text/javascript" src="js/html5.js"></script>
<style type="text/css">.main, .tabs ul.nav a, .content, .button1, .box1, .top { behavior:url("../js/PIE.htc")}</style>
<![endif]-->
</head>
<body id="page5">
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
					<li><a href="./index"><span><span>About</span></span></a></li>
					<li><a href="./Offers"><span><span>Offers</span></span></a></li>
					<li><a href="./Book"><span><span>Book</span></span></a></li>
					<li><a href="./Safety"><span><span>Safety</span></span></a></li>
					<li class="end"><a href="./Contacts"><span><span>Contacts</span></span></a></li>
					<c:if test="${not empty user }">
						<li id="menu_active"><a href="./Profile"><span><span>Profile</span></span></a></li>
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
								<li><span class="right color1">from GBP 143.-</span> <a
									href="book2.html">Zurich</a></li>
							</ul>
							<strong>London (LCY)</strong><br>
							<ul class="pad_bot1 list1">
								<li><span class="right color1">from GBP 176.-</span> <a
									href="book2.html">Geneva</a></li>
								<li><span class="right color1">from GBP 109.-</span> <a
									href="book2.html">Zurich</a></li>
							</ul>
							<strong>London (LHR)</strong><br>
							<ul class="pad_bot2 list1">
								<li><span class="right color1">from GBP 100.-</span> <a
									href="book2.html">Geneva</a></li>
								<li><span class="right color1">from GBP 112.-</span> <a
									href="book2.html">Zurich</a></li>
								<li><span class="right color1">from GBP 88.-</span> <a
									href="book2.html">Basel</a></li>
							</ul>
							<strong>Manchester</strong><br>
							<ul class="pad_bot2 list1">
								<li><span class="right color1">from GBP 97.-</span> <a
									href="book2.html">Basel</a></li>
								<li><span class="right color1">from GBP 103.-</span> <a
									href="book2.html">Zurich</a></li>
							</ul>
							<strong>Edinburgh</strong><br>
							<ul class="pad_bot2 list1">
								<li><span class="right color1">from GBP 165.-</span> <a
									href="book2.html">Zurich</a></li>
							</ul>
							<strong>Birmingham</strong><br>
							<ul class="pad_bot1 list1">
								<li><span class="right color1">from GBP 143.-</span> <a
									href="book2.html">Zurich</a></li>
							</ul>
							<strong>London (LCY)</strong><br>
							<ul class="pad_bot1 list1">
								<li><span class="right color1">from GBP 176.-</span> <a
									href="book2.html">Geneva</a></li>
								<li><span class="right color1">from GBP 109.-</span> <a
									href="book2.html">Zurich</a></li>
							</ul>
							<strong>London (LHR)</strong><br>
							<ul class="pad_bot2 list1">
								<li><span class="right color1">from GBP 100.-</span> <a
									href="book2.html">Geneva</a></li>
								<li><span class="right color1">from GBP 112.-</span> <a
									href="book2.html">Zurich</a></li>
								<li><span class="right color1">from GBP 88.-</span> <a
									href="book2.html">Basel</a></li>
							</ul>
						</div>
					</div>
				</article>
				<article
					style="margin-left: 400px; padding-top: 25px; width: 450px; padding-left: 20px; padding: 8px 6px; height: 22px; width: 280px; padding-bottom: 18px; padding-left: 15px; border-width: thin; border-radius: 3px; border: 1px solid rgba(4, 129, 177, 0.5);">
					<div class="profile_info">
						<div>
							<p>
								Number of passengers:
								<c:out value="${fn:length(adultPassengers)}" />
							</p>
							<form action="./Pay" method="post">
								<c:set var="price" scope="session"
									value="${(pickedFlights[0].price * fn:length(adultPassengers)) }" />
								<div>
									<c:forEach items="${pickedFlights}" var="flight">
										<div class="padding_flight" style="width: 500px">
											<br>
										</div>
										<div
											style="padding: 2px 2px 2px 2px; border-width: thin; border-radius: 3px; border: 1px solid rgba(4, 129, 177, 0.5); bаckground: white; border: 1px solid; border-radius: 5px 20px 5px; border-color: #6b7b8d;">
											<br>
											<p
												style="padding: 2px 2px 2px 2px; border-width: thin; border-radius: 3px; border: 1px solid rgba(4, 129, 177, 0.5); bаckground: white; border: 1px solid; border-radius: 5px 20px 5px; border-color: #6b7b8d;">
												Id :
												<c:out value="${flight.id}" />
											</p>
											<p
												style="padding: 2px 2px 2px 2px; border-width: thin; border-radius: 3px; border: 1px solid rgba(4, 129, 177, 0.5); bаckground: white; border: 1px solid; border-radius: 5px 20px 5px; border-color: #6b7b8d;">
												Origin Station :
												<c:out value="${flight.originStation}" />
											</p>
											<p
												style="padding: 2px 2px 2px 2px; border-width: thin; border-radius: 3px; border: 1px solid rgba(4, 129, 177, 0.5); bаckground: white; border: 1px solid; border-radius: 5px 20px 5px; border-color: #6b7b8d;">
												Destination Station :
												<c:out value="${flight.destinationStation}" />
											</p>
											<p
												style="padding: 2px 2px 2px 2px; border-width: thin; border-radius: 3px; border: 1px solid rgba(4, 129, 177, 0.5); bаckground: white; border: 1px solid; border-radius: 5px 20px 5px; border-color: #6b7b8d;">
												Departure :
												<c:out value="${flight.departure}" />
											</p>
											<p
												style="padding: 2px 2px 2px 2px; border-width: thin; border-radius: 3px; border: 1px solid rgba(4, 129, 177, 0.5); bаckground: white; border: 1px solid; border-radius: 5px 20px 5px; border-color: #6b7b8d;">
												Arrival :
												<c:out value="${flight.arrival}" />
											</p>
											<p
												style="padding: 2px 2px 2px 2px; border-width: thin; border-radius: 3px; border: 1px solid rgba(4, 129, 177, 0.5); bаckground: white; border: 1px solid; border-radius: 5px 20px 5px; border-color: #6b7b8d;">
												Duration :
												<c:out value="${flight.duration} minutes" />
											</p>
											<p
												style="padding: 2px 2px 2px 2px; border-width: thin; border-radius: 3px; border: 1px solid rgba(4, 129, 177, 0.5); bаckground: white; border: 1px solid; border-radius: 5px 20px 5px; border-color: #6b7b8d;">
												Carrier :
												<c:out value="WizzAir" />
											</p>
											<p
												style="padding: 2px 2px 2px 2px; border-width: thin; border-radius: 3px; border: 1px solid rgba(4, 129, 177, 0.5); bаckground: white; border: 1px solid; border-radius: 5px 20px 5px; border-color: #6b7b8d;">
												Price :
												<fmt:formatNumber type="number" maxFractionDigits="2"
													value="${flight.price}" />
											</p>
											<br>
										</div>
									</c:forEach>
									<p>
										<strong>Total :</strong>
										<fmt:formatNumber type="number" maxFractionDigits="2"
											value="${ price}" />
									</p>
								</div>
								<input type="submit" value="Book flight" />
							</form>
							<!--  
							<form action="./PayViaCard" method="post">
								<input type="submit" value="Pay via credit/debit card">
							</form>
							-->
						</div>
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
</body>
</html>