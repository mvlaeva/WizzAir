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
<link rel="stylesheet" href="css/regform.css" type="text/css"
	media="all">
<title>Flights</title>
</head>
<body id="page3" style="backgroung: white">
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
						<li><a href="./Login" class="nav2">Login</a></li>
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
					<li class="end"><a href="./Contacts"><span><span>Contacts</span></span></a></li>
				</ul>
			</nav>
		</header>
		<!-- / header -->
		<!--content -->
		<section id="content">
			<div class="wrapper pad1">
				<article class="col1" style="padding-left: 30px; width: 350px;">
					<div class="box1">
						<!--content -->
						<section id="content">
							<div class="wrapper pad1">
								<div id="wrapper">
									<form action="./Register" method="post">
										<fieldset>
											<legend>Register Form</legend>
											<div>
												<input type="text" name="first_name"
													placeholder="First Name" />
											</div>
											<div>
												<input type="text" name="last_name" placeholder="Last Name" />
											</div>
											<div>
												<input type="password" name="first_name"
													placeholder="Password" />
											</div>
											<div>
												<input type="text" name="email" placeholder="Email" />
											</div>
											<input type="submit" name="submit" value="Send" />
										</fieldset>
									</form>
								</div>

							</div>
						</section>
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