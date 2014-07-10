<%-- 
    Document   : gallery
    Created on : Jun 10, 2014, 11:38:53 PM
    Author     : Windows
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Deluxe Website Template | Gallery :: W3layouts</title>
		<link href="css/style.css" rel="stylesheet" type="text/css"  media="all" />
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
		<!---start-header---->
                <jsp:include page="templates/header.jsp"/>
		<!---End-header---->
		<!--start-image-slider---->
			<div class="image-slider">
				<!-- Slideshow 1 -->
                                <ul class="rslides" id="slider1">
                                      <s:iterator value="lis">
                                          <li><img src="<s:property value="slide"/>"/></li>
                                      </s:iterator>
				  </ul>
			</div>
		<!--End-image-slider---->
	<div class="clear"> </div>	
	<!---start-content---->	
	<div class="content">


		<div class="gallery">
                    <h4>Accomplished</h4>
                    <div class="section group">
                            <s:iterator value="list3TopProAc">
						<div class="grid_1_of_3 images_1_of_3">
                                                    <div class="Project-gallery"><a href="<s:property value="avatar"/>"><img width="100%" height="180px" src="<s:property value="avatar"/>" alt=""></a></div>
                                                    <p><s:property value="address" /></p>
						     <div class="button"><span><a href="single.html">Read More</a></span></div>
						</div>
						</s:iterator>
						</div>
                    <h4>On-Going</h4>
                    <div class="section group">
                            <s:iterator value="list3TopProOn">
						<div class="grid_1_of_3 images_1_of_3">
                                                    <div class="Project-gallery"><a href="<s:property value="avatar"/>"><img width="100%" height="180px" src="<s:property value="avatar"/>" alt=""></a></div>
                                                    <p><s:property value="address" /></p>
						     <div class="button"><span><a href="single.html">Read More</a></span></div>
						</div>
						</s:iterator>
						</div>
                    <h4>Up-Coming</h4>
			<div class="section group">
                            <s:iterator value="list3TopProUp">
						<div class="grid_1_of_3 images_1_of_3">
                                                    <div class="Project-gallery"><a href="<s:property value="avatar"/>"><img width="100%" height="180px" src="<s:property value="avatar"/>" alt=""></a></div>
                                                    <p><s:property value="address" /></p>
						     <div class="button"><span><a href="single.html">Read More</a></span></div>
						</div>
						</s:iterator>
						</div>
						
						<div class="projects-bottom-paination">
						<ul>
							<li class="corrent"><a href="#">1</a></li>
							<li><a href="#">2</a></li>
						</ul>
					</div>
					 <script type="text/javascript" src="js/jquery.lightbox.js"></script>
	    <link rel="stylesheet" type="text/css" href="css/lightbox.css" media="screen" />
	  	<script type="text/javascript">
	    $(function() {
	        $('.Project-gallery a').lightBox();
	    });
	    </script>
		</div>
	</div>
	<!---End-content---->	
	<jsp:include page="templates/footer.jsp"/>
	</div>
	<!---End-wrap---->
	</body>
</html>
