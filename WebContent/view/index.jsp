<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>AirLines</title>
<meta charset="utf-8">
<link rel="stylesheet" href="css/reset.css" type="text/css" media="all">
<link rel="stylesheet" href="css/layout.css" type="text/css" media="all">
<link rel="stylesheet" href="css/style.css" type="text/css" media="all">
<script type="text/javascript" src="js/jquery-1.5.2.js" ></script>
<script type="text/javascript" src="js/cufon-yui.js"></script>
<script type="text/javascript" src="js/cufon-replace.js"></script>
<script type="text/javascript" src="js/Cabin_400.font.js"></script>
<script type="text/javascript" src="js/tabs.js"></script>
<script type="text/javascript" src="js/jquery.jqtransform.js" ></script>
<script type="text/javascript" src="js/jquery.nivo.slider.pack.js"></script>
<script type="text/javascript" src="js/atooltip.jquery.js"></script>
<script type="text/javascript" src="js/script.js"></script>
<!--[if lt IE 9]>
<script type="text/javascript" src="js/html5.js"></script>
<style type="text/css">.main, .tabs ul.nav a, .content, .button1, .box1, .top { behavior:url("../js/PIE.htc")}</style>
<![endif]-->
</head>
<body id="page1">
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
						<li><a href="./index" class="nav1">Home</a></li>
						<li><a href="./Contacts" class="nav3">Contact</a></li>
					</ul>
				</nav>
			</div>
			<nav>
				<ul id="menu">
					<li id="menu_active" ><a href="./index"><span><span>About</span></span></a></li>
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
                      <input type="radio" name="name1" checked>
                      <span class="left">One-way</span>
                      <input type="radio" name="name1">
                      <span class="left">With transfer</span> </div>
                  </div>
                  <div class="row"> <span class="left">From</span>
                    <input type="text" class="input" name="origin">
                  </div>
                  <div class="row"> <span class="left">To</span>
                    <input type="text" class="input" name="destination">
                  </div>
                  <div class="wrapper">
                    <div class="col1">
                      <div class="row"> <span class="left">Outbound</span>
                        <input type="text" class="input1" value="2016-10-13" name="departureDate"  onblur="if(this.value=='') this.value='2016-10-13'" onFocus="if(this.value =='2016-10-13' ) this.value=''">
                      </div>
                      <div class="row"> <span class="left">Return</span>
                        <input type="text" class="input1" value="2016-10-18" name="returnDate" onblur="if(this.value=='') this.value='2016-10-18'" onFocus="if(this.value =='2016-10-18' ) this.value=''">
                      </div>
                    </div>     
                  </div>
                  <div class="row"> <span class="left">Adults</span>
                    <input type="text" class="input2" value="2" name="adults" onblur="if(this.value=='') this.value='2'" onFocus="if(this.value =='2' ) this.value=''">
                  </div>
                  <div class="row"> <span class="left">Children</span>
                    <input type="text" class="input2" value="0"  onblur="if(this.value=='') this.value='0'" onFocus="if(this.value =='0' ) this.value=''">
                    <span class="pad_left1">(0-11 years)</span> </div>
                  <div class="wrapper">  </div>
                </div>
                <input type="submit" value="Search" />
              </form>
            </div>         
          </div>
        </div>
      </article>
      <div id="slider"> <img src="images/banner1.jpg" alt=""> <img src="images/banner2.jpg" alt=""> <img src="images/banner3.jpg" alt=""> </div>
    </div>
    <div class="wrapper pad1">
      <article class="col1">
        <div class="box1">
          <h2 class="top">Offers of the Week from UK</h2>
          <div class="pad"> <strong>From Birmingham</strong><br>
            <ul class="pad_bot1 list1">
              <li> <span class="right color1">from GBP 143.-</span> <a href="book2.html">Zurich</a> </li>
            </ul>
            <strong>From London City</strong><br>
            <ul class="pad_bot1 list1">
              <li> <span class="right color1">from GBP 176.-</span> <a href="book2.html">Basel</a> </li>
              <li> <span class="right color1">from GBP 109.-</span> <a href="book2.html">Geneva</a> </li>
            </ul>
            <strong>From London Heathrow</strong><br>
            <ul class="pad_bot2 list1">
              <li> <span class="right color1">from GBP 100.-</span> <a href="book2.html">Geneva</a> </li>
              <li> <span class="right color1">from GBP 112.-</span> <a href="book2.html">Zurich</a> </li>
              <li> <span class="right color1">from GBP 88.-</span> <a href="book2.html">Basel</a> </li>
            </ul>
          </div>
          <h2>From Ireland To Switzerland</h2>
          <div class="pad"> <strong>From Dublin</strong><br>
            <ul class="pad_bot2 list1">
              <li class="pad_bot1"> <span class="right color1">from EUR 122.-</span> <a href="book2.html">Zurich</a> </li>
            </ul>
          </div>
        </div>
      </article>
      <article class="col2">
        <h3>About Our Airlines<span>Template created by TemplateMonster.com team</span></h3>
        <div class="wrapper">
          <article class="cols">
            <figure><img src="images/page1_img1.jpg" alt="" class="pad_bot2"></figure>
            <p class="pad_bot1"><strong>Airlines is one of free website templates created by TemplateMonster.com team.</strong></p>
            <p>This website template is optimized for 1024X768 screen resolution. It is also XHTML &amp; CSS valid. This website template has several pages: <a href="index.html">About</a>, <a href="offers.html">Offers</a>, <a href="book.html">Book</a>, <a href="services.html">Services</a>, <a href="safety.html">Safety</a>, <a href="contacts.html">Contacts</a>.</p>
          </article>
          <article class="cols pad_left1">
            <figure><img src="images/page1_img2.jpg" alt="" class="pad_bot2"></figure>
            <p class="pad_bot1"><strong>This Airlines Template goes with two packages.</strong></p>
            <p>With PSD source files and without them. PSD source files are available for free for the registered members of Templates.com. The basic package (without PSD source files) is available for anyone without registration).</p>
          </article>
        </div>
        <a href="#" class="button1"><strong>Read More</strong></a> </article>
    </div>
  </section>
  <!--content end-->
  <!--footer -->
  <footer>
    <div class="wrapper">
      <ul id="icons">
        <li><a href="https://www.facebook.com/wizzaircom" class="normaltip"><img src="images/icon1.jpg" height="30" width="30" alt=""></a></li>
        <li><a href="https://twitter.com/wizzair" class="normaltip"><img src="images/icon2.jpg" height="30" width="30" alt=""></a></li>
        <li><a href="https://www.youtube.com/user/WizzAirCorporate" class="normaltip"><img src="images/icon3.jpg" height="30" width="30" alt=""></a></li>
      </ul>
      </div>
  </footer>
  <!--footer end-->
