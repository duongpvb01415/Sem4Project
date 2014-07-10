<%-- 
    Document   : index
    Created on : Jul 4, 2014, 12:57:28 PM
    Author     : Windows
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Deluxe Website Template | Home :: W3layouts</title>
		<link href="css/1style.css" rel="stylesheet" type="text/css"  media="all" />
		<link href='http://fonts.googleapis.com/css?family=Karla' rel='stylesheet' type='text/css'>
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
		<script src="js/responsiveslides.min.js"></script>
		  <script>
		    // You can also use "$(window).load(function() {"
			    $(function () {
			
			      // Slideshow 1
			      $("#slider1").responsiveSlides({
			        maxwidth: 1600,
			        speed: 600
			      });
			});
		  </script>
	</head>
	<body>
	<!---start-wrap---->
	<div class="wrap">
		            <jsp:include page="templates/header.jsp"/>
                            <div class="top-nav">
                    <ul>
                        <li><a href="editHome?home=4">Logo Upload</a></li>
                        <li><a href="editHome?home=3">Slide Upload</a></li>
                        <li><a href="editHome?home=2">About</a></li>
                        <li><a href="editHome?home=1">Home</a></li>

                    </ul>
                </div>    
		<!--End-image-slider---->
	<div class="clear"> </div>	
	<!---start-content---->	
	<div class="content">
		<div class="grids">
			<div class="section group">
				<div class="grid_1_of_3 images_1_of_3">
					  <h3>Welcome!</h3>
					  <img src="images/g1.jpg">
					  <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.</p>
				     <div class="button"><span><a href="#">Read More</a></span></div>
				</div>
				<div class="grid_1_of_3 images_1_of_3">
					  <h3>Our Team</h3>
					   <img src="images/g2.jpg">
					  <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.</p>
				     <div class="button"><span><a href="#">Read More</a></span></div>
				</div>
				<div class="grid_1_of_3 images_1_of_3 last">
					<h3>Services</h3>
					  <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.</p>
				     <ul>
				     	<li><a href="#">consectetur adipisicing elit</a></li>
				     	<li><a href="#">eiusmod tempor incididunt ut</a></li>
				     	<li><a href="#">dolore magna aliqua. Duis</a></li>
				     	<li><a href="#">empor incididunt ut labore et</a></li>
				     	<li><a href="#">sit amet, consectetur adipisicing</a></li>
				     	<li><a href="#">dolore magna aliqua. Duis</a></li>
				     </ul>
				     <div class="button"><span><a href="#">Read More</a></span></div>
				</div>
			</div>
		</div>
		<div class="clear"> </div>
		<div class="box">
			<div class="left-box">
				<h3>What People Say About Us</h3>
				<div class="left-box1 frist-box">
					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed in reprehenderit adipisicing elit, sed in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.</p>
					<h5>consectetur adipisicing elit</h5>
					<span>voluptate velit esse cillum dolore eu</span>
				</div>
				<div class="left-box1">
					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed in reprehenderit adipisicing elit, sed in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.</p>
					<h5>consectetur adipisicing elit</h5>
					<span>voluptate velit esse cillum dolore eu</span>
				</div>
				<div class="clear"> </div>
				<a href="#">See all</a>
			</div>
			<div class="right-box">
				<h3>Our News</h3>
				<div class="right-box-grid">
					<div class="right-box-grid-img">
						<a href="#"><img src="images/n1.jpg" title="img" /></a>
					</div>
					<div class="right-box-grid-info">
						<span>02 March 2013</span>
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed in reprehenderit adipisicing elit,</p>
					</div>
					<div class="clear"> </div>
				</div>
				<div class="right-box-grid">
					<div class="right-box-grid-img">
						<a href="#"><img src="images/n1.jpg" title="img" /></a>
					</div>
					<div class="right-box-grid-info">
						<span>02 March 2013</span>
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed in reprehenderit adipisicing elit,</p>
					</div>
					<div class="clear"> </div>
				</div>
				<div class="seeall">
					<a href="#">See all</a>
				</div>
			</div>
			<div class="clear"> </div>
		</div>
	</div>
	<!---End-content---->	
	<div class="clear"> </div>
	<jsp:include page="templates/footer.jsp"/>
	</div>
	<!---End-wrap---->
	</body>
</html>
