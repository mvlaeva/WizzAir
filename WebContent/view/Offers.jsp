<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>AirLines | Offers</title>
<meta charset="utf-8">
<link rel="stylesheet" href="css/reset.css" type="text/css" media="all">
<link rel="stylesheet" href="css/layout.css" type="text/css" media="all">
<link rel="stylesheet" href="css/style.css" type="text/css" media="all">
<script type="text/javascript" src="js/jquery-1.5.2.js"></script>
<script type="text/javascript" src="js/cufon-yui.js"></script>
<script type="text/javascript" src="js/cufon-replace.js"></script>
<script type="text/javascript" src="js/Cabin_400.font.js"></script>
<script type="text/javascript" src="js/tabs.js"></script>
<script type="text/javascript" src="js/jquery.jqtransform.js"></script>
<script type="text/javascript" src="js/jquery.nivo.slider.pack.js"></script>
<script type="text/javascript" src="js/atooltip.jquery.js"></script>
<script type="text/javascript" src="js/script.js"></script>
<!--[if lt IE 9]>
<script type="text/javascript" src="js/html5.js"></script>
<style type="text/css">.main, .tabs ul.nav a, .content, .button1, .box1, .top { behavior:url("../js/PIE.htc")}</style>
<![endif]-->
</head>
<body id="page2">
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
					<li id="menu_active"><a href="./Offers"><span><span>Offers</span></span></a></li>
					<li><a href="./Book"><span><span>Book</span></span></a></li>
					<li><a href="./Services"><span><span>Services</span></span></a></li>
					<li><a href="./Safety"><span><span>Safety</span></span></a></li>
					<li class="end"><a href="./Contacts"><span><span>Contacts</span></span></a></li>
				</ul>
			</nav>
		</header>
		<!-- / header -->
		<!--content -->
		<section id="content">
			<div class="wrapper pad1" >
				<article class="col1" style="width: 300px">
					<div class="pad_bot3">
						<div class="box1">
							<h2 class="top">Search and Book Flights</h2>
							<form id="form_1" action="./SearchController" method="post">
								<div>
									<div class="radio">
										<div class="wrapper">
											<input type="radio" name="name1" checked> <span
												>One-way</span><input type="radio"
												name="name1"> <span class="left">With
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
												<span class="left">Outbound</span> <input type="text"
													class="input1" style="width: 65px" value="2016-10-13" name="departureDate"
													onblur="if(this.value=='') this.value='2016-10-13'"
													onFocus="if(this.value =='2016-10-13' ) this.value=''">
											</div>
											<div class="row">
												<span class="left">Return</span> <input type="text"
													class="input1" style="width: 65px" value="2016-10-18" name="returnDate"
													onblur="if(this.value=='') this.value='2016-10-18'"
													onFocus="if(this.value =='2016-10-18' ) this.value=''">
											</div>
										</div>
									</div>
									<div class="row">
										<span class="left">Adults</span> <input type="text"
											class="input2" value="2" name="adults"
											onblur="if(this.value=='') this.value='2'"
											onFocus="if(this.value =='2' ) this.value=''">
									</div>
									<div class="row">
										<span class="left">Children</span> <input type="text"
											class="input2" value="0"
											onblur="if(this.value=='') this.value='0'"
											onFocus="if(this.value =='0' ) this.value=''"> <span
											class="pad_left1">(0-11 years)</span>
									</div>
									<div class="wrapper"></div>
								</div>
								<input type="submit" value="Search" />
							</form>
						</div>
					</div>
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
						</div>
					</div>
				</article>
				<article class="col2">
					<h3 class="pad_top1">UK Europe Specials</h3>
					<div class="wrapper pad_bot3">
						<figure class="left marg_right1">
							<img src="images/page2_img1.jpg" alt="">
						</figure>
						<div class="cols">
							<h4>From UK</h4>
							<ul class="list1">
								<li><span class="color1 right">from GBP 130.-</span> <a
									href="book2.html">Malaga</a></li>
								<li><span class="color1 right">GBP 144.-</span> <a
									href="book2.html">Rome</a></li>
								<li><span class="color1 right">from GBP 146.-</span> <a
									href="book2.html">Budapest</a></li>
								<li><span class="color1 right">from GBP 146.-</span> <a
									href="book2.html">Bucharest</a></li>
								<li><span class="color1 right">from GBP 159.-</span> <a
									href="book2.html">Athens</a></li>
								<li><a href="#">More destinations</a></li>
							</ul>
						</div>
					</div>
					<h3>Switzerland Special from UK</h3>
					<div class="wrapper pad_bot3">
						<figure class="left marg_right1">
							<img src="images/page2_img2.jpg" alt="">
						</figure>
						<div class="cols">
							<h4>From Birmingham</h4>
							<ul class="list1 pad_bot1">
								<li><span class="color1 right">from GBP 143.-</span> <a
									href="book2.html">Zurich</a></li>
							</ul>
							<h4>From London Heatrow</h4>
							<ul class="list1 pad_bot1">
								<li><span class="color1 right">from GBP 146.-</span> <a
									href="book2.html">Zurich</a></li>
								<li><span class="color1 right">from GBP 146.-</span> <a
									href="book2.html">Geneva</a></li>
								<li><span class="color1 right">from GBP 159.-</span> <a
									href="book2.html">Basel</a></li>
							</ul>
							<h4>From Manchester</h4>
							<ul class="list1">
								<li><span class="color1 right">from GBP 146.-</span> <a
									href="book2.html">Zurich</a></li>
								<li><span class="color1 right">from GBP 146.-</span> <a
									href="book2.html">Geneva</a></li>
								<li><span class="color1 right">from GBP 159.-</span> <a
									href="book2.html">Basel</a></li>
							</ul>
						</div>
					</div>
					<h3>UK Intercontinental Economy Special</h3>
					<div class="wrapper">
						<figure class="left marg_right1">
							<img src="images/page2_img3.jpg" alt="">
						</figure>
						<div class="cols">
							<h4>From UK</h4>
							<ul class="list1 pad_bot1">
								<li><span class="color1 right">from GBP 464.-</span> <a
									href="book2.html">Hong Kong</a></li>
								<li><span class="color1 right">from GBP 509.-</span> <a
									href="book2.html">Johannesburg</a></li>
								<li><span class="color1 right">from GBP 601.-</span> <a
									href="book2.html">Bangkok</a></li>
								<li><span class="color1 right">from GBP 727.-</span> <a
									href="book2.html">Paulo</a></li>
								<li><span class="color1 right">from GBP 464.-</span> <a
									href="book2.html">Zurich</a></li>
								<li><span class="color1 right">from GBP 509.-</span> <a
									href="book2.html">Geneva</a></li>
								<li><span class="color1 right">from GBP 601.-</span> <a
									href="book2.html">Basel</a></li>
								<li><a href="#">More offers</a></li>
							</ul>
							Book by 15 May 2011 and travel between 16 April and 30 September
							2011.
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
	<script type="text/javascript">
		jQuery(document).ready(function($) {
			$('#form_4').jqTransform({
				imgPath : 'jqtransformplugin/img/'
			});
		});
	</script>
</body>
</html>