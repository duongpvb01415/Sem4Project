<%-- 
    Document   : about
    Created on : Jul 4, 2014, 1:00:51 PM
    Author     : Windows
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Deluxe Website Template | About :: W3layouts</title>
		<link href="css/1style.css" rel="stylesheet" type="text/css"  media="all" />
                <link rel="stylesheet" href="css/style1.css" type="text/css">
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
                        <li><a href="users?adduse=1">Add User</a></li>
                        <li><a href="users?listuse=1">List User</a></li>
                    </ul>
                </div>

            <div class="clear"> </div>	
            <!---start-content---->	
            <div class="content">
                <div class="clear"> </div>
                <div class="box">
                    <div class="left-box">
                        <s:if test="#session.addUser!=null">
                        <jsp:include page="templates/user/adduser.jsp"/>
                        </s:if><s:else>
                            <jsp:include page="templates/user/listuser.jsp"/>
                            </s:else>
                        <div class="clear"> </div>
                        <a href="#">See all</a>
                    </div>
                    <div class="right-box">
                        <h3>Adminstrator</h3>
                        <s:iterator value="lisA">
                        <div class="right-box-grid">
                            <div class="right-box-grid-img">
                                <a href="#"><img src="images/n1.jpg" title="img" /></a>
                            </div>
                            <div class="right-box-grid-info">
                                <span><s:property value="name"/></span>
                                <p><s:property value="email"/></p>
                                <p><s:property value="phone"/></p>
                            </div>
                            <div class="clear"> </div>
                        </div>
                        </s:iterator>
                        
                        <div class="seeall">
                            <a href="#">See all</a>
                        </div>
                    </div>
                    <div class="clear"> </div>
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
<%
session.removeAttribute("addUser");
session.removeAttribute("error");
%>