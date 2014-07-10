<%-- 
    Document   : about
    Created on : Jun 10, 2014, 11:37:13 PM
    Author     : Windows
--%>
<%
    if(session.getAttribute("about")==null){
        response.sendRedirect("about");
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <title>About</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"  media="all" />
        <link href='http://fonts.googleapis.com/css?family=Karla' rel='stylesheet' type='text/css'>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
        <script src="js/responsiveslides.min.js"></script>
        <script>
            // You can also use "$(window).load(function() {"
            $(function() {

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
                <div class="clear"> </div>
                <div class="box">
                    <div class="left-box">
                        <h3>What People Say About Us</h3>
                        <s:iterator value="allAbout">
                            <div class="left-box1 frist-box" style="position: relative; left: -20px;">
                                <p><s:property value="descriptions"/></p>
                                <h5><s:property value="title"/></h5>
                            </div>
                        </s:iterator>
                        <div class="clear"> </div>
                        <a class="see" href="#">View all</a>
                    </div>
                    <div class="right-box">
                        <h3>Our News</h3>
                        <div class="right-box-grid">
                            <s:iterator value="n">

                                <div class="right-box-grid-info" style="width: 100%">
                                    <span><s:property value="currentDate"/></span>
                                    <p><s:property value="name"/></p>
                                </div>

                                <div class="clear"> </div>
                            </s:iterator>
                        </div>
                        <div class="seeall">
                            <a class="see" href="#">View all</a>
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
    session.removeAttribute("about");
%>