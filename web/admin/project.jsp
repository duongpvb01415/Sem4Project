<%-- 
    Document   : project
    Created on : Jun 11, 2014, 11:27:06 AM
    Author     : Windows
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Project Manage</title>
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
                         <div class="top-nav">
                        <ul>
                        <li><a href="statusProject?status=4">Abortive</a></li>
                        <li><a href="statusProject?status=3">Accomplished</a></li>
                        <li><a href="statusProject?status=2">On-Going</a></li>
                        <li><a href="statusProject?status=1">Up-Coming</a></li>

                    </ul>
                </div>

		<!---End-header---->
		<!--start-image-slider---->
			
		<!--End-image-slider---->
	<div class="clear"> </div>	
	<!---start-content---->	
	<div class="content">
		<h4>Project</h4>
		<div class="gallery">
			<div class="section group">
                            <s:iterator value="listProject">
						<div class="grid_1_of_3
                                                     images_1_of_3">
                                                    <div class="Project-gallery"><a href="<s:property value="avatar"/>"><img width="100%" height="150px" src="../<s:property value="avatar"/>" alt=""></a></div>
							  <p><s:property value="address"/></p>
                                                          <div class="button" style="width: 30%; float: left"><span><a href="single.html"><s:property value="total_price"/></a></span></div>
                                                     <div style="float: left; width: 70%; background: #b7b7b7">
                                                         <ul style="padding: 2%">
                                                             <li>Start Time : <s:property value="start_time"/></li>
                                                             <li>Phone : 0<s:property value="phone"/></li>
                                                             <li> Status :
                                                                    <s:if test="startus==1">
                                                                        <span style="background: #990066; color: #8dc63f">Up-Coming</span>
                                                                    </s:if><s:elseif test="startus==2">
                                                                        On-Going
                                                                    </s:elseif><s:elseif test="startus==3">
                                                                        Accomplished 
                                                                    </s:elseif><s:elseif test="startus==4">
                                                                        <span style="background: red; color: white;">Abortive <a href="deleteProject?idProject=<s:property value="id"/>"><img src="images/delete_icon.gif" alt=""></a></span>
                                                                    </s:elseif>
                                                             </li>
                                                             <li><s:property value="time_request"/></li>
                                                         </ul>
                                                     </div>
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
	<div class="clear"> </div>
	<div class="footer">
            <jsp:include page="templates/footer.jsp"/>
	</div>
	</div>
	<!---End-wrap---->
	</body>
</html>
