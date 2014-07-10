<%-- 
    Document   : index
    Created on : Jun 9, 2014, 5:32:29 PM
    Author     : Windows
--%>
<%
    if(session.getAttribute("home")==null){
        response.sendRedirect("home");
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
	<head>
            <title><s:property value="h.title"/></title>
		<link href="css/style.css" rel="stylesheet" type="text/css"  media="all" />
		<link href='css/css.css' rel='stylesheet' type='text/css'>
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
				 <!-- Slideshow 2 -->
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
                                          <p><s:property value="h.content1"/></p>
				     <div class="button"><span><a href="#">Read More</a></span></div>
				</div>
				<div class="grid_1_of_3 images_1_of_3">
					  <h3>Our Team</h3>
					   <img src="images/g2.jpg">
					  <p><s:property value="h.content2"/></p>
				     <div class="button"><span><a href="#">Read More</a></span></div>
				</div>
				<div class="grid_1_of_3 images_1_of_3 last">
					<h3>Services</h3>
					  <p><s:property value="h.content3"/></p>
				     <ul>
                                         <s:iterator value="listTop6Ca">
                                             <li><a href="category?ID=<s:property value="id"/>"><s:property value="name"/></a></li>
                                         </s:iterator>
				     </ul>
				     <div class="button"><span><a href="#">Read More</a></span></div>
				</div>
			</div>
		</div>
		<div class="clear"> </div>
		<div class="box">
			<div class="left-box">
				<h3>What People Say About Us</h3>
                                <div class="left-box1 " style="position: relative; left: -20px">
                                    <s:iterator value="lisA">
                                        <td style="width: 48%; padding: 10px;"><p><s:property value="descriptions"/></p><span><s:property value="title"/></span></td>
                                    </s:iterator>

				</div>  
				<div class="clear"> </div>
				<a href="#">See all</a>
			</div>
			<div class="right-box">
				<h3>Our News</h3>
				
				<div class="right-box-grid">
                                    <s:iterator value="n">
					
                                        <div class="right-box-grid-info" style="width: 100%">
                                            <a href="news?ID=<s:property value="id"/>"><span><s:property value="currentDate"/></span></a>
						<p><s:property value="name"/></p>
					</div>
					<div class="clear"> </div>
                                    </s:iterator>
				</div>
				<div class="seeall">
					<a href="#">See all</a>
				</div>
			</div>
			<div class="clear"> </div>
		</div>
	</div>
	<!---End-content---->	
        <jsp:include page="templates/footer.jsp"/>
	</div>
	<!---End-wrap---->
	</body>
</html>
<%
    session.removeAttribute("home");
%>