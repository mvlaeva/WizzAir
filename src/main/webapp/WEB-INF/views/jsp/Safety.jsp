<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>AirLines | Safety</title>
<meta charset="utf-8">
<link href="<c:url value="/css/reset.css" />" rel="stylesheet">
<link href="<c:url value="/css/layout.css" />" rel="stylesheet">
<link href="<c:url value="/css/style.css" />" rel="stylesheet">
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
					<li id="menu_active"><a href="./Safety"><span><span>Safety</span></span></a></li>
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
				<article class="col2">
					<h3 class="pad_top1">About Safety</h3>
					<div class="wrapper pad_bot2">
						<figure class="left marg_right1">
							<img src="images/page5_img1.jpg" alt="">
						</figure>
						<p>
							<strong>Disabled passangers and passangers with needs</strong><br>In
							line with Regulation (EC) No 1107/2006, our partners provide a
							wide range of facilities for disabled and reduced mobility
							passengers at airports. Passengers are considered disabled when
							their physical, medical or mental condition requires individual
							attention (on embarking and disembarking, during flight, in an
							emergency evacuation, during ground handling) that is not
							normally extended to other passengers. Disabled passengers are
							passengers who use wheelchairs live with visual or hearing
							impairments travel with guide dogs Passengers with special needs
							are considered those who are pregnant travelling with a broken
							leg travelling with mobility equipment are affected by a
							contagious disease using medicine or medical equipment in need of
							extra oxygen for medical reasons
						</p>
					</div>
					<div class="wrapper pad_bot2">
						<figure class="left marg_right1">
							<img src="images/page5_img2.jpg" alt="">
						</figure>
						<p>
							<strong>Wheelchairs</strong><br> Two mobility equipments
							items can be checked-in or taken on board free of charge. <br>
							<strong>Batteries</strong> Only manual wheelchairs and dry cell,
							non-spillable battery-powered wheelchairs are accepted, provided
							that the terminals are insulated to prevent accidental short
							circuits. The battery must be securely attached to the
							wheelchair. <br> <strong>Dimensions</strong> If your
							wheelchair is not collapsible, please provide the dimensions when
							you are informing the Special Assistance Call Centre. <br> <strong>Assistance</strong>
							To make sure that you are comfortable, our handling agent will
							provide assistance during the check-in procedure and baggage
							drop-off. You will be assisted to the gate, through security and
							on board. Most often you will be seated in a window seat. Please
							note that our cabin crew cannot provide assistance with drinks,
							meals or medication, but they will help you in moving from your
							seat to the toilet facilities, if required. <br> <strong>Facilities</strong>
							Unfortunately onboard wheelchairs are not available on our
							flights. <br> <strong>Limit</strong> We can accept up to 28
							disabled passengers per flight, provided that a maximum of 10
							passengers who require a wheelchair from check-in to the cabin
							seat, can be carried on the same aircraft. There are 36 available
							seats for disabled passengers on our Airbus A321 aircraft, and we
							can accept a maximum 12 passengers who require a wheelchair from
							check-in to the cabin seat.<br> For further questions do not
							hesitate to contact us.
						</p>
					</div>
					<div class="wrapper">
						<a href="./Contacts" class="button1 right"><strong>Contact
								us</strong></a>
					</div>
					<h3>Pregnant Women</h3>
					<p>For safety reasons, pregnant women can travel only up to the
						34th week of pregnancy. In case of twin pregnancies, the time
						limit is the 32nd week. If you are over your 28th week of
						pregnancy, please provide a medical certificate confirming that
						you are fit to travel by air. Please note that the medical
						certificate must be issued within 6 days of your flight’s date.

						Wizz Air will only be liable in accordance with the General
						Conditions of Carriage for any health problems to pregnant women
						and/or their unborn child that may occur during or as a result of
						carriage by air.</p>
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