</div>
<script type="text/javascript">Cufon.now();</script>
<script type="text/javascript">
$(document).ready(function () {
    tabs.init();
});
jQuery(document).ready(function ($) {
    $('#form_1, #form_2, #form_3').jqTransform({
        imgPath: 'jqtransformplugin/img/'
    });
});
$(window).load(function () {
    $('#slider').nivoSlider({
        effect: 'fade', //Specify sets like: 'fold,fade,sliceDown, sliceDownLeft, sliceUp, sliceUpLeft, sliceUpDown, sliceUpDownLeft' 
        slices: 15,
        animSpeed: 500,
        pauseTime: 6000,
        startSlide: 0, //Set starting Slide (0 index)
        directionNav: false, //Next & Prev
        directionNavHide: false, //Only show on hover
        controlNav: false, //1,2,3...
        controlNavThumbs: false, //Use thumbnails for Control Nav
        controlNavThumbsFromRel: false, //Use image rel for thumbs
        controlNavThumbsSearch: '.jpg', //Replace this with...
        controlNavThumbsReplace: '_thumb.jpg', //...this in thumb Image src
        keyboardNav: true, //Use left & right arrows
        pauseOnHover: true, //Stop animation while hovering
        manualAdvance: false, //Force manual transitions
        captionOpacity: 1, //Universal caption opacity
        beforeChange: function () {},
        afterChange: function () {},
        slideshowEnd: function () {} //Triggers after all slides have been shown
    });
});
</script>
</body>
</html>
        