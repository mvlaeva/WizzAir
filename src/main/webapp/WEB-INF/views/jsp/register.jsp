<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<!--<link type="text/css" rel="stylesheet" href="<c:url value="css/style.css" />" />-->
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<c:url value="/css/reset.css" />" rel="stylesheet">
<link href="<c:url value="/css/layout.css" />" rel="stylesheet">
<link href="<c:url value="/css/style.css" />" rel="stylesheet">
<link href="<c:url value="/css/regform.css" />" rel="stylesheet">
<title>Airlines | Register</title>
</head>
<body id="page3" style="backgroung: white">
	<div class="main">
		<!--header -->
	<jsp:include page="header.jsp" />
		<!-- / header -->
		<!--content -->
		<section id="content">
			<div class="wrapper pad1">
				<article class="col1" style="padding-left: 30px; width: 450px;">
					<div class="box1">
						<!--content -->
						<section id="content">
							<div class="wrapper pad1">
								<div id="wrapper">
									<form action="./Register" method="post">
										<fieldset>
											<legend>Register Form</legend>
											<div>
												<input type="text" name="username" placeholder="Username" />
											</div>
											<div>
												<input type="password" name="password"
													placeholder="Password" />
											</div>
											<div>
												<input type="text" name="email" placeholder="Email" />
											</div>
											<div>
												<input type="text" name="first_name"
													placeholder="First Name" />
											</div>
											<div>
												<input type="text" name="last_name" placeholder="Last Name" />
											</div>
											<div>
												<input type="text" name="phone" placeholder="Phone" />
											</div>
											<input type="radio" name="gender" value="male" checked>
											Male <input type="radio" name="gender" value="female">
											Female <br>
											<button type="submit">Register</button>
											<c:if test="${not empty regMessage}">
												<p>
													<c:out value="${regMessage}" />
												</p>
											</c:if>
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
	<jsp:include page="footer.jsp" />
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