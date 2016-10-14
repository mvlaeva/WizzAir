<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>
<title>AirLines | About</title>
<meta charset="utf-8">
<link rel="stylesheet" href="css/reset.css" type="text/css" media="all">
<link rel="stylesheet" href="css/layout.css" type="text/css" media="all">
<link rel="stylesheet" href="css/style.css" type="text/css" media="all">
<script src="js/jquery-ui.js"></script>
<%-- <script src="<c:url value='js/jquery-1.5.2.js'/>"</script> --%>
<!--[if lt IE 9]>
<script type="text/javascript" src="js/html5.js"></script>
<style type="text/css">.main, .tabs ul.nav a, .content, .button1, .box1, .top { behavior:url("../js/PIE.htc")}</style>
<![endif]-->
</head>
<body id="page1">
	<script type="text/javascript">
		$(function() {
			$("#datepicker").datepicker({
				dateFormat : 'yy-mm-dd',
				minDate : 0,
				max : [ 2020, 1, 14 ]
			});
		});
		$(function() {
			$("#datepicker2").datepicker({
				dateFormat : 'yy-mm-dd',
				minDate : 1,
				max : [ 2020, 1, 14 ]
			});
		});
	</script>
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
					<li id="menu_active"><a href="./index"><span><span>About</span></span></a></li>
					<li><a href="./Offers"><span><span>Offers</span></span></a></li>
					<li><a href="./Book"><span><span>Book</span></span></a></li>
					<li><a href="./Safety"><span><span>Safety</span></span></a></li>
					<li><a href="./Contacts"><span><span>Contacts</span></span></a></li>
					<c:if test="${not empty user }">
						<li><a href="./Profile"><span><span>Profile</span></span></a></li>
					</c:if>
				</ul>
			</nav>
		</header>
		<!-- / header -->
		<!--content -->
		<c:if test="${ not empty viewHistoryMessage }">
			<div style="font-size: initial; padding: 15px;">
				<c:out value="${viewHistoryMessage }"></c:out>
			</div>
		</c:if>
		<c:if test="${not empty errorLog }">
			<div style="font-size: initial; padding: 15px;">
				<c:out value="${errorLog }"></c:out>
			</div>
		</c:if>
		<section id="content">
			<div class="for_banners">
				<article class="col1">
					<div class="tabs">
						<ul class="nav">
							<li class="selected"><a href="#Flight">Flight</a></li>
						</ul>
						<div class="content">
							<div class="tab-content" id="Flight">
								<form id="form_1" action="./SearchController" method="post">
									<div>
										<div class="radio">
											<div class="wrapper">
												<input type="radio" name="name1" checked> <span>One-way</span>
												<input type="radio" name="name1"> <span>With
													transfer</span>
											</div>
										</div>
										<div class="row">
											<span class="left">From</span> <input type="text"
												class="input" name="origin">
										</div>
										<div class="row">
											<span class="left">To</span> <input type="text" class="input"
												name="destination">
										</div>
										<div class="wrapper">
											<div class="col1">
												<div class="row">
													<span class="left">Outbound</span> <input type="date"
														id="datepicker" class="input1" name="departureDate">
												</div>
												<div class="row">
													<span class="left">Return</span> <input type="date"
														class="input1" name="returnDate">
												</div>
											</div>
										</div>
										<div class="row">
											<span class="left">Adults</span> <select name="adults">
												<option value="1">1</option>
												<option value="2">2</option>
												<option value="3">3</option>
											</select>
										</div>
										<div class="row">
											<span class="left"> Children (0-11 years)</span> <select
												name="children">
												<option value="0">0</option>
												<option value="1">1</option>
												<option value="2">2</option>
												<option value="3">3</option>
											</select>
										</div>
										<div class="row">
											<span class="left">Stops</span> <select name="stops">
												<option value="0">0</option>
												<option value="1">1</option>
												<option value="2">2</option>
												<option value="3">3</option>
											</select>
										</div>
										<div class="wrapper"></div>
									</div>
									<input type="submit" value="Search" />
								</form>
							</div>
						</div>
					</div>
				</article>
				<div id="slider">
					<img src="images/banner1.jpg" alt=""> <img
						src="images/banner2.jpg" alt=""> <img
						src="images/banner3.jpg" alt="">
				</div>
			</div>
			<div class="wrapper pad1">
				<article class="col1">
					<div class="box1">
						<h2 class="top">Offers of the Week from UK</h2>
						<div class="pad">
							<strong>From Birmingham</strong><br>
							<ul class="pad_bot1 list1">
								<li><span class="right color1">from GBP 143.-</span> <a
									href="book2.html">Zurich</a></li>
							</ul>
							<strong>From London City</strong><br>
							<ul class="pad_bot1 list1">
								<li><span class="right color1">from GBP 176.-</span> <a
									href="book2.html">Basel</a></li>
								<li><span class="right color1">from GBP 109.-</span> <a
									href="book2.html">Geneva</a></li>
							</ul>
							<strong>From London Heathrow</strong><br>
							<ul class="pad_bot2 list1">
								<li><span class="right color1">from GBP 100.-</span> <a
									href="book2.html">Geneva</a></li>
								<li><span class="right color1">from GBP 112.-</span> <a
									href="book2.html">Zurich</a></li>
								<li><span class="right color1">from GBP 88.-</span> <a
									href="book2.html">Basel</a></li>
							</ul>
						</div>
						<h2>From Ireland To Switzerland</h2>
						<div class="pad">
							<strong>From Dublin</strong><br>
							<ul class="pad_bot2 list1">
								<li class="pad_bot1"><span class="right color1">from
										EUR 122.-</span> <a href="book2.html">Zurich</a></li>
							</ul>
						</div>
					</div>
				</article>
				<article class="col2">
					<h3>
						About Our Airlines<span></span>
					</h3>
					<div class="wrapper">
						<article class="cols">
							<figure>
								<img src="images/page1_img1.jpg" alt="" class="pad_bot2">
							</figure>
							<p class="pad_bot1">
								<strong>We offer extra attention to disabled and
									reduced-mobility passengers and to passengers with special
									needs.</strong>
							</p>
							<p>In order to make your journey safe and comfortable, you
								need to inform Wizz Air at least 48 hours before the scheduled
								departure of the flight about your physical disability or
								reduced mobility, or any other condition that may require
								medical care. Your request can be made online during the booking
								process or by contacting the Special Assistance Call Centre. We
								recommend calling us on the day you make the reservation.</p>
						</article>
						<article class="cols pad_left1">
							<figure>
								<img src="images/page1_img2.jpg" alt="" class="pad_bot2">
							</figure>
							<p class="pad_bot1">
								<strong>Medical certificate</strong>
							</p>
							<p>If there is reasonable doubt that you can complete the
								flight safely, without requiring assistance during the flight,
								we reserve the right to require a medical certificate confirming
								your fitness to travel by air. This must contain explicit
								medical approval for your carriage by air.</p>
						</article>
					</div>
					<a href="./Safety" class="button1"><strong>Read More</strong></a>
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